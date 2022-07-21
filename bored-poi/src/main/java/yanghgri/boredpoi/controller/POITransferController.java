package yanghgri.boredpoi.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.boredpoi.service.ExcelService;
import yanghgri.devform.base.enums.SpecialMIMEType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class POITransferController {
    private final ExcelService excelService;

    @Autowired
    public POITransferController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping("/excel/download")
    public void excelDownloader(HttpServletResponse response) throws IOException {
        try (OutputStream outputStream = response.getOutputStream(); Workbook workbook = excelService.createExcelFile()) {
            response.setContentType(SpecialMIMEType.EXCEL_XLSX.getContent());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.xlsx");
            workbook.write(outputStream);
        }
    }
}