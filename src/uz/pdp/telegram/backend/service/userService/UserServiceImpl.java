package uz.pdp.telegram.backend.service.userService;

import uz.pdp.telegram.backend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    List<User>userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(User user) {

    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}
