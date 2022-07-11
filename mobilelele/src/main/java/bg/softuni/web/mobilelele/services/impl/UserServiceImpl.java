package bg.softuni.web.mobilelele.services.impl;

import bg.softuni.web.mobilelele.models.entities.UserEntity;
import bg.softuni.web.mobilelele.models.entities.UserRoleEntity;
import bg.softuni.web.mobilelele.models.entities.enums.Role;
import bg.softuni.web.mobilelele.models.service.UserRegisterServiceModel;
import bg.softuni.web.mobilelele.repositories.UserRepository;
import bg.softuni.web.mobilelele.repositories.UserRoleRepository;
import bg.softuni.web.mobilelele.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserDetailsService userDetailsService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userDetailsService = userDetailsService;
    }


    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initiliazeUsers();

    }

    private void initiliazeUsers() {
        if (this.userRepository.count() == 0) {
            UserEntity admin = new UserEntity();
            admin.setActive(true);
            admin.setUsername("admin");
            admin.setFirstName("Admincho");
            admin.setLastName("Adminchov");
            admin.setPassword(this.passwordEncoder.encode("test"));

            admin.setRoles(Set.of(this.userRoleRepository.findByRole(Role.ADMIN), this.userRoleRepository.findByRole(Role.USER)));
            this.userRepository.save(admin);

            UserEntity georgi = new UserEntity();
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
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(Role.ADMIN);

            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setRole(Role.USER);

            this.userRoleRepository.saveAll(List.of(adminRole, userRoleEntity));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel) {
        UserEntity newUserEntity = new UserEntity();
        UserRoleEntity userRoleEntity = this.userRoleRepository.findByRole(Role.USER);

        newUserEntity.setUsername(userRegisterServiceModel.getUsername());
        newUserEntity.setFirstName(userRegisterServiceModel.getFirstName());
        newUserEntity.setLastName(userRegisterServiceModel.getLastName());
        newUserEntity.setPassword(this.passwordEncoder.encode(userRegisterServiceModel.getPassword()));
        newUserEntity.setActive(true);
        newUserEntity.setRoles(Set.of(userRoleEntity));

        this.userRepository.save(newUserEntity);

        UserDetails principal = userDetailsService.loadUserByUsername(newUserEntity.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUserEntity.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean isUsernameFree(String username) {
        return this.userRepository.findUserByUsernameIgnoreCase(username).isEmpty();
    }

}
