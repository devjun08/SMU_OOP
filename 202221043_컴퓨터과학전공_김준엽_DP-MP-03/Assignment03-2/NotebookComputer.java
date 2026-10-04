public class NotebookComputer implements AbstractNotebookComputer {
    private String owner;
    private int spaceSize;

    public NotebookComputer(String owner, int size) {
        this.owner = owner;
        this.spaceSize = size;
    }

    @Override
    public double requiredSpace() {
        return spaceSize;
    }

    @Override
    public String toString() {
        return owner + "의 Notebook computer";
    }
}
