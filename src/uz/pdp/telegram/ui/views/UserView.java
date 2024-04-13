package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

public class UserView {
    public static int menu(){
        System.out.println("""
                1.chat
                2.group
                3.Search
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }


    public static void userProfile() {
        while (true) {
            int option = menu();
            switch (option) {
                case 1 -> ChatView.chatPart();
                case 2 -> GroupView.groupPart();
                case 0 -> {
                    return;
                }
            }
        }

    }
}
