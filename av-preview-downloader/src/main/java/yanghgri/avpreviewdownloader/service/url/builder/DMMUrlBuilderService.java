package yanghgri.avpreviewdownloader.service.url.builder;

import org.springframework.stereotype.Service;
import yanghgri.avpreviewdownloader.dto.Url;
import yanghgri.avpreviewdownloader.enums.DownLoadSourcePrefix;

@Service
public class DMMUrlBuilderService implements UrlBuilderService {
    @Override
    public Url build(String id) {
        String[] lettersAndNumbers = id.split("-");
        String letters = lettersAndNumbers[0];
        String numbers = lettersAndNumbers[1];
        char firstLetter = letters.charAt(0);
        Url result = new Url(DownLoadSourcePrefix.DMM.name());
        if (letters.length() < 3) {
            result.setPreviewUrl(DownLoadSourcePrefix.DMM.getPrefix() + firstLetter + "/" + letters + "/" + letters + "00" + numbers + "/" + letters + "00" + numbers + "_dmb_w.mp4");
        } else {
            result.setPreviewUrl(DownLoadSourcePrefix.DMM.getPrefix() + firstLetter + "/" + letters.substring(0, 3) + "/" + letters + "00" + numbers + "/" + letters + "00" + numbers + "_dmb_w.mp4");
        }
        return result;
    }
}