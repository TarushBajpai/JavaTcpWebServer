import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
    public void run() throws UnknownHostException , IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        System.out.println("Connecting to " + address + ":" + port);
        Socket socket = new Socket(address,port);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer.println("Hello form the client");
        String line = fromServer.readLine();
        System.out.println("response from the server is: "+line);
        socket.close();
        fromServer.close();
        toServer.close();
    }
    public static void main(String[] args) {
        try{
            Client client = new Client();
            client.run();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
