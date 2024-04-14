package uz.pdp.telegram.backend.service.contactService;

import uz.pdp.telegram.backend.model.Contacts;
import uz.pdp.telegram.backend.service.BaceService;

import java.util.List;

public interface ContactService extends BaceService<Contacts> {
    boolean add(Contacts o);

    boolean delete(Contacts contact);

    List<Contacts> getList();

    boolean isExist(String id, String contactId);
    List<Contacts> getContacts(String userId);
    Contacts getContact(String userId, String contactId);
}
