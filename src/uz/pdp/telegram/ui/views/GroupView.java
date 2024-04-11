package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.GroupChat;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.groupChatService.GroupChatService;
import uz.pdp.telegram.backend.service.groupChatService.GroupChatServiceImpl;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;

public class GroupView {

    static GroupChatService groupChatService= GroupChatServiceImpl.getInstance();
    static UserService userService= new UserServiceImpl();

    public static int menu(){
        System.out.println("""
                1.Create group
                2.Send message to group
                3.See my own groups 
                4.Delete group
                0.Exit    """);
        return ScanUtil.intScan("Choose ");

    }
    public static void createGroup(){
        List<User> users= userService.getAll();
        int i=1;
        for (User user : users) {
            System.out.println(user+""+i);
        }
        users.get( ScanUtil.intScan("Choose: ")-1);

    }


    public static void groupPart() {
          while (true){
              int option =menu();
              switch (option){
                  case 1:


              }

          }


    }
}
