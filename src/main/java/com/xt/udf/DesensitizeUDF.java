package com.xt.udf;


import com.aliyun.odps.udf.UDF;

public class DesensitizeUDF extends UDF {

    /**
     * 对手机号和身份证号进行脱敏处理
     *
     * @param data      需要脱敏的数据（字符串）
     * @param dataType  数据类型（'phone' 或 'idcard'）
     * @return          脱敏后的数据（字符串）
     */
    public String evaluate(final String data, final String dataType) {
        if (data == null || dataType == null) {
            return null;
        }

        String input = data.toString();
        String type = dataType.toString();

        String result = desensitizePersonalInfo(input, type);

        return result;
    }

    private String desensitizePersonalInfo(String data, String dataType) {
        if (dataType.equalsIgnoreCase("phone")) {
            // 手机号脱敏：保留前三位和后四位
            if (data.matches("\\d{11}")) {
                return data.substring(0, 3) + "****" + data.substring(7);
            }
        } else if (dataType.equalsIgnoreCase("idcard")) {
            // 身份证号脱敏：保留前四位和后四位（假设为18位身份证）
            if (data.matches("\\d{18}")) {
                return data.substring(0, 4) + "************" + data.substring(14);
            } else if (data.matches("\\d{15}")) {
                // 15位身份证号脱敏：保留前四位和后四位
                return data.substring(0, 4) + "*********";
            }
        }

        // 如果不符合上述规则，则直接返回原始数据
        return data;
    }

    // 示例用法（maxCompute中通过SQL调用UDF）
    // SELECT desensitize(phone_column, 'phone') FROM your_table;

}
