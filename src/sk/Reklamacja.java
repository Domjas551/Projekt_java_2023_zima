package sk;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Reklamacja
{
    private boolean czyDokonano;
    private String nazwaProduktu;
    private LocalDateTime dataReklamacji;
    private String powod;
    private Transakcja transakcja;

    public Reklamacja(){}
    public Reklamacja(Transakcja transakcja, String nazwaProduktu) {
        this.czyDokonano = false;
        this.dataReklamacji = null;
        this.nazwaProduktu=nazwaProduktu;
        this.powod ="";
        this.transakcja=transakcja;
    }

    public Transakcja getTransakcja() {
        return transakcja;
    }

    public void setTransakcja(Transakcja transakcja) {
        this.transakcja = transakcja;
    }

    public boolean isCzyDokonano() {
        return czyDokonano;
    }

    public void setCzyDokonano(boolean czyDokonano) {
        this.czyDokonano = czyDokonano;
    }

    public LocalDateTime getDataReklamacji() {
        return dataReklamacji;
    }

    public void setDataReklamacji(LocalDateTime dataReklamacji) {
        this.dataReklamacji = dataReklamacji;
    }

    public String getPowod() {
        return powod;
    }

    public void setPowod(String powod) {
        this.powod = powod;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    public void setNazwaProduktu(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
    }

    @Override
    public String toString() {
        return "ID transakcji: "+transakcja.getIdTransakcji()+" Data reklamacji: "+dataReklamacji.truncatedTo(ChronoUnit.MINUTES)+" Produkt: "+nazwaProduktu+"\nPowod reklamacji:\n"+powod;
    }
}
