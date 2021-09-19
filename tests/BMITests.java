import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.BMIStatus;
import model.Attributes;
import services.BMIAnalyzer;
import services.BMICalculator;
import services.MapInputRef;
import utils.NumberFormatTool;


public class BMITests {

    @Test
    public void shouldReturnNormalRangeBMIValue() {
        BMICalculator bmiCalculator = new BMICalculator();
        double bmiValue = bmiCalculator.formatBMIResult(80, 1.80);
        assertEquals(24.69, bmiValue);
    }

    @Test
    public void shouldReturnEvaluatedBMIValue() {
        double bmiValue = BMICalculator.evaluateBMI(80, 1.80);
        assertEquals(24.691358024691358, bmiValue);
    }

    @Test
    public void shouldReturnNormalRangeBMIStatus() {
        double bmiValue = 24.69;
        BMIStatus bmiStatus = BMIStatus.getBMIStatus(bmiValue);
        assertEquals(BMIStatus.NORMAL_RANGE, bmiStatus);
    }

    @Test
    public void shouldReturnObeseClassOneBMIStatus() {
        double bmiValue = 31;
        BMIStatus bmiStatus = BMIStatus.getBMIStatus(bmiValue);
        assertEquals(BMIStatus.OBESE_CLASS_1, bmiStatus);
    }

    @Test
    public void shouldThrowAnExceptionOnBMIValueOutOfRange() {
        Exception exception = assertThrows(Exception.class, () -> BMIAnalyzer.analyzeBMI(100));
        String exceptionMessage = "BMI Status is out of range! This person is probably dead ;/";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldFailOnTooTallPeopleInputHeight() {
        MapInputRef mapInputRef = new MapInputRef();
        Exception exception = assertThrows(Exception.class, () ->
                mapInputRef.validateAttribute(3, Attributes.HEIGHT)
        );
        String exceptionMessage = "Height can't be over 2.80 meters! We're not evaluating a giant's BMI";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldFailOnTooThinPeopleInputWeight() {
        MapInputRef mapInputRef = new MapInputRef();
        Exception exception = assertThrows(Exception.class, () ->
                mapInputRef.validateAttribute(2, Attributes.WEIGHT)
        );
        String exceptionMessage = "OMG this is a dead body! Weight can't be less than 3 Kg!";
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void shouldFormatDoubleNumberToTwoDecimalPoint() {
        double formattedDouble = NumberFormatTool.roundDoubleValue(10);
        assertEquals(10.00, formattedDouble);
    }
}
