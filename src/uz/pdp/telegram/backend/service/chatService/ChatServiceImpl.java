package uz.pdp.telegram.backend.service.chatService;

import uz.pdp.telegram.backend.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatServiceImpl implements ChatService {
    List<Chat>chatList;

    public ChatServiceImpl() {
        this.chatList = new ArrayList<>();
    }

    @Override
    public boolean create(Chat chat) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(Chat chat) {

    }

    @Override
    public Chat get(String id) {
        return null;
    }

    @Override
    public List<Chat> getAll() {
        return List.of();
    }
}
