public class WindyDayStrategy implements FlightStrategy {

    // 바람 부는 날에는 저고도에 안정적으로 destination까지 이동
    @Override
    public void fly(String destination) {
        System.out.println("바람이 부는 날: 저고도에서 안정적으로 " + destination + "까지 이동합니다.");
    }
}
