package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.views.OfferSummaryView;

import java.util.List;

public interface OfferService {

    void initiliazeOffers();

    List<OfferSummaryView> getAllOffers();
}
