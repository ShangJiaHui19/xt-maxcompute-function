package com.xt.model;

public enum ProductType {

    LX_APPLY_SERVICE("LX_APPLY_SERVICE", ProductLine.LX, "申请服务"),
    LX_APPLY_ADDITIONAL_SERVICE("LX_APPLY_ADDITIONAL_SERVICE", ProductLine.LX, "补充申请服务"),
    LX_SINGLE_SERVICE("LX_SINGLE_SERVICE", ProductLine.LX,"单项服务"),
    LX_APPRECIATION_SERVICE("LX_APPRECIATION_SERVICE", ProductLine.LX, "增值服务"),
    LX_THIRD_PART_SERVICE("LX_THIRD_PART_SERVICE", ProductLine.LX,"第三方协议"),
    FL_COURSE("FL_COURSE", ProductLine.FL,"课程"),
    FL_ONLINE_COURSE("FL_ONLINE_COURSE", ProductLine.FL,"在线课程"),
    FL_PROJECT("FL_PROJECT", ProductLine.FL, "项目"),
    OY_COURSE("OY_COURSE", ProductLine.OY,"课程"),
    OY_ONLINE_COURSE("OY_ONLINE_COURSE", ProductLine.OY,"在线课程"),
    OY_PROJECT("OY_PROJECT", ProductLine.OY,"项目"),
    XM_COURSE_AND_PROJECT("XM_COURSE_AND_PROJECT", ProductLine.XM,"课程和项目"),
    XZC_PROJECT("XZC_PROJECT", ProductLine.XZC,"项目"),
    BJTS_COOPERATE("BJTS_COOPERATE", ProductLine.BJTS,"合作产品"),
    BJTS_GROUP("BJTS_GROUP", ProductLine.BJTS,"集团产品"),
    PACKAGE("PACKAGE", ProductLine.ZH,"套餐产品"),
    ;
    private String code;
    private String name;
    private ProductLine productLine;
    private String description;
    ProductType(String code, ProductLine productLine, String name)
    {
        this.code = code;
        this.name = name;
        this.productLine = productLine;
    }

}
