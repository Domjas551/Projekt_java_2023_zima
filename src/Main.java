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
            //przejęcie połączenia od klienta
            socket = ss.accept();
            //utworzenie wątku z połączeniem do klienta
            Sesja o = new Sesja(socket,lock);
            //uruchomienie wątku
            exec.submit(o);
        }

    }
}


public class Main {
    public static void main(String[] args) {

        new Launcher();

    }
}

