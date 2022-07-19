package yanghgri.worldclock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

@Service
public class WorldClockService {
    private final Set<ZoneId> zoneIdSet;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    private static final TextStyle TEXT_STYLE = TextStyle.FULL;
    public static final Locale DEFAULT_LOCALE = Locale.getDefault();

    @Autowired
    public WorldClockService(Set<ZoneId> zoneIdSet) {
        this.zoneIdSet = zoneIdSet;
    }

    public Map<String, String> show() {
        Map<String, String> zonedDateTimeMap = new HashMap<>(zoneIdSet.size());
        ZonedDateTime now = ZonedDateTime.now();
        zoneIdSet.forEach(zoneId -> zonedDateTimeMap.put(zoneId.getDisplayName(TEXT_STYLE, DEFAULT_LOCALE), DATE_TIME_FORMATTER.withZone(zoneId).format(now)));
        return zonedDateTimeMap;
    }
}