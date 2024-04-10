package org.example.Biblioteca;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Autor {
    String nume;
    TipOpera tipOpera;
    LocalDate dataNasterii;
    List<Carte> carti;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public TipOpera getTipOpera() {
        return tipOpera;
    }

    public void setTipOpera(TipOpera tipOpera) {
        this.tipOpera = tipOpera;
    }

    public LocalDate getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(LocalDate dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public List<Carte> getCarti() {
        return carti;
    }

    public void setCarti(List<Carte> carti) {
        this.carti = carti;
    }

    public Autor(String nume, TipOpera tipOpera, LocalDate dataNasterii, List<Carte> carti) {
        this.nume = nume;
        this.tipOpera = tipOpera;
        this.dataNasterii = dataNasterii;
        this.carti = carti;
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nume='" + nume + '\'' +
                ", tipOpera=" + tipOpera +
                ", dataNasterii=" + dataNasterii +
                ", carti=" + carti +
                '}';
    }

    // FUNCTIE preluare date din json
    public static List<Autor> autorDinJson()
    {
        File file = new File("src/main/resources/autori.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            var listaAutori = mapper.readValue(file, new TypeReference<List<Autor>>() {
            });
            return listaAutori;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // FUNCTIE scriere in fisier json
    public static void autorInJson(List<Autor>listaAutori)
    {
        File file = new File("src/main/resources/autori.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
             mapper.writeValue(file,listaAutori);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
