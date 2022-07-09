package bg.softuni.web.mobilelele.init;


import bg.softuni.web.mobilelele.services.BrandService;
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
    private final BrandService brandService;

    public DatabaseInit(UserService userService, OfferService offerService, ModelService modelService, BrandService brandService) {
        this.userService = userService;
        this.offerService = offerService;
        this.modelService = modelService;
        this.brandService = brandService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.userService.initializeUsersAndRoles();
        this.brandService.initializeBrands();
        this.modelService.initializeModels();
        this.offerService.initializeOffers();


        this.modelService.initializeModels();
        this.offerService.initializeOffers();
    }
}
