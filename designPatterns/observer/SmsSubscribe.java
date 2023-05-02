package designPatterns.observer;

public class SmsSubscribe implements Subscribe{

    private String name;

    public SmsSubscribe(String name) {
        this.name = name;
    }

    @Override
    public void sendNotification() {
        System.out.println(name + " received an email from the news agency.");
    }
}
