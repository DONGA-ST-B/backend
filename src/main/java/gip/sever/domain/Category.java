package gip.sever.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Category {
    TOTAL("전체"),
    STANDARD("기기 본체"),
    PLUS("추가 용품"),
    PLUSSERVICE("추가 서비스");

    private final String displayName;


    public String getDisplayName() {
        return displayName;
    }
}

