package com.ll;

import com.ll.global.common.Req;
import com.ll.global.servlet.DispatcherServlet;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                DispatcherServlet dispatcherServlet = new DispatcherServlet();

                Req req = dispatcherServlet.parseRequest(scanner);

                dispatcherServlet.doDispatch(req, scanner);

                if (req.getUrl().equals(Req.END)) break;
            } catch (Exception e) {}
        }
        scanner.close();
    }
}