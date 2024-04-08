package uz.pdp.telegram.backend.model;

public class GroupChat extends BaceModel {

    private String userId;

    public GroupChat(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }




}
