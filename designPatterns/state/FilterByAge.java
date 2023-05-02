package designPatterns.state;

import java.util.List;

public class FilterByAge implements State {

    @Override
    public void filter(List<User> users, String filterValue) {
        System.out.println("Filtered users by age:");
        for (User user : users) {
            if (user.getAge() == Integer.parseInt(filterValue)) {
                System.out.println(user);
            }
        }
    }

    @Override
    public String getStatus() {
        return "Filtered users by age";
    }
}
