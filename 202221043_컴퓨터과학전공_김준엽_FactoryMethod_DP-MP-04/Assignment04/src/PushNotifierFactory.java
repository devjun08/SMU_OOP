public class PushNotifierFactory implements NotifierFactory {

    @Override
    public AbstractNotifier create() {
        return new PushNotifier();
    }
}
