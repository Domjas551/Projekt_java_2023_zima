package sk;

public class Procesor extends Produkt{
    private String rodzinaProc;
    private String seria;
    private String gniazdoProc;
    private double taktowanie;
    private int liczbaRdzeni;
    private int liczbaWatkow;
    private double poborMocy;

    public Procesor(){}
    public Procesor(String nazwa, int ilosc, String opis, String obraz, String producent, double cena, int typ, String rodzinaProc,
                    String seria,String gniazdoProc,double taktowanie, int liczbaRdzeni, int liczbaWatkow, double poborMocy ){
        super(nazwa, ilosc, opis, obraz, producent,cena,typ);
        this.rodzinaProc=rodzinaProc;
        this.seria=seria;
        this.gniazdoProc=gniazdoProc;
        this.taktowanie=taktowanie;
        this.liczbaRdzeni=liczbaRdzeni;
        this.liczbaWatkow=liczbaWatkow;
        this.poborMocy=poborMocy;
    }

    public String getGniazdoProc() {
        return gniazdoProc;
    }

    public int getLiczbaRdzeni() {
        return liczbaRdzeni;
    }

    public int getLiczbaWatkow() {
        return liczbaWatkow;
    }

    public double getPoborMocy() {
        return poborMocy;
    }

    public String getRodzinaProc() {
        return rodzinaProc;
    }

    public String getSeria() {
        return seria;
    }

    public double getTaktowanie() {
        return taktowanie;
    }

    public void setGniazdoProc(String gniazdoProc) {
        this.gniazdoProc = gniazdoProc;
    }

    public void setLiczbaRdzeni(int liczbaRdzeni) {
        this.liczbaRdzeni = liczbaRdzeni;
    }

    public void setLiczbaWatkow(int liczbaWatkow) {
        this.liczbaWatkow = liczbaWatkow;
    }

    public void setPoborMocy(double poborMocy) {
        this.poborMocy = poborMocy;
    }

    public void setRodzinaProc(String rodzinaProc) {
        this.rodzinaProc = rodzinaProc;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public void setTaktowanie(double taktowanie) {
        this.taktowanie = taktowanie;
    }

    public String toString(){
        return super.toString()+
                "\nRodzina procesorów: "+rodzinaProc+
                "\nSeria: "+seria+
                "\nGniazdo procesora: "+gniazdoProc+
                "\nTaktowanie: "+ taktowanie+ " MHz"+
                "\nLiczba rdzenia: "+liczbaRdzeni+
                "\nLiczba wątków: "+liczbaWatkow+
                "\nPobór mocy: "+poborMocy+" V\n";
    }
}
