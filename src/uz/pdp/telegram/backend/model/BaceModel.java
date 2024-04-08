package uz.pdp.telegram.backend.model;

import java.util.UUID;

public abstract class BaceModel {
    private String id;
    public BaceModel() {
        this.id = UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }
}
