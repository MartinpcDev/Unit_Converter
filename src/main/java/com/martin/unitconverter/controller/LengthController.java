package com.martin.unitconverter.controller;

import com.martin.unitconverter.util.Length;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LengthController {

  @GetMapping("/length")
  public String getLengthPage() {
    return "length";
  }

  @PostMapping("/convertLength")
  public String convertLength(
      @RequestParam double value,
      @RequestParam String fromUnit,
      @RequestParam String toUnit,
      Model model
  ) {
    double convertValue = convertLengthValue(value, fromUnit, toUnit);
    model.addAttribute("convertValue", convertValue);
    model.addAttribute("value", value);
    model.addAttribute("fromUnit", fromUnit);
    model.addAttribute("toUnit", toUnit);
    return "length";
  }

  private double convertLengthValue(double value, String fromUnit, String toUnit) {
    return (value * Length.obtenerValor(fromUnit)) / Length.obtenerValor(toUnit);
  }
}
