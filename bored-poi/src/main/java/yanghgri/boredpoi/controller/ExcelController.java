package yanghgri.boredpoi.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yanghgri.boredpoi.service.ExcelService;
import yanghgri.devform.web.enums.SpecialMIMEType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    private final ExcelService service;

    @Autowired
    public ExcelController(ExcelService service) {
        this.service = service;
    }

    @GetMapping("/write")
    public void write(@NonNull HttpServletResponse response) throws IOException {
        try (Workbook workbook = service.writeByApachePOI()) {
            response.setContentType(SpecialMIMEType.EXCEL_XLSX.getContent());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.xlsx");
            workbook.write(response.getOutputStream());
        }
    }

    @PostMapping("/read")
    public String read(@RequestPart("excel") MultipartFile excelFile) {
        try (Workbook workbook = new XSSFWorkbook(excelFile.getInputStream())) {
            return service.readByApachePOI(workbook);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }
}