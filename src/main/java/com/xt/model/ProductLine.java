package com.xt.model;

public enum ProductLine {

//    YMYJ	移民佣金	移民
//    LX	留学前端	留学
//    LXYJ	留学佣金	留学
//    BJTS	背提	背提
//    XZC	新职场	新职场
//    FL	考培	考培
//    OY	小语种	小语种
//    XM	小麦艺术	小麦艺术
//    YM	移民	移民
//    YX	游学	游学
//    YJ	幼教	幼教
//    SX	师训	师训
//    ZH	综合	综合
//    PY	培优	培优

    YMYJ("YMYJ", "移民佣金"),
    LX("LX", "留学前端"),
    LXYJ("LXYJ", "留学佣金"),
    BJTS("BJTS", "背提"),
    XZC("XZC", "新职场"),
    FL("FL", "考培"),
    OY("OY", "小语种"),
    XM("XM", "小麦艺术"),
    YM("YM", "移民"),
    YX("YX", "游学"),
   YJ("YJ", "幼教"),
    SX("SX", "师训"),
    ZH("ZH", "综合"),
    PY("PY", "培优");
    private String code;
    private String name;
    ProductLine(String code, String name)
    {
        this.code = code;
        this.name = name;
    }
    public String getCode()
    {
        return code;
    }
    public String getName()
    {
        return name;
    }


}
