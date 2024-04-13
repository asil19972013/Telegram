package uz.pdp.telegram.backend.service.groupService;

import uz.pdp.telegram.backend.model.Group;
import uz.pdp.telegram.backend.service.groupChatService.GroupChatService;
import uz.pdp.telegram.backend.service.groupChatService.GroupChatServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupServiceImpl implements GroupService{

    List<Group>groupList;

    public GroupServiceImpl() {
        this.groupList = new ArrayList<>();
    }

    @Override
    public boolean create(Group group) {
        groupList.add(group);
        return true;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(Group group) {

    }

    @Override
    public Group get(String id) {
        return null;
    }


    @Override
    public List<Group> getAll() {
        return groupList;
    }

    static GroupService groupService;


    public static GroupService getInstance(){
        if(groupService==null){
            groupService=new GroupServiceImpl();
        }
        return  groupService;
    }

}
