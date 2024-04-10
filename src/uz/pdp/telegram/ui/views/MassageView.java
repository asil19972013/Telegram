package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;
import uz.pdp.telegram.backend.service.massageService.MassageService;
import uz.pdp.telegram.backend.service.massageService.MassageServiceImpl;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;

public class MassageView {

    static MassageService massageService= MassageServiceImpl.getInstance();
    static ChatService chatService= ChatServiceImpl.getInstance();
    static UserService userService= UserServiceImpl.getInstance();

    public static void massagePart() {
        while (true){
            int options = menu();
            switch (options){
                case 1->chatWhithUser();
                case 0-> {
                    return;
                }
            }

        }
    }

    private static void chatWhithUser() {
        List<Chat> chats = chatService.seeAllMyChats(FrontEnd.curUser.getId());

    }


    public static int menu(){
        System.out.println("""
                1.Chatting with person
                2.See unreaded massages
                3.See readed massages
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
