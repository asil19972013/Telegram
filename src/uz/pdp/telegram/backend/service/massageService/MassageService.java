package uz.pdp.telegram.backend.service.massageService;

import uz.pdp.telegram.backend.model.Massage;
import uz.pdp.telegram.backend.service.BaceService;

import java.util.List;

public interface MassageService extends BaceService<Massage> {
    List<Massage> seeUnreadedMassags(String myId);
    List<Massage>seeReadedMassags(String myId);
    List<Massage> throughUserSeeAllMassages(String myId, String userId);
    List<Massage>seeAllMassagesByAdminId(String adminId);
}
