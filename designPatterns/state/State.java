package designPatterns.state;

import java.util.List;

public interface State {
    void filter(List<User> users, String filterValue);
    String getStatus();
}
