package com.ll.global.servlet;

import com.ll.global.common.Req;

public class HandlerMapping {
    public String getHandler(Req req) {
        String result = null;

        switch (req.getUrl()) {
            case Req.END -> result = Req.END;
            case Req.ADD -> result = Req.ADD;
            case Req.LIST -> result = Req.LIST;
            case Req.REMOVE -> result = Req.REMOVE;
            case Req.MODITY -> result = Req.MODITY;
            case Req.BUILD -> result = Req.BUILD;
            default -> result = Req.NOT_DEFIND;
        }

        return result;
    }
}