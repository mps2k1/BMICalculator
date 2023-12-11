package com.aplikacjewebowe.bmicalculator;

import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class BMIService {

    public double calculateBMI(BMI bmi) {
        return bmi.getWeight() / Math.pow(bmi.getHeight(), 2);
    }

    public String getBMICategory(double BMIValue) {
        if (BMIValue < 18.5) {
            return "Underweight";
        } else if (BMIValue < 24.9) {
            return "Normal Weight";
        } else if (BMIValue < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
