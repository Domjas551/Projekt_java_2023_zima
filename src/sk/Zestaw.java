package sk;

public class Zestaw implements ZestawInt{
    private String nazwa;
    private double cena;
    private String opis;
    private Plyta_glowna plytaGlowna;
    private Procesor procesor;
    private Pam_RAM pamRam;
    private Karta_graf kartaGraf;
    private Dysk dysk;

    public Zestaw(){}
    public Zestaw(String nazwa, String opis, Plyta_glowna plytaGlowna, Procesor procesor, Pam_RAM pamRam,
                  Karta_graf kartaGraf, Dysk dysk){
        try {
            if(nazwa==null||opis==null||plytaGlowna==null||procesor==null||pamRam==null||kartaGraf==null||dysk==null){
                throw new NullValue();
            }
            this.nazwa = nazwa;
            this.opis = opis;
            this.plytaGlowna = plytaGlowna;
            this.procesor = procesor;
            this.pamRam = pamRam;
            this.kartaGraf = kartaGraf;
            this.dysk = dysk;
            this.cena = plytaGlowna.getCena() + procesor.getCena() + pamRam.getCena() + kartaGraf.getCena() + dysk.getCena();
            this.cena = Math.round(((this.cena - (this.cena * 0.1)) * 100.0) / 100.0);
        }catch(NullValue n){
            System.out.println(n);
        }
    }

    public double getCena() {
        return cena;
    }

    public String getOpis() {
        return opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Dysk getDysk() {
        return dysk;
    }

    public Karta_graf getKartaGraf() {
        return kartaGraf;
    }

    public Pam_RAM getPamRam() {
        return pamRam;
    }

    public Plyta_glowna getPlytaGlowna() {
        return plytaGlowna;
    }

    public Procesor getProcesor() {
        return procesor;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setDysk(Dysk dysk) {
        this.dysk = dysk;
    }

    public void setKartaGraf(Karta_graf kartaGraf) {
        this.kartaGraf = kartaGraf;
    }

    public void setPamRam(Pam_RAM pamRam) {
        this.pamRam = pamRam;
    }

    public void setPlytaGlowna(Plyta_glowna plytaGlowna) {
        this.plytaGlowna = plytaGlowna;
    }

    public void setProcesor(Procesor procesor) {
        this.procesor = procesor;
    }

    public String toString()
    {
        return  "Nazwa: "+nazwa+
                "\nCena: "+cena+" zł"+
                "\nPłyta główna: "+plytaGlowna.getNazwa()+
                "\nProcesor: "+procesor.getNazwa()+
                "\nPamięć RAM: "+pamRam.getNazwa()+
                "\nKarta graficzna: "+kartaGraf.getNazwa()+
                "\nDysk: "+dysk.getNazwa();
    }

    public boolean czyDostepne()
    {
        if(plytaGlowna.getLiczba()>0&&procesor.getLiczba()>0&&pamRam.getLiczba()>0&&kartaGraf.getLiczba()>0&&dysk.getLiczba()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

