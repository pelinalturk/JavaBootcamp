package designPatterns.mediator;

public class OnSiteStudent implements User{

    private String name;
    private Dispatcher dispatcher;

    public OnSiteStudent(String name, Dispatcher dispatcher){
        this.name = name;
        this.dispatcher = dispatcher;
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        dispatcher.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " received : " + message);
    }
}
