public class PowerUsageNotification extends NotificationDecorator {
    public PowerUsageNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void show() {
        notification.show();
        System.out.println("전력 사용량: 1.2kWh");
    }
}
