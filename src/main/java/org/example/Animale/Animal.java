package org.example.Animale;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class Animal {
    String nume;
    int inaltime;
    LocalDate dataNasterii;
    Talie talie;

    public static List<Animal> listaDinJson() {
        File fisier = new File("src/main/resources/animale.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
           // mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            List<Animal> lista = mapper.readValue(fisier, new TypeReference<List<Animal>>() {
            });
            return lista;
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void listaInJson(List<Animal> animale) {
        File fisier = new File("src/main/resources/animale.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.writeValue(fisier, animale);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Animal(String nume, int inaltime, LocalDate dataNasterii, Talie talie) {
        this.nume = nume;
        this.inaltime = inaltime;
        this.dataNasterii = dataNasterii;
        this.talie = talie;
    }

    public Animal() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public LocalDate getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(LocalDate dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public Talie getTalie() {
        return talie;
    }

    public void setTalie(Talie talie) {
        this.talie = talie;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nume='" + nume + '\'' +
                ", inaltime=" + inaltime +
                ", dataNasterii=" + dataNasterii +
                ", talie=" + talie +
                '}';
    }
}