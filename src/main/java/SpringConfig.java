import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.hendrikm.services.AddEventService;
import com.hendrikm.services.EventsServiceInterface;

@Configuration
public class SpringConfig {
    @Bean(name="addEventService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public EventsServiceInterface getEvents() {
        return new AddEventService();
    }
}
