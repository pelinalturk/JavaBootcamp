package designPatterns.observer;

public interface Observer {
    void subscribe(Subscribe subscribe);
    void unSubscribe(Subscribe subscribe);
    void sendNotifications();
}
