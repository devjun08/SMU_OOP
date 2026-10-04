import java.util.Random;

public class NotificationMain {
    public static void main(String[] args) {
        Random random = new Random();
        Notification notification = new BasicNotification();

        for (int i = 0; i < 3; i++) {
            // 현재 알림을 감싸는 후보들을 배열에 저장한다.
            // 같은 종류가 다시 뽑혀도 별개의 객체로 추가되도록 매번 생성한다.
            NotificationDecorator[] decorators = {
                new TemperatureNotification(notification),
                new HumidityNotification(notification),
                new SecurityNotification(notification),
                new PowerUsageNotification(notification)
            };

            int index = random.nextInt(decorators.length);
            notification = decorators[index];
        }

        notification.show();
    }
}
