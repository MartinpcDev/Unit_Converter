package com.martin.unitconverter.util;

public enum Weight {
  MG(0.001, "mg"),
  G(1, "g"),
  KG(1000, "kg"),
  OZ(28.3495, "oz"),
  LB(453.592, "lb");

  private final double valor;
  private final String word;

  Weight(double valor, String word) {
    this.valor = valor;
    this.word = word;
  }

  public double getValor() {
    return this.valor;
  }

  public String getWord() {
    return this.word;
  }

  public static Weight fromString(String word) {
    for (Weight w : Weight.values()) {
      if (w.word.equalsIgnoreCase(word)) {
        return w;
      }
    }
    throw new IllegalArgumentException("Unidad de peso no valida " + word);
  }

  public static double obtenerValor(String unidad) {
    Weight peso = Weight.fromString(unidad);
    return peso.getValor();
  }
}
