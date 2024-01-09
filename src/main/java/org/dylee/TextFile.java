package org.dylee;

import java.util.List;
import java.util.Map;

/**
 * 텍스트 파일 처리 공동 메서드를 처리하기 위한 도메인 클래스
 */
public class TextFile {
    private final Map<String, String> attributes;
    private final List<String> lines;

    TextFile(Map<String, String> attributes, List<String> lines) {
        this.attributes = attributes;
        this.lines = lines;
    }

    void addLineSuffinx(final String prefix, final String attributeName) {
        for(final String line: lines) {
            if (line.startsWith(prefix)) {
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
}
