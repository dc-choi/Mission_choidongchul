package com.ll.domain.file.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.domain.wise.entity.Wise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files {
    public static final String FLIE_PATH = "src/main/resources/file";
    public static final String JSON_PATH = FLIE_PATH + "/data.json";
    public static final String DATABASE_PATH = FLIE_PATH + "/file.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void buildFile(List<Wise> wises, String filePath) {
        File file;

        try {
            file = checkFile(filePath);
            OBJECT_MAPPER.writeValue(file, wises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buildFile(List<Wise> wises, String filePath, String dirPath) {
        File file;

        try {
            file = checkFile(filePath, dirPath);
            OBJECT_MAPPER.writeValue(file, wises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Wise> parseFile (String filePath) {
        File file;
        List<Wise> wises = new ArrayList<>();

        try {
            file = checkFile(filePath);
            wises = OBJECT_MAPPER.readValue(file, new TypeReference<List<Wise>>() {
            });
        } catch (Exception e) {
            // System.out.println("저장된 파일이 없거나 파일을 불러오는데 실패하였습니다.");
        }

        return wises;
    }

    public static List<Wise> parseFile (String filePath, String dirPath) {
        File file;
        List<Wise> wises = new ArrayList<>();

        try {
            file = checkFile(filePath, dirPath);
            wises = OBJECT_MAPPER.readValue(file, new TypeReference<List<Wise>>() {
            });
        } catch (Exception e) {
            // System.out.println("저장된 파일이 없거나 파일을 불러오는데 실패하였습니다.");
        }

        return wises;
    }

    private static File checkFile(String filePath) throws IOException {
        File file = new File(FLIE_PATH);
        if (!file.exists()) file.mkdir();

        file = new File(filePath);
        if (!file.exists()) file.createNewFile();
        return file;
    }

    private static File checkFile(String filePath, String dirPath) throws IOException {
        File file;

        if (dirPath.contains(FLIE_PATH)) file = new File(FLIE_PATH);
        else file = new File(dirPath);
        if (!file.exists()) file.mkdir();

        file = new File(filePath);
        if (!file.exists()) file.createNewFile();
        return file;
    }
}
