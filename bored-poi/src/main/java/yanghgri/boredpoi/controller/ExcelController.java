package yanghgri.boredpoi.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yanghgri.boredpoi.service.ExcelService;
import yanghgri.devform.base.enums.SpecialMIMEType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    private final ExcelService excelService;

    @Autowired
    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @GetMapping("/download")
    public void excelDownloader(HttpServletResponse response) throws IOException {
        try (OutputStream outputStream = response.getOutputStream(); Workbook workbook = excelService.createExcelFile()) {
            response.setContentType(SpecialMIMEType.EXCEL_XLSX.getContent());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.xlsx");
            workbook.write(outputStream);
        }
    }

    @PostMapping("/read")
    public String readExcel(@RequestPart("file") MultipartFile file) {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            return excelService.readExcelFile(workbook);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }
}