package sk;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User{

    private int idAdmina;

    public Admin(String imie,String nazwisko,String email,String login,String haslo,int idAdmina){
        super(imie, nazwisko, email, login, haslo);
        this.idAdmina=idAdmina;
    }

    public int getIdAdmina() {return idAdmina;}

    public void setIdAdmina(int idAdmina) {this.idAdmina = idAdmina;}

    public void utworzZestaw(Magazyn m){
        m.utworzZestaw();
    }

    //tworzy nowy zestaw z komponentów w magazynie
    /*TODO do zmiany
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
    */
    //zamawia 5 szt. nowego komponentu, poczym zapisuje stan magazynu do pliku
    /*TODO do zmiany
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
*/
    public void wypiszStanMagazynu(){}
    public void wypiszHistorieTransakcji(){}
    public void WypiszStatystykiTransakcji(){}
    public void uzupelnijKomponent(){}
    public void przyznajZniżke(){}


    public String toString(){
        return super.toString()+
                "\nId admina: "+idAdmina;
    }
}
