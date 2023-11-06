package com.ll.global.servlet;

import com.ll.domain.wise.api.WiseController;
import com.ll.global.common.Req;

import java.util.Scanner;

public class HandlerAdapter {
    private final WiseController wiseController;

    public HandlerAdapter() {
        this.wiseController = new WiseController();
    }

    public HandlerAdapter(WiseController wiseController) {
        this.wiseController = wiseController;
    }

    public void handle(Req req, Scanner scanner) throws RuntimeException {
        // ModelAndView modelAndView = null; // 실제 스프링로직을 이해할 수 있도록 주석으로 남김.

        switch (req.getUrl()) {
            case Req.END -> wiseController.end(req);
            case Req.ADD -> wiseController.add(req, scanner);
            case Req.LIST -> wiseController.list(req);
            case Req.REMOVE -> wiseController.remove(req);
            case Req.MODITY -> wiseController.modify(req, scanner);
            case Req.BUILD -> wiseController.build(req);
            default -> System.out.println("알 수 없는 명령어입니다.");
        }

        // return modelAndView;
    }
}

