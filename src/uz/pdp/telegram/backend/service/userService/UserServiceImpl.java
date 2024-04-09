package uz.pdp.telegram.backend.service.userService;

import uz.pdp.telegram.backend.dto.LoginDto;
import uz.pdp.telegram.backend.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService{


    List<User>userList;


    public UserServiceImpl() {
        this.userList = new ArrayList<>();
    }

    @Override
    public User login(LoginDto login) {

        for (User user : userList) {
            if(Objects.equals(user.getName(),login.name())&&
                    Objects.equals(user.getPassword(),login.password())){
                return user;
            }
        }
        return null;

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


    static UserService userService;


    public static UserService getInstance(){
        if(userService==null){
            userService=new UserServiceImpl();
        }
        return  userService;
    }
}
