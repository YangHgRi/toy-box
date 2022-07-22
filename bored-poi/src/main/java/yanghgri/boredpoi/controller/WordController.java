package yanghgri.boredpoi.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.boredpoi.service.WordService;
import yanghgri.devform.base.enums.SpecialMIMEType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/word")
public class WordController {
    private final WordService service;

    @Autowired
    public WordController(WordService service) {
        this.service = service;
    }

    public void download(HttpServletResponse response) {
        try (XWPFDocument document = service.download()) {
            document.write(response.getOutputStream());
            response.setContentType(SpecialMIMEType.WORD_DOCX.getContent());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.docx");

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}