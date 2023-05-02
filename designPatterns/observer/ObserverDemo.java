package designPatterns.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        // Create a news agency
        NewsAgency newsAgency = new NewsAgency();

// Create subscribers
        Subscribe emailSubscribe = new EmailSubscribe("John");
        Subscribe smsSubscribe = new SmsSubscribe("Jane");

// Subscribe to news agency
        newsAgency.subscribe(emailSubscribe);
        newsAgency.subscribe(smsSubscribe);

// Send notifications to subscribers
        newsAgency.sendNotifications();

// Unsubscribe from news agency
        System.out.println("\nJohn Unsubscribed from news agency");
        newsAgency.unSubscribe(emailSubscribe);

// Send notifications to remaining subscribers
        newsAgency.sendNotifications();
    }
}
