package yanghgri.boredpoi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class POITransferController {
    @GetMapping("/excel/download")
    public void excelDownloader(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello");
    }
}