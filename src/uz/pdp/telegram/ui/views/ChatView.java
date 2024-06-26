package uz.pdp.telegram.ui.views;

import com.sun.source.doctree.BlockTagTree;
import uz.pdp.telegram.backend.enums.MassageStatus;
import uz.pdp.telegram.backend.enums.MassageType;
import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.Massage;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;
import uz.pdp.telegram.backend.service.massageService.MassageService;
import uz.pdp.telegram.backend.service.massageService.MassageServiceImpl;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.SimpleTimeZone;


public class ChatView {

    static UserService userService = UserServiceImpl.getInstance();
    static ChatService chatService = ChatServiceImpl.getInstance();
    static MassageService massageService= MassageServiceImpl.getInstance();


    public static void chatSetting(){
        while (true) {
            int menu = ScanUtil.intScan("1.create contact \n2.delete contact \n0 exit \nchoose: ");
            System.out.println();
            switch (menu){
                case 1->addKontakt();
                case 2->deleteChat();
                case 3-> myChats();
                case 0-> {
                    return;
                }
                default -> System.out.println("Wrong option try again!!!");
            }
            System.out.println();
        }
    }

public static void chatPart() {
    List<Chat> chats = myChats();
    boolean isTrue = true;
        if (!(chats.isEmpty())) {
            User user = userService.get(chats.get(ScanUtil.intScan("Choose: ") - 1).getUser2Id());
            while (isTrue) {
                List<Massage> massages = massageService.throughUserSeeAllMassages(FrontEnd.curUser.getId(), user.getId());
                for (Massage massage : massages) {
                    System.out.println(massage.getWord());
                }
                Integer i = ScanUtil.intScan("0.Back 1.Massage \nchoose: ");
                if (i == 0) return;
                String strMass = ScanUtil.strScan("write a message here: ");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Massage massage = new Massage(FrontEnd.curUser.getId(), user.getId(), strMass, MassageStatus.UNREADED, simpleDateFormat);
                massageService.create(massage);
            }
        }else {System.out.println("You do not have users👩‍💻👩‍💻👩‍💻");}

}



public static void deleteChat(){
        if (myChats().isEmpty()){
            System.out.println("You do not have users👩‍💻👩‍💻👩‍💻");
            return;
        }
       myChats();
       int choose= ScanUtil.intScan("Enter deletiton person: ")-1;
       delete(choose);
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

    private static void delete(int choose){
        List<Chat> chats = chatService.seeAllMyChats(FrontEnd.curUser.getId());
        for (int i = 0; i <chats.size(); i++) {
            Chat chat= chats.get(i);
            if(choose==i){
                chatService.delete(chat.getId());
                System.out.println("Your contact deleted!!! ");
            }
        }
    }

    public static List<Chat>myChats(){
        List<Chat> chats = chatService.seeAllMyChats(FrontEnd.curUser.getId());
        int i=1;
        for (Chat chat : chats) {
            User user = userService.get(chat.getUser2Id());
            System.out.println(i+" "+user.getUsername());
            i++;
        }

        return chats;
    }

}
