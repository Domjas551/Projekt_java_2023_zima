package sk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class System_sklepu implements SystemInt{
    private Sklep_komputerowy sklep;
    private ArrayList<Klient> klienci;
    private ArrayList<Transakcja> transakcje;
    private ArrayList<Reklamacja> reklamacje;
    private ArrayList<Zamowienie> zamowienia;

    public System_sklepu() {
    }

    public System_sklepu(Sklep_komputerowy sklep) {
        this.sklep = sklep;
        klienci = new ArrayList<>();
        transakcje = new ArrayList<>();
        reklamacje = new ArrayList<>();
        zamowienia = new ArrayList<>();
    }

    public Sklep_komputerowy getSklep() {
        return sklep;
    }

    public void setSklep(Sklep_komputerowy sklep) {
        this.sklep = sklep;
    }

    public ArrayList<Transakcja> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(ArrayList<Transakcja> transakcje) {
        this.transakcje = transakcje;
    }

    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(ArrayList<Klient> klienci) {
        this.klienci = klienci;
    }

    public ArrayList<Reklamacja> getReklamacje() {
        return reklamacje;
    }

    public void setReklamacje(ArrayList<Reklamacja> reklamacje) {
        this.reklamacje = reklamacje;
    }

    //rejestruje nowego klienta
    public void zarejestrujKlienta() {
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
            imie = scan.next();
            System.out.print("Podaj nazwisko: ");
            nazwisko = scan.next();
            System.out.print("Podaj email: ");
            email = scan.next();

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

            alfa = true;
            while (alfa) {
                System.out.print("Podaj haslo: ");
                haslo = scan.next();

                if (haslo.length() < 6) {
                    System.out.println("Hasło jest za krótkie, min. długość: 6 znaków");
                } else {
                    alfa = false;
                }
            }

            klienci.add(new Klient(imie, nazwisko, email, login, haslo, id));

        } catch (InputMismatchException i) {
            System.out.println("Podano niepoprawne wartości");
        }

        zapiszKlientow();
    }

    //usuwa wskazanego klienta
    public void usunKlienta(int ind) {
        if (klienci.size() > 0) {
            if (ind < 1 || ind > klienci.size()) {
                System.out.println("Brak klienta o podanym indeksie");
            } else {
                klienci.remove(ind - 1);
            }
        } else {
            System.out.println("Brak zapisanych klientów");
        }

        zapiszKlientow();

    }

    //wypisuje wszystkich klientów
    public void wypiszKlientow() {
        try {
            if (klienci.size() == 0) {
                throw new NoRecords();
            }
            int i = 1;
            for (Klient k : klienci) {
                System.out.println(i + "." + k);
                i++;
            }
        } catch (NoRecords n) {
            System.out.println(n);
        }
    }

    //wypisuje wszystkie transakcje
    public void wypiszTransakcje() {
        try {
            if (transakcje.size() == 0) {
                throw new NoRecords();
            }
            for (Transakcja t : transakcje) {
                System.out.println("\n" + t);
            }
        } catch (NoRecords n) {
            System.out.println(n);
        }
    }

    //wypisuje wszystkie zamowienia
    public void wypiszZamowienia() {
        try {
            if (zamowienia.size() == 0) {
                throw new NoRecords();
            }
            for (Zamowienie z : zamowienia) {
                System.out.println("\n" + z);
            }
        } catch (NoRecords n) {
            System.out.println(n);
        }
    }

    //wypisuje wszystkie dostępne reklamacje
    public void wypiszReklamacje() {
        try {
            if (reklamacje.size() == 0) {
                throw new NoRecords();
            }
            for (Reklamacja r : reklamacje) {
                System.out.println("\n" + r);
            }
        } catch (NoRecords n) {
            System.out.println(n);
        }
    }

    private String caesar(String text, int shift) {
        shift %= 26;
        if (shift == 0) return text;
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c += shift;
                if (c > 'Z') c -= 26;
            } else if (c >= 'a' && c <= 'z') {
                c += shift;
                if (c > 'z') c -= 26;
            }

            sb.append((char) c);
        }
        return sb.toString();
    }

    private String acaesar(String text, int shift) {
        shift %= 26;
        if (shift == 0) return text;
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c -= shift;
                if (c < 'A') c += 26;
            } else if (c >= 'a' && c <= 'z') {
                c -= shift;
                if (c < 'a') c += 26;
            }

            sb.append((char) c);
        }
        return sb.toString();
    }

    //zapis wszystkich klientów do pliku
    public void zapiszKlientow() {
        String a = "";
        try {
            if (klienci.size() == 0) {
                throw new NoRecords();
            }
            int i = 1;
            for (Klient k : klienci) {
                a += i + ".\n" + k;
                i++;
            }
        } catch (NoRecords n) {
            System.out.println(n);
        }

        try {
            //tworzenie plików
            File f1 = new File("klienciNC.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }
            File f2 = new File("klienciC.txt");
            if (!f2.exists()) {
                f2.createNewFile();
            }
            File f3 = new File("klienciOC.txt");
            if (!f3.exists()) {
                f3.createNewFile();
            }

            //zapis klientów do pliku
            FileWriter writer = new FileWriter("klienciNC.txt");
            writer.write(a);
            writer.close();

            //zapis zaszyfrowany do pliku
            writer = new FileWriter("klienciC.txt");
            writer.write(caesar(a, 2));
            writer.close();

            //odszyfrowanie do pliku
            Scanner input = new Scanner(new File("klienciC.txt"));
            writer = new FileWriter("klienciOC.txt");
            a = "";
            while (input.hasNextLine()) {
                a += input.nextLine();
            }
            writer.write(acaesar(a, 2));
            writer.close();

        } catch (FileNotFoundException f) {
            System.out.println("Nie znaleziono pliku do odczytu");
        } catch (IOException i) {
            System.out.println("Wystąpił błąd");
        }
    }

    public void sprawdzOdpowiedz(int i) throws InvalidAnswer
    {
        if(i!=0 && i!=1)
        {
            throw new InvalidAnswer();
        }
    }

    //sprawdzenie poprawności podanego typu, poprawne wartośći <1,6>
    public void sprawdzTyp(int i) throws TypeException
    {
        if(i<1||i>6)
        {
            throw new TypeException();
        }
    }

    //funkcja realizująca procedure sprzedaży
    //TODO zmienić
    public void sprzedaj(Pracownik pracownikObslugujacy) {
        Scanner scan = new Scanner(System.in);
        int s, i;
        int p = 0;
        double cena = 0;
        String imie, nazwisko, email, login, haslo, nazwa;
        System.out.println("\nCzy zakupu dokonać chcesz jako gość? (1-tak/0-nie):");
        s = scan.nextInt();
        scan.nextLine();
        try{
            sprawdzOdpowiedz(s);
        }
        catch(InvalidAnswer ia)
        {
            System.out.println(ia);
        }
        if (s == 1) {
            System.out.println("Podaj imie: ");
            imie = scan.nextLine();
            System.out.println("Podaj nazwisko: ");
            nazwisko = scan.nextLine();
            System.out.println("Podaj email: ");
            email = scan.nextLine();
        } else {
            i = 0;
            System.out.println("Czy posiadasz już konto? (1-tak/0-nie): ");
            s = scan.nextInt();
            scan.nextLine();
            try{
                sprawdzOdpowiedz(s);
            }
            catch(InvalidAnswer ia)
            {
                System.out.println(ia);
            }
            if (s == 0) {
                zarejestrujKlienta();
            }
            s = 0;
            System.out.println("Prosimy się zalogowac: ");
            while (i < 3 && s == 0) {
                System.out.println("Podaj login: ");
                login = scan.nextLine();
                System.out.println("Podaj haslo: ");
                haslo = scan.nextLine();

                for (int j = 0; j < klienci.size(); j++) {
                    if (klienci.get(j).getLogin().equals(login)) {
                        if (klienci.get(j).getHaslo().equals(haslo)) {
                            s = 1;
                            p = j;
                        }
                        break;
                    }
                }

                if (s == 0) {
                    i++;
                    System.out.println("Podano nieprawidłowy login lub hasło!");
                    System.out.println("Liczba pozostałych prób: " + (3 - i));
                }
            }

            if (s == 0) {
                System.out.println("Logowanie nieudane. Transakcja nie doszła do skutku!");
                return;
            } else {
                imie = klienci.get(p).getImie();
                nazwisko = klienci.get(p).getNazwisko();
                email = klienci.get(p).getEmail();
            }
        }
        p = transakcje.size();
        transakcje.add(new Transakcja((p + 1), email, imie, nazwisko));
        s = 1;
        while (s == 1) {
            System.out.println("Proszę podac nazwę nabywanego produktu:");
            nazwa = scan.nextLine();
            System.out.println("Proszę podac typ nabywanego produktu: (1-Płyta główna, 2-Procesor, 3-Karta Graficzna, 4-Pamięć RAM, 5-Dysk, 6-Zestaw");
            i = scan.nextInt();
            scan.nextLine();
            try{
                sprawdzTyp(i);
            }
            catch(TypeException te)
            {
                System.out.println(te);
            }
            cena = pracownikObslugujacy.podajProdukt(sklep.getMagazyn(), nazwa, i);
            if (cena != 0) {
                transakcje.get(p).dodajLog(nazwa,i,cena);
                System.out.println("Cena wybranego produktu: " + cena + "zł");
                transakcje.get(p).setCenaCalkowita(transakcje.get(p).getCenaCalkowita() + cena);
                System.out.println("Nowa cena całokształtu zawartosci koszyka: " + transakcje.get(p).getCenaCalkowita() + "zł");
            }
            System.out.println("Czy dodać kolejny produkt? (1-tak/0-nie): ");
            s = scan.nextInt();
            scan.nextLine();
            try{
                sprawdzOdpowiedz(s);
            }
            catch(InvalidAnswer ia)
            {
                System.out.println(ia);
            }
        }

        System.out.println("Podsumowanie transakcji: ");
        System.out.println(transakcje.get(p));
        s = 1;

        while (s == 1) {
            System.out.println("1-Przejść do płatności/0-Anulować transakcję: ");
            s = scan.nextInt();
            scan.nextLine();
            try{
                sprawdzOdpowiedz(s);
            }
            catch(InvalidAnswer ia)
            {
                System.out.println(ia);
            }

            if (s == 0) {
                System.out.println("Transakcja została anulowana!");
                for (int j = 0; j < transakcje.get(p).getLogi().size(); j++) {
                    pracownikObslugujacy.odlozProdukt(sklep.getMagazyn(), transakcje.get(p).getLogi().get(j).getProdukt(), transakcje.get(p).getLogi().get(j).getTyp());
                }
                transakcje.remove(p);
                p = -1;
            } else {
                System.out.println("Proszę wprowadzic środki:");
                cena = scan.nextDouble();
                scan.nextLine();
                if (cena < transakcje.get(p).getCenaCalkowita()) {
                    System.out.println("Środki niewystarczające!");
                } else {
                    System.out.println("Transakcja powiodła się! Wydano " + String.format("%.2f",(cena - transakcje.get(p).getCenaCalkowita())) + "zł.");
                    System.out.println("Dziękujemy za dokonanie zakupu i zapraszamy ponownie!");
                    s = 0;
                }
            }
        }

        if (!(p == -1)) {
            String a = "";
            for (int j = 0; j < transakcje.size(); j++) {
                a = a + "\n" + transakcje.get(j);
            }

            //zapis do pliku
            try {
                //tworzenie plików
                File f1 = new File("transakcjeNC.txt");
                if (!f1.exists()) {
                    f1.createNewFile();
                }
                File f2 = new File("transakcjeC.txt");
                if (!f2.exists()) {
                    f2.createNewFile();
                }
                File f3 = new File("transakcjeOC.txt");
                if (!f3.exists()) {
                    f3.createNewFile();
                }
                //zapis historii transakcji do pliku
                FileWriter writer = new FileWriter("transakcjeNC.txt");
                writer.write(a);
                writer.close();

                //zapis zaszyfrowany do pliku
                writer = new FileWriter("transakcjeC.txt");
                writer.write(caesar(a, 2));
                writer.close();

                //odszyfrowanie do pliku
                Scanner input = new Scanner(new File("transakcjeC.txt"));
                writer = new FileWriter("transakcjeOC.txt");
                a = "";
                while (input.hasNextLine()) {
                    a += input.nextLine();
                }
                writer.write(acaesar(a, 2));
                writer.close();

            } catch (FileNotFoundException f) {
                System.out.println("Nie znaleziono pliku do odczytu");
            } catch (IOException e) {
                System.out.println("Wystąpił błąd");
            }
        }
    }

    //funkcja realizująca procedure reklamacji
    public void dokonajReklamacji(int idTransakcji) {
        Scanner scan = new Scanner(System.in);
        int i = -1;
        int x =-1;
        int s2 = 0;
        String powod = "";
        boolean s1 = false;
        for (int j = 0; j < transakcje.size(); j++) {
            if (transakcje.get(j).getIdTransakcji() == idTransakcji) {
                s1 = true;
                i = j;
                break;
            }
        }

        if (!s1) {
            System.out.println("\nNie znaleziono w bazie danych transakcji o takim ID!");
        } else {
                System.out.println("\nWybrana transakcja:\n" + transakcje.get(i));
                System.out.println("\nReklamacji ktorego z produktow chcesz dokonac?(<1-" + (transakcje.get(i).getLogi().size()) + ">): ");
                x = scan.nextInt();
                scan.nextLine();
                x--;

            if(!(x>=0&&x<=transakcje.get(i).getReklamacje().size()))
            {
                System.out.println("\nPodano bledny numer produktu!");
            }
            else if (transakcje.get(i).getReklamacje().get(x).isCzyDokonano()) {
                System.out.println("\nReklamacji w sprawie tych produktów już dokonano!");
            } else if (LocalDateTime.now().isAfter(transakcje.get(i).getData().plusYears(2))) {
                System.out.println("\nOd dokonania transakcji upłynęły już ponad dwa lata. Reklamacja nie jest możliwa!");
            } else {
                System.out.println("\nReklamacja możliwa. Czy na pewno chcesz kontynuować?");
                System.out.println("1-Tak/0-Nie:");
                s2 = scan.nextInt();
                scan.nextLine();
                try{
                    sprawdzOdpowiedz(s2);
                }
                catch(InvalidAnswer ia)
                {
                    System.out.println(ia);
                }

                if (s2 == 0) {
                    System.out.println("Akcja anulowana!");
                } else {
                    transakcje.get(i).getReklamacje().get(x).setCzyDokonano(true);
                    transakcje.get(i).getReklamacje().get(x).setDataReklamacji(LocalDateTime.now());
                    System.out.println("Proszę podać powód reklamacji:");
                    powod = scan.nextLine();
                    transakcje.get(i).getReklamacje().get(x).setPowod(powod);
                    reklamacje.add(transakcje.get(i).getReklamacje().get(x));
                    System.out.println("Dokonano reklamacji!");

                    String a = "";
                    for (int j = 0; j < reklamacje.size(); j++) {
                        a = a + "\n" + reklamacje.get(j);
                    }

                    //zapis do pliku
                    try {
                        //tworzenie plików
                        File f1 = new File("reklamacjeNC.txt");
                        if (!f1.exists()) {
                            f1.createNewFile();
                        }
                        File f2 = new File("reklamacjeC.txt");
                        if (!f2.exists()) {
                            f2.createNewFile();
                        }
                        File f3 = new File("reklamacjeOC.txt");
                        if (!f3.exists()) {
                            f3.createNewFile();
                        }
                        //zapis reklamacji do pliku
                        FileWriter writer = new FileWriter("reklamacjeNC.txt");
                        writer.write(a);
                        writer.close();

                        //zapis zaszyfrowany do pliku
                        writer = new FileWriter("reklamacjeC.txt");
                        writer.write(caesar(a, 2));
                        writer.close();

                        //odszyfrowanie do pliku
                        Scanner input = new Scanner(new File("reklamacjeC.txt"));
                        writer = new FileWriter("reklamacjeOC.txt");
                        a = "";
                        while (input.hasNextLine()) {
                            a += input.nextLine();
                        }
                        writer.write(acaesar(a, 2));
                        writer.close();

                    } catch (FileNotFoundException f) {
                        System.out.println("Nie znaleziono pliku do odczytu");
                    } catch (IOException e) {
                        System.out.println("Wystąpił błąd");
                    }
                }
            }
        }
    }
    //TODO do usunięcia
    public void odbierzZamowienie(Pracownik pracownikObslugujacy) {
        Scanner scan = new Scanner(System.in);
        int s, i,d1,d2,d3;
        int p = 0;
        double cena = 0;
        String imie, nazwisko, email, login, haslo, nazwa;

        i = 0;
        System.out.println("\nCzy posiadasz już konto? (1-tak/0-nie): ");
        s = scan.nextInt();
        scan.nextLine();
        try{
            sprawdzOdpowiedz(s);
        }
        catch(InvalidAnswer ia)
        {
            System.out.println(ia);
        }
        if (s == 0) {
            zarejestrujKlienta();
        }
        s = 0;
        System.out.println("Prosimy się zalogowac: ");
        while (i < 3 && s == 0) {
            System.out.println("Podaj login: ");
            login = scan.nextLine();
            System.out.println("Podaj haslo: ");
            haslo = scan.nextLine();

            for (int j = 0; j < klienci.size(); j++) {
                if (klienci.get(j).getLogin().equals(login)) {
                    if (klienci.get(j).getHaslo().equals(haslo)) {
                        s = 1;
                        p = j;
                    }
                    break;
                }
            }

            if (s == 0) {
                i++;
                System.out.println("Podano nieprawidłowy login lub hasło!");
                System.out.println("Liczba pozostałych prób: " + (3 - i));
            }
        }

        if (s == 0) {
            System.out.println("Logowanie nieudane. Zamowienie anulowane!");
            return;
        } else {
            imie = klienci.get(p).getImie();
            nazwisko = klienci.get(p).getNazwisko();
            email = klienci.get(p).getEmail();
        }
        p = zamowienia.size();
        zamowienia.add(new Zamowienie((p + 1), email, imie, nazwisko));
        s = 1;
        while (s == 1) {
            System.out.println("Proszę podac nazwę zamawianego produktu:");
            nazwa = scan.nextLine();
            System.out.println("Proszę podac typ zamawianego produktu: (1-Płyta główna, 2-Procesor, 3-Karta Graficzna, 4-Pamięć RAM, 5-Dysk, 6-Zestaw");
            i = scan.nextInt();
            scan.nextLine();
            try{
                sprawdzTyp(i);
            }
            catch(TypeException te)
            {
                System.out.println(te);
            }
            cena = pracownikObslugujacy.sprawdzOferte(sklep.getMagazyn(), nazwa, i);
            if (cena != 0) {
                zamowienia.get(p).dodajLog(nazwa,i);
            }
            System.out.println("Czy dodać kolejny produkt? (1-tak/0-nie): ");
            s = scan.nextInt();
            scan.nextLine();
            try{
                sprawdzOdpowiedz(s);
            }
            catch(InvalidAnswer ia)
            {
                System.out.println(ia);
            }
        }

        s=0;
        while(s==0) {
            System.out.println("Proszę podać oczekiwaną datę odbioru (dd MM yyyy): ");
            d1 = scan.nextInt();
            d2 = scan.nextInt();
            d3 = scan.nextInt();
            scan.nextLine();
            zamowienia.get(p).setDataOdbioru(LocalDateTime.of(d3,d2,d1,0,0,0));
            if(zamowienia.get(p).getDataOdbioru().isBefore(LocalDateTime.now().plusDays(1)))
            {
                System.out.println("Podano zbyt wczesną datę. Proszę spróbować ponownie!");
            }
            else
            {
                s=1;
            }
        }

        System.out.println("Podsumowanie zamowienia: ");
        System.out.println(zamowienia.get(p));
        s = 1;

        System.out.println("1-Potwierdzić/0-Anulować zamowienie: ");
        s = scan.nextInt();
        scan.nextLine();
        try{
            sprawdzOdpowiedz(s);
        }
        catch(InvalidAnswer ia)
        {
            System.out.println(ia);
        }
        if (s == 0) {
            System.out.println("Zamowienie zostalo anulowane!");
            zamowienia.remove(p);
            p = -1;

            if (!(p == -1)) {
                String a = "";
                for (int j = 0; j < zamowienia.size(); j++) {
                    a = a + "\n" + zamowienia.get(j);
                }

                //zapis do pliku
                try {
                    //tworzenie plików
                    File f1 = new File("zamowieniaNC.txt");
                    if (!f1.exists()) {
                        f1.createNewFile();
                    }
                    File f2 = new File("zamowieniaC.txt");
                    if (!f2.exists()) {
                        f2.createNewFile();
                    }
                    File f3 = new File("zamowieniaOC.txt");
                    if (!f3.exists()) {
                        f3.createNewFile();
                    }
                    //zapis zmowienia do pliku
                    FileWriter writer = new FileWriter("zamowieniaNC.txt");
                    writer.write(a);
                    writer.close();

                    //zapis zaszyfrowany do pliku
                    writer = new FileWriter("zamowieniaC.txt");
                    writer.write(caesar(a, 2));
                    writer.close();

                    //odszyfrowanie do pliku
                    Scanner input = new Scanner(new File("zamowieniaC.txt"));
                    writer = new FileWriter("zamowieniaOC.txt");
                    a = "";
                    while (input.hasNextLine()) {
                        a += input.nextLine();
                    }
                    writer.write(acaesar(a, 2));
                    writer.close();

                } catch (FileNotFoundException f) {
                    System.out.println("Nie znaleziono pliku do odczytu");
                } catch (IOException e) {
                    System.out.println("Wystąpił błąd");
                }
            }
        }
    }

    //umożliwia usunięcie konkretnego zamówienia, jeśli pozostało więcej niż dwa dni do realizacji
    public void anulujZamowienie(int idZamowienia) {
        Scanner scan = new Scanner(System.in);
        int i = -1;
        int s2 = 0;
        boolean s1 = false;
        for (int j = 0; j <zamowienia.size(); j++) {
            if (zamowienia.get(j).getIdZamowienia() == idZamowienia) {
                s1 = true;
                i = j;
                break;
            }
        }

        if (!s1) {
            System.out.println("\nNie znaleziono w bazie danych zamowienia o takim ID!");
        }
        else
        {
            if (LocalDateTime.now().isAfter(zamowienia.get(i).getDataOdbioru().minusDays(2))) {
            System.out.println("\nPrzepraszamy, anulowanie zamówienia w mniej niż dwa dni przed planowaną datą jego odbioru nie jest możlwe!");
            } else {
                System.out.println("\nAnulowanie zamówienia możliwe. Czy na pewno chcesz kontynuować?");
                System.out.println("1-Tak/0-Nie:");
                s2 = scan.nextInt();
                scan.nextLine();
                try{
                    sprawdzOdpowiedz(s2);
                }
                catch(InvalidAnswer ia)
                {
                    System.out.println(ia);
                }

                if (s2 == 0) {
                    System.out.println("Akcja anulowana!");
                } else {
                    zamowienia.remove(i);
                    System.out.println("Anulowano zamówienie!");

                    String a = "";
                    for (int j = 0; j < zamowienia.size(); j++) {
                        a = a + "\n" + zamowienia.get(j);
                    }

                    //zapis do pliku
                    try {
                        //tworzenie plików
                        File f1 = new File("zamowieniaNC.txt");
                        if (!f1.exists()) {
                            f1.createNewFile();
                        }
                        File f2 = new File("zamowieniaC.txt");
                        if (!f2.exists()) {
                            f2.createNewFile();
                        }
                        File f3 = new File("zamowieniaOC.txt");
                        if (!f3.exists()) {
                            f3.createNewFile();
                        }
                        //zapis zamowien do pliku
                        FileWriter writer = new FileWriter("zamowieniaNC.txt");
                        writer.write(a);
                        writer.close();

                        //zapis zaszyfrowany do pliku
                        writer = new FileWriter("zamowieniaC.txt");
                        writer.write(caesar(a, 2));
                        writer.close();

                        //odszyfrowanie do pliku
                        Scanner input = new Scanner(new File("zamowieniaC.txt"));
                        writer = new FileWriter("zamowieniaOC.txt");
                        a = "";
                        while (input.hasNextLine()) {
                            a += input.nextLine();
                        }
                        writer.write(acaesar(a, 2));
                        writer.close();

                    } catch (FileNotFoundException f) {
                        System.out.println("Nie znaleziono pliku do odczytu");
                    } catch (IOException e) {
                        System.out.println("Wystąpił błąd");
                    }
                }
            }
        }
    }
}
