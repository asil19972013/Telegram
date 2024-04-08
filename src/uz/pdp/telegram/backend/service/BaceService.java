package uz.pdp.telegram.backend.service;

import java.util.List;

public interface BaceService<M> {


    boolean create(M m);

    void delete(String id);

    void updete(M m);

    M get(String id);

    List<M> getAll();
}
