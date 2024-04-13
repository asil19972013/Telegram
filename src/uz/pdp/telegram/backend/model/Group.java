package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.enums.GroupType;

import java.util.List;

public class Group extends BaceModel {
    private String groupName;
    private GroupType type;
    private String owner;

    public Group( GroupType type,String groupName,String owner) {
        this.type = type;
        this.groupName=groupName;
        this.owner=owner;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public GroupType getType() {
        return type;
    }

    public void setType(GroupType type) {
        this.type = type;
    }
}
