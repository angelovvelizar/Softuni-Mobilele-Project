package bg.softuni.web.mobilelele.services.impl;

import bg.softuni.web.mobilelele.models.bindings.OfferAddBindingModel;
import bg.softuni.web.mobilelele.models.entities.OfferEntity;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;
import bg.softuni.web.mobilelele.models.service.OfferUpdateServiceModel;
import bg.softuni.web.mobilelele.models.views.OfferSummaryView;
import bg.softuni.web.mobilelele.repositories.ModelRepository;
import bg.softuni.web.mobilelele.repositories.OfferRepository;
import bg.softuni.web.mobilelele.repositories.UserRepository;
import bg.softuni.web.mobilelele.services.OfferService;
import bg.softuni.web.mobilelele.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void initializeOffers() {
        if(this.offerRepository.count() == 0){
            OfferEntity offerEntity1 = new OfferEntity();
            offerEntity1.setMileage(22500L);
            offerEntity1.setPrice(new BigDecimal(14300));
            offerEntity1.setEngine(Engine.ELECTRIC);
            offerEntity1.setTransmission(Transmission.AUTOMATIC);
            offerEntity1.setYear(2019);
            offerEntity1.setModel(this.modelRepository.findByName("G-Class"));
            offerEntity1.setImageUrl("https://www.mercedes-benz.bg/passengercars/mercedes-benz-cars/models/g-class/suv-w463/_jcr_content/image.MQ6.2.2x.20190930092450.png");
            offerEntity1.setSeller(this.userRepository.findUserByUsername("admin").orElse(null));

            OfferEntity offerEntity2 = new OfferEntity();
            offerEntity2.setMileage(445000L);
            offerEntity2.setPrice(new BigDecimal(2000));
            offerEntity2.setEngine(Engine.DIESEL);
            offerEntity2.setTransmission(Transmission.MANUAL);
            offerEntity2.setYear(1998);
            offerEntity2.setModel(this.modelRepository.findByName("SomeCycle"));
            offerEntity2.setImageUrl("https://i.pinimg.com/originals/55/f9/73/55f973d378c3e4c8f5e1b25f6e4620e4.jpg");
            offerEntity2.setSeller(this.userRepository.findUserByUsername("GeorgixxSlayer").orElse(null));

            this.offerRepository.saveAll(List.of(offerEntity1, offerEntity2));
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(this::map).collect(Collectors.toList());
    }


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
        OfferEntity offerEntity = this.offerRepository
                .findById(offerModel.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Offer with id: " + offerModel.getId() + " not found!"));

        offerEntity.setPrice(offerModel.getPrice());
        offerEntity.setDescription(offerModel.getDescription());
        offerEntity.setEngine(offerModel.getEngine());
        offerEntity.setImageUrl(offerModel.getImageUrl());
        offerEntity.setMileage(offerModel.getMileage());
        offerEntity.setTransmission(offerModel.getTransmission());
        offerEntity.setYear(offerModel.getYear());

        this.offerRepository.save(offerEntity);

    }

    @Override
    public void addOffer(OfferAddBindingModel offerAddBindingModel) {
        OfferEntity offer = this.modelMapper.map(offerAddBindingModel, OfferEntity.class);
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //TODO:add offer in repository
    }

    private OfferSummaryView map(OfferEntity offerEntity){
        OfferSummaryView summaryView = this.modelMapper.map(offerEntity,OfferSummaryView.class);
        summaryView.setModel(offerEntity.getModel().getName());
        summaryView.setSeller(String.join(" ", offerEntity.getSeller().getFirstName(), offerEntity.getSeller().getLastName()));
        summaryView.setBrand(offerEntity.getModel().getBrand().getName());

        return summaryView;
    }
}
