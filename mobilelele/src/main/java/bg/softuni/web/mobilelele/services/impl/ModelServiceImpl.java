package bg.softuni.web.mobilelele.services.impl;

import bg.softuni.web.mobilelele.models.entities.ModelEntity;
import bg.softuni.web.mobilelele.models.entities.enums.Category;
import bg.softuni.web.mobilelele.models.views.ModelView;
import bg.softuni.web.mobilelele.repositories.BrandRepository;
import bg.softuni.web.mobilelele.repositories.ModelRepository;
import bg.softuni.web.mobilelele.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeModels() {


        if(this.modelRepository.count() == 0){
            ModelEntity modelEntity1 = new ModelEntity();

            modelEntity1.setName("G-Class");
            modelEntity1.setCategory(Category.CAR);
            modelEntity1.setStartYear(1999);
            modelEntity1.setUrl("https://www.mercedes-benz.bg/passengercars/mercedes-benz-cars/models/g-class/suv-w463/_jcr_content/image.MQ6.2.2x.20190930092450.png");
            modelEntity1.setBrand(this.brandRepository.findBrandByName("Mercedes"));

            ModelEntity modelEntity2 = new ModelEntity();

            modelEntity2.setName("SomeCycle");
            modelEntity2.setCategory(Category.MOTORCYCLE);
            modelEntity2.setStartYear(2010);
            modelEntity2.setUrl("https://i.pinimg.com/originals/55/f9/73/55f973d378c3e4c8f5e1b25f6e4620e4.jpg");
            modelEntity2.setBrand(this.brandRepository.findBrandByName("Audi"));

            ModelEntity modelEntity3 = new ModelEntity();

            modelEntity3.setName("Fiesta");
            modelEntity3.setCategory(Category.CAR);
            modelEntity3.setStartYear(1990);
            modelEntity3.setBrand(this.brandRepository.findBrandByName("Ford"));
            modelEntity3.setUrl("https://cdn.wheel-size.com/automobile/body/ford-fiesta-2017-2021-1604308748.4095798.jpg");

            this.modelRepository.saveAll(List.of(modelEntity1, modelEntity2, modelEntity3));
        }

        //TODO: add offers

    }

    @Override
    public List<ModelView> getModels() {
        return this.modelRepository.findAll()
                .stream().map(modelEntity -> this.modelMapper.map(modelEntity,ModelView.class))
                .collect(Collectors.toList());
    }
}
