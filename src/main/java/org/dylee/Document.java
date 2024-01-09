package org.dylee;

import java.util.Map;

/**
 * 검색할 수 있는 다양한 속성을 포함하는 문서 클래스
 */
public class Document {
    private final Map<String, String> attributes;

    Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttributes(final String attributeName) {
        return attributes.get(attributeName);
    }
}
