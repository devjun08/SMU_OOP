public abstract class AbstractExternalDevice implements AbstractNotebookComputer {
    private String deviceType;
    private int spaceSize;
    protected AbstractNotebookComputer computer;

    public AbstractExternalDevice(AbstractNotebookComputer computer,
                                  String type, int size) {
        this.computer = computer;
        this.deviceType = type;
        this.spaceSize = size;
    }

    @Override
    public double requiredSpace() {
        // 기존 장치 전체의 공간에 이번 주변기기의 공간을 더한다.
        return computer.requiredSpace() + spaceSize;
    }

    @Override
    public String toString() {
        return computer.toString() + ", " + deviceType;
    }
}
