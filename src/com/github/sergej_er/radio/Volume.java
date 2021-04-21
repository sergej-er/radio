package com.github.sergej_er.radio;

public class Volume extends Value {
    // Es wurde eine Lautstärke von 0 - 100 % benutzt mit Änderungen von 5 %

    // Konstruktor mit Parameter
    public Volume(float value) {
        super("Lautstärke", "%", 5.0f, 0.0f, 100.0f, value);
    }

    // Standardkonstruktor
    public Volume() {
        super("Lautstärke", "%", 5.0f, 0.0f, 100.0f, 50.0f);
    }
}
