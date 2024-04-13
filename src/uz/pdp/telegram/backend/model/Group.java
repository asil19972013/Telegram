package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.enums.GroupType;

import java.util.List;

public class Group extends BaceModel {
    public String groupName;
    public String groupChatId;
    public GroupType type;

    public Group(String groupChatId, GroupType type,String groupName) {
        this.groupChatId = groupChatId;
        this.type = type;
        this.groupName=groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupChatId() {
        return groupChatId;
    }

    public void setGroupChatId(String groupChatId) {
        this.groupChatId = groupChatId;
    }

    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }
}
