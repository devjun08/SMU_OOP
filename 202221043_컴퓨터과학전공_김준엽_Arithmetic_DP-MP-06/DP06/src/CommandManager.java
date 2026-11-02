import java.util.List;
import java.util.ArrayList;

class CommandManager {
    private List<Command> opList;

    public CommandManager() {
        opList = new ArrayList<>();
    }

    public void addOperation(Command op) {
        opList.add(op);
    }

    public void performOperations() {
        for (Command command : opList) {
            System.out.println(command.execute());
        }
    }
}