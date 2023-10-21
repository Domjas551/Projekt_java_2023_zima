package sk;

public class Dysk extends Produkt{
    private String pojemnosc;
    private String typDysku;
    private double szerokosc;
    private double wysokosc;
    private double glebokosc;

    public Dysk(){}
    public Dysk(String nazwa, int ilosc, String opis, String obraz, String producent,double cena, int typ, String pojemnosc,
                String typDysku, double szerokosc, double wysokosc, double glebokosc){
        super(nazwa, ilosc, opis, obraz, producent,cena,typ);
        this.pojemnosc=pojemnosc;
        this.typDysku=typDysku;
        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;
        this.glebokosc=glebokosc;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double getSzerokosc() {
        return szerokosc;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public String getPojemnosc() {
        return pojemnosc;
    }

    public String getTypDysku() {
        return typDysku;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public void setSzerokosc(double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public void setGlebokosc(double glebokosc) {
        this.glebokosc = glebokosc;
    }

    public void setPojemnosc(String pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public void setTypDysku(String typDysku) {
        this.typDysku = typDysku;
    }

    public String toString(){
        return super.toString()+
                "\nTyp dysku: "+typDysku+
                "\nPojemność: "+pojemnosc+
                "\nSzerokość: "+szerokosc+" cm" +
                "\nWysokość: "+wysokosc+" cm" +
                "\nGłębokość: "+glebokosc+" cm";
    }
}
