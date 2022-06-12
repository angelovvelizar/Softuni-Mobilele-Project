package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.entities.Offer;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;
<<<<<<< HEAD
import bg.softuni.web.mobilelele.models.service.OfferUpdateServiceModel;
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;
import bg.softuni.web.mobilelele.repositories.ModelRepository;
import bg.softuni.web.mobilelele.repositories.OfferRepository;
import bg.softuni.web.mobilelele.repositories.UserRepository;
import bg.softuni.web.mobilelele.web.exception.ObjectNotFoundException;
=======
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;
import bg.softuni.web.mobilelele.repositories.OfferRepository;
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
<<<<<<< HEAD
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
=======

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
    }


    @Override
    public void initiliazeOffers() {
        if(this.offerRepository.count() == 0){
<<<<<<< HEAD
=======
            //TODO: Add image url
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
            Offer offer1 = new Offer();
            offer1.setMileage(22500L);
            offer1.setPrice(new BigDecimal(14300));
            offer1.setEngine(Engine.ELECTRIC);
            offer1.setTransmission(Transmission.AUTOMATIC);
            offer1.setYear(2019);
<<<<<<< HEAD
            offer1.setModel(this.modelRepository.findByName("G-Class"));
            offer1.setImageUrl("https://www.mercedes-benz.bg/passengercars/mercedes-benz-cars/models/g-class/suv-w463/_jcr_content/image.MQ6.2.2x.20190930092450.png");
            offer1.setSeller(this.userRepository.findUserByUsername("admin").orElse(null));

=======

            //TODO: Add image url
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
            Offer offer2 = new Offer();
            offer2.setMileage(445000L);
            offer2.setPrice(new BigDecimal(2000));
            offer2.setEngine(Engine.DIESEL);
            offer2.setTransmission(Transmission.MANUAL);
            offer2.setYear(1998);
<<<<<<< HEAD
            offer2.setModel(this.modelRepository.findByName("SomeCycle"));
            offer2.setImageUrl("https://i.pinimg.com/originals/55/f9/73/55f973d378c3e4c8f5e1b25f6e4620e4.jpg");
            offer2.setSeller(this.userRepository.findUserByUsername("GeorgixxSlayer").orElse(null));
=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb

            this.offerRepository.saveAll(List.of(offer1,offer2));
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(this::map).collect(Collectors.toList());
    }

<<<<<<< HEAD
    @Override
    public OfferSummaryView findById(Long id) {
        return this.offerRepository.findById(id)
                .map(this::map).orElse(null);
    }

    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.deleteById(id);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerModel) {
        Offer offer = this.offerRepository
                .findById(offerModel.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Offer with id: " + offerModel.getId() + " not found!"));

        offer.setPrice(offerModel.getPrice());
        offer.setDescription(offerModel.getDescription());
        offer.setEngine(offerModel.getEngine());
        offer.setImageUrl(offerModel.getImageUrl());
        offer.setMileage(offerModel.getMileage());
        offer.setTransmission(offerModel.getTransmission());
        offer.setYear(offerModel.getYear());

        this.offerRepository.save(offer);

    }

    private OfferSummaryView map(Offer offer){
        OfferSummaryView summaryView = this.modelMapper.map(offer,OfferSummaryView.class);
        summaryView.setModel(offer.getModel().getName());
        summaryView.setSeller(String.join(" ", offer.getSeller().getFirstName(), offer.getSeller().getLastName()));
        summaryView.setBrand(offer.getModel().getBrand().getName());
=======
    private OfferSummaryView map(Offer offer){
        OfferSummaryView summaryView = this.modelMapper.map(offer,OfferSummaryView.class);
        summaryView.setModel(offer.getModel().getUrl());
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb

        return summaryView;
    }
}
