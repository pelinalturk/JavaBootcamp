package designPatterns.strategy;

public class Item {
    private String upcCode;
    private int price;

    public Item(String upcCode, int price) {
        this.upcCode = upcCode;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "upCode='" + upcCode + '\'' +
                ", price=" + price +
                '}';
    }
}
