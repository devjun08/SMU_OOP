class SquareValueCommand implements Command {
    private int x;

    public SquareValueCommand(int x) {
        this.x = x;
    }

    @Override
    public int execute() {
        return x * x;
    }
}
