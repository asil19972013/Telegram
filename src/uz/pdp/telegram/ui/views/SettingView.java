package uz.pdp.telegram.ui.views;

import com.sun.tools.javac.Main;
import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.Group;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;
import uz.pdp.telegram.backend.service.groupChatService.GroupChatService;
import uz.pdp.telegram.backend.service.groupChatService.GroupChatServiceImpl;
import uz.pdp.telegram.backend.service.groupService.GroupService;
import uz.pdp.telegram.backend.service.groupService.GroupServiceImpl;
import uz.pdp.telegram.backend.service.massageService.MassageService;
import uz.pdp.telegram.backend.service.massageService.MassageServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;


public class SettingView {
    static ChatService chatService= ChatServiceImpl.getInstance();
    static GroupService groupService = GroupServiceImpl.getInstance();
    static GroupChatService groupChatService = GroupChatServiceImpl.getInstance();
    static MassageService massageService = MassageServiceImpl.getInstance();

    public static void settingPart() {
        while (true) {
            int menu = menu();
            switch (menu){
                case 1-> addKontakt();
                case 2->createGroup();
                case 3-> addBio();
                case 4-> viewProfile();
                case 5-> changeName();
                case 6-> changeNumber();
                case 7-> deleteAccount();
                case 0-> {
                    return;
                }
            }
        }
    }


    public static void createGroup(){
        String groupName=ScanUtil.strScan("Enter group name");
        Group group=new Group(groupName,FrontEnd.curUser.getId());
        groupService.create(group);
        System.out.println("Sucseesfully added✅✅✅");

    }


    private static void addKontakt() {
        List<User> users = UserView.allMyUsers();
        User user = users.get(ScanUtil.intScan("Choose: ") - 1);
        Chat chat=new Chat(FrontEnd.curUser.getId(),user.getId());
        chatService.create(chat);
    }
    public static void addBio(){

    }
   public static void viewProfile(){
       System.out.println("Your name: "+FrontEnd.curUser.getUsername());
       System.out.println("Your phone number: "+FrontEnd.curUser.getPhone());
       System.out.println("Your phone password: "+FrontEnd.curUser.getPassword());
  }
  public static void changeName(){
      String name=ScanUtil.strScan("What is your new name: ");
      FrontEnd.curUser.setUsername(name);
  }
  public static void changeNumber(){
      String number=ScanUtil.strScan("What is your new number: ");
      FrontEnd.curUser.setPhone(number);
  }
  public static void deleteAccount(){
  }


    public static int menu(){
        System.out.println("""
                1.Add kontakt
                2.Create Group
                3.Add bio
                4.View profile
                5.Change name
                6.Change number
                7.Delete account
                0.Exit
                """);
      return   ScanUtil.intScan("Choose: ");
    }



}
