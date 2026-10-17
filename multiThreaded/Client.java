import java.io.*;
import java.net.Socket;

public class Client {
   public static void main(String[] args) {
    int port = 8010;
    for (int i = 0; i < 20; i++) {
        Thread t = new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", port);
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String serverMsg = fromServer.readLine();
                System.out.println("response from the server is: " + serverMsg);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
}
