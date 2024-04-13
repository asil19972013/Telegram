package uz.pdp.telegram.backend.service.userService;

import uz.pdp.telegram.backend.dto.LoginDto;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.ui.FrontEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService{
    List<User>userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
        userList.add(new User("user","555","userboy"));
    }

    @Override
    public User login(LoginDto login) {
        for (User user : userList) {
            if(Objects.equals(user.getUsername(),login.username())&&
                    Objects.equals(user.getPassword(),login.password())){
                return user;
            }
        }
        System.out.println("This user not logined!!!");
        return null;

    }
    @Override
    public boolean create(User user) {
        userList.add(user);
        return true;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(User user) {

    }

    @Override
    public User get(String id) {
        for (User user : userList) {
            if(Objects.equals(user.getId(),id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User>getList=new ArrayList<>();
        for (User user : userList) {
            if (!(Objects.equals(FrontEnd.curUser.getId(),user.getId()))){
                getList.add(user);
            }
        }
      return getList;
    }


    static UserService userService;


    public static UserService getInstance(){
        if(userService==null){
            userService=new UserServiceImpl();
        }
        return  userService;
    }
}
