package yanghgri.boredpoi.service;

import com.alibaba.excel.EasyExcel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import yanghgri.boredpoi.entity.MockCell;
import yanghgri.boredpoi.poi.ExcelDataListener;

import java.io.InputStream;

@Service
public class ExcelService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public ExcelService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Workbook writeByApachePOI() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("第一页");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("哈喽，第一页，第一行，第一列");
        return workbook;
    }

    public String readByApachePOI(Workbook workbook) {
        Sheet sheet = workbook.getSheet("第一页");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        return cell.getStringCellValue();
    }

    public void readByEasyExcel(InputStream inputStream) {
        EasyExcel.read(inputStream, MockCell.class, new ExcelDataListener<MockCell>(redisTemplate)).sheet().doRead();
    }
}