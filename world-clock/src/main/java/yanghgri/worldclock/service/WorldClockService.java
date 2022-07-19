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
    //配置好的时区集合
    private final Set<ZoneId> zoneIdSet;
    //默认的时间格式化器，放在二方库中更优雅
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    //表示法，选这个就是了
    private static final TextStyle TEXT_STYLE = TextStyle.FULL;
    //由JVM宿主机环境决定当前地理地区
    public static final Locale DEFAULT_LOCALE = Locale.getDefault();

    @Autowired
    public WorldClockService(Set<ZoneId> zoneIdSet) {
        this.zoneIdSet = zoneIdSet;
    }

    public Map<String, String> show() {
        Map<String, String> zonedDateTimeMap = new HashMap<>(zoneIdSet.size());
        ZonedDateTime now = ZonedDateTime.now();
        //withZone()是返回个新的对象而不是给某个成员变量赋值，不用担心线程安全问题
        zoneIdSet.forEach(zoneId -> zonedDateTimeMap.put(zoneId.getDisplayName(TEXT_STYLE, DEFAULT_LOCALE), DATE_TIME_FORMATTER.withZone(zoneId).format(now)));
        return zonedDateTimeMap;
    }
}