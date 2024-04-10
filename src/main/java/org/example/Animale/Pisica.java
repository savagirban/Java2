package org.example.Animale;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Pisica extends Animal {
    private int greutate;
    private String rasa;

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public Pisica(String nume, int inaltime, LocalDate dataNasterii, Talie talie, int greutate, String rasa) {
        super(nume, inaltime, dataNasterii, talie);
        this.greutate = greutate;
        this.rasa = rasa;
    }

    public Pisica(int greutate, String rasa) {
        this.greutate = greutate;
        this.rasa = rasa;
    }

    public Pisica() {
    }

    @Override
    public String toString() {
        return "Pisica{" +
                "nume='" + nume + '\'' +
                ", inaltime=" + inaltime +
                ", dataNasterii=" + dataNasterii +
                ", talie=" + talie +
                '}';
    }
}
