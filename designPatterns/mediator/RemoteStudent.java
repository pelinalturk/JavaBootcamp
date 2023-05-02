package designPatterns.mediator;

public class RemoteStudent implements User{
    String name;
    Dispatcher dispatcher;

    public RemoteStudent(String name, Dispatcher dispatcher) {
        this.name = name;
        this.dispatcher = dispatcher;
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received : " + message);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " send : " + message);
        dispatcher.sendMessage(message, this);
    }
}
