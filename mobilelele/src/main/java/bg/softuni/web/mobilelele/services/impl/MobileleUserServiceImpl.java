package bg.softuni.web.mobilelele.services.impl;

import bg.softuni.web.mobilelele.models.entities.UserEntity;
import bg.softuni.web.mobilelele.models.entities.UserRoleEntity;
import bg.softuni.web.mobilelele.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class MobileleUserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public MobileleUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findUserByUsername(username)
                .map(this::map).orElseThrow(() -> new UsernameNotFoundException("User with " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity){
        return User
                .builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles()
                        .stream()
                        .map(this::map)
                        .collect(Collectors.toSet()))
                .build();
    }

    private GrantedAuthority map(UserRoleEntity userRoleEntity){
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }
}
