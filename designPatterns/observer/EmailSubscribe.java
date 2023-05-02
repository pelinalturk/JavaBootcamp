package designPatterns.observer;

public class EmailSubscribe implements Subscribe{

    private String name;

    public EmailSubscribe(String name) {
        this.name = name;
    }

    @Override
    public void sendNotification() {
        System.out.println(name + " received an SMS from the news agency.");
    }
}
