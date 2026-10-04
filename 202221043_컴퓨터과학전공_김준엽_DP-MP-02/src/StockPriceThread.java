import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class StockPriceThread implements Subject, Runnable {

    private final String stockName;
    private int price;
    private final List<Observer> observers;

    private static final int SLEEP_TIME = 1000;
    private static final int UPDATE_COUNT = 10;

    public StockPriceThread(String stockName) {
        this.stockName = stockName;

        // 초기 가격: 30 ~ 150
        this.price = ThreadLocalRandom.current()
                .nextInt(30, 151);

        observers = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int oldPrice, int newPrice) {
        for (Observer observer : observers) {
            observer.update(stockName, oldPrice, newPrice);
        }
    }

    private void changePrice() {
        int oldPrice = price;

        // 가격 변동 폭: 10 ~ 20
        int difference = ThreadLocalRandom.current()
                .nextInt(10, 21);

        // 상승 또는 하락
        boolean increase = ThreadLocalRandom.current()
                .nextBoolean();

        if (increase || price < difference) {
            price += difference;
        } else {
            price -= difference;
        }

        // 가격이 음수가 되지 않도록 처리
        price = Math.max(0, price);

        if (oldPrice != price) {
            notifyObservers(oldPrice, price);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < UPDATE_COUNT; i++) {
            try {
                Thread.sleep(SLEEP_TIME);
                changePrice();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}