package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class TestUtilTest {
    @Test
    @DisplayName("스캐너 입력 확인")
    void checkInput() {
        Scanner scanner = TestUtil.generateScanner("안녕하세요.\n감사해요.\n잘 있어요.\n다시 만나요.");

        String hello = scanner.nextLine();
        String thank = scanner.nextLine();
        String goodbye = scanner.nextLine();
        String seeyouagain = scanner.nextLine();

        assertThat(hello).isEqualTo("안녕하세요.");
        assertThat(thank).isEqualTo("감사해요.");
        assertThat(goodbye).isEqualTo("잘 있어요.");
        assertThat(seeyouagain).isEqualTo("다시 만나요.");
    }

    @Test
    @DisplayName("스트림 출력 확인")
    void checkOutput() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

        String out = byteArrayOutputStream.toString().trim();

        assertThat(out).isEqualTo("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
        System.out.println("이제는 화면에 출력됩니다.");
    }
}