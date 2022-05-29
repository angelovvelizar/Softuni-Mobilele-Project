package bg.softuni.web.mobilelele.user;

import bg.softuni.web.mobilelele.models.entities.enums.Role;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private boolean isLogged;
    private String username;
    private String firstName;
    private String lastName;
    private Set<Role> roles = new HashSet<>();

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void clearRoles(){
        this.roles.clear();
    }

    public void addRole(Role role){
        roles.add(role);
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    public void clean(){
        this.setFirstName(null);
        this.setLastName(null);
        this.setLogged(false);
        this.setUsername(null);
        this.clearRoles();
    }
}
