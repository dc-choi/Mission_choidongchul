package com.ll.global.common.util;

import com.ll.domain.wise.entity.Wise;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileUtilTest {
    private static String TEST_FLIE_PATH = "src/test/resources/file";
    private static String TEST_JSON_PATH = TEST_FLIE_PATH + "/data.json";
    private static String TEST_DATABASE_PATH = TEST_FLIE_PATH + "/file.json";

    @Test
    @DisplayName("파일 정상 저장")
    void save() {
        List<Wise> wises = new ArrayList<>();
        wises.add(new Wise(1L, "1", "1"));
        wises.add(new Wise(2L, "2", "3"));
        wises.add(new Wise(3L, "3", "3"));
        wises.add(new Wise(4L, "4", "4"));

        FileUtil.buildFile(wises, TEST_DATABASE_PATH, TEST_FLIE_PATH);

        List<Wise> parseFile = FileUtil.parseFile(TEST_DATABASE_PATH, TEST_FLIE_PATH);
        assertThat(parseFile.size()).isEqualTo(wises.size());
    }

    @Test
    @DisplayName("파일 가져오기")
    void parse() {
        List<Wise> wises = new ArrayList<>();
        wises.add(new Wise(1L, "1", "1"));
        wises.add(new Wise(2L, "2", "3"));
        wises.add(new Wise(3L, "3", "3"));
        wises.add(new Wise(4L, "4", "4"));

        FileUtil.buildFile(wises, TEST_DATABASE_PATH, TEST_FLIE_PATH);

        List<Wise> parseFile = FileUtil.parseFile(TEST_DATABASE_PATH, TEST_FLIE_PATH);
        assertThat(parseFile.size()).isEqualTo(wises.size());
    }

    @Test
    @DisplayName("다른 경로의 파일을 저장하고 가져오기")
    void other() {
        List<Wise> wises = new ArrayList<>();
        wises.add(new Wise(1L, "1", "1"));
        wises.add(new Wise(2L, "2", "3"));
        wises.add(new Wise(3L, "3", "3"));
        wises.add(new Wise(4L, "4", "4"));

        FileUtil.buildFile(wises, TEST_JSON_PATH, TEST_FLIE_PATH);

        List<Wise> parseFile = FileUtil.parseFile(TEST_JSON_PATH, TEST_FLIE_PATH);
        assertThat(parseFile.size()).isEqualTo(wises.size());
    }
}