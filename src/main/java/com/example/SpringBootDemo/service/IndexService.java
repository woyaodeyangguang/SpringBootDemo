package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IndexService {
    @Autowired
    private IndexDao indexDao;

    public Map<String, Object> getIndexData() {
        return indexDao.getIndexData();
    }
}
