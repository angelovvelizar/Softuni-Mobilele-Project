package bg.softuni.web.mobilelele.services;

<<<<<<< HEAD
import bg.softuni.web.mobilelele.models.entities.Model;
import bg.softuni.web.mobilelele.models.entities.enums.Category;
import bg.softuni.web.mobilelele.repositories.BrandRepository;
import bg.softuni.web.mobilelele.repositories.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
=======
import bg.softuni.web.mobilelele.repositories.ModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
    }

    @Override
    public void initiliazeModels() {
<<<<<<< HEAD

        if(this.modelRepository.count() == 0){
            Model model1 = new Model();

            model1.setName("G-Class");
            model1.setCategory(Category.CAR);
            model1.setStartYear(1999);
            model1.setUrl("https://www.mercedes-benz.bg/passengercars/mercedes-benz-cars/models/g-class/suv-w463/_jcr_content/image.MQ6.2.2x.20190930092450.png");
            model1.setBrand(this.brandRepository.findBrandByName("Mercedes"));

            Model model2 = new Model();

            model2.setName("SomeCycle");
            model2.setCategory(Category.MOTORCYCLE);
            model2.setStartYear(2010);
            model2.setUrl("https://i.pinimg.com/originals/55/f9/73/55f973d378c3e4c8f5e1b25f6e4620e4.jpg");
            model2.setBrand(this.brandRepository.findBrandByName("Audi"));

            Model model3 = new Model();

            model3.setName("Fiesta");
            model3.setCategory(Category.CAR);
            model3.setStartYear(1990);
            model3.setBrand(this.brandRepository.findBrandByName("Ford"));
            model3.setUrl("https://cdn.wheel-size.com/automobile/body/ford-fiesta-2017-2021-1604308748.4095798.jpg");

            this.modelRepository.saveAll(List.of(model1, model2, model3));
        }
=======
        //TODO: add offers
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
    }
}
