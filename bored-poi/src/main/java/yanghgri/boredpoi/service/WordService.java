package yanghgri.boredpoi.service;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    public XWPFDocument write() {
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

    public String read(XWPFDocument document) {
        StringBuilder stringBuilder = new StringBuilder();
        document.getParagraphsIterator().forEachRemaining(paragraph -> paragraph.getRuns().forEach(run -> stringBuilder.append(run).append(" ")));
        return stringBuilder.toString();
    }
}