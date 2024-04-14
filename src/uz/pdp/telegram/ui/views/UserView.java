package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;

public class UserView {
    static UserService userService=UserServiceImpl.getInstance();
    public static int menu(){
        System.out.println("""
                1.Chat
                2.Group
                3.Search
                4.Settings
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

    static ChatService chatService = ChatServiceImpl.getInstance();

    public static void userProfile() {
        System.out.println("Your account created !!! ");
        while (true) {
            int option = menu();
            switch (option) {
                case 1 -> ChatView.chatPart();
                case 2 -> GroupView.groupPart();
                case 3 -> ChatView.allChats();
                case 4 -> SettingView.settingPart();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Wrong option try again!!!");
            }
        }

    }

    public static List<User> allMyUsers(){
        List<User> all = userService.getAll();
        int i=0;
        for (User user : all) {
            System.out.println(i+1+"-"+user.getUsername());
            i++;
        }
        return all;
    }


}
