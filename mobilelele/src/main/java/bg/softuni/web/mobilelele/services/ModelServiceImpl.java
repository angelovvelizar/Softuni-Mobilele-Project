package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.repositories.ModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void initiliazeModels() {
        //TODO: add offers
    }
}
