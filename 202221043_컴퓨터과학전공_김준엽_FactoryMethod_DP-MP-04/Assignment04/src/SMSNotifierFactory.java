public class SMSNotifierFactory implements NotifierFactory {

    @Override
    public AbstractNotifier create() {
        return new SMSNotifier();
    }
}
