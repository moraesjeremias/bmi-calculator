package services;

import utils.NumberFormatTool;

public class BMICalculator {

    public double formatBMIResult(double weight, double height) {
        return NumberFormatTool.roundDoubleValue(evaluateBMI(weight, height));
    }

    public static double evaluateBMI(double weight, double height) {
        return weight / (height * height);
    }

}
