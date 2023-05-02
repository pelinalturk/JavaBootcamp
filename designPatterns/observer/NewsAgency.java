package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Observer{
    private List<Subscribe>allSubscribes;

    public NewsAgency() {
        allSubscribes = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscribe subscribe) {
        allSubscribes.add(subscribe);
    }

    @Override
    public void unSubscribe(Subscribe subscribe) {
        allSubscribes.remove(subscribe);
    }

    @Override
    public void sendNotifications() {
        for(Subscribe subscribe: allSubscribes){
            subscribe.sendNotification();
        }
    }
}
