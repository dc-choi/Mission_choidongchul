package com.ll.domain.wise.application;

import com.ll.domain.wise.entity.Wise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WiseServiceTest {
    public static final String TEST_FLIE_PATH = "src/test/resources/file";
    public static final String TEST_JSON_PATH = TEST_FLIE_PATH + "/data.json";
    public static final String TEST_DATABASE_PATH = TEST_FLIE_PATH + "/file.json";
    private static final TestFileWiseRepository wiseRepository = new TestFileWiseRepository(TEST_DATABASE_PATH, TEST_FLIE_PATH);
    private static final WiseService wiseService = new WiseService(wiseRepository);

    /**
     * 테스트는 기본적으로 서로 의존하면 안됨.
     * 파일을 통해 영속성이 추가되어서 파일에 저장된 데이터를 통해 서로 의존될 수 있음.
     * 그래서 매 테스트를 진행하기 전, 데이터를 제거한다.
     */
    @BeforeEach
    void beforeEach() {
        wiseRepository.clean();
    }

    @Test
    @DisplayName("등록 성공")
    void add() {
        String author = "hi";
        String word = "hi";

        Wise wise = wiseService.add(author, word);

        assertThat(wise.getAuthor()).isEqualTo(author);
        assertThat(wise.getWord()).isEqualTo(word);
    }

    @Test
    @DisplayName("조회 성공")
    void list() {
        String author = "hi";
        String word = "hi";

        wiseService.add(author, word);
        wiseService.add(author, word);
        wiseService.add(author, word);
        List<Wise> wises = wiseService.list();

        assertThat(wises.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("상세 조회 성공")
    void get() {
        String author = "hi";
        String word = "hi";

        Wise wise = wiseService.add(author, word);
        Wise wise2 = wiseService.get(wise.getId());

        assertThat(wise2.getAuthor()).isEqualTo(author);
        assertThat(wise2.getWord()).isEqualTo(word);
    }

    @Test
    @DisplayName("삭제 성공")
    public void remove() {
        String author = "hi";
        String word = "hi";

        Wise wise = wiseService.add(author, word);
        Wise wise2 = wiseService.remove(wise.getId());

        assertThat(wise2.getAuthor()).isEqualTo(author);
        assertThat(wise2.getWord()).isEqualTo(word);
    }

    @Test
    @DisplayName("수정 성공")
    public void modify() {
        String author = "hi";
        String word = "hi";

        Wise wise = wiseService.add(author, word);
        Wise wise2 = wiseService.modify(wise.getId(), "hello", "hello");

        assertThat(wise2.getAuthor()).isEqualTo("hello");
        assertThat(wise2.getWord()).isEqualTo("hello");
    }

    @Test
    @DisplayName("종료 성공")
    public void end() {
        wiseService.end();
    }

    @Test
    @DisplayName("빌드 성공")
    public void build() {
        wiseService.build(TEST_JSON_PATH);
    }
}