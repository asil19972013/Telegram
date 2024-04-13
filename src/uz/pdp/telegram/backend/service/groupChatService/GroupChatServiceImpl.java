package uz.pdp.telegram.backend.service.groupChatService;

import uz.pdp.telegram.backend.model.GroupChat;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupChatServiceImpl implements GroupChatService{

    List<GroupChat>groupChatList;

    public GroupChatServiceImpl() {
        this.groupChatList = new ArrayList<>();
    }

    @Override
    public boolean create(GroupChat groupChat) {
        this.groupChatList.add(groupChat);
        return true;
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < groupChatList.size(); i++) {
            GroupChat groupChat = groupChatList.get(i);

        }
    }

    @Override
    public void updete(GroupChat groupChat) {

    }

    @Override
    public GroupChat get(String id) {
        for (GroupChat groupChat : groupChatList) {
            if(Objects.equals(groupChat.getId(),id)){
                return groupChat;
            }
        }
        return null;
    }

    @Override
    public List<GroupChat> getAll() {
        return groupChatList;
    }

    static GroupChatService groupChatService;


    public static GroupChatService getInstance(){
        if(groupChatService==null){
            groupChatService=new GroupChatServiceImpl();
        }
        return  groupChatService;
    }
}
