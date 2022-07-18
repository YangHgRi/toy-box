package yanghgri.avpreviewdownloader.service.url.builder.selector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import yanghgri.avpreviewdownloader.dto.Url;
import yanghgri.avpreviewdownloader.service.url.builder.UrlBuilderService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UrlBuilderSelectorService {
    private final ApplicationContext applicationContext;

    @Autowired
    public UrlBuilderSelectorService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    public List<Url> selectAllBuilder(String id) {
        //获取IOC容器中所有UrlBuilderService实现类Bean对象
        Map<String, UrlBuilderService> stringUrlBuilderServiceMap = applicationContext.getBeansOfType(UrlBuilderService.class);
        //提取所有Bean对象
        Collection<UrlBuilderService> urlBuilderServiceCollection = stringUrlBuilderServiceMap.values();
        //存储迭代构建Url结果
        List<Url> urlList = new ArrayList<>();
        //起飞
        urlBuilderServiceCollection.forEach(urlBuilderService -> urlList.add(urlBuilderService.build(id)));
        return urlList;
    }
}