package yanghgri.avpreviewdownloader.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DownLoadSourcePrefix {
    DMM("https://cc3001.dmm.co.jp/litevideo/freepv/");

    @Getter
    private final String prefix;
}