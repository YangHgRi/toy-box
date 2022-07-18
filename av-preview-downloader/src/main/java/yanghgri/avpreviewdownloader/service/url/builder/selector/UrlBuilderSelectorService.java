package yanghgri.avpreviewdownloader.service.url.builder.selector;

import org.springframework.stereotype.Service;
import yanghgri.avpreviewdownloader.dto.Url;
import yanghgri.avpreviewdownloader.service.url.builder.DMMUrlBuilderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlBuilderSelectorService {
    public List<Url> selectAllBuilder(String id) {
        List<Url> urlList = new ArrayList<>();
        //TODO 有新的下载源URL构造器实现了，就用上
        urlList.add(new DMMUrlBuilderService().build(id));
        return urlList;
    }
}