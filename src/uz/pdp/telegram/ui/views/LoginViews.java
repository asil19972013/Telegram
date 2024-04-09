package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.dto.LoginDto;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.utils.ScanUtil;

public class LoginViews {

    static UserService userService= UserServiceImpl.getInstance();

    public static User logIn(){
        System.out.println("Enter Login Info-->");
        String username = ScanUtil.strScan("Username: ");
        String password = ScanUtil.strScan("Password: ");
        User login =userService.login(new LoginDto(username,password));
        return login;
    }

    public static int menu(){
        System.out.println("""
                1.Log In
                2.Sign Up
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

}
