package sk;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rejestracja {

    public Rejestracja(){}

    public void zarejestroj(){
        Scanner scan = new Scanner(System.in);

        String imie;
        String nazwisko;
        String email;
        String login = "";
        String haslo = "";
        boolean alfa = true;
        int id = (int) ((Math.random() * 9999) + 1000);

        try {

            while(alfa){
                System.out.print("Podaj imie: ");
                imie = scan.nextLine();
                Pattern pat_imie=Pattern.compile("^[A-Z][a-z]+$");
                Matcher matcher= pat_imie.matcher(imie);
                boolean matchFound=matcher.find();
                if(matchFound){
                    alfa=false;
                }else{
                    System.out.println("Podano niepoprawne imie");
                }
            }

            alfa=true;

            while(alfa){
                System.out.print("Podaj nazwisko: ");
                nazwisko = scan.nextLine();
                Pattern pat_naz=Pattern.compile("^[A-Z][a-z]+$");
                Matcher matcher= pat_naz.matcher(nazwisko);
                boolean matchFound=matcher.find();
                if(matchFound){
                    alfa=false;
                }else{
                    System.out.println("Podano niepoprawne nazwisko");
                }
            }

            alfa=true;

            while(alfa){
                System.out.print("Podaj email: ");
                email = scan.nextLine();
                Pattern pat_em=Pattern.compile(".*@.*");
                Matcher matcher= pat_em.matcher(email);
                boolean matchFound=matcher.find();
                if(matchFound){
                    alfa=false;
                }else{
                    System.out.println("Podano niepoprawny email");
                }
            }
/*
            while (alfa) {
                System.out.print("Podaj login: ");
                login = scan.next();
                if (klienci.size() != 0) {
                    int i = 0;
                    for (Klient k : klienci) {
                        if (k.getLogin().equals(login)) {
                            i = 1;
                        }
                    }
                    if (i == 1) {
                        System.out.println("Podana nazwa użytkownika jest zajęta");
                    } else {
                        alfa = false;
                    }
                } else {
                    alfa = false;
                }
            }
            */
            alfa = true;
            while (alfa) {
                System.out.print("Podaj haslo: ");
                haslo = scan.next();

                Pattern pat_ha=Pattern.compile("[a-zA-Z]+[0-9]+");
                Matcher matcher= pat_ha.matcher(haslo);
                boolean matchFound=matcher.find();


                if (haslo.length() < 6) {
                    System.out.println("Hasło jest za krótkie, min. długość: 6 znaków");
                } else if(!matchFound){
                    System.out.println("HAsło musi zawierać litere i cyfre");
                } else {
                    alfa = false;
                }
            }


        } catch (InputMismatchException i) {
            System.out.println("Podano niepoprawne wartości");
        }
    }

}
