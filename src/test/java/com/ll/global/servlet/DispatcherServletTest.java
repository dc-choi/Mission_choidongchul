package com.ll.global.servlet;

import com.ll.TestUtil;
import com.ll.global.common.Req;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class DispatcherServletTest {
    @Test
    @DisplayName("명령이 잘 처리되는지 확인")
    void checkRequest() {
        Scanner scanner = TestUtil.generateScanner("목록");
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());

        assertThat(req.getUrl()).isEqualTo("목록");
    }

    @Test
    @DisplayName("매개값이 들어간 명령이 잘 처리되는지 확인")
    void checkRequestAndParam() {
        Scanner scanner = TestUtil.generateScanner("수정?id=1");
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());

        assertThat(req.getUrl()).isEqualTo("수정");
        assertThat(req.getParams()).isEqualTo("id=1");
    }

    @Test
    @DisplayName("매개값이 여러개 들어간 명령이 잘 처리되는지 확인")
    void checkRequestAndParams() {
        Scanner scanner = TestUtil.generateScanner("수정?id=1&name=1&phone=01012345678");
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());

        assertThat(req.getUrl()).isEqualTo("수정");
        assertThat(req.getParams()).isEqualTo("id=1&name=1&phone=01012345678");
    }
}