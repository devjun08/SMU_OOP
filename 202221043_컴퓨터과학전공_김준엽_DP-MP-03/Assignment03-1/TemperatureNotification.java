public class TemperatureNotification extends NotificationDecorator {
    public TemperatureNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void show() {
        notification.show();
        System.out.println("온도: 23도");
    }
}
