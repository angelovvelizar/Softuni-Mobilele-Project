package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.bindings.OfferAddBindingModel;
import bg.softuni.web.mobilelele.models.service.OfferAddServiceModel;
import bg.softuni.web.mobilelele.models.service.OfferUpdateServiceModel;
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;

import java.security.Principal;
import java.util.List;

public interface OfferService {

    void initializeOffers();

    List<OfferSummaryView> getAllOffers();

    OfferSummaryView findById(Long id, String currentUser);

    void deleteOffer(Long id);

    boolean isOwner(String username, Long id);

    void updateOffer(OfferUpdateServiceModel offerModel);

    OfferAddServiceModel addOffer(OfferAddBindingModel offerAddBindingModel, Principal principal);
}
