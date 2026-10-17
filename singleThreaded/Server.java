import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server{
    public void run() throws SocketException , IOException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        // socket.setSoTimeout(10000);
        while(true){
            try{
              System.out.println("server is listening on port "+port);
              Socket acceptedConnection = socket.accept();
              System.out.println("connection accepted from client "+ acceptedConnection.getRemoteSocketAddress());
              PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(),true);
              BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
              String clientMsg = fromClient.readLine();
              System.out.println(clientMsg);
              toClient.println("hello from the server");
              acceptedConnection.close();
              toClient.close();
              fromClient.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }
}