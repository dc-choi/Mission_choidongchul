package com.ll;

import com.ll.global.common.Req;
import com.ll.global.servlet.DispatcherServlet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                DispatcherServlet dispatcherServlet = new DispatcherServlet();

                System.out.print("명령) ");
                String input = scanner.nextLine();

                Req req = dispatcherServlet.parseRequest(input);

                dispatcherServlet.run(req, scanner);

                if (req.getUrl().equals(Req.END)) break;
            } catch (Exception e) {}
        }

        scanner.close();
    }
}
