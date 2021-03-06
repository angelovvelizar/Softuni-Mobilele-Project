package bg.softuni.web.mobilelele.web;

import bg.softuni.web.mobilelele.models.bindings.UserRegisterBindingModel;
import bg.softuni.web.mobilelele.models.service.UserRegisterServiceModel;
import bg.softuni.web.mobilelele.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userModel")
    public UserRegisterBindingModel userModel(){
        return new UserRegisterBindingModel();
    }

    @GetMapping("/users/register")
    public String registerUser() {

        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegisterBindingModel userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/register";
        }

        if(!userModel.getPassword().equals(userModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("passwordsNotMatching", true);

            return "redirect:/users/register";
        }

        UserRegisterServiceModel serviceModel = this.modelMapper
                .map(userModel, UserRegisterServiceModel.class);

        if(!this.userService.isUsernameFree(serviceModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("usernameOccupied", true);

            return "redirect:/users/register";
        }else{
            this.userService.registerAndLoginUser(serviceModel);
        }

        return "redirect:/";
    }
}
