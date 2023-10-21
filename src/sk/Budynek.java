package sk;
//TODO do usuniecia
import java.util.ArrayList;

public class Budynek {
    private String adres;
    private String powierzchnia;
    private Sklep_komputerowy sklep;

    private ArrayList<Kasa> kasy;

    public Budynek(){}
    public Budynek(String adres, String powierzchnia, Sklep_komputerowy sklep){
        this.adres=adres;
        this.powierzchnia=powierzchnia;
        this.sklep=sklep;
        this.kasy=new ArrayList<>();
    }

    public ArrayList<Kasa> getKasy() {
        return kasy;
    }

    public void setKasy(ArrayList<Kasa> kasy) {
        this.kasy = kasy;
    }

    public Sklep_komputerowy getSklep() {
        return sklep;
    }

    public void setSklep(Sklep_komputerowy sklep) {
        this.sklep = sklep;
    }

    public String getAdres() {
        return adres;
    }

    public String getPowierzchnia() {
        return powierzchnia;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPowierzchnia(String powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public String toString(){
        return "Adres: "+adres+
               "\nPowierzchnia: "+powierzchnia;
    }
}
