package yanghgri.worldclock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yanghgri.devform.base.constant.ZonedDateTimeConstant;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class WorldClockService {
    //配置好的时区集合
    private final Set<ZoneId> zoneIdSet;

    @Autowired
    public WorldClockService(Set<ZoneId> zoneIdSet) {
        this.zoneIdSet = zoneIdSet;
    }

    public Map<String, String> show() {
        Map<String, String> zonedDateTimeMap = new HashMap<>(zoneIdSet.size());
        ZonedDateTime now = ZonedDateTime.now();
        //withZone()是返回个新的对象而不是给某个成员变量赋值，不用担心线程安全问题
        zoneIdSet.forEach(zoneId -> zonedDateTimeMap.put(zoneId.getDisplayName(ZonedDateTimeConstant.DEFAULT_TEXT_STYLE, ZonedDateTimeConstant.DEFAULT_LOCALE), ZonedDateTimeConstant.DEFAULT_DATE_TIME_FORMATTER.withZone(zoneId).format(now)));
        return zonedDateTimeMap;
    }
}