package uz.pdp.telegram.backend.service.contactService;


import uz.pdp.telegram.backend.model.Contacts;
import uz.pdp.telegram.backend.service.contactService.ContactService;

import java.util.ArrayList;
import java.util.List;

class ContactServiceImpl implements ContactService {

    private static ContactService contactService;

    private List<Contacts> contacts;

    public ContactServiceImpl() {
        this.contacts = new ArrayList<>();
    }

    public static ContactService getInstance() {
        if (contactService == null) {
            contactService = new ContactServiceImpl();
        }
        return contactService;
    }

    @Override
    public boolean add(Contacts o) {
        return contacts.add(o);
    }

    @Override
    public boolean delete(Contacts contact) {
        return contacts.remove(contact);
    }

    @Override
    public boolean create(Contacts contacts) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(Contacts contacts) {

    }

    @Override
    public Contacts get(String id) {
        for (Contacts contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contacts> getAll() {
        return null;
    }

    @Override
    public List<Contacts> getList() {
        return contacts;
    }

    @Override
    public boolean isExist(String id, String contactId) {
        for (Contacts contact : contacts) {
            if (contact.getUserId().equals(id) && contact.getId().equals(contactId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Contacts> getContacts(String userId) {
        ArrayList<Contacts> contactsArrayList = new ArrayList<>();
        for (Contacts contact : contacts) {
            if (contact.getUserId().equals(userId)) {
                contactsArrayList.add(contact);
            }
        }
        return contactsArrayList;
    }

    @Override
    public Contacts getContact(String userId, String contactId) {
        for (Contacts contact : contacts) {
            if (contact.getUserId().equals(userId) && contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }
}

