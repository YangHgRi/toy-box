package yanghgri.boredpoi.service;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    public XWPFDocument download() {
        XWPFDocument document = new XWPFDocument();
        //第一段
        XWPFParagraph paragraph = document.createParagraph();
        //设置居中对齐
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        //第一行
        XWPFRun run = paragraph.createRun();
        run.setText("哈喽，word!");
        run.setColor("009933");
        run.setBold(true);
        run.setFontSize(16);
        return document;
    }
}
