package uz.pdp.telegram.backend.service.userService;

import uz.pdp.telegram.backend.dto.LoginDto;
import uz.pdp.telegram.backend.model.User;
import uz.pdp.telegram.backend.service.BaceService;

public interface UserService extends BaceService<User> {
    User login(LoginDto login);
}
