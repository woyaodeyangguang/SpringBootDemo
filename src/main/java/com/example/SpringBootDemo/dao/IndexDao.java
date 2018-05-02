package com.example.SpringBootDemo.dao;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IndexDao {
    public Map<String, Object> getIndexData() {
        Map<String, Object> result = new HashMap<>();
        result.put("info", "Spring Boot Application");
        return result;
    }
}
