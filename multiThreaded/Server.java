import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        int port = 8010;
        try{
        ServerSocket serverSocket = new ServerSocket(port);
        // serverSocket.setSoTimeout(10000);
        System.out.println("server is listening on port: "+port);
        while(true){
            Socket acceptedConnection = serverSocket.accept();
            Thread t = new Thread(()->{
                try{
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(),true);
                toClient.println("Hello form the server");
                acceptedConnection.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            });
            t.start();
        }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
