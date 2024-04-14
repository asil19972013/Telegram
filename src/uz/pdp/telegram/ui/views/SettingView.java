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
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.Formattable;
import java.util.List;


public class SettingView {
    static ChatService chatService= ChatServiceImpl.getInstance();
    static GroupService groupService = GroupServiceImpl.getInstance();
    static UserService userService = UserServiceImpl.getInstance();


    public static void settingPart() {
        while (true) {
            int menu = menu();
            System.out.println();
            switch (menu){
                case 1->chatSetting();
                case 2->groupSetting();
                case 3-> profileSetting();
                case 0-> {
                    return;
                }
                default -> System.out.println("Wrong option try again!!!");
            }
            System.out.println();
        }
    }

    public static void chatSetting(){
        while (true) {
            int menu = ScanUtil.intScan("1.create contact \n2.delet chat \n0 exit \nchoose: ");
            System.out.println();
            switch (menu){
                case 1->addKontakt();
                case 2->createGroup();
                case 3-> viewProfile();
                case 0-> {
                    return;
                }
                default -> System.out.println("Wrong option try again!!!");
            }
            System.out.println();
        }
    }

    public static void groupSetting(){
        while (true) {
            int menu = ScanUtil.intScan("1.create group \n2.delet group \n0 exit \nchoose: ");
            System.out.println();
            switch (menu){
                case 1->createGroup();
                case 2->createGroup();
                case 3-> viewProfile();
                case 0-> {
                    return;
                }
                default -> System.out.println("Wrong option try again!!!");
            }
            System.out.println();
        }
    }


    public static void createGroup(){
        String groupName=ScanUtil.strScan("Enter group name: ");
        Group group=new Group(groupName,FrontEnd.curUser.getId());
        groupService.create(group);
        System.out.println("Sucseesfully added✅✅✅");

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
      System.out.println("Your name successfully changed!!");
  }
  public static void changeNumber(){
      String number=ScanUtil.strScan("What is your new number +998: ");
      FrontEnd.curUser.setPhone(number);
      System.out.println("Your number successfully changed!!");
  }
  public static void deleteAccount(){
        userService.delete(FrontEnd.curUser.getId());
      System.out.println("Your account deleted!!!");
      FrontEnd.main();
  }


    public static int menu(){
        System.out.println("""
                1.Chat setting
                2.Groups setting
                3.Profile setting
                """);
      return   ScanUtil.intScan("Choose: ");
    }
    private static void addKontakt() {
        List<User> users = userService.getAll();
        boolean equals=false;
        User user2 = null;
        String choose=ScanUtil.strScan("Enter users number +998: ");
        for (User user : users) {
            equals = user.getPhone().equals(choose);
            if (equals){
                user2=user;}
        }
        if(equals){
            Chat chat = new Chat(FrontEnd.curUser.getId(), user2.getId());
            chatService.create(chat);
            System.out.println("Successfully added!!!");
        } else {
            System.out.print("Do not have this account in telegram!!!");
            System.out.println();;
        }

    }
    public static void profileSetting(){
        while (true) {
            int menu = ScanUtil.intScan("1.change number \n2.change name \n3.view profile \n0 exit \nchoose: ");
            System.out.println();
            switch (menu){
                case 1->changeNumber();
                case 2->changeName();
                case 3->viewProfile();
                case 0-> {
                    return;
                }
                default -> System.out.println("Wrong option try again!!!");
            }
            System.out.println();
        }
    }



}
