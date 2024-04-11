package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.enums.MassageStatus;
import uz.pdp.telegram.backend.enums.MassageType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Massage extends BaceModel {

    private MassageType type;

    private String from;

    private String to;

    private String word;

    private MassageStatus massageStatus;

    private LocalDateTime date;



    public Massage(String from, String to, MassageType type,String word,MassageStatus massageStatus,LocalDateTime localDate) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.word=word;
        this.massageStatus=massageStatus;
        this.date=localDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public MassageStatus getMassageStatus() {
        return massageStatus;
    }

    public void setMassageStatus(MassageStatus massageStatus) {
        this.massageStatus = massageStatus;
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
