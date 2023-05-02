package designPatterns.state;

import java.util.List;

public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void filterUsers(List<User> users, String filterValue) {
        state.filter(users, filterValue);
    }

    public String getStatus(){
        return state.getStatus();
    }
}
