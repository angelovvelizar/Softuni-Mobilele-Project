package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    BrandEntity findBrandByName(String name);
}
