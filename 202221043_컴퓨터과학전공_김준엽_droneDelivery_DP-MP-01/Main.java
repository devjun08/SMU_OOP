import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // 난수 생성을 위한 객체
        Random random = new Random();

        // 배송을 수행할 객체 - 기본값은 SunnyDayStrategy
        Context context = new Context();

        // 배송을 총 5번 수행
        for (int i = 0; i < 5; i++) {

            // 0 ~ 29999 사이의 난수 발생
            int weather = random.nextInt(30000);

            // 난 값에 따라 비행 전략 선택
            if (weather <= 9999) {
                context.setFlightStrategy(new SunnyDayStrategy());
            } else if (weather <= 19999) {
                context.setFlightStrategy(new RainyDayStrategy());
            } else if (weather <= 29999) {
                context.setFlightStrategy(new WindyDayStrategy());
            }

            // 현재 선택된 전략으로 배송
            context.deliver("우리집");
        }
    }
}
