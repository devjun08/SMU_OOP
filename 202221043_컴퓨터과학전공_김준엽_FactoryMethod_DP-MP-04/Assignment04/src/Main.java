import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("알림 방식을 입력하세요 (email, sms, push / 종료: quit): ");
        String type = sc.next();

        // 여전히 결합성이 높음
        /*
        NotifierFactory[] factories = {
                new EmailNotifierFactory(),
                new SMSNotifierFactory(),
                new PushNotifierFactory()
        };

        for (NotifierFactory factory : factories) {

            AbstractNotifier notifier = factory.create();

            notifier.prepareMessage();
            notifier.sendMessage();
            notifier.logNotification();

            System.out.println();
        }
        */

        while (!type.equals("quit")) {

            NotifierFactory factory =
                    NotifierFactoryManager.getFactory(type);

            AbstractNotifier notifier = factory.create();

            notifier.prepareMessage();
            notifier.sendMessage();
            notifier.logNotification();

            System.out.println();

            System.out.print("알림 방식을 입력하세요 (email, sms, push / 종료: quit): ");
            type = sc.next();
        }

        sc.close();
    }
}
