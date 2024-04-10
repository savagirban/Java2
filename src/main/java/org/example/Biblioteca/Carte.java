package org.example.Biblioteca;

public class Carte {
    String titlu;
    int numarPagini;
    boolean esteAudiobook;

    public Carte(String titlu, int numarPagini, boolean esteAudiobook) {
        this.titlu = titlu;
        this.numarPagini = numarPagini;
        this.esteAudiobook = esteAudiobook;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", numarPagini=" + numarPagini +
                ", esteAudiobook=" + esteAudiobook +
                '}';
    }

    public Carte() {
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public void setNumarPagini(int numarPagini) {
        this.numarPagini = numarPagini;
    }

    public boolean isEsteAudiobook() {
        return esteAudiobook;
    }

    public void setEsteAudiobook(boolean esteAudiobook) {
        this.esteAudiobook = esteAudiobook;
    }
}
