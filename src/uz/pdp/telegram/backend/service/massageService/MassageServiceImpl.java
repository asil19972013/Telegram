package uz.pdp.telegram.backend.service.massageService;

import uz.pdp.telegram.backend.enums.MassageStatus;
import uz.pdp.telegram.backend.model.Chat;
import uz.pdp.telegram.backend.model.Massage;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.groupService.GroupService;
import uz.pdp.telegram.backend.service.groupService.GroupServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MassageServiceImpl implements MassageService{

   List<Massage>massageList;

    public MassageServiceImpl() {
        this.massageList = new ArrayList<>();
    }

    @Override
    public boolean create(Massage massage) {
        massageList.add(massage);
        return true;
    }

    @Override
    public List<Massage> seeReadedMassags(String myId) {
        List<Massage>readedMas=new ArrayList<>();
        for (Massage massage : massageList) {
            if(massage.getMassageStatus().equals(MassageStatus.READED)&&massage.getTo().equals(myId)){
                readedMas.add(massage);
            }
        }
        return readedMas;
    }

    @Override
    public List<Massage> seeUnreadedMassags(String myId) {
        List<Massage>unreadedMas=new ArrayList<>();
        for (Massage massage : massageList) {
            if(massage.getMassageStatus().equals(MassageStatus.UNREADED)&&massage.getTo().equals(myId)){
                unreadedMas.add(massage);
            }
        }
        return unreadedMas;
    }

    @Override
    public List<Massage> throughUserSeeAllMassages(String myId,String userId) {
        List<Massage>massageList1=new ArrayList<>();
        for (Massage massage : massageList) {
            if(massage.getTo().equals(myId)&&massage.getFrom().equals(userId)){
                massageList1.add(massage);
            }
        }
        return massageList1;
    }


    @Override
    public void delete(String id) {

    }


    @Override
    public List<Massage> seeAllMassagesByAdminId(String adminId) {
        List<Massage>adminMassage=new ArrayList<>();
        for (Massage massage : massageList) {
            if(Objects.equals(massage.getFrom(),adminId)){
                adminMassage.add(massage);
            }
        }
        return adminMassage;
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

    static MassageService massageService;


    public static MassageService getInstance(){
        if(massageService==null){
            massageService=new MassageServiceImpl();
        }
        return  massageService;
    }
}
