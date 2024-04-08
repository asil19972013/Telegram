package uz.pdp.telegram.backend.service.groupService;

import uz.pdp.telegram.backend.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService{

    List<Group>groupList;

    public GroupServiceImpl() {
        this.groupList = new ArrayList<>();
    }

    @Override
    public boolean create(Group group) {
        return false;
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
        return List.of();
    }
}
