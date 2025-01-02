package com.auto.htt.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class LocalizationUtils {
    private final Map<String, Object> loc;

    public LocalizationUtils(String language) throws IOException {
        // Tải file JSON tương ứng
        String filePath = String.format("src/main/resources/loc/%s.json", language);
        ObjectMapper mapper = new ObjectMapper();
        loc = mapper.readValue(Paths.get(filePath).toFile(), Map.class);
    }

    // Hàm để lấy chuỗi văn bản theo key, hỗ trợ truy cập lồng nhau
    public String get(String key) {
        String[] keys = key.split("\\.");
        Map<String, Object> current = loc;

        for (int i = 0; i < keys.length - 1; i++) {
            current = (Map<String, Object>) current.get(keys[i]);
        }

        return (String) current.get(keys[keys.length - 1]);
    }
}