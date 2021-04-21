package com.github.sergej_er.radio;

public class Frequency extends Value {
    // Es wurden Frequenzen von 86.7 - 107.9 MHz benutzt mit Änderungen von 0.1 Mhz

    // Konstruktor mit Parameter
    public Frequency(float value) {
        super("Frequenz", "MHz", 0.1f, 86.7f, 107.9f, value);
    }

    // Standardkonstruktor
    public Frequency() {
        super("Frequenz", "MHz", 0.1f, 86.7f, 107.9f, 86.7f);
    }
}
