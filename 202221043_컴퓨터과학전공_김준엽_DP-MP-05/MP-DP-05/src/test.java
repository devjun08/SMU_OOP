
import java.util.Scanner;

/*
 * State Pattern 실습 (28~35페이지)
 *
 * 기능:
 * - 숫자를 한 글자씩 입력받아 여러 자리 정수를 만듦
 * - +, -, *, / 연산 지원
 * - 두 개 이상의 정수를 연속으로 계산
 * - 연산자 우선순위 없이 왼쪽부터 계산
 * - '=' 입력 시 최종 결과 출력
 * - q 또는 Q 입력 시 종료
 *
 * 상태 흐름:
 * Start → Operand1 → Operator → Operand2
 *                       ↑          |
 *                       └──────────┘
 */

// 모든 상태 클래스가 구현해야 하는 인터페이스
interface CalcState {

    // calc: 계산기 객체 (데이터와 상태를 관리)
    // ch: 사용자가 입력한 문자 한 개
    void process(Calculator calc, char ch);
}


// ========================================
// Context: 계산기 전체를 관리하는 클래스
// ========================================
public class Calculator {

    // 각 상태 객체
    private CalcState startState;
    private CalcState operand1State;
    private CalcState operatorState;
    private CalcState operand2State;

    // 현재 실행할 상태 객체
    private CalcState currentState;

    private Scanner sc;

    // 숫자 문자를 이어 붙이는 버퍼
    // 예: '1', '2', '3' → "123"
    private StringBuffer operandString;

    // 첫 번째 피연산자 또는 이전 계산 결과
    private int operand1;

    // 현재 연산자
    private char operator;


    // 생성자: 상태 객체를 생성하고 초기 상태를 지정
    public Calculator() {
        sc = new Scanner(System.in);

        startState = new Start();
        operand1State = new Operand1();
        operatorState = new Operator();
        operand2State = new Operand2();

        currentState = startState;
        operandString = new StringBuffer();
    }


    // 숫자 입력 버퍼 초기화
    public void initialize() {
        operandString.setLength(0);
    }


    // 사용자에게 문자 하나를 입력받음
    public char getInput() {
        System.out.print("숫자 한 개 또는 연산자를 입력하세요: ");

        String s = sc.next();
        char ch = s.charAt(0);

        // q 또는 Q 입력 시 프로그램 종료
        if (ch == 'q' || ch == 'Q') {
            System.exit(0);
        }

        return ch;
    }


    // 계산기 실행
    public void process() {
        while (true) {

            // 입력 문자 하나를 읽음
            char ch = getInput();

            // 현재 상태 객체에 입력 처리를 맡김
            currentState.process(this, ch);
        }
    }


    // 각 상태 객체를 반환
    public CalcState getStartState() {
        return startState;
    }

    public CalcState getOperand1State() {
        return operand1State;
    }

    public CalcState getOperatorState() {
        return operatorState;
    }

    public CalcState getOperand2State() {
        return operand2State;
    }


    // 현재 상태를 변경하고 같은 입력 문자를 새 상태에서 처리
    public void setState(CalcState state, char ch) {
        currentState = state;
        currentState.process(this, ch);
    }


    // 입력한 숫자 문자를 버퍼 뒤에 추가
    public void appendToOperandString(char ch) {
        operandString.append(ch);
    }


    // 버퍼의 문자열을 정수로 변환한 뒤 버퍼를 비움
    public int convertOperandStringToInt() {
        int value = Integer.parseInt(
                operandString.toString()
        );

        operandString.setLength(0);
        return value;
    }


    // 계산 데이터 Getter / Setter
    public int getOperand1() {
        return operand1;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperand1(int v) {
        operand1 = v;
    }

    public void setOperator(char op) {
        operator = op;
    }


    // 프로그램 시작점
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.process();
    }
}


// ========================================
// Start: 계산 시작 상태
// ========================================
class Start implements CalcState {

    @Override
    public void process(Calculator calc, char ch) {

        if (ch == '=') {

            // 계산 시작 전 버퍼 초기화
            calc.initialize();

        } else if (ch >= '1' && ch <= '9') {

            // 숫자가 들어오면 첫 번째 피연산자 상태로 이동
            // 입력한 숫자도 새 상태에 전달
            calc.setState(calc.getOperand1State(), ch);
        }
    }
}


// ========================================
// Operand1: 첫 번째 피연산자 입력 상태
// ========================================
class Operand1 implements CalcState {

    @Override
    public void process(Calculator calc, char ch) {

        if (ch >= '1' && ch <= '9') {

            // 숫자를 계속 이어 붙임
            // 예: '1' → '2' → "12"
            calc.appendToOperandString(ch);

        } else {

            // 숫자가 아닌 문자가 들어오면 정수 변환
            calc.setOperand1(
                    calc.convertOperandStringToInt()
            );

            // 입력한 문자를 연산자 상태로 전달
            calc.setState(calc.getOperatorState(), ch);
        }
    }
}


// ========================================
// Operator: 연산자 입력 상태
// ========================================
class Operator implements CalcState {

    @Override
    public void process(Calculator calc, char ch) {

        if (ch == '+' || ch == '-' ||
                ch == '*' || ch == '/') {

            // 연산자 저장
            calc.setOperator(ch);

        } else {

            // 연산자가 아니면 두 번째 피연산자 입력 시작
            calc.setState(calc.getOperand2State(), ch);
        }
    }
}


// ========================================
// Operand2: 두 번째 피연산자 및 계산 상태
// ========================================
class Operand2 implements CalcState {

    @Override
    public void process(Calculator calc, char ch) {

        if (ch >= '0' && ch <= '9') {

            // 두 번째 피연산자를 문자 단위로 저장
            calc.appendToOperandString(ch);

        } else {

            // 연산자 또는 '=' 입력 시 계산 수행
            int op1 = calc.getOperand1();
            char op = calc.getOperator();
            int op2 = calc.convertOperandStringToInt();

            int result = 0;

            // 현재 연산자로 두 피연산자 계산
            switch (op) {
                case '+':
                    result = op1 + op2;
                    break;

                case '-':
                    result = op1 - op2;
                    break;

                case '*':
                    result = op1 * op2;
                    break;

                case '/':
                    result = op1 / op2;
                    break;
            }

            if (ch == '=') {

                // '='이면 최종 결과 출력
                System.out.printf(
                        "%d %c %d = %d%n",
                        op1, op, op2, result
                );

            } else {

                // 연산자가 들어오면 연속 계산 준비
                // 현재 결과를 다음 계산의 첫 번째 피연산자로 사용
                calc.setOperand1(result);

                System.out.printf(
                        "%d %c %d%n",
                        op1, op, op2
                );

                // 방금 입력한 연산자를 다음 계산에 사용
                calc.setState(calc.getOperatorState(), ch);
            }
        }
    }
}
