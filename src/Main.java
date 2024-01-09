import sk.*;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Launcher {
    public Launcher() {
        try {
            handleConnection();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void handleConnection() throws IOException {

        //utworzenie socketu serwera
        ServerSocket ss = new ServerSocket(6700);
        //utworzenie wykonawcy na wątki
        ExecutorService exec= Executors.newCachedThreadPool();
        //utworzenie rygla
        ReentrantLock lock=new ReentrantLock();
        Socket socket;


        while (true) {
            System.out.println("ps");
            //przejęcie połączenia od klienta
            socket = ss.accept();
            System.out.println("pos");
            //utworzenie wątku z połączeniem do klienta
            Sesja o = new Sesja(socket,lock);
            //uruchomienie wątku
            exec.submit(o);
//            PrintWriter pw=new PrintWriter(socket.getOutputStream(), true);
//            InputStreamReader isr=new InputStreamReader(socket.getInputStream());
//            BufferedReader br=new BufferedReader(isr);
//
//            pw.println("Połączenie z serwerem zostało nawiązane.");
//            System.out.println("przesłanie");
//            System.out.println(br.readLine());
//            System.out.println("odczytanie");
//
//            pw.close();
        }
       //exec.shutdownNow();
    }
}


public class Main {
    public static void main(String[] args) {

        new Launcher();

        //Testy BD
        //trzeba w File>Project Structure>Modules>Dependencies dodaj odpowiedni .jar z driverem (oracle jdbc driver)
        /*try{
            //Krok 1: załaduj klase drivera
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Krok 2: Utwórz obiekt połączenia
            Connection con=DriverManager.getConnection(
                    //jbdc:oracle:connection details //[host]:[port]/[DB service name]
                    "jdbc:oracle:thin:@149.156.138.232:1521:orcl",
                    "sbd01",
                    "sbd01"
            );

            //Krok 3: Utworzenie zapytania
            Statement stm=con.createStatement();
            //stm.executeQuery("Create table test(a date, b float(7),c number(2), d varchar2(1 char))");
            //stm.executeQuery("Create table test(picture blob)");
            LocalDateTime data=LocalDateTime.now();
            double f=4.56;
            int i=15;
            char c='a';
            String ca="ab";
            //System.out.println(f);
            //"+f+", "+i+", "+c+
            PreparedStatement pstm=con.prepareStatement("Insert into test values(?)");
            InputStream in= new FileInputStream("C:\\Users\\Xelor\\Desktop\\dot.jpg");
            pstm.setBlob(1,in);
            //pstm.execute();
            //stm.executeQuery("Insert into test values("+in+")");
            ResultSet r=stm.executeQuery("Select * from test ");
            ResultSetMetaData rMeta=r.getMetaData();
            //System.out.println(r);
            while(r.next()){
//                System.out.println(rMeta.getColumnName(2)+": "+r.getFloat(2));
//                System.out.println(rMeta.getColumnName(3)+": "+r.getInt(3));
//                System.out.println(rMeta.getColumnName(4)+": "+r.getString(4));
//                System.out.println("------------------");
                System.out.println(rMeta.getColumnName(1)+": "+r.getBlob(1));
            }

            //Krok 4: Zamknij połączenie
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }*/

    }
}

