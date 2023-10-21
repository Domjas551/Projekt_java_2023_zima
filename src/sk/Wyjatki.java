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

class TooShortPassword extends RuntimeException{
    private String wiadomosc;

    public TooShortPassword(){
        wiadomosc="Hasło jest za krótkie, musi mieć min. 6 znaków";
    }

    public String toString(){
        return wiadomosc;
    }
}