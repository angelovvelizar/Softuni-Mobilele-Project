package bg.softuni.web.mobilelele.web;

import bg.softuni.web.mobilelele.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OffersController {
    private final OfferService offerService;

    public OffersController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/offers/all")
    public String allOffers(Model model){
        model.addAttribute("offers",
                this.offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable Long id){
        return "details";
    }
}
