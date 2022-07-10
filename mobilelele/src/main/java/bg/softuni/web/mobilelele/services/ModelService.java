package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.views.ModelView;

import java.util.List;

public interface ModelService {
    void initializeModels();

    List<ModelView> getModels();
}
