package sk;

public class User {
    protected String imie;
    protected String nazwisko;
    protected String email;
    protected String login;
    protected String haslo;

    public User(){}
    public User(String imie,String nazwisko,String email,String login,String haslo){
        try {
            if(imie==null||nazwisko==null||email==null||login==null||haslo==null){
                throw new NullValue();
            }
            if(haslo.length()<6){
                throw new BadPasswordException();
            }
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.email = email;
            this.login = login;
            this.haslo = haslo;
        }catch(NullValue n){
            java.lang.System.out.println(n);
        }catch(BadPasswordException t){
            java.lang.System.out.println(t);
        }
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        try {
            if(haslo.length()<6){
                throw new BadPasswordException();
            }
            this.haslo = haslo;
        }catch(BadPasswordException t){
            System.out.println(t);
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Imie: "+imie+
               "\nNazwisko: "+nazwisko+
               "\nEmail: "+email+
               "\nLogin: "+login;
    }
}
