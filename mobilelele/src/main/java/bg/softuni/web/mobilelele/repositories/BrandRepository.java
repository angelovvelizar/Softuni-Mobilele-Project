package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findBrandByName(String name);
}
