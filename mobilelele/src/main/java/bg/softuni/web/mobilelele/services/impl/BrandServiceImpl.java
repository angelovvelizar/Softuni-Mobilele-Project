package bg.softuni.web.mobilelele.services.impl;

import bg.softuni.web.mobilelele.models.entities.BrandEntity;
import bg.softuni.web.mobilelele.repositories.BrandRepository;
import bg.softuni.web.mobilelele.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public void initializeBrands() {

        if(this.brandRepository.count() == 0) {
            BrandEntity brandEntity1 = new BrandEntity();
            brandEntity1.setName("Mercedes");

            BrandEntity brandEntity2 = new BrandEntity();
            brandEntity2.setName("Audi");

            BrandEntity brandEntity3 = new BrandEntity();
            brandEntity3.setName("Ford");

            this.brandRepository.saveAll(List.of(brandEntity1, brandEntity2, brandEntity3));
        }
    }
}
