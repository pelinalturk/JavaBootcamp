package designPatterns.mediator;

public interface Dispatcher {
    void sendMessage(String message, User user);
    void addUser(User user);
}
