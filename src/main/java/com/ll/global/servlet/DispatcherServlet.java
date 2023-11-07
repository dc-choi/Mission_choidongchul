package com.ll.global.servlet;

import com.ll.global.common.Req;

import java.util.Scanner;

public class DispatcherServlet {
    public Req parseRequest(String input) {
        Req req;
        String url;
        String params;

        int randomIndex = input.indexOf("?");

        if (!(randomIndex == -1)) {
            params = input.substring(randomIndex + 1);
            url = input.substring(0, randomIndex);
            req = new Req(url, params);
        } else {
            url = input;
            req = new Req(url);
        }

        return req;
    }

    public void doDispatch(Req req, Scanner scanner) {
        String validUrl = new HandlerMapping().getHandler(req);
        req.setUrl(validUrl);

        new HandlerAdapter().handle(req, scanner);
    }
}
