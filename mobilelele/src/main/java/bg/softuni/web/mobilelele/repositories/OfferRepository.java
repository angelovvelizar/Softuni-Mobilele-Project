package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
