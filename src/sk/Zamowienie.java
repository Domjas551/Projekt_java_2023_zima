package sk;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Zamowienie
{
    private int idZamowienia;
    private String email;
    private String imie;
    private String nazwisko;
    private LocalDateTime dataZlozenia;
    private LocalDateTime dataOdbioru;

    private ArrayList<LogZamowienia> logi;

    public Zamowienie(){};
    public Zamowienie(int idZamowienia,String email,String imie,String nazwisko)
    {
        this.idZamowienia=idZamowienia;
        this.email=email;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dataZlozenia= LocalDateTime.now();
        this.dataOdbioru= null;

        this.logi=new ArrayList<>();
    }

    public int getIdZamowienia() {
        return idZamowienia;
    }

    public void setIdZamowienia(int idZamowienia) {
        this.idZamowienia = idZamowienia;
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

    public LocalDateTime getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(LocalDateTime dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public LocalDateTime getDataOdbioru() {
        return dataOdbioru;
    }

    public void setDataOdbioru(LocalDateTime dataOdbioru) {
        this.dataOdbioru = dataOdbioru;
    }

    public void dodajLog(String nazwa,int typ)
    {
        this.logi.add(new LogZamowienia(nazwa,typ));
    }


    public String toString(){
        String p1="";

        if(logi.size()==0)
        {
            p1="\n---";
        }
        else {
            for (int i = 0; i < logi.size(); i++) {
                p1 = p1 + "\n" + (i+1) + ". Produkt: " + logi.get(i).getProdukt() + " Typ: " + logi.get(i).getTyp();
            }
        }
        return "\nID Transakcji: "+idZamowienia+" Kupujący: "+imie+" "+nazwisko+" Email: "+email+" Data złożenia zamowienia: "+dataZlozenia.truncatedTo(ChronoUnit.MINUTES)+" Data odbioru:"+dataOdbioru.truncatedTo(ChronoUnit.MINUTES)+
               "\nWykaz zawartosci koszyka:" + p1;
    }

    public class LogZamowienia
    {
        private String produkt;
        private int typ;

        public LogZamowienia(String produkt, int typ) {
            this.produkt = produkt;
            this.typ = typ;
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
    }
}

