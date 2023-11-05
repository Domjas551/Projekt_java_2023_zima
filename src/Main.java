import sk.*;
import java.sql.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import static java.time.LocalDateTime.*;

public class Main {
    public static void main(String[] args) {
        /*
        //Zmiany
        //Usunięcie
        //sklep budynek
        //sklep system, magazyn

        //utworzenie sklepu, magazynu, systemu

        Sklep_komputerowy sk=new Sklep_komputerowy("Sklep1");

        Budynek b1=new Budynek("Szlak 1","1000 m2",sk);

        Magazyn m1=new Magazyn("Magazyn 1",b1);
        System_sklepu sy=new System_sklepu(sk);

        sk.setMagazyn(m1);
        sk.setSystem(sy);

        //utworzenie 2 pracowników wraz z ich dodaniem do systemu
        Pracownik p1=new Pracownik("Jan","Kowalski","jankow@gmail.com","jankow","123456",1);
        Pracownik p2=new Pracownik("Ewa","Nowak","ewnow@gmail.com","ewnow","324567",2);

        //testy działania f. systemowych na klientach
        //sy.wypiszPracownikow();
        sy.dodajPracownika(p1);
        sy.dodajPracownika(p2);
*/
        /*sy.wypiszPracownikow();
        sy.usunPracownika(p2);
        sy.wypiszPracownikow();
        */

        //utworzenie 2 klientów
        //testy działania f. systemowych na klientach
        /*
        sy.zarejestrujKlienta();
        sy.zarejestrujKlienta();
        sy.wypiszKlientow();
        sy.usunKlienta(2);
        sy.wypiszKlientow();
        */

        //testowanie f. magazynu
/*
        m1.wypiszZestawy();
        m1.wypiszInwentarz();

 */
        //tworzenie komponentów
        /*
        Dysk d=new Dysk("Goodram",5,"Dysk ssd","dysk.jpg","samsung",99.99,5,"512 GB","SSD",70,7,100);
        Pam_RAM pam=new Pam_RAM("Crucia",5,"Pamięć ram","pamram.jpg","Crucial",309,4,"DDR4",32,3200,1.2);
        Karta_graf k=new Karta_graf("Inno3d",5,"Karta graf.","kartaG.jpg","Nvidia",3990,3,"GeForce RTX z serii 40","PCIe 4.0 x16",12,
                "GDDR6X",21000,2610,279,42,118,285);
        Procesor p=new Procesor("Intel Core i5-12600K",0,"procesor","proc.jpg","Intel",1249.99,2,"Intel Core i5","i5-12600K","Socket 1700"
                , 3.7,10,16,125);
        Plyta_glowna pl=new Plyta_glowna("MSI B550-A PRO",5,"płyta główna","plGl.jpg","MSI",479,1,"Socket AM4","AMD B550","DDR4-3200 MHz",
                "4 x DIMM","128 GB",244,305);
        //dodanie komponentów do magazynu
        m1.getDyski().add(d);
        m1.getPlytyGl().add(pl);
        m1.getProcesory().add(p);
        m1.getPamRam().add(pam);
        m1.getKartyGraf().add(k);
        //testowanie f.
        //m1.zamowNowyKomponent();
        m1.wypiszInwentarz();
        m1.uzupelnijInwentarz();
        m1.zamowKomponent(p,10);
        m1.wypiszInwentarz();
        //testowanie f. zestawów
        //p1.utworzZestaw(m1);
        //m1.wypiszZestawy();

        //testowanie transakcji
        Kasa ka= new Kasa(b1);
        /*
        sy.sprzedaj(p1);
        sy.sprzedaj(p1);
        sy.sprzedaj(p1);
        sy.sprzedaj(p1);
        ka.sprzedaj(p1);
        sy.wypiszTransakcje();
        */

        //testowanie reklamacji
        /*
        sy.dokonajReklamacji(1);
        sy.sprzedaj(p1);
        sy.sprzedaj(p1);
        ka.sprzedaj(p2);
        sy.wypiszTransakcje();
        sy.wypiszReklamacje();
        sy.dokonajReklamacji(1);
        sy.dokonajReklamacji(1);
        sy.dokonajReklamacji(2);
        sy.dokonajReklamacji(3);
        sy.wypiszTransakcje();
        sy.wypiszReklamacje();
        */

        //testowanie skaldania i anulowania zamowien
        /*
        sy.odbierzZamowienie(p1);
        sy.odbierzZamowienie(p2);
        sy.odbierzZamowienie(p2);
        sy.wypiszZamowienia();
        sy.anulujZamowienie(1);
        sy.anulujZamowienie(1);
        sy.anulujZamowienie(3);
        sy.wypiszZamowienia();
         */
    /*
        Rejestracja rej=new Rejestracja();
        rej.zarejestroj();
*/
        //Testy BD
        //trzeba w File>Project Structure>Modules>Dependencies dodaj odpowiedni .jar z driverem (oracle jdbc driver)
        try{
            //Krok 1: załaduj klase drivera
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Krok 2: Utwórz obiekt połączenia
            Connection con=DriverManager.getConnection(
                    //jbdc:oracle:connection details //[host]:[port]/[DB service name]
                    "jdbc:oracle:thin:@149.156.138.232:1521:orcl",
                    "sbd01",
                    "sbd01"
            );

            //Krok 3: Utworzenie zapytania
            Statement stm=con.createStatement();
            //stm.executeQuery("Create table test(a date, b float(7),c number(2), d varchar2(1 char))");
            LocalDateTime data=LocalDateTime.now();
            double f=4.56;
            int i=15;
            char c='a';
            String ca="ab";
            System.out.println(f);
            //"+f+", "+i+", "+c+
            stm.executeQuery("Insert into test values(null,"+f+","+i+",'"+c+"')");
            ResultSet r=stm.executeQuery("Select * from test ");
            ResultSetMetaData rMeta=r.getMetaData();

            while(r.next()){
                System.out.println(rMeta.getColumnName(2)+": "+r.getFloat(2));
                System.out.println(rMeta.getColumnName(3)+": "+r.getInt(3));
                System.out.println(rMeta.getColumnName(4)+": "+r.getString(4));
                System.out.println("------------------");
            }

            //Krok 4: Zamknij połączenie
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

