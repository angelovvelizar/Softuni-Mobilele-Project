package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.service.UserRegisterServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);

    boolean isUsernameFree(String username);
}
