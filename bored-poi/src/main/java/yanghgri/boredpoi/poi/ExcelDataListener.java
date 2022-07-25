package yanghgri.boredpoi.poi;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExcelDataListener<T> implements ReadListener<T> {

    private final RedisTemplate<String, Object> redisTemplate;

    public final String CACHE_LIST_KEY = "excel-invoke-cache:" + UUID.randomUUID();

    public static final byte BATCH_COUNT = 100;

    private List<T> cachedDataList = new ArrayList<>(BATCH_COUNT);

    public ExcelDataListener(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            redisTemplate.opsForList().leftPushAll(CACHE_LIST_KEY, cachedDataList);
            // 存储完成清理 list
            cachedDataList = new ArrayList<>(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        redisTemplate.opsForList().leftPushAll(CACHE_LIST_KEY, cachedDataList);
    }
}