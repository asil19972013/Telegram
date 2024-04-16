package uz.pdp.telegram.backend.service.groupService;

import uz.pdp.telegram.backend.model.Group;
import uz.pdp.telegram.backend.service.BaceService;

import java.util.List;

public interface GroupService extends BaceService<Group> {
List<Group>allMyGroups(String ownerId);
List<Group>seeAllGroupByName(String name);
}
