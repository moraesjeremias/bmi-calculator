import model.Person;
import org.junit.jupiter.api.Test;
import services.BMICalculator;

public class BMITests {

    @Test
    public void shouldReturnNormalRangBMIfor80Kilos2MetersPerson() {
        BMICalculator bmiCalculator = new BMICalculator();
        Person person = new Person();
        person.setHeight(1.80);
        person.setWeight(80);

        double bmi = bmiCalculator.formatBMIResult(person.getWeight(), person.getHeight());
        assert bmi == 24.69;
    }
}
