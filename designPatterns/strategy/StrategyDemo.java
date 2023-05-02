package designPatterns.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        Item item1 = new Item("upcCode001", 250);
        Item item2 = new Item("upcCode002", 150);
        Item item3 = new Item("upcCode003", 100);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        cart.pay(new CreditCardStrategy("Pelin","1234567891234567", "123","09/28"));

        cart.removeItem(item3);
        cart.pay(new PaypalStrategy("myemail@gmail.com", "mysecretpassword"));
    }
}
