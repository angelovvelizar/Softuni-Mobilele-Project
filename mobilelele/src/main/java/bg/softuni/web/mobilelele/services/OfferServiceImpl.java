package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.entities.Offer;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;
import bg.softuni.web.mobilelele.repositories.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initiliazeOffers() {
        if(this.offerRepository.count() == 0){
            //TODO: Add image url
            Offer offer1 = new Offer();
            offer1.setMileage(22500L);
            offer1.setPrice(new BigDecimal(14300));
            offer1.setEngine(Engine.ELECTRIC);
            offer1.setTransmission(Transmission.AUTOMATIC);
            offer1.setYear(2019);

            //TODO: Add image url
            Offer offer2 = new Offer();
            offer2.setMileage(445000L);
            offer2.setPrice(new BigDecimal(2000));
            offer2.setEngine(Engine.DIESEL);
            offer2.setTransmission(Transmission.MANUAL);
            offer2.setYear(1998);

            this.offerRepository.saveAll(List.of(offer1,offer2));
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(this::map).collect(Collectors.toList());
    }

    private OfferSummaryView map(Offer offer){
        OfferSummaryView summaryView = this.modelMapper.map(offer,OfferSummaryView.class);
        summaryView.setModel(offer.getModel().getUrl());

        return summaryView;
    }
}
