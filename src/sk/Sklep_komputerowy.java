package sk;
public class Sklep_komputerowy {
    private String nazwa;
    private Magazyn magazyn;
    private System_sklepu system;

    public Sklep_komputerowy() {}

    public Sklep_komputerowy(String nazwa)
    {
        this.nazwa=nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public System_sklepu getSystem() {
        return system;
    }

    public void setSystem(System_sklepu system) {
        this.system = system;
    }
}
