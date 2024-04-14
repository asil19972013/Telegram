package uz.pdp.telegram.backend.service.chatService;

import uz.pdp.telegram.backend.model.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatServiceImpl implements ChatService {
    List<Chat>chatList;

    public ChatServiceImpl() {
        this.chatList = new ArrayList<>();
    }

    @Override
    public List<Chat> unKnownChat(String myID) {
        List<Chat>chats=new ArrayList<>();
        for (Chat chat : chatList) {
            if(chat.getUser2Id().equals(myID)){
                chats.add(chat);
            }
        }
        return chats;
    }

    @Override
    public List<Chat> seeAllMyChats(String userId) {
        List<Chat>chatList1=new ArrayList<>();
        for (Chat chat : chatList) {
            if(Objects.equals(chat.getUser1Id(),userId)){
                chatList1.add(chat);
            }
        }
        return  chatList1;
    }

    @Override
    public boolean create(Chat chat) {
                this.chatList.add(chat);
                return true;
    }


    @Override
    public void delete(String id) {
        for (int i = 0; i < chatList.size(); i++) {
         Chat chat=chatList.get(i);
         if(Objects.equals(chat.getId(),id)){
            chatList.remove(i);
         }
        }
    }



    @Override
    public void updete(Chat chat) {

    }

    @Override
    public Chat get(String id) {
        for (int i = 0; i < chatList.size(); i++) {
            Chat chat = chatList.get(i);
            if(Objects.equals(chat.getId(),id)){
                return chat;
            }
        }
        return null;
    }

    @Override
    public List<Chat> getAll() {
        return chatList;
    }

    static ChatService chatService;


    public static ChatService getInstance(){
        if(chatService==null){
            chatService=new ChatServiceImpl();
        }
        return  chatService;
    }
}
