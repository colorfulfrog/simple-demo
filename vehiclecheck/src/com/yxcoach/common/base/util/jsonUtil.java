package com.yxcoach.common.base.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonUtil {
	private static ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(ObjectMapper mapper,
                                             Class<?> collectionClass,
                                             Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * json 转对象
     * @param jsonStr
     * @param beanClass
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static Object jsonToObject(String jsonStr, Class<?> beanClass)
            throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(jsonStr.getBytes(), beanClass);
    }

    /**
     * 对象转json
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String objToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
