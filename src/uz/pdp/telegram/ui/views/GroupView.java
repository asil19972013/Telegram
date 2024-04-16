package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.enums.GroupType;
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

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class GroupView {

    static GroupChatService groupChatService= GroupChatServiceImpl.getInstance();
    static GroupService groupService= GroupServiceImpl.getInstance();
    static UserService userService= UserServiceImpl.getInstance();
    static MassageService massageService= MassageServiceImpl.getInstance();


    public static void groupSetting(){
        while (true) {
            int menu = ScanUtil.intScan("1.create group \n2.delet group \n3.add user to group \n0.exit \nchoose: ");
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
        String show = GroupType.show();
        System.out.println(show);
        GroupType type = GroupType.getType(ScanUtil.intScan("Choose: "));
        Group group=new Group(groupName,FrontEnd.curUser.getId(),type);
        groupService.create(group);
        System.out.println("Group sucseesfully created✅✅✅");

    }



    public static void groupPart(){
        while (true) {
            System.out.println("1.My created group \n2.Invited me group \n3.Search by group name \n0.Exit");

            Integer option = ScanUtil.intScan("Choose: ");

            if (!Character.isAlphabetic(option)) {

                switch (option) {
                    case 1 -> created();
                    case 2 -> initedMeGroup();
                    case 3 -> searchByGroupName();
                    case 0 -> {
                        return;
                    }
                }

            } else System.out.println("It is not a number❌❌❌");
        }

    }

    private static void searchByGroupName() {
        String search = ScanUtil.strScan("Search.......\n");
        List<Group> groups = groupService.seeAllGroupByName(search);
        int i=0;
        for (Group group : groups) {
            Group group1 = groupService.get(group.getId());
            System.out.println(i+1+"-"+group1.getGroupName());
            i++;
        }
        if(groups.isEmpty()){
            System.out.println("Do not have group like this name❌❌❌");
        }
        else {
            Integer choose = ScanUtil.intScan("Choose: ") - 1;
            if (!(Character.isAlphabetic(choose))) {
                Group group = groupService.get(groups.get(choose).getId());
                if (group.getGroupType().equals(GroupType.PUBLIC)) {
                    List<Massage> massages = massageService.seeAllMassagesByGroup(FrontEnd.curUser.getId(), group.getId());
                    for (Massage massage : massages) {
                        User user = userService.get(massage.getFrom());
                        System.out.println(user.getUsername() + "-" + massage.getWord());
                    }
                    while (true) {
                        Integer j = ScanUtil.intScan("0.Back 1.Massage \nchoose: ");
                        if (j == 0) return;
                        String word = ScanUtil.strScan("write a message here: ");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new Date();
                        String format = simpleDateFormat.format(date);
                        Massage massage = new Massage(FrontEnd.curUser.getId(), group.getId(), word, simpleDateFormat);
                        massageService.create(massage);


                    }
                } else {
                    List<Massage> massages = massageService.seeAllMassagesByGroup(FrontEnd.curUser.getId(), group.getId());
                    for (Massage massage : massages) {
                        User user = userService.get(massage.getFrom());
                        System.out.println(user.getUsername() + "-" + massage.getWord());
                    }
                }
            } else System.out.println("It is not a number❌❌❌");

        }



    }

    private static void initedMeGroup() {
        List<GroupChat> groupChats = groupChatService.allInvitedMeGroup(FrontEnd.curUser.getId());
        int i=0;
        for (GroupChat groupChat : groupChats) {
            Group group = groupService.get(groupChat.getGroupId());
            System.out.println(i+1+"-"+group.getGroupName());
            i++;
        }
        if(groupChats.isEmpty()){
            System.out.println("Nobody invited you❌❌❌");
        }
        else {
            Integer choose = ScanUtil.intScan("Choose: ") - 1;
            if (!(Character.isAlphabetic(choose))) {
                Group group = groupService.get(groupChats.get(choose).getGroupId());
                if (group.getGroupType().equals(GroupType.PUBLIC)) {
                    List<Massage> massages = massageService.seeAllMassagesByGroup(FrontEnd.curUser.getId(), group.getId());
                    for (Massage massage : massages) {
                        User user=userService.get(massage.getFrom());
                        System.out.println(user.getUsername()+"-"+massage.getWord());
                    }
                    while (true) {
                        Integer j = ScanUtil.intScan("0.Back 1.Massage \nchoose: ");
                            if (j == 0) return;
                            String word = ScanUtil.strScan("write a message here: ");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            Date date=new Date();
                            String format = simpleDateFormat.format(date);
                        Massage massage = new Massage(FrontEnd.curUser.getId(), group.getId(), word, simpleDateFormat);
                            massageService.create(massage);


                    }
                } else {
                    List<Massage> massages = massageService.seeAllMassagesByGroup(FrontEnd.curUser.getId(), group.getId());
                    for (Massage massage : massages) {
                        User user=userService.get(massage.getFrom());
                        System.out.println(user.getUsername()+"-"+massage.getWord());
                    }
                }
            } else System.out.println("It is not a number❌❌❌");

        }
    }


    private static void created() {
        List<Group> groups = seeAllMyGroups();
        if(groups.isEmpty()){
            return;
        }
        else {
            Group group = groups.get(ScanUtil.intScan("Choose: ") - 1);
            List<Massage> massages = massageService.seeAllMassagesByGroup(FrontEnd.curUser.getId(), group.getId());
            for (Massage massage : massages) {
                if (massage.getTo().equals(group.getId())) {
                    User user = userService.get(massage.getFrom());
                    System.out.println(user.getUsername() + "-" + massage.getWord());
                }
            }
            while (true) {
                Integer i = ScanUtil.intScan("0.Back 1.Massage \nchoose: ");
                if (!(Character.isAlphabetic(i))) {
                    if (i == 0) return;
                    String word = ScanUtil.strScan("write a message here: ");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Massage massage = new Massage(FrontEnd.curUser.getId(), group.getId(), word, simpleDateFormat);
                    massageService.create(massage);
                }
                else System.out.println("it is not correct option❌❌❌");
            }

        }
    }


    private static void addUsersToGroup() {
        if(groupService.allMyGroups(FrontEnd.curUser.getId()).isEmpty()){
            System.out.println("You do not any groups !!! ");
            return;}
        List<Group> groups = seeAllMyGroups();
        Group group = groups.get(ScanUtil.intScan("Choose: ") - 1);
        List<User> all = userService.getAll();
        int i=0;
        for (User user : all) {
            System.out.println(i+1+" "+user.getUsername());
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
                System.out.println(i+1+" "+group.getGroupName());
                i++;
            }
        }
        return groups;
    }

    public static void deleteGroup() {
        if(seeAllMyGroups().isEmpty()) return;
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
