package uz.pdp.telegram.ui.utils;

import java.util.Scanner;

public interface ScanUtil {
    static Integer intScan(String hint){
        Scanner scanner= new Scanner(System.in);
        System.out.println(hint);
        return scanner.nextInt();
    }
    static String strScan(String hint){
        Scanner scanner= new Scanner(System.in);
        System.out.println(hint);
        return scanner.nextLine();
    }

}
