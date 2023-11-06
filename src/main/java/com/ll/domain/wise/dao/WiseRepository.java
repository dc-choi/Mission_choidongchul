package com.ll.domain.wise.dao;

import com.ll.domain.wise.entity.Wise;

import java.util.List;

public interface WiseRepository {
    public Wise create(String author, String word);
    public List<Wise> findAll();
    public Wise findOne(Long id);
    public Wise delete(Long id);
    public Wise update(Long id, String author, String word);
    public void save();
    public void save(String filePath);
}
