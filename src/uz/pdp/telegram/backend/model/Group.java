package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.enums.GroupType;

import java.util.List;

public class Group extends BaceModel {
    private String groupName;
    private String owner;

    public Group(String groupName,String owner) {
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


}
