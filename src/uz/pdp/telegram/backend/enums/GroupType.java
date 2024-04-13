package uz.pdp.telegram.backend.enums;

import java.util.StringJoiner;

public enum GroupType {
    PUBLIC,
    PRIVATE;
    public static String show(){
        GroupType[] values = GroupType.values();
        StringJoiner stringJoiner=new StringJoiner(",","[","]");
        for (GroupType value : values) {
            stringJoiner.add(value.ordinal()+1+"-"+value.name());
        }
        return stringJoiner.toString();
    }

    public static GroupType getType(Integer ordinal){
        GroupType[] values = GroupType.values();
        for (GroupType value : values) {
            if(value.ordinal()==ordinal-1){
                return value;
            }
        }
        return null;
    }
}
