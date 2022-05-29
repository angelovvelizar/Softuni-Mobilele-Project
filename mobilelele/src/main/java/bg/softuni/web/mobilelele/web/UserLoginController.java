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
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {
        boolean loginSuccessfull = userService.login(new UserLoginServiceModel()
                .setUsername(userLoginBindingModel.getUsername()).setRawPassword(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                userLoginBindingModel.getUsername(), loginSuccessfull);

        if(loginSuccessfull){
            return "redirect:/";
        }

        return "redirect:/users/login";
    }
}