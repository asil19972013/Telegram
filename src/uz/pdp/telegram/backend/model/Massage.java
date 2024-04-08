package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.enums.MassageType;

public class Massage extends BaceModel {

    private MassageType type;

    private String from;

    private String to;



    public Massage(String from, String to, MassageType type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public MassageType getType() {
        return type;
    }

    public void setType(MassageType type) {
        this.type = type;
    }
}
