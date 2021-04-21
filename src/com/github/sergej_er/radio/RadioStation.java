package com.github.sergej_er.radio;

public class RadioStation {
    // Frequenz des Radiosenders
    private final float FREQUENCY;
    // Name des Radiosenders
    private final String NAME;

    // Konstruktor
    public RadioStation(float FREQUENCY, String NAME) {
        this.FREQUENCY = FREQUENCY;
        this.NAME = NAME;
    }

    // Getter & Setter

    public float getFrequency() {
        return FREQUENCY;
    }

    public String getName() {
        return NAME;
    }
}
