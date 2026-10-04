public class EmailNotifier extends AbstractNotifier {

    @Override
    public void sendMessage() {
        System.out.println("이메일로 전송합니다.");
    }
}