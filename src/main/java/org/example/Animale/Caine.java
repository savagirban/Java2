package org.example.Animale;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Caine extends Animal {
    boolean esteAdoptat;

    public boolean isEsteAdoptat() {
        return esteAdoptat;
    }

    public void setEsteAdoptat(boolean esteAdoptat) {
        this.esteAdoptat = esteAdoptat;
    }

    public Caine(String nume, int inaltime, LocalDate dataNasterii, Talie talie, boolean esteAdoptat) {
        super(nume, inaltime, dataNasterii, talie);
        this.esteAdoptat = esteAdoptat;
    }

    public Caine(boolean esteAdoptat) {
        this.esteAdoptat = esteAdoptat;
    }
    public Caine()
    {

    }
    @Override
    public String toString() {
        return "Caine{" +
                "esteAdoptat=" + esteAdoptat +
                ", nume='" + nume + '\'' +
                ", inaltime=" + inaltime +
                ", dataNasterii=" + dataNasterii +
                ", talie=" + talie +
                '}';
    }
}
