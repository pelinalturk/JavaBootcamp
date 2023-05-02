package designPatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item>items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
        System.out.println("item added: " + item);
    }

    public void removeItem(Item item){
        items.remove(item);
        System.out.println("item deleted: " + item);
    }

    public int calculateTotal(){
        int total = 0;
        for(Item item: items){
            total+=item.getPrice();
        }
        return total;
    }

    public void pay(PaymentStrategy paymentStrategy){
        paymentStrategy.pay(calculateTotal());
    }
}
