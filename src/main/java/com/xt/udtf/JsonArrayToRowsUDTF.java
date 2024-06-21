package com.xt.udtf;

import com.aliyun.odps.udf.UDFException;
import com.aliyun.odps.udf.UDTF;
import com.aliyun.odps.udf.annotation.Resolve;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * UDTF实现，用于将JSON数组字符串解析为多行数据输出。
 * 每个JSON对象作为一个单独的行输出。
 *
 * 示例输入："[{\"name\":\"a\",\"age\":\"1\"},{\"name\":\"b\",\"age\":\"2\"}]"
 * 输出：第一行：{"name":"a","age":"1"}
 *      第二行：{"name":"b","age":"2"}
 *
 * @author 通义灵码
 */
@Resolve("string->string")
public class JsonArrayToRowsUDTF extends UDTF {

    /**
     * 处理输入的JSON数组字符串，将其解析后逐个输出。
     *
     * @param jsonString 包含JSON数组的字符串。
     * @throws UDFException 如果输入不是有效的JSON数组或处理过程中发生错误。
     */
    @Override
    public void process(Object[] args) throws UDFException {
        if (args[0] == null) {
            throw new UDFException("Input JSON string is null.");
        }

        String jsonString = (String) args[0];

        try {
            // 创建Gson实例
            Gson gson = new Gson();

            // 定义类型Token来指定我们期望解析的类型
            Type listType = new TypeToken<List<Map<String, String>>>(){}.getType();

            // 使用Gson解析JSON字符串为List<Map<String, String>>
            List<Map<String, String>> jsonArray = gson.fromJson(jsonString, listType);

            if (jsonArray != null && !jsonArray.isEmpty()) {
                // 遍历解析后的列表，逐个输出每个JSON对象
                for (Map<String, String> jsonObject : jsonArray) {
                    // 直接输出Map，因为这里不需要再转换回JSON字符串
                    forward(jsonObject.toString()); // 注意：这里根据实际需求调整，toString可能不是最佳选择
                }
            } else {
                throw new UDFException("Parsed JSON array is null or empty.");
            }
        } catch (Exception e) {
            throw new UDFException("Error parsing JSON: " + e.getMessage());
        }
    }
}
