import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.hendrikm.data.EventsDataAccessInterface;
import com.hendrikm.data.EventsDataServiceForRepository;
import com.hendrikm.services.EventsServiceInterface;
import com.hendrikm.services.GetEventsService;

@Configuration
public class SpringConfig {
    @Bean(name="getEventService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public EventsServiceInterface getEvents() {
        return new GetEventsService();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name="eventsDAO")
    @RequestScope
    public EventsDataAccessInterface getDataService() {
        return new EventsDataServiceForRepository(dataSource);
        // return new EventsDataService();
    }
}
