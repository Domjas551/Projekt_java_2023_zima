package sk;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Sesja implements Runnable{
    private Socket socket;
    private ReentrantLock lock;
    private int id;

    public Sesja(Socket socket,ReentrantLock lock){
        this.socket=socket;
        this.lock=lock;
        //przypisanie id wątkowi
        this.id=(int)((Math.random()*9999)+1000);
    }

    //funkcja do komunikacji z BD
    public void bd(PrintWriter pw, String zapytanie) throws SQLException{
        try{
            //odczytanie danych do połączenia z BD
            File plik=new File("db_credentials.txt");
            Scanner odczyt=new Scanner(plik);
            String db_dane=odczyt.nextLine();
            String s1[]=db_dane.split(";");

            //Utworzenie połączenia do BD
            //Załądowanie klasy drivera
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Utworzenie instancji połączenia
            Connection con = DriverManager.getConnection(
                    //jbdc:oracle:connection details //[host]:[port]/[DB service name]
                    s1[0],
                    s1[1],
                    s1[2]
            );

            //Utworzenie zapytania
            Statement stm = con.createStatement();
            //TESTOWANIE
            //System.out.println(zapytanie);
            if (zapytanie.contains("Select")) {

                ResultSet result = stm.executeQuery(zapytanie);
                ResultSetMetaData resultMeta = result.getMetaData();

                //zmienna na wynik zapytania
                String rezultat = "";
                while (result.next()) {
                    for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                        if (resultMeta.getColumnType(i) != 2004) {
                            rezultat += result.getString(i) + ";";
                        }
                    }
                }
                //TESTOWANIE
                //System.out.println(rezultat);

                //przesłanie wyniku do klienta
                pw.println(rezultat);
            } else {
                try{
                    stm.executeUpdate(zapytanie);
                }catch(SQLSyntaxErrorException s){
                    pw.println("Wprowadzenie/modyfikacja danych nieudana");
                }catch (Exception e){
                    e.printStackTrace();
                }
                pw.println("Wprowadzenie/modyfikacja danych zakończona pomyślnie");
            }
            //Zamknięcie połączenia
            con.close();

        }catch(FileNotFoundException f){
            System.out.println("Nie znalezniono pliku db_credentials.txt");
        }catch(ClassNotFoundException c){
            c.printStackTrace();
        }
    }

    public void run(){
        try{

            //utworzenie zmiennej do obsługi strumienia wyjściowego
            PrintWriter pw=new PrintWriter(socket.getOutputStream(), true);
            //utworzenie zmiennej do obsługi strumienia wejściowego
            InputStreamReader isr=new InputStreamReader(socket.getInputStream());
            BufferedReader br=new BufferedReader(isr);

            while(true){

                try {

                    //odczytanie informacji od klienta
                    String zapytanie = br.readLine();

                    if(zapytanie.equals("lock")){
                        try{
                            //wejście do sekcji krytycznej
                            lock.lock();
                            //wynokynanie zapytań w sekcji krytycznej
                            do{
                                zapytanie= br.readLine();
                                if(!zapytanie.equals("unlock")){
                                    bd(pw,zapytanie);
                                }
                            }while(!zapytanie.equals("unlock"));
                        }finally {
                            //wyjście z sekcji krytycznej
                            lock.unlock();
                        }
                    }else{
                        bd(pw,zapytanie);
                    }

                }catch(SocketException s){
                    //blok odpowiedzialny za zakończenie pracy wątka w przypadku zamknięcia aplikacji użytkownika
                    System.out.println("Host "+id+" zakończył połączenie");
                    break;
                }catch(SQLException s){
                    //blok odpowiedzialny za obsługe błędu przy próbie połączenia z BD
                    System.out.println("Błąd przy próbie połączenia z BD");
                    socket.close();
                    break;
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
