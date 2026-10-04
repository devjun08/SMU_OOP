public class SecurityNotification extends NotificationDecorator {
    public SecurityNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void show() {
        notification.show();
        System.out.println("보안: 현관문 열림 감지");
    }
}
