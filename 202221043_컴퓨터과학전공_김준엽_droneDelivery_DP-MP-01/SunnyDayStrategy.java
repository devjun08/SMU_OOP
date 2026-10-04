public class SunnyDayStrategy implements FlightStrategy {

    // 맑은 날씨에 직선 경로로 빠르게 destination까지 이동
    @Override
    public void fly(String destination) {
        System.out.println("맑은 날: 직선 경로로 빠르게 " + destination + "까지 이동합니다.");
    }
}
