package com.psn.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toString(Object object) {
        if (object == null) {
            return "";
        } else if (object instanceof String) {
            return object + "";
        } else {
            try {
                return mapper.writeValueAsString(object);
            } catch (JsonProcessingException var2) {
                var2.printStackTrace();
                return "";
            }
        }
    }

    public static <T> T toObject(String stringObject, Class<T> clazz) {
        if (StringUtils.isNotNullOrEmpty(stringObject)) {
            return defaultValue(clazz);
        } else {
            try {
                try {
                    return mapper.readValue(stringObject, clazz);
                } catch (Exception var3) {
                    return mapper.convertValue(stringObject, clazz);
                }
            } catch (Exception var4) {
                var4.printStackTrace();
                System.out.println("khong convert sang object duoc:" + stringObject);
                return defaultValue(clazz);
            }
        }
    }

    private static <T> T defaultValue(Class<T> clazz) {
        return "vn.com.msb.db.bean.ErrorResponse".equals(clazz.getName()) ? toObject("{\r\n    \"errors\": [\r\n        {\r\n            \"MambuError\": -19,\r\n            \"errorSource\": null,\r\n            \"errorReason\": \"TRANSACTION_FAIL\",\r\n            \"timeout\": false\r\n        }\r\n    ]\r\n}", clazz) : null;
    }

    public static <T> T toObject(String stringObject, TypeReference<T> type) {
        if (StringUtils.isNotNullOrEmpty(stringObject)) {
            return null;
        } else {
            try {
                try {
                    return mapper.readValue(stringObject, type);
                } catch (Exception var3) {
                    return mapper.convertValue(stringObject, type);
                }
            } catch (Exception var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    public static <C> C toObject(String stringObject, Class<C> clazz, Class subClazz) {
        if (StringUtils.isNotNullOrEmpty(stringObject)) {
            return null;
        } else {
            try {
                JavaType type = mapper.getTypeFactory().constructParametricType(clazz, new Class[]{subClazz});
                return mapper.readValue(stringObject, type);
            } catch (IOException var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }

    public static JsonNode toJsonObject(String input) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = null;

        try {
            actualObj = mapper.readTree(input);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return actualObj;
    }

    public static Map<String, String> toHashMap(String stringObject) {
        if (StringUtils.isNotNullOrEmpty(stringObject)) {
            return null;
        } else {
            try {
                return (Map)mapper.readValue(stringObject, Map.class);
            } catch (IOException var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    public static <T> T convertObject(Object data, Class<T> clazz) {
        try {
            if (data == null) {
                return null;
            } else {
                ObjectMapper smObjectMapper = new ObjectMapper();
                return smObjectMapper.convertValue(data, clazz);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }
}
