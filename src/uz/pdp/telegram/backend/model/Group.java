package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.BaceModel;
import uz.pdp.telegram.backend.enums.GroupType;

public class Group extends BaceModel {


    private GroupChat chat;
    public GroupType type;


    public Group(GroupChat chat, GroupType type) {
        this.chat = chat;
        this.type = type;
    }

    public GroupChat getChat() {
        return chat;
    }

    public void setChat(GroupChat chat) {
        this.chat = chat;
    }

    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Group{" +
                "chat=" + chat +
                ", type=" + type +
                '}';
    }
}
