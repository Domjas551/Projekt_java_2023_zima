package sk;

public class Pam_RAM extends Produkt{
    private String rodzajPam;
    private int pojemnosc;
    private int taktowanie;
    private double napiecie;

    public Pam_RAM(){}
    public Pam_RAM(String nazwa, int ilosc, String opis, String obraz, String producent, double cena, int typ,
                   String rodzajPam, int pojemnosc, int taktowanie,double napiecie){
        super(nazwa, ilosc, opis, obraz, producent,cena,typ);
        this.rodzajPam = rodzajPam;
        this.pojemnosc=pojemnosc;
        this.taktowanie=taktowanie;
        this.napiecie=napiecie;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int getTaktowanie() {
        return taktowanie;
    }

    public String getRodzajPam() {
        return rodzajPam;
    }

    public double getNapiecie() {
        return napiecie;
    }

    public void setNapiecie(double napiecie) {
        this.napiecie = napiecie;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public void setTaktowanie(int taktowanie) {
        this.taktowanie = taktowanie;
    }

    public void setRodzajPam(String rodzajPam) {
        this.rodzajPam = rodzajPam;
    }

    public String toString(){
        return super.toString()+
                "\nRodzaj pamięci: "+rodzajPam+
                "\nPojemność: "+pojemnosc+ " GB"+
                "\nTaktowanie: "+taktowanie+" MHz"+
                "\nNapięcie: "+napiecie+" V\n";
    }
}
