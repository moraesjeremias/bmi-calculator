package services;

import model.Attributes;
import model.Person;

import java.util.Scanner;

public class MapInputRef {

    public Person mapPersonsAttributes() throws Exception {
        Scanner reader = new Scanner(System.in);
        double weight = mapInputAttributes("weight (Kg)", reader);
        validateAttribute(weight, Attributes.WEIGHT);
        double height = mapInputAttributes("height (meters)", reader);
        validateAttribute(height, Attributes.HEIGHT);
        reader.close();
        return createNewPerson(weight, height);
    }

    private double mapInputAttributes(String attributeMessage, Scanner reader) {
        System.out.printf("Enter a persons %s: ", attributeMessage);
        double personAttributeValue = reader.nextBigDecimal().doubleValue();
        return personAttributeValue;
    }

    private Person createNewPerson(double weight, double height) {
        Person person = new Person();
        person.setHeight(height);
        person.setWeight(weight);
        return person;
    }

    public void validateAttribute(double attributeValue, Attributes attribue) throws Exception{
        if (attribue.equals(Attributes.HEIGHT)) validateHeight(attributeValue);
        if (attribue.equals(Attributes.WEIGHT)) validateWeight(attributeValue);
    }

    private void validateWeight(double weight) throws Exception {
         if (weight < 3) throw new Exception("OMG this is a dead body! Weight can't be less than 3 Kg!");
    }

    private void validateHeight(double height) throws Exception {
         if (height > 2.80) throw new Exception("Height can't be over 2.80 meters! We're not evaluating a giant's BMI");
    }
}
