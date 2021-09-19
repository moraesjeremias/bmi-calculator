package utils;

public class NumberFormatTool {

    public double roundDoubleValue(double doubleValue) {
        java.text.NumberFormat numberFormat = java.text.NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        return Double.parseDouble(numberFormat.format(doubleValue));
    }
}
