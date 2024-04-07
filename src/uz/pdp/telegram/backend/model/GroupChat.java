package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.BaceModel;

public class GroupChat extends BaceModel {

    private String userId;

    public GroupChat(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }




}
