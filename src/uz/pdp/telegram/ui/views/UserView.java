package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.ui.utils.ScanUtil;

public class UserView {
    public static int menu(){
        System.out.println("""
                1.Create Chat
                2.Create Group
                3.See unreaded massage
                4.See readed massage
                5.Chat with person
                6.Delete
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

    public static void userProfile() {
        System.out.println("Welcome to your own telegram profile😊😊😊");
        int options = menu();
        switch (options){
            case 1-> System.out.println();
        }

    }
}
