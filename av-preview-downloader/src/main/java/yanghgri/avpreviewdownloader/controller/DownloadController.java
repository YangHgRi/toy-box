package yanghgri.avpreviewdownloader.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.avpreviewdownloader.dto.Url;
import yanghgri.avpreviewdownloader.service.url.builder.selector.UrlBuilderSelectorService;

import java.util.List;

@RestController
public class DownloadController {
    private final UrlBuilderSelectorService urlBuilderSelectorService;

    @Autowired
    public DownloadController(UrlBuilderSelectorService urlBuilderSelectorService) {
        this.urlBuilderSelectorService = urlBuilderSelectorService;
    }

    @GetMapping("find/{id}")
    public List<Url> findDownLoadSource(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("番号为空");
        }
        //去除空格，转为小写
        id = id.trim().toLowerCase();
        return urlBuilderSelectorService.selectAllBuilder(id);
    }
}