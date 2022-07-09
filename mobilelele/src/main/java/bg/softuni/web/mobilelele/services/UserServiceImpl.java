package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.entities.User;
import bg.softuni.web.mobilelele.models.entities.UserRole;
import bg.softuni.web.mobilelele.models.entities.enums.Role;
import bg.softuni.web.mobilelele.models.service.UserRegisterServiceModel;
import bg.softuni.web.mobilelele.repositories.UserRepository;
import bg.softuni.web.mobilelele.repositories.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initiliazeUsers();

    }

    private void initiliazeUsers() {
        if (this.userRepository.count() == 0) {
            User admin = new User();
            admin.setActive(true);
            admin.setUsername("admin");
            admin.setFirstName("Admincho");
            admin.setLastName("Adminchov");
            admin.setPassword(this.passwordEncoder.encode("test"));

            admin.setRoles(Set.of(this.userRoleRepository.findByRole(Role.ADMIN), this.userRoleRepository.findByRole(Role.USER)));
            this.userRepository.save(admin);

            User georgi = new User();
            georgi.setActive(true);
            georgi.setUsername("GeorgixxSlayer");
            georgi.setFirstName("Georgi");
            georgi.setLastName("Ivanov");
            georgi.setPassword(this.passwordEncoder.encode("test123"));

            georgi.setRoles(Set.of(this.userRoleRepository.findByRole(Role.USER)));

            this.userRepository.save(georgi);
        }
    }

    private void initializeRoles() {
        if (this.userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(Role.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(Role.USER);

            this.userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {
        User newUser = new User();
        UserRole userRole = this.userRoleRepository.findByRole(Role.USER);

        newUser.setUsername(userRegisterServiceModel.getUsername());
        newUser.setFirstName(userRegisterServiceModel.getFirstName());
        newUser.setLastName(userRegisterServiceModel.getLastName());
        newUser.setPassword(this.passwordEncoder.encode(userRegisterServiceModel.getPassword()));
        newUser.setActive(true);
        newUser.setRoles(Set.of(userRole));

        this.userRepository.save(newUser);

        //todo: register user
        /*login(newUser);*/
    }

    @Override
    public boolean isUsernameFree(String username) {
        return this.userRepository.findUserByUsernameIgnoreCase(username).isEmpty();
    }

}
