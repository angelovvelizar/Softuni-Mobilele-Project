package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.entities.User;
import bg.softuni.web.mobilelele.models.entities.UserRole;
import bg.softuni.web.mobilelele.models.entities.enums.Role;
import bg.softuni.web.mobilelele.models.service.UserLoginServiceModel;
import bg.softuni.web.mobilelele.repositories.UserRepository;
import bg.softuni.web.mobilelele.repositories.UserRoleRepository;
import bg.softuni.web.mobilelele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public void initiliazeUsersAndRoles() {
        initiliazeRoles();
        initiliazeUsers();

    }

    private void initiliazeUsers(){
        if(this.userRepository.count() == 0){
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

    private void initiliazeRoles(){
        if(this.userRoleRepository.count() == 0){
            UserRole adminRole = new UserRole();
            adminRole.setRole(Role.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(Role.USER);

            this.userRoleRepository.saveAll(List.of(adminRole,userRole));
        }
    }


    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<User> userEntityOpt = userRepository.findUserByUsername(userLoginServiceModel.getUsername());

        if(userEntityOpt.isEmpty()){
            logout();
            return false;
        }else{
            boolean success = passwordEncoder
                    .matches(userLoginServiceModel.getRawPassword(), userEntityOpt.get().getPassword());

            if(success){
                User loggedInUser = userEntityOpt.get();
                this.currentUser.setUsername(loggedInUser.getUsername());
                this.currentUser.setLogged(true);
                this.currentUser.setFirstName(loggedInUser.getFirstName());
                this.currentUser.setLastName(loggedInUser.getLastName());

                loggedInUser.getRoles()
                        .forEach(r -> this.currentUser.addRole(r.getRole()));
            }

            return success;
        }
    }

    @Override
    public void logout() {
        this.currentUser.clean();
    }
}
