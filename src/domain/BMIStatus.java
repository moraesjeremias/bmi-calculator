package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum BMIStatus {
    MODERATE_THINNESS("Muito abaixo do peso", 0, 17.00),
    MILD_THINNESS("Abaixo do peso normal", 17.00, 18.49),
    NORMAL_RANGE("Peso normal", 18.50, 24.99),
    OVERWEIGHT("Sobrepeso", 25.00, 29.99),
    OBESE_CLASS_1("Obesidade I ", 30.00, 34.99),
    OBESE_CLASS_2("Obesidade II - Severa", 35.00, 39.99),
    OBESE_CLASS_3("Obesidade III - Mórbida", 40.00, 100);

    private final String bmiStatusDescription;
    private final double bmiMinRangeValue;
    private final double bmiMaxRangeValue;

    BMIStatus(String bmiStatusDescription, double bmiMinRangeValue, double bmiMaxRangeValue) {
        this.bmiStatusDescription = bmiStatusDescription;
        this.bmiMinRangeValue = bmiMinRangeValue;
        this.bmiMaxRangeValue = bmiMaxRangeValue;
    }

    public double getBMIMinRangeValue() {
        return bmiMinRangeValue;
    }

    public double getBMIMaxRangeValue() {
        return bmiMaxRangeValue;
    }

    public String getBMIStatusDescription() {
        return bmiStatusDescription;
    }

    private static Stream<BMIStatus> evaluateBMIRangeFromValue(BMIStatus[] bmiStatusValues, double bmiValue) {
        Stream<BMIStatus> verifiedBMIStatus = Arrays.stream(bmiStatusValues).filter(bmiStatus ->
                bmiValue > bmiStatus.getBMIMinRangeValue() && bmiValue < bmiStatus.getBMIMaxRangeValue()

        );
        return verifiedBMIStatus;
    }

    public static BMIStatus getBMIStatus(double bmiValue) {
        BMIStatus[] bmiStatusValues = BMIStatus.values().clone();
        Stream<BMIStatus> verifiedBMIStatus = evaluateBMIRangeFromValue(bmiStatusValues, bmiValue);
        List<BMIStatus> evaluatedBMIStatus = verifiedBMIStatus.toList();
        return evaluatedBMIStatus.isEmpty() ? null : evaluatedBMIStatus.get(0);
    }
}
