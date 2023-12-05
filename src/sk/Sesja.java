package sk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

import static java.lang.Thread.sleep;

public class Sesja implements Runnable{
    private Socket socket;

    public Sesja(Socket socket){
        this.socket=socket;
    }

    public void run(){
        try{
            //sleep(3000);
            System.out.println("w_test");
            PrintWriter pw=new PrintWriter(socket.getOutputStream(), true);
            InputStreamReader isr=new InputStreamReader(socket.getInputStream());
            BufferedReader br=new BufferedReader(isr);

            //wysłanie informacji do klienta
            //pw.println("Połączenie z serwerem zostało nawiązane.");
            //System.out.println("przesłanie");

            //odczytanie informacji od klienta
            String zapytanie=br.readLine();

            //Utworzenie połączenia do BD
            //Załądowanie klasy drivera
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Utworzenie instancji połączenia
            Connection con=DriverManager.getConnection(
                    //jbdc:oracle:connection details //[host]:[port]/[DB service name]
                    "jdbc:oracle:thin:@149.156.138.232:1521:orcl",
                    "sbd01",
                    "sbd01"
            );
            //Utworzenie zapytania
            Statement stm=con.createStatement();

            if(zapytanie.contains("Select")){
                //System.out.println("1");
                ResultSet result=stm.executeQuery(zapytanie);
                //System.out.println("2");
                ResultSetMetaData resultMeta =result.getMetaData();
                //System.out.println("3");
                //zmienna na wynik zapytania
                String rezultat="";
                while(result.next()){
                    for(int i=1;i<=resultMeta.getColumnCount();i++){
                        if(resultMeta.getColumnType(i)!=2004){
                            //rezultat+=resultMeta.getColumnName(i)+": "+result.getString(i)+";";
                            rezultat+=result.getString(i)+";";
                        }
                    }
                }
                System.out.println(rezultat);
                pw.println(rezultat);
            }else{
                stm.executeQuery(zapytanie);
            }
            //Zamknięcie połączenia
            con.close();

            pw.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
