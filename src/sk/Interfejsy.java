package sk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

interface MagazynInt{
    public void wypiszInwentarz();
    public void uzupelnijInwentarz();
    public void zamowKomponent(Produkt komponent,int ilosc);
    public void zamowNowyKomponent();
    public void utworzZestaw();
    public void zapiszInwentarz();
    public void wypiszZestawy() ;
    public void zapiszZestawy();
}

interface PracownikInt{
    public void utworzZestaw(Magazyn m);
    public double podajProdukt(Magazyn m, String nazwa,int typ);
    public void odlozProdukt(Magazyn m, String nazwa,int typ);
    public double sprawdzOferte(Magazyn m, String nazwa,int typ);
}

interface SystemInt{
    public void zarejestrujKlienta();
    public void usunKlienta(int ind);
    public void wypiszKlientow();
    public void wypiszTransakcje();
    public void wypiszZamowienia();
    public void wypiszReklamacje();
    public void zapiszKlientow();
    public void sprzedaj(Pracownik pracownikObslugujacy);
    public void dokonajReklamacji(int idTransakcji);
    public void odbierzZamowienie(Pracownik pracownikObslugujacy);
    public void anulujZamowienie(int idZamowienia);
}

interface KasaInt
{
    public void sprzedaj(Pracownik pracownikObslugujacy);
}

interface ZestawInt
{
    public boolean czyDostepne();
}

interface ProduktInt
{
    public void wypiszOpis();
}

interface ReklamacjaInt
{
    public String czyReklamowano();
}