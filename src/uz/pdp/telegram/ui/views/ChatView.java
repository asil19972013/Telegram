package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;
import java.util.Objects;



public class ChatView {

    static UserService userService = UserServiceImpl.getInstance();
    static ChatService chatService = ChatServiceImpl.getInstance();


    public static int menu(){
        System.out.println("""
                1.Create chat         
                2.See my all chats
                3.Delete
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

    public static void createChat() {
        List<User> users = userService.getAll();
        int i = 1;
        for (User user : users) {
            System.out.println(i + "-" + user.getUsername());
            ++i;
        }
        User myUser = users.get(ScanUtil.intScan("Choose: ") - 1);
        Chat chat = new Chat(FrontEnd.curUser.getId(), myUser.getId());
        chatService.create(chat);

        }



    public static void allChats() {
        List<Chat> chats = chatService.seeAllMyChats(FrontEnd.curUser.getId());
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
