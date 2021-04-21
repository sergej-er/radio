package com.github.sergej_er.radio;

import java.math.BigDecimal;

public class Value {
    // Einheit des Wertes
    private final String UNIT;
    // Maximal- und Minimalwert
    private final float MIN_VALUE;
    private final float MAX_VALUE;
    // Name des Wertes
    private String valueName;
    // Um wie viel der Wert erhöht bzw. reduziert werden soll
    private float adjustValue;
    // Der Wert
    private float value;

    // Konstruktor
    public Value(String valueName, String UNIT, float adjustValue, float MIN_VALUE, float MAX_VALUE, float value) {
        this.valueName = valueName;
        this.UNIT = UNIT;
        this.adjustValue = adjustValue;
        this.MIN_VALUE = MIN_VALUE;
        this.MAX_VALUE = MAX_VALUE;
        setValue(value);
    }

    // Erhöhen bzw. reduzieren des Wertes

    public void increment() {
        setValue(value + adjustValue);
    }

    public void decrement() {
        setValue(value - adjustValue);
    }

    // Wert formatiert ausgeben
    public void print() {
        System.out.printf("%s: %.1f %s%n", valueName, value, UNIT);
    }

    // Getter & Setter

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public float getAdjustValue() {
        return adjustValue;
    }

    public void setAdjustValue(float adjustValue) {
        this.adjustValue = adjustValue;
    }

    public float getMinValue() {
        return MIN_VALUE;
    }

    public float getMaxValue() {
        return MAX_VALUE;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        // Wert aufgrund der Ungenauigkeit von float formatieren
        BigDecimal bigDec = new BigDecimal(value).setScale(1, BigDecimal.ROUND_HALF_UP);
        float formattedValue = bigDec.floatValue();

        // Sicherstellen, dass sich der Wert zwischen Minimal- und Maximalwert befindet
        if (formattedValue < MIN_VALUE) {
            System.out.printf("Minimale %s von %.1f %s bereits erreicht%n", valueName, MIN_VALUE, UNIT);
            this.value = MIN_VALUE;
        } else if (formattedValue > MAX_VALUE) {
            System.out.printf("Maximale %s von %.1f %s bereits erreicht%n", valueName, MAX_VALUE, UNIT);
            this.value = MAX_VALUE;
        } else {
            this.value = formattedValue;
        }
    }
}
