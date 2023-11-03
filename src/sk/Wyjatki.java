package sk;

class TypeException extends RuntimeException{
    private String wiadomość;

    public TypeException(){
        wiadomość="Niepoprawna wartość typu";
    }
    public String toString(){
        return wiadomość;
    }
}

class InvalidAnswer extends RuntimeException{
    private String wiadomość;

    public InvalidAnswer(){
        wiadomość="Niepoprawna odpowiedź!";
    }
    public String toString(){
        return wiadomość;
    }
}

class NullValue extends RuntimeException{
    private String wiadomość;

    public NullValue(){
        wiadomość="Wartość jest pusta";
    }
    public String toString(){
        return wiadomość;
    }
}

class NoRecords extends RuntimeException{
    private String wiadomosc;

    public NoRecords(){
        wiadomosc="Brak zapisanych rekordów";
    }

    public String toString(){
        return wiadomosc;
    }
}

public class BadDataException extends Exception{

    private String message;
    private String field;

    public BadDataException(String field){
        this.field = field;
    }

    @Override
    public String toString(){
        return "Niepoprawne dane!";
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}


public class BadPasswordException extends Exception{

    private String message;

    public BadPasswordException(){}

    @Override
    public String toString(){
        return "Hasło musi posiadać od 6 do 20 znaków, w tym co najmniej jedną małą i duża literę, cyfrę, oraz znak specjalny.";
    }
}
