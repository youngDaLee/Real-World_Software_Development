package org.dylee;

import java.io.File;
import java.io.IOException;

/**
 * 다양한 종류의 문서를 Import 할 수 있도록 인터페이스를 생성
 */
public interface Importer {
    Document importFile(File file) throws IOException;
}
