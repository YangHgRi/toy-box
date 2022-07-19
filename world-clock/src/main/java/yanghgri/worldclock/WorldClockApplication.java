package yanghgri.worldclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class WorldClockApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorldClockApplication.class, args);
    }
}