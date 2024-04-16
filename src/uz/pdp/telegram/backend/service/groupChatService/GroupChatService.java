package uz.pdp.telegram.backend.service.groupChatService;

import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.Group;
import uz.pdp.telegram.backend.model.GroupChat;
import uz.pdp.telegram.backend.service.BaceService;

import java.util.List;

public interface GroupChatService extends BaceService<GroupChat> {

    List<GroupChat> allInvitedMeGroup(String ownId);
    List<GroupChat>seeallChatsByGroupId(String groupId);

}
