package sk;

public class Plyta_glowna  extends Produkt{
    private String gniazdoProcesora;
    private String chipSet;
    private String typObslugiwanejPam;
    private String liczbaBankowPamieci;
    private String maxWielkoscRam;
    private double szerokosc;
    private double wysokosc;

    public Plyta_glowna(){}
    public Plyta_glowna(String nazwa, int ilosc, String opis, String obraz, String producent, double cena, int typ,String gniazdoProcesora,
                        String chipSet,String typObslugiwanejPam,String liczbaBankowPamieci,String maxWielkoscRam,
                        double szerokosc,double wysokosc ){
        super(nazwa, ilosc, opis, obraz, producent,cena,typ);
        this.gniazdoProcesora=gniazdoProcesora;
        this.chipSet=chipSet;
        this.typObslugiwanejPam=typObslugiwanejPam;
        this.liczbaBankowPamieci=liczbaBankowPamieci;
        this.maxWielkoscRam=maxWielkoscRam;
        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;
    }

    public String getChipSet() {
        return chipSet;
    }

    public String getGniazdoProcesora() {
        return gniazdoProcesora;
    }

    public String getLiczbaBankowPamieci() {
        return liczbaBankowPamieci;
    }

    public String getMaxWielkoscRam() {
        return maxWielkoscRam;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public String getTypObslugiwanejPam() {
        return typObslugiwanejPam;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public void setGniazdoProcesora(String gniazdoProcesora) {
        this.gniazdoProcesora = gniazdoProcesora;
    }

    public void setLiczbaBankowPamieci(String liczbaBankowPamieci) {
        this.liczbaBankowPamieci = liczbaBankowPamieci;
    }

    public void setMaxWielkoscRam(String maxWielkoscRam) {
        this.maxWielkoscRam = maxWielkoscRam;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public void setTypObslugiwanejPam(String typObslugiwanejPam) {
        this.typObslugiwanejPam = typObslugiwanejPam;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public String toString(){
        return super.toString()+
                "\nGniazdo procesora: "+gniazdoProcesora+
                "\nChipset: "+chipSet+
                "\nTyp obsługiwanej pamięci: "+typObslugiwanejPam+
                "\nIlość banków pamięci: "+liczbaBankowPamieci+
                "\nMax wielkość pamięci RAM: "+maxWielkoscRam+
                "\nSzerokość: "+szerokosc+" mm"+
                "\nWysokość: "+wysokosc+" mm\n";
    }
}
