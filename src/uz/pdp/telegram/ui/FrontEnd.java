package uz.pdp.telegram.ui;

import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.ui.views.LoginViews;

public class FrontEnd {
    public static User curUser;
    public static void main(String[] args) {
        System.out.println("Welcome to Telegram");
        while (true){
            Integer menu = LoginViews.menu();
            switch (menu){
                case 1->{
                    if( curUser!= null){

                    }

                }


            }

        }
    }
}