package com.Railway.utilities;

import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class TestDataLoader {
    private static JsonObject testData;

    static {
        try {
            Reader reader = new FileReader("src/main/java/com/Railway/dataObject/data.json"); // Đường dẫn đến file của bạn
            testData = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Không tìm thấy file test data!", e);
        }
    }

    public static JsonElement getTestData(String testCaseId) {
        return testData.get(testCaseId);
    }

    public static JsonObject getTestDataObject(String testCaseId) {
        return testData.getAsJsonObject(testCaseId);
    }

    public static JsonArray getTestDataArray(String testCaseId) {
        return testData.getAsJsonArray(testCaseId);
    }
}
