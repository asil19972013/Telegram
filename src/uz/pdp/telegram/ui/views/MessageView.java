package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.backend.model.Massage;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.massageService.MassageService;
import uz.pdp.telegram.backend.service.massageService.MassageServiceImpl;
import uz.pdp.telegram.backend.service.userService.UserService;
import uz.pdp.telegram.backend.service.userService.UserServiceImpl;
import uz.pdp.telegram.ui.FrontEnd;
import uz.pdp.telegram.ui.utils.ScanUtil;

import java.util.List;

public class MessageView {
    private static final MassageService massageService = MassageServiceImpl.getInstance();
    private static final UserService userService = UserServiceImpl.getInstance();
    private static void massagepart(){
        while (true){
            int option = menu();
            switch (option){
                case 1 -> usersMassages();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid opsion. Please try again !");
            }
        }
    }
    public  static void usersMassages(){
        List<User> allUsers = userService.getAll();
        if (!allUsers.isEmpty()){
            int i = 0;
            for (User user : allUsers){
                System.out.println(i + 1 + "-" + user.getUsername());
                i++;
            }
            User selectUser = allUsers.get(ScanUtil.intScan("Choose user : ") - 1);
            List<Massage> sentMassages = massageService.seeAllMassagesByUser(FrontEnd.curUser.getId(),selectUser.getId());
            List<Massage
                    > receivedMassages = massageService.seeAllMassagesByUser(selectUser.getId(),FrontEnd.curUser.getId());
            for (Massage massage : receivedMassages) {
                System.out.println(massage.getWord() + " - " + massage.getDate() + " - recevied");
                for (Massage massage1 : sentMassages) {
                    System.out.println(massage1.getWord() + " - " + massage1.getDate() + " - sent");
                }
            }
        }else {
            System.out.println("Error");
        }
    }
//    static MassageService massageService= MassageServiceImpl.getInstance();
//    static ChatService chatService= aChatServiceImpl.getInstance();
//    static UserService userService= UserServiceImpl.getInstance();
//    static Executor executor= Executors.newFixedThreadPool(2);
//
//    public static void massagePart() {
//        while (true){
//            int options = menu();
//            switch (options){
//                case 1->creatMessage();
//                case 2->creatMessage();
//                case 3->creatMessage();
//                case 0-> {
//                    return;
//                }
//            }
//
//        }
//    }
//
//    public static void creatMessage(){
//
//    }
//

    public static int menu(){
        System.out.println("""
                1.Write message
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }



}
