package services;

import domain.BMIStatus;

public class BMIAnalyzer {

    public static void analyzeBMI(double bmiValue) throws Exception {
        BMIStatus bmiStatus = BMIStatus.getBMIStatus(bmiValue);
        validateBMIStatus(bmiStatus);
        printPersonHealthStatus(bmiValue, bmiStatus);
    }

    private static void validateBMIStatus(BMIStatus bmiStatus) throws Exception {
        if (bmiStatus == null) throw new Exception("BMI Status is out of range! This person is probably dead ;/");
    }

    private static void printPersonHealthStatus(double bmiValue, BMIStatus bmiStatus) {
        System.out.printf("Person's BMI: %s kg/m2\n", bmiValue);
        System.out.printf("Person has: %s", bmiStatus.getBMIStatusDescription());
    }
}
