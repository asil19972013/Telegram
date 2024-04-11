package uz.pdp.telegram.backend.service.chatService;

import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.service.BaceService;

import java.util.List;

public interface ChatService extends BaceService<Chat> {
List<Chat> seeAllMyChats(String userId);
}
