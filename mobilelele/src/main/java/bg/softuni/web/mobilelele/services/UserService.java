package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.service.UserLoginServiceModel;
import bg.softuni.web.mobilelele.models.service.UserRegisterServiceModel;

public interface UserService {

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void initiliazeUsersAndRoles();

    void logout();

    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);

    boolean isUsernameFree(String username);
}
