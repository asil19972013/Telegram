package uz.pdp.telegram.backend.enums;

import java.util.StringJoiner;

public enum MassageStatus {
    READED,
    UNREADED;

    public static String show(){
        MassageStatus[] values = MassageStatus.values();
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
        for (MassageStatus value : values) {
            stringJoiner.add(value.ordinal()+1+"-"+value.name());
        }
        return stringJoiner.toString();
    }

    public static MassageStatus getStatus(Integer ordinal){
        MassageStatus[] values = MassageStatus.values();
        for (MassageStatus value : values) {
            if(value.ordinal()==ordinal-1){
                return value;
            }
        }
        return null;
    }
}
