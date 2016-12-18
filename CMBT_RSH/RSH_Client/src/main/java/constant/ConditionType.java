package constant;

public enum ConditionType {

    BIRTHDAY,
    ROOMNUM,
    TOTAL,
    MEMBER,
    COMMERCE;


    public static String getStringConditionType(ConditionType type){
        if(type.equals(ConditionType.BIRTHDAY))
            return "生日特惠";
        if(type.equals(ConditionType.ROOMNUM))
            return "单次预定房间数 >= ";
        if(type.equals(ConditionType.TOTAL))
            return "总额 >= ";
        if(type.equals(ConditionType.MEMBER))
            return "普通会员";
        if(type.equals(ConditionType.COMMERCE))
            return "企业会员";
        return null;
    }
}