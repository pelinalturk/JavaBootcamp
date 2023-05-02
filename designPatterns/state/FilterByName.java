package designPatterns.state;

import java.util.List;

public class FilterByName implements State{

    @Override
    public void filter(List<User> users, String filterValue) {
        System.out.println("Filtered users by name:");
        for (User user : users) {
            if (user.getName().equals(filterValue)) {
                System.out.println(user);
            }
        }
    }

    @Override
    public String getStatus() {
        return "Users filtered by name";
    }
}
