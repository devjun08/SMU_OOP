//public class Main {
//    public static void main(String[] args) {
//        CommandManager manager = new CommandManager();
//
//        manager.addOperation(new AddValueCommand(10, 5));
//        manager.addOperation(new SubtractValueCommand(20, 8));
//        manager.addOperation(new MultiplyValueCommand(6, 7));
//        manager.addOperation(new DivideValueCommand(20, 4));
//        manager.addOperation(new RemainderValueCommand(17, 5));
//        manager.addOperation(new SquareValueCommand(4));
//
//        System.out.println("===== 계산 결과 =====");
//        System.out.println("1. 덧셈: 10 + 5");
//        System.out.println("2. 뺄셈: 20 - 8");
//        System.out.println("3. 곱셈: 6 * 7");
//        System.out.println("4. 나눗셈: 20 / 4");
//        System.out.println("5. 나머지: 17 % 5");
//        System.out.println("6. 제곱: 4 * 4");
//
//        System.out.println("\n===== 실행 결과 =====");
//        manager.performOperations();
//    }
//}