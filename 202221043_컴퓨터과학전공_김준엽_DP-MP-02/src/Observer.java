public interface Observer {
    void update(String stockName, int oldPrice, int newPrice);
}
