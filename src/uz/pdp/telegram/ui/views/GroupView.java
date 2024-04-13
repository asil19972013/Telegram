package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.enums.GroupType;
import uz.pdp.telegram.backend.enums.MassageType;
import uz.pdp.telegram.backend.model.Group;
import uz.pdp.telegram.backend.model.GroupChat;
import uz.pdp.telegram.backend.model.Massage;
import uz.pdp.telegram.backend.model.User;
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

import java.time.LocalDateTime;
import java.util.*;

public class GroupView {

    static GroupChatService groupChatService= GroupChatServiceImpl.getInstance();
    static GroupService groupService= GroupServiceImpl.getInstance();
    static UserService userService= UserServiceImpl.getInstance();
    static MassageService massageService= MassageServiceImpl.getInstance();

    public static int menu(){
        System.out.println("""
                1.Create group
                2.Send message to group
                3.See my own groups 
                4.See my group massage
                5.Delete group
                0.Exit    """);
        return ScanUtil.intScan("Choose ");

    }
    public static void createGroup(){
        while (true) {
            System.out.println("1.I want to add users to group \n2.I want to create group \n3.Back");
            int option = ScanUtil.intScan("Choose: ");
            switch (option) {
                case 1 -> {
                    User user = allUsers().get(ScanUtil.intScan("Choose: ") - 1);
                    GroupChat groupChat = new GroupChat(FrontEnd.curUser.getId(), user.getId());
                    groupChatService.create(groupChat);
                }
                case 2 -> {
                    if (groupChatService != null) {
                        List<GroupChat> all = groupChatService.getAll();
                        String groupName = ScanUtil.strScan("Give a name for your group");
                        for (GroupChat groupChat : all) {
                            Group group=new Group(groupChat.getId(),GroupType.PUBLIC,groupName);
                            groupService.create(group);
                        }
                        System.out.println("Created sucsessfuly✅✅✅");
                    } else {
                        System.out.println("You do not have users❌❌❌");
                    }
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Wrong option.Try again🔍🔍🔍");

            }
        }

    }


    public static void groupPart() {
          while (true){
              int option =menu();
              switch (option){
                  case 1->createGroup();
                  case 2->sendMassageToTheGroup();
                  case 3->seeAllMyGroups();
                  case 4->seeMyGroupMassage();
                  case 5->deleteGroup();
                  case 0-> {
                      return;
                  }


              }

          }


    }



    public static void seeMyGroupMassage () {
        List<Massage> massages = massageService.seeAllMassagesByAdminId(FrontEnd.curUser.getId());
        Set<String>massages1=new HashSet<>();
        for (Massage massage : massages) {
            massages1.add(massage.getWord());
        }
        for (String s : massages1) {
            System.out.println(s);
        }
    }




    public static Set<String> seeAllMyGroups() {
        Set<String>groups=new HashSet<>();
        int i=0;
        for (Group group : groupService.getAll()) {
          groups.add(group.getGroupName());
        }
        for (String group : groups) {
            System.out.println(i+1+"-"+group);
            i++;
        }
        return groups;
    }

    public static void deleteGroup() {

    }


    public static void sendMassageToTheGroup() {
        Set<String> strings = seeAllMyGroups();
        ArrayList<String> arrayList = new ArrayList<>(strings);
        String option = arrayList.get(ScanUtil.intScan("Choose: ") - 1);
        String word=ScanUtil.strScan("Send a massage: ");
        LocalDateTime localDateTime=LocalDateTime.now();
        for (Group group : groupService.getAll()) {
            if(group.getGroupName().equals(option)){
                GroupChat groupChat = groupChatService.get(group.groupChatId);
                Massage massage=new Massage(FrontEnd.curUser.getId(),groupChat.getUserId(), MassageType.GROUP,word,localDateTime);
                massageService.create(massage);
            }
        }
    }

    public static List<User>  allUsers(){
        List<User> users= userService.getAll();
        int i=0;
        for (User user : users) {
            System.out.println(i+1 +"-"+ user.getUsername());;
            i++;
        }
        return users;
    }
}
