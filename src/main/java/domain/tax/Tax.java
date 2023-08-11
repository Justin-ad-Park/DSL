package domain.tax;

public class Tax {
    //지역세
    public static double regional(double value) {
        return value * 1.05;
    }

    //부가가치세
    public static double vat(double value) {
        return value * 1.1;
    }

    // 할증
    public static double surcharge(double value) {
        return value * 1.03;
    }

    public static double calculate(double value, boolean useRegional,
                                   boolean useVAT, boolean useSurcharge) {
        if(useRegional) value = Tax.regional(value);
        if(useVAT) value = Tax.vat(value);
        if(useSurcharge) value = Tax.surcharge(value);

        return value;
    }
}
