package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private int HEALTH_CHECK_COUNTER= 5;
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();
      if (timeEntryRepository.list().size() > HEALTH_CHECK_COUNTER){
            builder.up();
      } else {
          builder.down();
      }
      return builder.build();
    }
}
