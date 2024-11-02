package com.martin.unitconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemperatureController {

  @GetMapping("/temperature")
  public String getLengthPage() {
    return "temperature";
  }

  @PostMapping("/convertTemperature")
  public String convertTemperature(
      @RequestParam double value,
      @RequestParam String fromUnit,
      @RequestParam String toUnit,
      Model model
  ) {
    double convertValue = convertTemperarureValue(value, fromUnit, toUnit);
    model.addAttribute("convertValue", convertValue);
    model.addAttribute("value", value);
    model.addAttribute("fromUnit", fromUnit);
    model.addAttribute("toUnit", toUnit);
    return "temperature";
  }

  private double convertTemperarureValue(double value, String fromUnit, String toUnit) {
    double celsius = switch (fromUnit) {
      case "C" -> value;
      case "F" -> (value - 32) * 5 / 9;
      case "K" -> value - 273.15;
      default -> throw new IllegalArgumentException("Invalid fromUnit: " + fromUnit);
    };

    return switch (toUnit) {
      case "C" -> celsius;
      case "F" -> (celsius * 9 / 5) + 32;
      case "K" -> celsius + 273.15;
      default -> throw new IllegalArgumentException("Invalid toUnit: " + toUnit);
    };
  }
}
