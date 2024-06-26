package uz.pdp.telegram.backend.enums;

import java.util.StringJoiner;

public enum  MassageType {
    GROUP,
    CHAT;


    public static String show(){
        MassageType[] values = MassageType.values();
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
        for (MassageType value : values) {
            stringJoiner.add(value.ordinal()+1+"-"+value.name());
        }
        return stringJoiner.toString();
    }

    public static MassageType getType(Integer ordinal){
        MassageType[] values = MassageType.values();
        for (MassageType value : values) {
            if(value.ordinal()==ordinal-1){
                return value;
            }
        }
        return null;
    }
}
