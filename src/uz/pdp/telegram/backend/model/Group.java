package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.enums.GroupType;
import uz.pdp.telegram.backend.enums.MassageType;

import java.util.List;

public class Group extends BaceModel {
    private String groupName;
    private String owner;
    private  GroupType groupType;

    public Group(String groupName,String owner,GroupType groupType) {
        this.groupName=groupName;
        this.owner=owner;
        this.groupType=groupType;
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

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType;
    }
}
