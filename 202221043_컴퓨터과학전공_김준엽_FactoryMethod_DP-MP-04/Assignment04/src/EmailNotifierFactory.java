public class EmailNotifierFactory implements NotifierFactory {

    @Override
    public AbstractNotifier create() {
        return new EmailNotifier();
    }
}
