import model.Person;
import org.jetbrains.annotations.NotNull;
import services.BMIAnalyzer;
import services.MapInputRef;
import services.BMICalculator;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Person person = cretePerson();
            double bmi = evaluateBMI(person);
            analyzeBMI(bmi);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.printf("Couldn't evaluate persons BMI. Error: \n${exception}%s", exception);
        }
    }

    private static Person cretePerson() throws Exception {
        MapInputRef inputRef = new MapInputRef();
        Person person = inputRef.mapPersonsAttributes();
        return person;
    }

    public static double evaluateBMI(@NotNull Person person) throws Exception {
        BMICalculator bmiCalculator = new BMICalculator();
        double bmi = bmiCalculator.formatBMIResult(person.getWeight(), person.getHeight());
        return bmi;
    }

    public static void analyzeBMI(Double bmi) throws Exception {
        BMIAnalyzer.analyzeBMI(bmi);
    }
}
