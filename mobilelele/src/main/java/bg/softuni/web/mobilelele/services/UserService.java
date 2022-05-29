package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.service.UserLoginServiceModel;

public interface UserService {

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void initiliazeUsersAndRoles();

    void logout();
}
