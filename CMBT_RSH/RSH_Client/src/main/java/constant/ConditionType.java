package constant;

public enum ConditionType {

    BIRTHDAY,
    ROOMNUM,
    COMMERCE,
    SPECIALPERIOD,
    MEMBER,
    TOTAL;

    public static String getStringConditionType(ConditionType type){
        // 为了界面显示居中，八个字
        if(type.equals(ConditionType.BIRTHDAY))
            return "生日当天入住优惠";
        if(type.equals(ConditionType.ROOMNUM))
            return "    单次预定 >= ";
        if(type.equals(ConditionType.COMMERCE))
            return "      合作企业  ";
        if(type.equals(ConditionType.SPECIALPERIOD))
            return "特定期间入住优惠";
        if(type.equals(ConditionType.MEMBER))
            return " 会员尊享优惠 ";
        if(type.equals(ConditionType.TOTAL))
            return "  总额 >=  ";
        return null;
    }
}