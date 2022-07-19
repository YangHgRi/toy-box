package yanghgri.worldclock.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

@ConfigurationProperties(prefix = "clock")
public class ClockPropertyConf {
    @Getter
    @Setter
    private Set<String> active;

    @Bean
    public Set<ZoneId> zoneIdSet() {
        Set<ZoneId> opsZoneIdSet = new HashSet<>(active.size());
        active.forEach(zoneId -> opsZoneIdSet.add(ZoneId.of(zoneId)));
        return opsZoneIdSet;
    }
}