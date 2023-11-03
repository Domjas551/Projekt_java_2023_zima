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
            System.out.print("Podaj imie: ");
            imie = scan.nextLine();
            Pattern pat_imie = Pattern.compile("^[A-Z][a-z]+$");
            Matcher matcher = pat_imie.matcher(imie);
            if (matcher.find()) {
                //pass
            } else {
                throw new BadDataException("imie");
            }

            System.out.print("Podaj nazwisko: ");
            nazwisko = scan.nextLine();
            Pattern pat_naz = Pattern.compile("^[A-Z][a-z]+$");
            matcher = pat_naz.matcher(nazwisko);
            if (matcher.find()) {
                //pass
            } else {
                throw new BadDataException("nazwisko");
            }

            System.out.print("Podaj email: ");
            email = scan.nextLine();
            Pattern pat_em = Pattern.compile("^.+@.+[.].+$");
            matcher = pat_em.matcher(email);
            if (matcher.find()) {
                //pass
            } else {
                throw new BadDataException("email");
            }
        }
        catch(BadDataException ex){
            //pass
        }
        try{
            System.out.print("Podaj haslo: ");
            haslo = scan.next();

            Pattern pat_ha = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(){};:<>~?_=+-]).{6,20}$");
            Matcher matcher = pat_ha.matcher(haslo);

            if (haslo.length() < 6 || haslo.length() > 20 || !matcher.find()) {
                throw new BadPasswordException();
            }
        }
        catch (BadPasswordException ex){
            //pass
        }
    }
}
