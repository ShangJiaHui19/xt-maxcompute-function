package com.xt.udtf;

import com.aliyun.odps.conf.Configuration;
import com.aliyun.odps.udf.UDFException;
import com.aliyun.odps.udf.UDTF;
import com.aliyun.odps.udf.annotation.Resolve;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// 声明UDTF
@Resolve("json_array_to_rows")
public class JsonArrayToRowsUDTF extends UDTF {

    // 声明输出字段
    private Object[] forwardData = new Object[1];


    // 处理方法
    @Override
    public void process(Object[] args) throws UDFException {
        // 假设输入的参数是一个JSON字符串，且只含有一个元素
        if (args == null || args.length == 0 || !(args[0] instanceof String)) {
            throw new UDFException("Input should be a JSON string.");
        }

        String jsonString = (String) args[0];

        ObjectMapper mapper = new ObjectMapper();

        try {
            // 解析JSON字符串为JsonNode
            JsonNode rootNode = mapper.readTree(jsonString);

            // 检查是否是一个数组
            if (!rootNode.isArray()) {
                throw new UDFException("Input should be a JSON array.");
            }

            // 遍历数组并发送每一行数据
            for (JsonNode element : rootNode) {
                // 假设数组中的元素是字符串，你可以根据需要处理其他类型
                if (element.isTextual()) {
                    forwardData[0] = element.asText();
                    forward(forwardData); // 发送数据
                } else {
                    // 处理非字符串元素（如果需要）
                }
            }

        } catch (IOException e) {
            throw new UDFException("Failed to parse JSON: " + e.getMessage());
        }
    }

    // 清理资源（如果需要）
    @Override
    public void close() throws UDFException {
        // 清理代码（如果需要）
    }
}