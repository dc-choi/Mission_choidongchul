package com.ll.domain.wise.application;

import com.ll.domain.wise.dao.FileWiseRepository;

public class TestFileWiseRepository extends FileWiseRepository {
    /**
     * Test를 위한 Repository
     */
    public TestFileWiseRepository(String filePath, String dirPath) {
        super(filePath, dirPath);
    }

    /**
     * wises의 모든 객체를 없앤다 (테스트 전용)
     */
    public void clean() {
        wises.clear();
    }
}