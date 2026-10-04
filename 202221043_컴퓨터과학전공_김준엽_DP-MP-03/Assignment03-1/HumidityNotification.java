public class HumidityNotification extends NotificationDecorator {
    public HumidityNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void show() {
        notification.show();
        System.out.println("습도: 45%");
    }
}
