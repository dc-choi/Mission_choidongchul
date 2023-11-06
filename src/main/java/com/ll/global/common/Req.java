package com.ll.global.common;

public class Req {
    private String url; // 요청주소
    private String params; // 요청값
    public static final String ADD = "등록";
    public static final String LIST = "목록";
    public static final String REMOVE = "삭제";
    public static final String MODITY = "수정";
    public static final String BUILD = "빌드";
    public static final String END = "종료";
    public static final String NOT_DEFIND = "정의되지않음";

    public Req(String url) {
        this(url, null);
    }

    public Req(String url, String params) {
        this.url = url;
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParameter(String name) throws IllegalArgumentException {
        int keyStart = -1;

        if (this.params != null) keyStart = this.params.indexOf(name);
        if (keyStart == -1) throw new IllegalArgumentException("parse Param Error");

        int keyEnd = keyStart + name.length() + 1;

        int valueStart = this.params.substring(keyStart, keyEnd).indexOf("=") + 1;
        int valueEnd = 0;
        if (!this.params.contains("&")) valueEnd = this.params.length(); // 매개변수가 하나인 경우
        else valueEnd = valueStart + this.params.substring(keyEnd).indexOf("&"); // 매개변수가 둘 이상인 경우

        return this.params.substring(valueStart, valueEnd);
    }
}

