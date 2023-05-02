package designPatterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class DispatcherMediator implements  Dispatcher{

    private List<User> allUsers;

    public DispatcherMediator() {
        allUsers = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User receiver : allUsers) {
            if (user != receiver) {
                receiver.receive(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        allUsers.add(user);
    }
}
