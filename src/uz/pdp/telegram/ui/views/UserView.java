package uz.pdp.telegram.ui.views;

import uz.pdp.telegram.ui.utils.ScanUtil;

public class UserView {
    public static int menu(){
        System.out.println("""
                1.Enter to chat part
                2.Enter to group part
                3.Enter to Massage part
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }

    public static void userProfile() {
        System.out.println("Welcome to your own telegram profile😊😊😊");
        while (true) {
            int options = menu();
            switch (options) {
                case 1 -> ChatView.chatPart();
                case 2 -> GroupView.groupPart();
                case 3 -> MassageView.massagePat();
                case 0 -> {
                    return;
                }
            }
        }

    }
}
