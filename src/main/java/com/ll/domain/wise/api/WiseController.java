package com.ll.domain.wise.api;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.application.WiseService;
import com.ll.domain.wise.entity.Wise;
import com.ll.global.common.Req;

import java.util.List;
import java.util.Scanner;

public class WiseController {
    private final WiseService wiseService;

    public WiseController() {
        this.wiseService = new WiseService();
    }

    public WiseController(WiseService wiseService) {
        this.wiseService = wiseService;
    }

    public void end(Req req) throws RuntimeException {
        wiseService.end();
    }

    public void add(Req req, Scanner scanner) throws RuntimeException {
        System.out.print("명언 : ");
        String word = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        Wise wise = wiseService.add(author, word);
        System.out.println(wise.getId() + "번 명언이 등록되었습니다.");
    }

    public void list(Req req) throws RuntimeException {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<Wise> wises = wiseService.list();

        wises.forEach(wise -> {
            System.out.print(wise.getId());
            System.out.print(" / ");
            System.out.print(wise.getAuthor());
            System.out.print(" / ");
            System.out.print(wise.getWord());
            System.out.println();
        });
    }

    public void remove(Req req) throws RuntimeException {
        Long id = Long.parseLong(req.getParameter("id"));
        Wise wise = wiseService.get(id);

        if (wise == null) System.out.println(id + "번 명언은 존재하지 않습니다.");
        else {
            wiseService.remove(id);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
    }

    public void modify(Req req, Scanner scanner) throws RuntimeException {
        Long id = Long.parseLong(req.getParameter("id"));
        Wise wise = wiseService.get(id);

        if (wise == null) System.out.println(id + "번 명언은 존재하지 않습니다.");
        else {
            System.out.println("명언(기존) : " + wise.getWord());
            System.out.print("명언 : ");
            String word = scanner.nextLine();
            System.out.println("작가(기존) : " + wise.getAuthor());
            System.out.print("작가 : ");
            String author = scanner.nextLine();

            wiseService.modify(id, author, word);
            System.out.println(id + "번 명언이 수정되었습니다.");
        }
    }

    public void build(Req req) throws RuntimeException {
        wiseService.build(Files.JSON_PATH);
        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}
