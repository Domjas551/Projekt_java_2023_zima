package sk;

public class Klient extends User{
    private int idKlienta;

    public Klient(){};
    public Klient(String imie,String nazwisko,String email,String login,String haslo,int idKlienta){
        super(imie, nazwisko, email, login, haslo);
        this.idKlienta=idKlienta;
    };

    public int getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(int idKlienta) {
        this.idKlienta = idKlienta;
    }

    public String toString(){
        return super.toString()+
                "\nId klienta: "+idKlienta;
    }
}
