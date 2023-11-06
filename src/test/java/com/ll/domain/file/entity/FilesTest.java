package com.ll.domain.file.entity;

import com.ll.domain.wise.entity.Wise;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilesTest {
    private static final Properties properties = new Properties();
    private static String MODE;
    private static String TEST_FLIE_PATH;
    private static String TEST_JSON_PATH;
    private static String TEST_DATABASE_PATH;

    @BeforeAll
    static void beforeAll() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/com/ll/app.properties");
            properties.load(fileInputStream);

            MODE = properties.getProperty("MODE");
            TEST_FLIE_PATH = properties.getProperty("TEST_FLIE_PATH");
            TEST_JSON_PATH = properties.getProperty("TEST_JSON_PATH");
            TEST_DATABASE_PATH = properties.getProperty("TEST_DATABASE_PATH");
        } catch (IOException e) {}
    }

    @Test
    @DisplayName("파일 정상 저장")
    void save() {
        List<Wise> wises = new ArrayList<>();
        wises.add(new Wise(1L, "1", "1"));
        wises.add(new Wise(2L, "2", "3"));
        wises.add(new Wise(3L, "3", "3"));
        wises.add(new Wise(4L, "4", "4"));

        Files.buildFile(wises, TEST_DATABASE_PATH, TEST_FLIE_PATH);
    }

    @Test
    @DisplayName("파일 가져오기")
    void parse() {
        List<Wise> wises = new ArrayList<>();
        wises.add(new Wise(1L, "1", "1"));
        wises.add(new Wise(2L, "2", "3"));
        wises.add(new Wise(3L, "3", "3"));
        wises.add(new Wise(4L, "4", "4"));

        Files.buildFile(wises, TEST_DATABASE_PATH, TEST_FLIE_PATH);

        List<Wise> parseFile = Files.parseFile(TEST_DATABASE_PATH, TEST_FLIE_PATH);
        assertThat(parseFile.size()).isEqualTo(wises.size());
    }
}