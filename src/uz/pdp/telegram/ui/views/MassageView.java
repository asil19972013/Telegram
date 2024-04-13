package uz.pdp.telegram.ui.views;

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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MassageView {

    static MassageService massageService= MassageServiceImpl.getInstance();
    static ChatService chatService= ChatServiceImpl.getInstance();
    static UserService userService= UserServiceImpl.getInstance();
    static Executor executor= Executors.newFixedThreadPool(2);

    public static void massagePart() {
        while (true){
            int options = menu();
            switch (options){
                case 1->unreadedMassages();
                case 2->readedMassages();
                case 3->seeChatsWithUser();
                case 0-> {
                    return;
                }
            }

        }
    }

    public static void seeChatsWithUser() {
        List<User> all = userService.getAll();
        int i=0;
        for (User user : all) {
            System.out.println(i+1+"-"+user.getUsername());
            i++;
        }
        if(!(all.isEmpty())) {
            User user = all.get(ScanUtil.intScan("Choose: ") - 1);
            List<Massage> massages = massageService.throughUserSeeAllMassages(FrontEnd.curUser.getId(), user.getId());
            List<Massage> massages1 = massageService.throughUserSeeAllMassages(user.getId(), FrontEnd.curUser.getId());
                for (Massage massage : massages1) {
                    System.out.println(massage.getWord()+"-"+massage.getDate());
                }
                for (Massage massage : massages) {
                    System.out.println(massage.getWord()+"-"+massage.getDate());
                }

        }
        else{
                System.out.println("You have not existed users❌❌❌");
            }
        }


    public static void unreadedMassages() {
        List<Massage> massages = massageService.seeUnreadedMassags(FrontEnd.curUser.getId());
        for (Massage massage : massages) {
            User user=userService.get(massage.getFrom());
            System.out.println(user.getUsername()+"-"+massage.getWord());
            massage.setMassageStatus(MassageStatus.READED);
        }
    }

    public static void readedMassages() {
        List<Massage> massages = massageService.seeReadedMassags(FrontEnd.curUser.getId());
        for (Massage massage : massages) {
            User user=userService.get(massage.getFrom());
            System.out.println(user.getUsername()+"-"+massage.getWord());
        }
    }



    public static int menu(){
        System.out.println("""
                1.See unreaded massages
                2.See readed massages
                3.User's massages
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
