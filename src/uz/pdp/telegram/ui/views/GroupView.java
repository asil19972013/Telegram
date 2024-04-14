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



    public static void groupSetting(){
        while (true) {
            int menu = ScanUtil.intScan("1.create group \n2.delet group \n3.add user to group \n0. exit \nchoose: ");
            System.out.println();
            switch (menu){
                case 1->createGroup();
                case 2->deleteGroup();
                case 3->addUsersToGroup();
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
    public static void groupPart(){
        seeAllMyGroups();

    }


    private static void addUsersToGroup() {
        List<Group> groups = seeAllMyGroups();
        Group group = groups.get(ScanUtil.intScan("Choose: ") - 1);
        List<User> all = userService.getAll();
        int i=0;
        for (User user : all) {
            System.out.println(user.getUsername());
            i++;
        }
        User user = all.get(ScanUtil.intScan("Choose: ") - 1);
        GroupChat groupChat=new GroupChat(group.getId(),user.getId());
        groupChatService.create(groupChat);
        System.out.println("Added sucsessfully✅✅✅");

    }


    public static List<Group> seeAllMyGroups() {
        List<Group> groups = groupService.allMyGroups(FrontEnd.curUser.getId());
        int i=0;
        if(groups.isEmpty()){
            System.out.println("You do not have group❌❌❌");
        }
        else {
            for (Group group : groups) {
                System.out.println(i+1+"-"+group.getGroupName());
                i++;
            }
        }
        return groups;
    }

    public static void deleteGroup() {
        List<Group> groups = seeAllMyGroups();
        Group group = groups.get(ScanUtil.intScan("Choose: ") - 1);
        groupService.delete(group.getId());
        System.out.println("Sucsessfully deleted✅✅✅");
    }


    public static List<User>allUsers(){
        List<User> users= userService.getAll();
        int i=0;
        for (User user : users) {
            System.out.println(i+1 +"-"+ user.getUsername());;
            i++;
        }
        return users;
    }
}
