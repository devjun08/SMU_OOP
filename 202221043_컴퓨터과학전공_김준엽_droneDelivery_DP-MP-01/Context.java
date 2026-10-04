public class Context {

    // 현재 드론 사용할 비행 전략 선택
    private FlightStrategy strategy;

    // SunnyDayStrategy로 초기화
    public Context() {
        strategy = new SunnyDayStrategy();
    }

    // 날씨가 변경되 사용할 비행 전략 교체
    public void setFlightStrategy(FlightStrategy strategy) {
        this.strategy = strategy;
    }

    // 현재 설정된 전략으로 배송
    public void deliver(String destination) {
        strategy.fly(destination);
    }
}
