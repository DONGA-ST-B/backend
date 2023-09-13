package gip.sever.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Category {
    전체("전체"),
    기기본체("기기 본체"),
    추가용품("추가 용품"),
    추가서비스("추가 서비스");

    private final String displayName;


    public String getDisplayName() {
        return displayName;
    }
}

