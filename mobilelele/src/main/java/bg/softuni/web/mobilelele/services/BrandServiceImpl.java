package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.entities.Brand;
import bg.softuni.web.mobilelele.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void initiliazeBrands() {

        if(this.brandRepository.count() == 0) {
            Brand brand1 = new Brand();
            brand1.setName("Mercedes");

            Brand brand2 = new Brand();
            brand2.setName("Audi");

            Brand brand3 = new Brand();
            brand3.setName("Ford");

            this.brandRepository.saveAll(List.of(brand1,brand2,brand3));
        }
    }
}
