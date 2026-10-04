
public class Main {

    public static void main(String[] args) {

        // 주식 종목 생성
        StockPriceThread samsung =
                new StockPriceThread("삼성전자");

        StockPriceThread hynix =
                new StockPriceThread("하이닉스");

        StockPriceThread hyundai =
                new StockPriceThread("현대자동차");

        // 옵저버 생성
        Observer logger = new PriceLogger();

        Observer alert = new ThresholdAlert(120, 60);

        // 옵저버 등록
        samsung.addObserver(logger);
        samsung.addObserver(alert);

        hynix.addObserver(logger);
        hynix.addObserver(alert);

        hyundai.addObserver(logger);
        hyundai.addObserver(alert);

        // 종목별 스레드 생성
        Thread thread1 = new Thread(samsung);
        Thread thread2 = new Thread(hynix);
        Thread thread3 = new Thread(hyundai);

        // 스레드 시작
        thread1.start();
        thread2.start();
        thread3.start();

        // 모든 스레드의 종료 대기
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("주식 시세 확인 종료");
    }
}