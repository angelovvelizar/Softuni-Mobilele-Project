package bg.softuni.web.mobilelele.init;

<<<<<<< HEAD
import bg.softuni.web.mobilelele.services.BrandService;
=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
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
<<<<<<< HEAD
    private final BrandService brandService;

    public DatabaseInit(UserService userService, OfferService offerService, ModelService modelService, BrandService brandService) {
        this.userService = userService;
        this.offerService = offerService;
        this.modelService = modelService;
        this.brandService = brandService;
=======

    public DatabaseInit(UserService userService, OfferService offerService, ModelService modelService) {
        this.userService = userService;
        this.offerService = offerService;
        this.modelService = modelService;
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
    }


    @Override
    public void run(String... args) throws Exception {
        this.userService.initiliazeUsersAndRoles();
<<<<<<< HEAD
        this.brandService.initiliazeBrands();
        this.modelService.initiliazeModels();
        this.offerService.initiliazeOffers();

=======
        this.modelService.initiliazeModels();
        this.offerService.initiliazeOffers();
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
    }
}
