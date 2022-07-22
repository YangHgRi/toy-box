package yanghgri.boredpoi.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/write")
    public void write(@NonNull HttpServletResponse response) {
        try (XWPFDocument document = service.write()) {
            response.setContentType(SpecialMIMEType.WORD_DOCX.getContent());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.docx");
            document.write(response.getOutputStream());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}