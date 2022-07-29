package yanghgri.boredpoi.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yanghgri.boredpoi.service.WordService;
import yanghgri.devform.web.enums.SpecialMIMEType;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/read")
    public String read(@RequestPart("word") MultipartFile wordFile) {
        try (XWPFDocument document = new XWPFDocument(wordFile.getInputStream())) {
            return service.read(document);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}