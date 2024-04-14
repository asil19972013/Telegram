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
                Integer i = ScanUtil.intScan("0.Back 1.Massage \n choose: ");
                if (i == 0) return;
                String strMass = ScanUtil.strScan("write a message here: ");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Massage massage = new Massage(FrontEnd.curUser.getId(), user.getId(), strMass, MassageStatus.UNREADED, simpleDateFormat);
                massageService.create(massage);
            }
        }else System.out.println("You do not have users👩‍💻👩‍💻👩‍💻");

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
