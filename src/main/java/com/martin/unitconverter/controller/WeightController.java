package com.martin.unitconverter.controller;

import com.martin.unitconverter.util.Weight;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeightController {

  @GetMapping("/weight")
  public String getWeigthPage() {
    return "weight";
  }

  @PostMapping("/convertWeight")
  public String convertWeight(
      @RequestParam double value,
      @RequestParam String fromUnit,
      @RequestParam String toUnit,
      Model model
  ) {
    double convertValue = convertWeightValue(value, fromUnit, toUnit);
    model.addAttribute("convertValue", convertValue);
    model.addAttribute("value", value);
    model.addAttribute("fromUnit", fromUnit);
    model.addAttribute("toUnit", toUnit);
    return "weight";
  }

  private double convertWeightValue(double value, String fromUnit, String toUnit) {
    return (value * Weight.obtenerValor(fromUnit)) / Weight.obtenerValor(toUnit);
  }
}
