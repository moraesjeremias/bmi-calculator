package services;

import utils.NumberFormatTool;

public class BMICalculator {

    public double formatBMIResult(double weight, double height) {
        NumberFormatTool formatTool = new NumberFormatTool();
        double bmiFormatedResult = formatTool.roundDoubleValue(evaluateBMI(weight, height));
        return bmiFormatedResult;
    }

    public double evaluateBMI(double weight, double height) {
        return weight / (height * height);
    }

}
