package uz.pdp.telegram.backend.service.massageService;

import uz.pdp.telegram.backend.model.Massage;

import java.util.ArrayList;
import java.util.List;

public class MassageServiceImpl implements MassageService{

   List<Massage>massageList;

    public MassageServiceImpl() {
        this.massageList = new ArrayList<>();
    }

    @Override
    public boolean create(Massage massage) {
        return false;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void updete(Massage massage) {

    }

    @Override
    public Massage get(String id) {
        return null;
    }

    @Override
    public List<Massage> getAll() {
        return List.of();
    }
}
