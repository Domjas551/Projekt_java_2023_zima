package sk;
//TODO do teminacji
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kasa implements KasaInt
{
    private Budynek budynek;

    public Kasa(Budynek budynek) {
        this.budynek = budynek;
    }

    public Budynek getBudynek() {
        return budynek;
    }

    public void setBudynek(Budynek budynek) {
        this.budynek = budynek;
    }

    public String caesar(String text, int shift) {
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

    public String acaesar(String text, int shift){
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

    public void sprawdzOdpowiedz(int i) throws InvalidAnswer
    {
        if(i!=0 && i!=1)
        {
            throw new InvalidAnswer();
        }
    }

    public void sprawdzTyp(int i) throws TypeException
    {
        if(i<1||i>6)
        {
            throw new TypeException();
        }
    }

    public void sprzedaj(Pracownik pracownikObslugujacy) {
        Scanner scan = new Scanner(System.in);
        int s, i;
        int p = 0;
        double cena = 0;
        String nazwa;

        p = budynek.getSklep().getSystem().getTransakcje().size();
        budynek.getSklep().getSystem().getTransakcje().add(new Transakcja((p + 1), "Kasa", "---", "---"));
        s = 1;
        while (s == 1) {
            System.out.println("\nProszę podac nazwę nabywanego produktu:");
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
            cena = pracownikObslugujacy.podajProdukt(budynek.getSklep().getMagazyn(), nazwa, i);
            if (cena != 0) {
                budynek.getSklep().getSystem().getTransakcje().get(p).dodajLog(nazwa,i, cena);
                System.out.println("Cena wybranego produktu: " + cena + "zł");
                budynek.getSklep().getSystem().getTransakcje().get(p).setCenaCalkowita(budynek.getSklep().getSystem().getTransakcje().get(p).getCenaCalkowita() + cena);
                System.out.println("Nowa cena całokształtu zawartosci koszyka: " + budynek.getSklep().getSystem().getTransakcje().get(p).getCenaCalkowita() + "zł");
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
        System.out.println(budynek.getSklep().getSystem().getTransakcje().get(p));
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
                for (int j = 0; j < budynek.getSklep().getSystem().getTransakcje().get(p).getLogi().size(); j++) {
                    pracownikObslugujacy.odlozProdukt(budynek.getSklep().getMagazyn(), budynek.getSklep().getSystem().getTransakcje().get(p).getLogi().get(j).getProdukt(), budynek.getSklep().getSystem().getTransakcje().get(p).getLogi().get(j).getTyp());
                }
                budynek.getSklep().getSystem().getTransakcje().remove(p);
                p = -1;
            } else {
                System.out.println("Proszę wprowadzic środki:");
                cena = scan.nextDouble();
                scan.nextLine();
                if (cena < budynek.getSklep().getSystem().getTransakcje().get(p).getCenaCalkowita()) {
                    System.out.println("Środki niewystarczające!");
                } else {
                    System.out.println("Transakcja powiodła się! Wydano " + String.format("%.2f",(cena - budynek.getSklep().getSystem().getTransakcje().get(p).getCenaCalkowita())) + "zł.");
                    System.out.println("Dziękujemy za dokonanie zakupu i zapraszamy ponownie!");
                    s = 0;
                }
            }
        }

        if (!(p == -1)) {
            String a = "";
            for (int j = 0; j < budynek.getSklep().getSystem().getTransakcje().size(); j++) {
                a = a + "\n" + budynek.getSklep().getSystem().getTransakcje().get(j);
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
}
