
class SubtractValueCommand implements Command {
    private int x;
    private int y;

    public SubtractValueCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int execute() {
        return x - y;
    }
}
