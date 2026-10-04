public class ThresholdAlert implements Observer {

    private final int upperLimit;
    private final int lowerLimit;

    public ThresholdAlert(int upperLimit, int lowerLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    @Override
    public void update(
            String stockName,
            int oldPrice,
            int newPrice
    ) {
        if (newPrice >= upperLimit) {
            System.out.printf(
                    "[상한 알림] %s: %d (기준: %d 이상)%n",
                    stockName,
                    newPrice,
                    upperLimit
            );
        }

        if (newPrice <= lowerLimit) {
            System.out.printf(
                    "[하한 알림] %s: %d (기준: %d 이하)%n",
                    stockName,
                    newPrice,
                    lowerLimit
            );
        }
    }
}