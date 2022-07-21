package yanghgri.boredpoi.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
    public Workbook createExcelFile() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("第一页");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("哈喽，第一页，第一行，第一列");
        return workbook;
    }

    public String readExcelFile(Workbook workbook) {
        Sheet sheet = workbook.getSheet("第一页");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        return cell.getStringCellValue();
    }
}