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

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.SimpleTimeZone;


public class ChatView {

    static UserService userService = UserServiceImpl.getInstance();
    static ChatService chatService = ChatServiceImpl.getInstance();
    static MassageService massageService= MassageServiceImpl.getInstance();


    public static int menu(){
        System.out.println("""
                1.Create chat
                2.All chats
                3.Delete
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

    public static void createChat() {
        List<User> users = userService.getAll();
        boolean equals=false;
        User user2 = null;
        String choose=ScanUtil.strScan("Enter phone number: ");
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
            System.out.print("Do not have this account in telegram !!! ");
        }
        }



    public static void allChats() {
        List<Chat> chats = chatService.seeAllMyChats(FrontEnd.curUser.getId());
        if (chats.isEmpty()){
            System.out.println("You do not have any accounts !!! ");
        }

        int i=0;
        for (Chat chat : chats) {
            User user=userService.get(chat.getUser2Id());
            System.out.println(i+1+"-"+user.getUsername());
            i++;
        }
    }

public static void delete(){
        allChats();
    List<Chat> all = chatService.getAll();
    Chat chat = all.get(ScanUtil.intScan("Choose: ") - 1);
    chatService.delete(chat.getId());

}



    public static void chatWhithUser() {
        List<Chat> chats = chatService.seeAllMyChats(FrontEnd.curUser.getId());
        int i=0;
        for (Chat chat : chats) {
            User user=userService.get(chat.getUser2Id());
            System.out.println(i+1+"-"+user.getUsername());
            i++;
        }
        if(!(chats.isEmpty())) {
            Chat chat = chats.get(ScanUtil.intScan("Choose: ") - 1);
            String word = ScanUtil.strScan("============");
            String showStatus = MassageStatus.show();
            System.out.println(showStatus);
            MassageStatus status = MassageStatus.getStatus(ScanUtil.intScan("Choose: "));
            LocalDateTime localDateTime=LocalDateTime.now();
            Massage massage = new Massage(FrontEnd.curUser.getId(), chat.getUser2Id(), word, status,localDateTime);
            massageService.create(massage);
        }
        else System.out.println("You have not existed chats❌❌❌");
    }

public static void seeChats(){

}



    public static void chatPart() {
        while (true) {
            int options = menu();
            switch (options){
                case 1->createChat();
                case 2->allChats();
                case 3->delete();
                case 0-> {
                    return;
                }
                default -> System.out.println("Wrong option. Please try again❌❌❌");
            }
        }
    }


}
