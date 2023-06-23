import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket ss = new ServerSocket(4321);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = "";
            while(!str.equals("stop")){
                str=dis.readUTF();
                System.out.println("Client says "+str);
            }
            dis.close(); // data input stream is closed
            ss.close(); // server socket is closed

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
