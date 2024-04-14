package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.model.BaceModel;

public class Contacts extends BaceModel implements Comparable {
    private final String userId;
    private String contactId;
    private String name;

    public Contacts(String userId, String contactId, String name) {
        this.userId = userId;
        this.contactId = contactId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}