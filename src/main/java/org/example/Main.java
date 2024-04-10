package org.example;

import org.example.Animale.Animal;
import org.example.Animale.Caine;
import org.example.Animale.Pisica;
import org.example.Animale.Talie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void scriere()
    {
        List<Animal> animale  = new ArrayList<>();
        animale.add(new Pisica("dsdsd",23, LocalDate.of(2004,3,5), Talie.MEDIE,23,"dsdsd"));
        animale.add(new Pisica("dsdssd",45, LocalDate.of(2006,3,7), Talie.MICA,23,"dsdsd"));
        animale.add(new Animal("Iepurila",12,LocalDate.of(2020,6,12),Talie.MICA));
        animale.add(new Caine("Cutu",45,LocalDate.of(2023,4,20),Talie.MARE,true));
        Animal.listaInJson(animale);
    }
    public static void main(String[] args) {

        //scriere();
        List<Animal> animale = Animal.listaDinJson();
        animale.forEach(System.out::println);// referinte la metode
        System.out.println("\n Afisisare lambda:");
        animale.forEach(animal-> System.out.println(animal)); //lambda

        for(Animal animal : animale){
            System.out.println(animal);
        }  // afisare cu for

        int inaltime=0;
        boolean cititGresit = true;
        do{
            System.out.println("Citim:");
            Scanner scanner = new Scanner(System.in);
            try{inaltime = scanner.nextInt();
            cititGresit = false;
            }
            catch (NumberFormatException e)
            {

            }
        }while(cititGresit);
        if (!animale.isEmpty() && animale.get(0).getInaltime() == inaltime) {
            System.out.println("Da, primul animal are aceasta inaltime");
        } else {
            System.out.println("Nu, primul animal NU are aceasta inaltime");
        }


        //Varsta animale:
        System.out.println("Varsta animalelor:");
        animale.forEach(e-> System.out.println(LocalDate.now().getYear()- e.getDataNasterii().getYear()));


        // Lista pisici
        List<Pisica> pisici= new ArrayList<>();
        pisici.add(new Pisica("esd",23,LocalDate.of(2002,3,4),Talie.MEDIE,32,"maidanez"));
        pisici.add(new Pisica("swsws",23,LocalDate.of(2002,3,4),Talie.MEDIE,21,"pesiana"));

        //считывание расы
        System.out.println("Introduceti rasa: ");
        Scanner scanner = new Scanner(System.in);
        String rasa = scanner.next();

        var listaSortata = pisici.stream().filter(pis->pis.getRasa().equals(rasa)).sorted((a,b)->a.getGreutate()-b.getGreutate()).toList();
        System.out.println("Lista sortata:");
        System.out.println(listaSortata);


    }
}