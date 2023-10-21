package sk;

public class Produkt implements ProduktInt{
    protected String nazwa;
    protected int liczba;
    protected String opis;
    protected String obraz;
    protected String producent;
    protected double cena;
    protected int typ; //1 - plytGl, 2 - procesor, 3 - kartGraf, 4 - pamRam, 5 - dysk

    public Produkt(){}
    public Produkt(String nazwa, int ilosc, String opis, String obraz, String producent, double cena, int typ){
        try {
            if(nazwa==null || opis==null || producent==null){
                throw new NullValue();
            }
            this.nazwa = nazwa;
            this.liczba = ilosc;
            this.opis = opis;
            this.obraz = obraz;
            this.producent = producent;
            this.cena = cena;
            this.typ = typ;
        }catch(NullValue n){
            System.out.println(n);
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getLiczba() {
        return liczba;
    }

    public String getObraz() {
        return obraz;
    }

    public String getOpis() {
        return opis;
    }

    public String getProducent() {
        return producent;
    }

    public double getCena() {
        return cena;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setObraz(String obraz) {
        this.obraz = obraz;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String toString(){
        String a;
        switch(typ){
            case 1:
                a="Płyta główna";
                break;
            case 2:
                a="Procesor";
                break;
            case 3:
                a="Karta graficzna";
                break;
            case 4:
                a="Pamięć RAM";
                break;
            case 5:
                a="Dysk";
                break;
            default:
                a="Nieznany komponent";
        }

        return "Typ: "+a+
               "\nNazwa: "+nazwa+
               "\nIlość: "+liczba+
               "\nCena: "+cena+"zł"+
               "\nOpis: "+opis+
               "\nProducent: "+producent+
               "\nObraz: "+obraz;
    }
    public void wypiszOpis(){
        String b;
        switch(typ){
            case 1:
                b="Płyta główna";
                break;
            case 2:
                b="Procesor";
                break;
            case 3:
                b="Karta graficzna";
                break;
            case 4:
                b="Pamięć RAM";
                break;
            case 5:
                b="Dysk";
                break;
            default:
                b="Nieznany komponent";
        }
        String a="Typ: "+b+
                 "\nNazwa: "+nazwa+
                 "\nIlość: "+liczba+
                 "\nCena: "+cena+"zł"+
                 "\nOpis: "+opis+
                 "\nProducent: "+producent+"\n";
        System.out.println(a);
    }
}
