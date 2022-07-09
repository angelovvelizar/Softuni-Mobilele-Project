package bg.softuni.web.mobilelele.web;

import bg.softuni.web.mobilelele.models.bindings.UserLoginBindingModel;
import bg.softuni.web.mobilelele.models.service.UserLoginServiceModel;
import bg.softuni.web.mobilelele.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }
}
