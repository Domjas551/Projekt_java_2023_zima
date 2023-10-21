package sk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Magazyn implements MagazynInt{
    private String nazwa;
    private ArrayList<Produkt> plytyGl;
    private ArrayList<Produkt> procesory;
    private ArrayList<Produkt> kartyGraf;
    private ArrayList<Produkt> pamRam;
    private ArrayList<Produkt> dyski;
    private ArrayList<Zestaw> zestawy;

    public Magazyn(){}
    public Magazyn(String nazwa){
        this.nazwa=nazwa;
        this.plytyGl=new ArrayList<Produkt>();
        this.procesory=new ArrayList<Produkt>();
        this.kartyGraf=new ArrayList<Produkt>();
        this.pamRam=new ArrayList<Produkt>();
        this.dyski=new ArrayList<Produkt>();
        this.zestawy=new ArrayList<Zestaw>();
    }

    //wypisuje stan wszystkich komponentów w magazynie
    public void wypiszInwentarz(){
        try {
            if (plytyGl.size() == 0 && procesory.size()==0 && kartyGraf.size()==0 && pamRam.size()==0 && dyski.size()==0) {
                throw new NoRecords();
            }
            int ind = 1;
            for (Produkt p : plytyGl) {
                System.out.println("Indeks: " + ind);
                ind++;
                p.wypiszOpis();
            }
            for (Produkt p : procesory) {
                System.out.println("Indeks: " + ind);
                ind++;
                p.wypiszOpis();
            }
            for (Produkt p : pamRam) {
                System.out.println("Indeks: " + ind);
                ind++;
                p.wypiszOpis();
            }
            for (Produkt p : kartyGraf) {
                System.out.println("Indeks: " + ind);
                ind++;
                p.wypiszOpis();
            }
            for (Produkt p : dyski) {
                System.out.println("Indeks: " + ind);
                ind++;
                p.wypiszOpis();
            }
        }catch(NoRecords n){
            System.out.println(n);
        }
    }

    //uzupełnia liczbe komponentów których stan w magazynie wynosi 0 do 5
    public void uzupelnijInwentarz(){
        for(Produkt p : plytyGl){
            if(p.getLiczba()==0){
                p.setLiczba(5);
            }
        }
        for(Produkt p : procesory){
            if(p.getLiczba()==0){
                p.setLiczba(5);
            }
        }
        for(Produkt p : pamRam){
            if(p.getLiczba()==0){
                p.setLiczba(5);
            }
        }
        for(Produkt p : kartyGraf){
            if(p.getLiczba()==0){
                p.setLiczba(5);
            }
        }
        for(Produkt p : dyski){
            if(p.getLiczba()==0){
                p.setLiczba(5);
            }
        }
        zapiszInwentarz();
    }

    //zamawia podaną ilość konkretnego komponentu, poczym zapisuje stan magazynu do pliku
    public void zamowKomponent(Produkt komponent,int ilosc){
        int typ=komponent.getTyp();
        int index;
        switch(typ){
            case 1:
                index=plytyGl.indexOf(komponent);
                plytyGl.get(index).setLiczba( plytyGl.get(index).getLiczba()+ilosc);
                break;
            case 2:
                index=procesory.indexOf(komponent);
                procesory.get(index).setLiczba( procesory.get(index).getLiczba()+ilosc);
                break;
            case 3:
                index=kartyGraf.indexOf(komponent);
                kartyGraf.get(index).setLiczba( kartyGraf.get(index).getLiczba()+ilosc);
                break;
            case 4:
                index=pamRam.indexOf(komponent);
                pamRam.get(index).setLiczba( pamRam.get(index).getLiczba()+ilosc);
                break;
            case 5:
                index=dyski.indexOf(komponent);
                dyski.get(index).setLiczba( dyski.get(index).getLiczba()+ilosc);
                break;
        }
        zapiszInwentarz();
    }

    //zamawia 5 szt. nowego komponentu, poczym zapisuje stan magazynu do pliku
    public void zamowNowyKomponent(){
        Scanner scan=new Scanner(System.in);
        int typ=0;
        String nazwa;
        String opis;
        String obraz;
        String producent;
        double cena;
        System.out.println("Wybierz typ komponentu:\n1 - Płyta główna\n2 - Procesor\n3 - Karta graficzna\n4 - Pamięć RAM" +
                "\n5 - Dysk");
        try{
            typ= scan.nextInt();
            if(typ<1||typ>5){
                throw new TypeException();
            }
        }catch(InputMismatchException in){
            System.out.println("Podano niepoprawną wartość");
        }catch (TypeException ty){
            System.out.println(ty);
        }

        switch(typ){
            case 1:
                try{
                    System.out.println("Podaj dane komponentu:");
                    scan.nextLine();
                    System.out.print("Podaj nazwe: ");
                    nazwa=scan.nextLine();
                    System.out.print("Podaj producenta: ");
                    producent=scan.next();
                    scan.nextLine();
                    System.out.print("Podaj opis: ");
                    opis=scan.nextLine();
                    System.out.print("Podaj obraz: ");
                    obraz=scan.next();
                    System.out.print("Podaj cene: ");
                    cena=scan.nextDouble();

                    //dane plyty głównej
                    String gniazdoProc;
                    String chipset;
                    String typObsPam;
                    String liczbaBankowPam;
                    String maxWielPam;
                    double szerokosc;
                    double wysokosc;

                    System.out.print("Podaj gniazdo procesora: ");
                    scan.nextLine();
                    gniazdoProc=scan.nextLine();
                    System.out.print("Podaj chipset: ");
                    chipset=scan.nextLine();
                    System.out.print("Podaj typ obsługiwanej pamięci: ");
                    typObsPam=scan.nextLine();
                    System.out.print("Podaj liczbe banków pamięci: ");
                    liczbaBankowPam=scan.nextLine();
                    System.out.print("Podaj max wielkość banków pamięci: ");
                    maxWielPam=scan.next();
                    System.out.print("Podaj szerokość: ");
                    szerokosc=scan.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    wysokosc=scan.nextDouble();

                    if(nazwa==null||producent==null||opis==null||obraz==null||gniazdoProc==null||
                    chipset==null||typObsPam==null||liczbaBankowPam==null||maxWielPam==null){
                        throw new NullValue();
                    }

                    plytyGl.add(new Plyta_glowna(nazwa,5,opis,obraz,producent,cena,1,gniazdoProc,chipset,typObsPam,
                            liczbaBankowPam,maxWielPam,szerokosc,wysokosc));
                }catch(InputMismatchException i){
                    System.out.println("Podano niepoprawną wartość");
                }catch(NullValue n){
                    System.out.println(n);
                }
                break;
            case 2:
                try{
                    System.out.println("Podaj dane komponentu:");
                    System.out.print("Podaj nazwe: ");
                    scan.nextLine();
                    nazwa=scan.nextLine();
                    System.out.print("Podaj producenta: ");
                    producent=scan.next();
                    System.out.print("Podaj opis: ");
                    opis=scan.next();
                    System.out.print("Podaj obraz: ");
                    obraz=scan.next();
                    System.out.print("Podaj cene: ");
                    cena=scan.nextDouble();

                    //dane procesora
                    String rodzinaProc;
                    String seria;
                    String gniazdoProc;
                    double taktowanie;
                    int liczbaRdzeni;
                    int liczbaWatkow;
                    double poborMocy;

                    System.out.print("Podaj rodzine procesora: ");
                    scan.nextLine();
                    rodzinaProc=scan.nextLine();
                    System.out.print("Podaj serie: ");
                    seria=scan.next();
                    System.out.print("Podaj gniazdo procesora: ");
                    scan.nextLine();
                    gniazdoProc=scan.nextLine();
                    System.out.print("Podaj taktowanie: ");
                    taktowanie=scan.nextDouble();
                    System.out.print("Podaj liczbe rdzeni: ");
                    liczbaRdzeni=scan.nextInt();
                    System.out.print("Podaj liczbe wątków: ");
                    liczbaWatkow=scan.nextInt();
                    System.out.print("Podaj pobór mocy: ");
                    poborMocy=scan.nextDouble();

                    if(nazwa==null||producent==null||opis==null||obraz==null||gniazdoProc==null||
                            rodzinaProc==null||seria==null||gniazdoProc==null){
                        throw new NullValue();
                    }

                    procesory.add(new Procesor(nazwa,5,opis,obraz,producent,cena,2,rodzinaProc,seria,
                            gniazdoProc,taktowanie,liczbaRdzeni,liczbaWatkow,poborMocy));
                }catch(InputMismatchException i){
                    System.out.println("Podano niepoprawną wartość");
                }catch(NullValue n){
                    System.out.println(n);
                }
                break;
            case 3:
                try{
                    System.out.println("Podaj dane komponentu:");
                    System.out.print("Podaj nazwe: ");
                    scan.nextLine();
                    nazwa=scan.nextLine();
                    System.out.print("Podaj producenta: ");
                    producent=scan.next();
                    System.out.print("Podaj opis: ");
                    opis=scan.next();
                    System.out.print("Podaj obraz: ");
                    obraz=scan.next();
                    System.out.print("Podaj cene: ");
                    cena=scan.nextDouble();

                    //dane kartGraf
                    String ukladGraf;
                    String rodzajZlacza;
                    int pamiec;
                    String rodzajPam;
                    int taktowaniePam;
                    int taktowanieRdzenia;
                    double szerokosc;
                    double wysokosc;
                    double glebokosc;
                    double poborMocy;

                    System.out.print("Podaj układ graficzny: ");
                    scan.nextLine();
                    ukladGraf=scan.nextLine();
                    System.out.print("Podaj rodzaj złącza: ");
                    rodzajZlacza=scan.nextLine();
                    System.out.print("Podaj rozmiar pamięci: ");
                    pamiec=scan.nextInt();
                    System.out.print("Podaj rodzaj pamięci: ");
                    rodzajPam=scan.next();
                    System.out.print("Podaj taktowanie pamięci: ");
                    taktowaniePam=scan.nextInt();
                    System.out.print("Podaj taktowanie rdzenia: ");
                    taktowanieRdzenia=scan.nextInt();
                    System.out.print("Podaj szerokość: ");
                    szerokosc=scan.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    wysokosc=scan.nextDouble();
                    System.out.print("Podaj głębokość: ");
                    glebokosc=scan.nextDouble();
                    System.out.print("Podaj pobór mocy: ");
                    poborMocy=scan.nextDouble();

                    if(nazwa==null||producent==null||opis==null||obraz==null||ukladGraf==null||
                            rodzajZlacza==null||rodzajPam==null){
                        throw new NullValue();
                    }

                    kartyGraf.add(new Karta_graf(nazwa,5,opis,obraz,producent,cena,3,ukladGraf,rodzajZlacza,pamiec,rodzajPam,
                            taktowaniePam,taktowanieRdzenia,szerokosc,wysokosc,glebokosc,poborMocy));
                }catch(InputMismatchException i){
                    System.out.println("Podano niepoprawną wartość");
                }catch(NullValue n){
                    System.out.println(n);
                }
                break;
            case 4:
                try{
                    System.out.println("Podaj dane komponentu:");
                    System.out.print("Podaj nazwe: ");
                    scan.nextLine();
                    nazwa=scan.nextLine();
                    System.out.print("Podaj producenta: ");
                    producent=scan.next();
                    System.out.print("Podaj opis: ");
                    opis=scan.next();
                    System.out.print("Podaj obraz: ");
                    obraz=scan.next();
                    System.out.print("Podaj cene: ");
                    cena=scan.nextDouble();

                    //dane pamRAM
                    String rodzajPam;
                    int pojemnosc;
                    int taktowanie;
                    double napiecie;

                    System.out.print("Podaj rodzaj pamięci: ");
                    scan.nextLine();
                    rodzajPam=scan.nextLine();
                    System.out.print("Podaj pojemność: ");
                    pojemnosc=scan.nextInt();
                    System.out.print("Podaj taktowanie: ");
                    taktowanie=scan.nextInt();
                    System.out.print("Podaj napięcie: ");
                    napiecie=scan.nextDouble();

                    if(nazwa==null||producent==null||opis==null||obraz==null||rodzajPam==null){
                        throw new NullValue();
                    }

                    pamRam.add(new Pam_RAM(nazwa,5,opis,obraz,producent,cena,4,rodzajPam,pojemnosc,taktowanie,
                            napiecie));
                }catch(InputMismatchException i){
                    System.out.println("Podano niepoprawną wartość");
                }catch(NullValue n){
                    System.out.println(n);
                }
                break;
            case 5:
                try{
                    System.out.println("Podaj dane komponentu:");
                    System.out.print("Podaj nazwe: ");
                    scan.nextLine();
                    nazwa=scan.nextLine();
                    System.out.print("Podaj producenta: ");
                    producent=scan.next();
                    System.out.print("Podaj opis: ");
                    opis=scan.next();
                    System.out.print("Podaj obraz: ");
                    obraz=scan.next();
                    System.out.print("Podaj cene: ");
                    cena=scan.nextDouble();

                    //dane dysku
                    String pojemnosc;
                    String typDysku;
                    double szerokosc;
                    double wysokosc;
                    double glebokosc;

                    System.out.print("Podaj typ dysku: ");
                    scan.nextLine();
                    typDysku=scan.next();
                    System.out.print("Podaj pojemność: ");
                    scan.nextLine();
                    pojemnosc=scan.nextLine();
                    System.out.print("Podaj szerokość: ");
                    szerokosc=scan.nextDouble();
                    System.out.print("Podaj wysokość: ");
                    wysokosc=scan.nextDouble();
                    System.out.print("Podaj głębokość: ");
                    glebokosc=scan.nextDouble();

                    if(nazwa==null||producent==null||opis==null||obraz==null||pojemnosc==null||typDysku==null){
                        throw new NullValue();
                    }

                    dyski.add(new Dysk(nazwa,5,opis,obraz,producent,cena,5,pojemnosc,typDysku,szerokosc,wysokosc,glebokosc));
                }catch(InputMismatchException i){
                    System.out.println("Podano niepoprawną wartość");
                }catch(NullValue n){
                    System.out.println(n);
                }
                break;
        }

        zapiszInwentarz();
    }

    //tworzy nowy zestaw z komponentów w magazynie
    public void utworzZestaw(){
        try{
            if(plytyGl.size()==0||procesory.size()==0||pamRam.size()==0||kartyGraf.size()==0||dyski.size()==0){
                System.out.println("Niewystarczająca ilość elementów do utworzenia zestawu");
            }else{
                int i=1;
                int ind=0;
                Scanner scan=new Scanner(System.in);
                Plyta_glowna pl;
                Procesor pr;
                Karta_graf kg;
                Pam_RAM pam;
                Dysk dy;
                boolean alfa=true;
                String nazwa;
                String opis;

                System.out.print("Podaj nazwe zestawu:");
                nazwa=scan.nextLine();
                System.out.print("Podaj opis zestawu:");
                opis= scan.nextLine();

                System.out.println("Wybierz płyte główną:");
                for(Produkt p : plytyGl){
                    System.out.println("Indeks: "+i+"\n"+p);
                    i++;
                }
                while(alfa){
                    System.out.print("Podaj indeks płyty: ");
                    ind=scan.nextInt();
                    if(ind<1||ind>plytyGl.size()){
                        System.out.println("Podano niepoprawny indeks");
                    }else{
                        alfa=false;
                    }
                }
                pl=(Plyta_glowna) plytyGl.get(ind-1);
                i=1;
                alfa=true;

                System.out.println("Wybierz procesor:");
                for(Produkt p : procesory){
                    System.out.println("Indeks: "+i+"\n"+p);
                    i++;
                }
                while(alfa){
                    System.out.print("Podaj indeks procesora: ");
                    ind=scan.nextInt();
                    if(ind<1||ind>procesory.size()){
                        System.out.println("Podano niepoprawny indeks");
                    }else{
                        alfa=false;
                    }
                }
                pr=(Procesor) procesory.get(ind-1);
                i=1;
                alfa=true;

                System.out.println("Wybierz karte graficzną:");
                for(Produkt p : kartyGraf){
                    System.out.println("Indeks: "+i+"\n"+p);
                    i++;
                }
                while(alfa){
                    System.out.print("Podaj indeks karty: ");
                    ind=scan.nextInt();
                    if(ind<1||ind>kartyGraf.size()){
                        System.out.println("Podano niepoprawny indeks");
                    }else{
                        alfa=false;
                    }
                }
                kg=(Karta_graf) kartyGraf.get(ind-1);
                i=1;
                alfa=true;

                System.out.println("Wybierz pamięć RAM:");
                for(Produkt p : pamRam){
                    System.out.println("Indeks: "+i+"\n"+p);
                    i++;
                }
                while(alfa){
                    System.out.print("Podaj indeks pamięci: ");
                    ind=scan.nextInt();
                    if(ind<1||ind>pamRam.size()){
                        System.out.println("Podano niepoprawny indeks");
                    }else{
                        alfa=false;
                    }
                }
                pam=(Pam_RAM) pamRam.get(ind-1);
                i=1;
                alfa=true;

                System.out.println("Wybierz dysk:");
                for(Produkt p : dyski){
                    System.out.println("Indeks: "+i+"\n"+p);
                    i++;
                }
                while(alfa){
                    System.out.print("Podaj indeks dysku: ");
                    ind=scan.nextInt();
                    if(ind<1||ind>dyski.size()){
                        System.out.println("Podano niepoprawny indeks");
                    }else{
                        alfa=false;
                    }
                }
                dy=(Dysk) dyski.get(ind-1);
                i=1;
                alfa=true;

                zestawy.add(new Zestaw(nazwa, opis,pl,pr,pam,kg,dy));
            }
        }catch(InputMismatchException i){
            System.out.println("Podano niepoprawne wartości");
        }
        zapiszZestawy();
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

    private String acaesar(String text, int shift){
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

    //zapisuje inwentarz do pliku, po ówczesnym zaszyfrowaniu danych
    public void zapiszInwentarz(){
        try {
            if (plytyGl.size() == 0 && procesory.size() == 0 && kartyGraf.size() == 0 && pamRam.size() == 0 && dyski.size() == 0) {
                throw new NoRecords();
            }
            int ind = 1;
            String a = "";
            for (Produkt p : plytyGl) {
                ind++;
                a += p.toString();
            }
            for (Produkt p : procesory) {
                ind++;
                a += p.toString();
            }
            for (Produkt p : pamRam) {
                ind++;
                a += p.toString();
            }
            for (Produkt p : kartyGraf) {
                ind++;
                a += p.toString();
            }
            for (Produkt p : dyski) {
                ind++;
                a += p.toString();
            }

            //zapis do pliku
            try {
                //tworzenie plików
                File f1 = new File("inwentarzNC.txt");
                if (!f1.exists()) {
                    f1.createNewFile();
                }
                File f2 = new File("inwentarzC.txt");
                if (!f2.exists()) {
                    f2.createNewFile();
                }
                File f3 = new File("inwentarzOC.txt");
                if (!f3.exists()) {
                    f3.createNewFile();
                }
                //zapis inwentarzu do pliku
                FileWriter writer = new FileWriter("inwentarzNC.txt");
                writer.write(a);
                writer.close();

                //zapis zaszyfrowany do pliku
                writer = new FileWriter("inwentarzC.txt");
                writer.write(caesar(a, 2));
                writer.close();

                //odszyfrowanie do pliku
                Scanner input = new Scanner(new File("inwentarzC.txt"));
                writer = new FileWriter("inwentarzOC.txt");
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
        }catch(NoRecords n){
            System.out.println(n);
        }
    }

    //wypisuje zapisane zestawy z pliku, po ówczesnym odszyfrowaniu danych
    public void wypiszZestawy() {
        try {
            if (zestawy.size() == 0) {
                throw new NoRecords();
            }
            int ind = 1;
            for (Zestaw z : zestawy) {
                System.out.println("Indeks: " + ind + "\n" + z.toString());
                ind++;
            }
        } catch (NoRecords n) {
            System.out.println(n);
        }
    }

    //zapisuje zestawy do pliku, po ówczesnym zaszyfrowaniu danych
    public void zapiszZestawy(){

        String a="";

        try{

            if(zestawy.size()==0){
                throw new NoRecords();
            }

            int ind=1;

            for(Zestaw z: zestawy){
                a+="Indeks: "+ind+"\n"+z.toString();
                ind++;
            }
        }catch(NoRecords n){
            System.out.println(n);
        }

        try{
            //tworzenie plików
            File f1= new File("zestawyNC.txt");
            if(!f1.exists()){
                f1.createNewFile();
            }
            File f2=new File("zestawyC.txt");
            if(!f2.exists()){
                f2.createNewFile();
            }
            File f3=new File("zestawyOC.txt");
            if(!f3.exists()){
                f3.createNewFile();
            }
            //zapis zestawów do pliku
            FileWriter writer= new FileWriter("zestawyNC.txt");
            writer.write(a);
            writer.close();

            //zapis zaszyfrowany do pliku
            writer=new FileWriter("zestawyC.txt");
            writer.write(caesar(a,2));
            writer.close();

            //odszyfrowanie do pliku
            Scanner input=new Scanner(new File("zestawyC.txt"));
            writer= new FileWriter("zestawyOC.txt");
            a="";
            while (input.hasNextLine()) {
                a+=input.nextLine();
            }
            writer.write(acaesar(a,2));
            writer.close();

        }catch(FileNotFoundException f){
            System.out.println("Nie znaleziono pliku do odczytu");
        }catch(IOException i){
            System.out.println("Wystąpił błąd");
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Produkt> getPlytyGl() {
        return plytyGl;
    }

    public void setPlytyGl(ArrayList<Produkt> plytyGl) {
        this.plytyGl = plytyGl;
    }

    public ArrayList<Produkt> getProcesory() {
        return procesory;
    }

    public void setProcesory(ArrayList<Produkt> procesory) {
        this.procesory = procesory;
    }

    public ArrayList<Produkt> getKartyGraf() {
        return kartyGraf;
    }

    public void setKartyGraf(ArrayList<Produkt> kartyGraf) {
        this.kartyGraf = kartyGraf;
    }

    public ArrayList<Produkt> getPamRam() {
        return pamRam;
    }

    public void setPamRam(ArrayList<Produkt> pamRam) {
        this.pamRam = pamRam;
    }

    public ArrayList<Produkt> getDyski() {
        return dyski;
    }

    public void setDyski(ArrayList<Produkt> dyski) {
        this.dyski = dyski;
    }

    public ArrayList<Zestaw> getZestawy() {
        return zestawy;
    }

    public void setZestawy(ArrayList<Zestaw> zestawy) {
        this.zestawy = zestawy;
    }

    public String toString(){
        return "\nNazwa: "+nazwa;
    }
}
