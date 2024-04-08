package uz.pdp.telegram.backend.service.groupChatService;

import uz.pdp.telegram.backend.model.GroupChat;
import uz.pdp.telegram.backend.service.chatService.ChatService;
import uz.pdp.telegram.backend.service.chatService.ChatServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GroupChatServiceImpl implements GroupChatService{

    List<GroupChat>groupChatList;

    public GroupChatServiceImpl() {
        this.groupChatList = new ArrayList<>();
    }

    @Override
    public boolean create(GroupChat groupChat) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(GroupChat groupChat) {

    }

    @Override
    public GroupChat get(String id) {
        return null;
    }

    @Override
    public List<GroupChat> getAll() {
        return List.of();
    }

    static GroupChatService groupChatService;


    public static GroupChatService getInstance(){
        if(groupChatService==null){
            groupChatService=new GroupChatServiceImpl();
        }
        return  groupChatService;
    }
}
