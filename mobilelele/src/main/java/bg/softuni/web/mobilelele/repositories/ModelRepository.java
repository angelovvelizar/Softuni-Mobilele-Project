package bg.softuni.web.mobilelele.repositories;

import bg.softuni.web.mobilelele.models.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    ModelEntity findByName(String name);
}
