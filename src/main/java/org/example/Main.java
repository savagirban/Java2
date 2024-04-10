package org.example;

import org.example.Biblioteca.Autor;
import org.example.Biblioteca.Carte;
import org.example.Biblioteca.TipOpera;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void scriere()
    {
        // SCRIEM date in fisier
         List<Carte> carti= Collections.unmodifiableList(
                Arrays.asList(new Carte("Ana", 24, false),
                        new Carte("In valurile marii", 278, false),
                        new Carte("Furtuna", 186, false)
                )
        );
        List<Autor> autori = new ArrayList<Autor>();
        autori.add(new Autor("Marcu", TipOpera.BELETRISTICA,LocalDate.of(2004,3,5),carti));
        autori.add(new Autor(
                "Matei",
                TipOpera.COMEDIE,
                LocalDate.of(2021,3,4),
                Arrays.asList(new Carte("Mai3",531,false),
                        new Carte("Yxnnx",23,true))
        ));
        Autor.autorInJson(autori);
    }
    public static void main(String[] args) {
        //scriere();
        List<Autor> autori = Autor.autorDinJson();
        autori.forEach(System.out::println); //Afisare cu referinta la metoda


        ///Citire n carti de la tastatura

        int n;
        System.out.print("n=");
        Scanner scanner= new Scanner(System.in);
        n = scanner.nextInt();
        Carte c;
        List<Carte> listaCarti = new ArrayList<Carte>();
        while(n>0)
        {    c = new Carte();
            System.out.print("\nNume carte:");
            c.setTitlu(scanner.next());
            boolean cititGresit = true;
            int nrPagini = 0;
            do{
                try{
                    nrPagini = scanner.nextInt();
                    cititGresit = false;
                }catch (Exception e)
                {

                }

            }while (cititGresit);
            c.setNumarPagini(nrPagini);
            c.setEsteAudiobook(scanner.nextBoolean());
            listaCarti.add(c);


            //Afisare primele n carti ale primului autor
            for(var i=0;i<n;i++)
            {
                System.out.println(autori.get(0).getCarti().get(i));
            }

            var autoriCerut = autori.stream().filter(a->a.getTipOpera()==TipOpera.HORROR&&a.getDataNasterii().getYear()>1980&&a.getCarti().size()>n);
            System.out.println("Autorul cerute este: " +autoriCerut);


            var listaNisteCarti = autori.get(0).getCarti().stream().filter(Carte::isEsteAudiobook).collect(Collectors.toList());
            listaNisteCarti.sort((a,b)->a.getNumarPagini()-b.getNumarPagini());

        }

    }
}