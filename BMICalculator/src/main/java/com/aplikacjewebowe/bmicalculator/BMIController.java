package com.aplikacjewebowe.bmicalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BMIController {

    private final BMIService bmiService;

    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @GetMapping("/bmi")
    public String showBMIForm(Model model) {
        model.addAttribute("bmi", new BMI());
        return "bmiForm";
    }

    @PostMapping("/bmi")
    public String calculateBMI(BMI bmi, Model model) {
        double bmiValue = bmiService.calculateBMI(bmi);
        String bmiCategory = bmiService.getBMICategory(bmiValue);

        model.addAttribute("bmiValue", bmiValue);
        model.addAttribute("bmiCategory", bmiCategory);

        return "bmiResult";
    }
}