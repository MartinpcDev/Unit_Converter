package com.martin.unitconverter.util;

public enum Length {
  MM(0.0001, "mm"),
  CM(0.01, "cm"),
  M(1, "m"),
  KM(1000, "km"),
  IN(0.0254, "in"),
  FT(0.3048, "ft"),
  YD(0.9144, "yd"),
  MI(1609.34, "mi");

  private final double valor;
  private final String word;

  Length(double valor, String word) {
    this.valor = valor;
    this.word = word;
  }

  public double getValor() {
    return valor;
  }

  public String getWord() {
    return word;
  }

  public static Length fromString(String word) {
    for (Length l : Length.values()) {
      if (l.word.equalsIgnoreCase(word)) {
        return l;
      }
    }
    throw new IllegalArgumentException("Unidad de peso no valida " + word);
  }

  public static double obtenerValor(String unidad) {
    Length length = Length.fromString(unidad);
    return length.getValor();
  }
}
