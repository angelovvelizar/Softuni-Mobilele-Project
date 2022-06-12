package bg.softuni.web.mobilelele.services;

<<<<<<< HEAD
import bg.softuni.web.mobilelele.models.service.OfferUpdateServiceModel;
=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initiliazeOffers();

    List<OfferSummaryView> getAllOffers();
<<<<<<< HEAD

    OfferSummaryView findById(Long id);

    void deleteOffer(Long id);

    void updateOffer(OfferUpdateServiceModel offerModel);
=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
}
