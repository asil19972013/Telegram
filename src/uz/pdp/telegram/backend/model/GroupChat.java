package uz.pdp.telegram.backend.model;

public class GroupChat extends BaceModel {
    private String groupId;
    private String userId;




    public GroupChat(String groupId, String userId1) {
        this.groupId=groupId;
        this.userId = userId1;

    }


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
