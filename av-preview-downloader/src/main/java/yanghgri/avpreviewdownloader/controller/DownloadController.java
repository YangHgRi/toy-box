package yanghgri.avpreviewdownloader.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.avpreviewdownloader.dto.Url;
import yanghgri.avpreviewdownloader.service.url.builder.selector.UrlBuilderSelectorService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class DownloadController {
    private final UrlBuilderSelectorService urlBuilderSelectorService;

    @Autowired
    public DownloadController(UrlBuilderSelectorService urlBuilderSelectorService) {
        this.urlBuilderSelectorService = urlBuilderSelectorService;
    }

    @GetMapping("/find/{id}")
    public void findDownLoadSource(@PathVariable String id, HttpServletResponse response) throws IOException {
        log.info("查询番号：{}", id);
        if (StringUtils.isBlank(id)) {
            throw new RuntimeException("番号为空");
        }
        //去除空格，转为小写
        id = id.trim().toLowerCase();
        List<Url> result = urlBuilderSelectorService.selectAllBuilder(id);
        response.sendRedirect(result.get(0).getPreviewUrl());
    }
}