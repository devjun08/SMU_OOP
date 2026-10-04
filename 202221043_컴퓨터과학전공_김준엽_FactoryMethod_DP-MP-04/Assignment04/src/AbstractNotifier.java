public abstract class AbstractNotifier {

    public void prepareMessage() {
        System.out.println("메시지를 준비합니다.");
    }

    public abstract void sendMessage();

    public void logNotification() {
        System.out.println("알림을 로그에 기록합니다.");
    }
}
