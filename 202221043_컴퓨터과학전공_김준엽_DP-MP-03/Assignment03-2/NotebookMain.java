public class NotebookMain {
    private static void printComputer(AbstractNotebookComputer computer) {
        System.out.println("Devices: " + computer.toString());
        System.out.println("Required space: " + computer.requiredSpace());
    }

    public static void main(String[] args) {
        AbstractNotebookComputer computer = new NotebookComputer("owner", 250);
        printComputer(computer);

        System.out.println("외부 모니터 추가. 요구 공간 150 추가");
        computer = new LEDMonitor(computer);
        printComputer(computer);

        System.out.println("외부 모니터 추가. 요구 공간 150 추가");
        computer = new LEDMonitor(computer);
        printComputer(computer);

        System.out.println("외부 키보드 추가. 요구 공간 80 추가");
        computer = new Keyboard(computer);
        printComputer(computer);

        System.out.println("외부 마우스 추가. 요구 공간 30 추가");
        computer = new Mouse(computer);
        printComputer(computer);

        System.out.println("외장 하드 추가. 요구 공간 40 추가");
        computer = new HardDrive(computer);
        printComputer(computer);
    }
}
