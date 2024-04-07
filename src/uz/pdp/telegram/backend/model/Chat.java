package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.BaceModel;

public class Chat extends BaceModel {


    private String user1Id;

    private String user2Id;

    public Chat(String user1Id, String user2Id) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public String getUser1Id() {
        return user1Id;
    }
}
