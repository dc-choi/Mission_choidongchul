package com.ll.global.servlet;

import com.ll.TestUtil;
import com.ll.global.common.Req;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class HandlerMappingTest {
    @Test
    @DisplayName("종료 요청 핸들링 동작여부")
    void end() {
        Scanner scanner = TestUtil.generateScanner(Req.END);
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.END);
    }

    @Test
    @DisplayName("등록 요청 핸들링 동작여부")
    void add() {
        Scanner scanner = TestUtil.generateScanner(Req.ADD);
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.ADD);
    }

    @Test
    @DisplayName("목록 요청 핸들링 동작여부")
    void list() {
        Scanner scanner = TestUtil.generateScanner(Req.LIST);
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.LIST);
    }

    @Test
    @DisplayName("삭제 요청 핸들링 동작여부")
    void remove() {
        Scanner scanner = TestUtil.generateScanner(Req.REMOVE);
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.REMOVE);
    }

    @Test
    @DisplayName("수정 요청 핸들링 동작여부")
    void modify() {
        Scanner scanner = TestUtil.generateScanner(Req.MODITY);
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.MODITY);
    }

    @Test
    @DisplayName("빌드 요청 핸들링 동작여부")
    void build() {
        Scanner scanner = TestUtil.generateScanner(Req.BUILD);
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.BUILD);
    }

    @Test
    @DisplayName("알 수 없는 요청 요청 핸들링 동작여부")
    void notDefind() {
        Scanner scanner = TestUtil.generateScanner("qwerqwerqwerqwerqwer");
        Req req = new DispatcherServlet().parseRequest(scanner.nextLine());
        String url = new HandlerMapping().getHandler(req);

        assertThat(url).isEqualTo(Req.NOT_DEFIND);
    }
}