package bg.softuni.web.mobilelele.init;

import bg.softuni.web.mobilelele.services.ModelService;
import bg.softuni.web.mobilelele.services.OfferService;
import bg.softuni.web.mobilelele.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final UserService userService;
    private final OfferService offerService;
    private final ModelService modelService;

    public DatabaseInit(UserService userService, OfferService offerService, ModelService modelService) {
        this.userService = userService;
        this.offerService = offerService;
        this.modelService = modelService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.userService.initiliazeUsersAndRoles();
        this.modelService.initiliazeModels();
        this.offerService.initiliazeOffers();
    }
}
