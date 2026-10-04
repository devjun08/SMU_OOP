public class RainyDayStrategy implements FlightStrategy {

    // 비 오는 날에는 건물 사이 우회하며 목적지까지 이동
    @Override
    public void fly(String destination) {
        System.out.println("비 오는 날: 건물 사이로 우회하며 " + destination + "까지 이동합니다.");
    }
}
