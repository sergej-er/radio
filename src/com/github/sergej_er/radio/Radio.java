package com.github.sergej_er.radio;

import java.util.ArrayList;

public class Radio {
    // Frequenz des Radios
    private Frequency frequency;
    // Lautstärke des Radios
    private Volume volume;
    // Zustand des Radios
    private boolean isPlaying;
    // Liste der Radiosender
    private ArrayList<RadioStation> stations;

    // Konstruktor mit Parametern
    public Radio(float frequency, float volume, boolean isPlaying, ArrayList<RadioStation> stations) {
        this.frequency = new Frequency(frequency);
        this.volume = new Volume(volume);
        this.isPlaying = isPlaying;
        this.stations = stations;
    }

    // Standardkonstruktor
    public Radio() {
        frequency = new Frequency();
        volume = new Volume();
        isPlaying = false;
        stations = new ArrayList<>();
    }

    // Frequenz erhöhen
    public void nextFrequency() {
        frequency.increment();
        printCurrentStation(frequency.getValue());
    }

    // Frequenz reduzieren
    public void previousFrequency() {
        frequency.decrement();
        printCurrentStation(frequency.getValue());
    }

    // Lautstärke erhöhen
    public void volumeUp() {
        volume.increment();
    }

    // Frequenz reduzieren
    public void volumeDown() {
        volume.decrement();
    }

    // Radio an- oder ausschalten
    public void toggleRadio() {
        setPlaying(!isPlaying);
    }

    // Zustand des Radios ausgeben
    public void print() {
        System.out.printf("Radio ist %s%n", isPlaying ? "eingeschaltet" : "ausgeschaltet");
    }

    // Radioinformationen mit Zustand, Lautstärke, Frequenz und eventuellem Radiosender ausgeben
    public void printInfo() {
        this.print();
        volume.print();
        frequency.print();
        printCurrentStation(frequency.getValue());
    }

    // Falls vorhanden, laufenden Radiosender ausgeben
    public void printCurrentStation(float frequency) {
        stations.stream()
                .filter(station -> frequency == station.getFrequency())
                .findFirst().ifPresent(station -> System.out.printf("Radiosender: %s%n", station.getName()));
    }

    // Alle verfügbaren Radiosender ausgeben
    public void printStations() {
        if (stations.size() > 0) {
            for (RadioStation station : stations) {
                System.out.printf("%s, %.1f MHz%n", station.getName(), station.getFrequency());
            }
        } else {
            System.out.println("Keine Sender gefunden");
        }
    }

    // Getter & Setter

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
        printCurrentStation(frequency.getValue());
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public ArrayList<RadioStation> getStations() {
        return stations;
    }

    public void setStations(ArrayList<RadioStation> stations) {
        this.stations = stations;
    }
}
