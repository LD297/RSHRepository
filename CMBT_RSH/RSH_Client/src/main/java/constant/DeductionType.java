package constant;

public enum DeductionType {

    DISCOUNT,
    REDUCE;

    public static String getStringDeductionType(DeductionType type){
        if(type.equals(DeductionType.DISCOUNT))
            return " 折";
        if(type.equals(DeductionType.REDUCE))
            return "减 ";
        return null;

    }
}
