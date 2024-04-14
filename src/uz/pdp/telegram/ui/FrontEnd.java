package uz.pdp.telegram.ui;

import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.ui.views.ChatView;
import uz.pdp.telegram.ui.views.LoginViews;
import uz.pdp.telegram.ui.views.UserView;

public class FrontEnd {
    public static User curUser;

    public static void main(String[] args) {
        System.out.println("Welcome to Telegram");
        while (true) {
            int menu = LoginViews.menu();
            switch (menu) {
                case 1 -> {
                    curUser= LoginViews.logIn();
                    if (curUser != null) {
                        UserView.userProfile();
                    }
                }
                case 2->{
                    LoginViews.signUp();
                    UserView.userProfile();
                }
            }
        }
    }

}