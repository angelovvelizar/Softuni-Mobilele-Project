package bg.softuni.web.mobilelele.services;

import bg.softuni.web.mobilelele.models.views.StatsView;

public interface StatsService {
    void onRequest();

    StatsView getStats();
}
