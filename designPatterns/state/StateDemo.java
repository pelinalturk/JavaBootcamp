package designPatterns.state;

import java.util.Arrays;
import java.util.List;

public class StateDemo {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Pelin", 22),
                new User("Selin", 21)
        );
        Context context = new Context();
        FilterByName filterByName = new FilterByName();
        FilterByAge filterByAge = new FilterByAge();

        context.setState(filterByName);
        context.filterUsers(users, "Pelin");

        context.setState(filterByAge);
        context.filterUsers(users, "21");
    }
}
