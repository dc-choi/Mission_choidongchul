package com.ll.domain.wise.dao;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.entity.Wise;

import java.util.List;

public class FileWiseRepository implements WiseRepository {
    private final String filePath;
    private static List<Wise> wises;

    public FileWiseRepository() {
        this.filePath = Files.DATABASE_PATH;
        wises = Files.parseFile(Files.DATABASE_PATH);
    }

    public FileWiseRepository(String filePath, String dirPath) {
        this.filePath = filePath;
        wises = Files.parseFile(filePath, dirPath);
    }

    @Override
    public Wise create(String author, String word) {
        Long max = this.max();
        Wise wise = new Wise(max, author, word);
        wises.add(wise);

        this.save();

        return wise;
    }

    @Override
    public List<Wise> findAll() {
        return wises;
    }

    @Override
    public Wise findOne(Long id) {
        Wise wise = null;

        for (Wise w : wises) {
            if (w.getId().equals(id)) {
                wise = new Wise(w.getId(), w.getAuthor(), w.getWord());
            }
        }

        return wise;
    }

    @Override
    public Wise delete(Long id) {
        Wise wise = null;

        for (int i = 0; i < wises.size(); i++) {
            if (id.equals(wises.get(i).getId())) {
                wise = wises.get(i);
                wises.remove(i);
            }
        }

        this.save();

        return wise;
    }

    @Override
    public Wise update(Long id, String author, String word) {
        Wise wise = null;

        for (Wise value : wises) {
            if (id.equals(value.getId())) {
                value.setAuthor(author);
                value.setWord(word);
                wise = value;
            }
        }

        this.save();

        return wise;
    }

    @Override
    public void save() {
        Files.buildFile(wises, this.filePath);
    }

    @Override
    public void save(String filePath) {
        Files.buildFile(wises, filePath);
    }

    /**
     * wises가 가진 id의 최대값을 구한다.
     *
     * @return wises가 가진 id의 최대값
     */
    private Long max() {
        Long max = 0L;

        for (Wise wise : wises) {
            if (max < wise.getId()) max = wise.getId();
        }

        return max + 1;
    }

    /**
     * wises의 모든 객체를 없앤다 (테스트 전용)
     */
    public void clean() {
        wises.clear();
    }
}
