public class PriceLogger implements Observer {

    @Override
    public void update(
            String stockName,
            int oldPrice,
            int newPrice
    ) {
        System.out.printf(
                "[가격 변동] %s: %d → %d%n",
                stockName,
                oldPrice,
                newPrice
        );
    }
}