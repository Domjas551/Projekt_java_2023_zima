package sk;

public class    Karta_graf extends Produkt {
    private String ukladGraf;
    private String rodzajZlacza;
    private int pamiec;
    private String rodzajPam;
    private int taktowaniePam;
    private int taktowanieRdzenia;
    private double szerokosc;
    private double wysokosc;
    private double glebokosc;
    private double poborMocy;

    public Karta_graf(){}
    public Karta_graf(String nazwa, int ilosc, String opis, String obraz, String producent, double cena, int typ, String ukladGraf,
                      String rodzajZlacza, int pamiec, String rodzajPam, int taktowaniePam, int taktowanieRdzenia,
                      double szerokosc, double wysokosc, double glebokosc, double poborMocy ){
        super(nazwa, ilosc, opis, obraz, producent,cena,typ);
        this.ukladGraf=ukladGraf;
        this.rodzajZlacza=rodzajZlacza;
        this.pamiec=pamiec;
        this.rodzajPam=rodzajPam;
        this.taktowaniePam=taktowaniePam;
        this.taktowanieRdzenia=taktowanieRdzenia;
        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;
        this.glebokosc=glebokosc;
        this.poborMocy=poborMocy;
    }

    public String getRodzajPam() {
        return rodzajPam;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double getPoborMocy() {
        return poborMocy;
    }

    public int getPamiec() {
        return pamiec;
    }

    public String getRodzajZlacza() {
        return rodzajZlacza;
    }

    public int getTaktowaniePam() {
        return taktowaniePam;
    }

    public int getTaktowanieRdzenia() {
        return taktowanieRdzenia;
    }

    public String getUkladGraf() {
        return ukladGraf;
    }

    public void setRodzajPam(String rodzajPam) {
        this.rodzajPam = rodzajPam;
    }

    public void setGlebokosc(double glebokosc) {
        this.glebokosc = glebokosc;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public void setPoborMocy(double poborMocy) {
        this.poborMocy = poborMocy;
    }

    public void setPamiec(int pamiec) {
        this.pamiec = pamiec;
    }

    public void setRodzajZlacza(String rodzajZlacza) {
        this.rodzajZlacza = rodzajZlacza;
    }

    public void setTaktowaniePam(int taktowaniePam) {
        this.taktowaniePam = taktowaniePam;
    }

    public void setTaktowanieRdzenia(int taktowanieRdzenia) {
        this.taktowanieRdzenia = taktowanieRdzenia;
    }

    public void setUkladGraf(String ukladGraf) {
        this.ukladGraf = ukladGraf;
    }

    public String toString(){
        return super.toString()+
                "\nUkład graficzny: "+ukladGraf+
                "\nRodzaj złącza: "+rodzajZlacza+
                "\nPamięć: "+pamiec+" GB"+
                "\nRodzaj pamięci: "+rodzajPam+
                "\nTaktowanie pamięci: "+taktowaniePam+" MHz"+
                "\nTaktowanie rdzenia: "+taktowanieRdzenia+" MHz"+
                "\nSzerokość: "+szerokosc+" mm"+
                "\nWysokość: "+wysokosc+" mm"+
                "\nGłębokość: "+glebokosc+" mm"+
                "\nPobór mocy: "+poborMocy+" V\n";
    }
}
