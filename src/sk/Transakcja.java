package sk;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Transakcja
{
    private int idTransakcji;
    private String email;
    private String imie;
    private String nazwisko;
    private LocalDateTime data;
    private double cenaCalkowita;

    private ArrayList<Reklamacja> reklamacje;
    private ArrayList<LogTransakcji> logi;


    public Transakcja(){};
    public Transakcja(int idTransakcji,String email,String imie,String nazwisko) {
        this.idTransakcji = idTransakcji;
        this.email = email;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data = LocalDateTime.now();
        this.cenaCalkowita = 0;
        this.reklamacje = new ArrayList<>();
        this.logi=new ArrayList<>();

    }

    public ArrayList<Reklamacja> getReklamacje() {
        return reklamacje;
    }

    public void setReklamacje(ArrayList<Reklamacja> reklamacje) {
        this.reklamacje = reklamacje;
    }

    public int getIdTransakcji() {
        return idTransakcji;
    }

    public void setIdTransakcji(int idTransakcji) {
        this.idTransakcji = idTransakcji;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public double getCenaCalkowita() {
        return cenaCalkowita;
    }

    public void setCenaCalkowita(double cenaCalkowita) {
        this.cenaCalkowita = cenaCalkowita;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ArrayList<LogTransakcji> getLogi() {
        return logi;
    }

    public void setLogi(ArrayList<LogTransakcji> logi) {
        this.logi = logi;
    }

    public void dodajLog(String nazwa,int typ, double cena)
    {
        this.logi.add(new LogTransakcji(nazwa,typ,cena));
        this.reklamacje.add(new Reklamacja(this,nazwa));
    }

    public String toString(){
        String p1="";
        String p2="";
        int s1=0;

        for(int i=0; i<reklamacje.size();i++) {
            if (reklamacje.get(i).isCzyDokonano()) {
                p2 = p2+ "\n" + reklamacje.get(i);
                s1=1;
            }
        }

        if(s1==0)
        {
            p2="\n---";
        }

        if(logi.size()==0)
        {
            p1="\n---";
        }
        else {
            for (int i = 0; i < logi.size(); i++) {
                p1 = p1 + "\n" + (i+1) + ". Produkt: " + logi.get(i).produkt + " Typ: " + logi.get(i).getTyp() + " Cena: " + logi.get(i).cena + "zł";
            }
        }
        return "\nID Transakcji: "+idTransakcji+" Cena całkowita: "+cenaCalkowita+"zł Kupujący: "+imie+" "+nazwisko+" Email: "+email+" Data: "+data.truncatedTo(ChronoUnit.MINUTES)+
               "\nWykaz zawartosci koszyka:" + p1+
               "\nReklamacje: "+p2;

    }

    public class LogTransakcji
    {
        private String produkt;
        private int typ;
        private Double cena;

        public LogTransakcji(String produkt, int typ, Double cena) {
            this.produkt = produkt;
            this.typ = typ;
            this.cena = cena;
        }

        public String getProdukt() {
            return produkt;
        }

        public void setProdukt(String produkt) {
            this.produkt = produkt;
        }

        public int getTyp() {
            return typ;
        }

        public void setTyp(int typ) {
            this.typ = typ;
        }

        public Double getCena() {
            return cena;
        }

        public void setCena(Double cena) {
            this.cena = cena;
        }
    }
}
