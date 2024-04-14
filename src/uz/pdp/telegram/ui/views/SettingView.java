package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;


public class SettingView {
    static ChatService chatService= ChatServiceImpl.getInstance();
    public static void settingPart() {
        while (true) {
            int menu = menu();
            switch (menu){
                case 1->createUser();
                case 2->createGroup();
                case 0-> {
                    return;
                }
            }
        }
    }


    private static void createGroup(){

    }


    private static void createUser() {
        List<User> users = UserView.allMyUsers();
        User user = users.get(ScanUtil.intScan("Choose: ") - 1);
        Chat chat=new Chat(FrontEnd.curUser.getId(),user.getId());
        chatService.create(chat);
    }


    public static int menu(){
        System.out.println("""
                1.Create user
                2.Create Group
                3.Change coulur
                0.Exit
                """);
      return   ScanUtil.intScan("Choose: ");
    }



}
