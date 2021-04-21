package com.github.sergej_er.radio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<RadioStation> stations = new ArrayList<>(Arrays.asList(
                new RadioStation(88.3f, "RB Bremen Zwei"),
                new RadioStation(89.8f, "Energy Bremen"),
                new RadioStation(92.9f, "N-JOY"),
                new RadioStation(95.6f, "RB Bremen Next"),
                new RadioStation(101.2f, "RB Bremen Vier"),
                new RadioStation(102.3f, "Radio FFN"),
                new RadioStation(105.7f, "Antenne Niedersachsen")
        ));

        // Beispielradio mit eigenen Werten
        Radio radio = new Radio(86.7f, 50f, false, stations);

        // Radio mit Standardwerten
        // Radio radio = new Radio();
        //
        // radio.setStations(stations);

        // Interaktion mit Benutzer
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Simulation gestartet!");
        System.out.println("Befehl eingeben (H für Befehlsliste, Q zum Beenden):");
        // Schleife wird verlassen, wenn Q eingegeben wird
        while (!quit) {
            String input = scanner.nextLine();
            if (input != null) {
                String arg = input.substring(1);
                if (input.equals("Q")) {
                    // Programm beenden
                    System.out.println("Simulation wird beendet");
                    quit = true;
                } else if (input.equals("H")) {
                    // Liste mit allen Befehlen
                    System.out.printf("%s: %s%n", "O", "Radio an- und ausschalten");
                    System.out.printf("%s: %s%n", "Z", "Radiozustand ausgeben");
                    System.out.printf("%s: %s%n", "I", "Radioinformationen ausgeben");
                    System.out.printf("%s: %s%n", "F", "Frequenz ausgeben");
                    System.out.printf("%s: %s%n", "F+", "Frequenz erhöhen");
                    System.out.printf("%s: %s%n", "F-", "Frequenz reduzieren");
                    System.out.printf("%s: %s%n", "F<n>", "Frequenz auf n setzen (z. B. F86.7)");
                    System.out.printf("%s: %s%n", "V", "Lautstärke ausgeben");
                    System.out.printf("%s: %s%n", "V+", "Lautstärke erhöhen");
                    System.out.printf("%s: %s%n", "V-", "Lautstärke reduzieren");
                    System.out.printf("%s: %s%n", "V<n>", "Lautstärke auf n setzen (z. B. V100)");
                    System.out.printf("%s: %s%n", "R", "Verfügbare Radiosender ausgeben");
                } else if (input.equals("O")) {
                    // Radio an- und ausschalten
                    radio.toggleRadio();
                    radio.print();
                } else if (input.equals("Z")) {
                    // Radiozustand ausgeben
                    radio.print();
                    // Folgende Funktionen nur möglich, wenn Radio angeschaltet ist
                } else if (radio.isPlaying()) {
                    if (input.equals("I")) {
                    // Alle Radioinformationen ausgeben
                        radio.printInfo();
                    } else if (input.startsWith("F")) {
                        // Frequenzsteuerung
                        if (arg.length() > 0) {
                            if (arg.equals("+")) {
                                // Frequenz erhöhen
                                radio.nextFrequency();
                            } else if (arg.equals("-")) {
                                // Frequenz reduzieren
                                radio.previousFrequency();
                            } else {
                                try {
                                    // Neue Frequenz setzen
                                    Frequency newFrequency = new Frequency(Float.parseFloat(arg));
                                    radio.setFrequency(newFrequency);
                                } catch (NumberFormatException e) {
                                    System.out.printf("Unbekannter Parameter: %s%n", arg);
                                }
                            }
                        }
                        // Frequenz ausgeben
                        radio.getFrequency().print();
                    } else if (input.startsWith("V")) {
                        // Lautstärke regulieren
                        if (arg.length() > 0) {
                            if (arg.equals("+")) {
                                // Lautstärke erhöhen
                                radio.volumeUp();
                            } else if (arg.equals("-")) {
                                // Lautstärke reduzieren
                                radio.volumeDown();
                            } else {
                                try {
                                    // Neue Lautstärke setzen
                                    Volume newVolume = new Volume(Float.parseFloat(arg));
                                    radio.setVolume(newVolume);
                                } catch (NumberFormatException e) {
                                    System.out.printf("Unbekannter Parameter: %s%n", arg);
                                }
                            }
                        }
                        // Lautstärke ausgeben
                        radio.getVolume().print();
                    } else if (input.equals("R")) {
                        // Alle verfügbaren Radiosender ausgeben
                        radio.printStations();
                    } else {
                        System.out.println("Unbekannter Befehl: " + input);
                    }
                } else {
                    System.out.println("Radio muss zuerst angeschaltet werden!");
                }
            } else {
                System.out.println("Eingabe wird erwartet!");
            }
        }
        scanner.close();
    }
}
