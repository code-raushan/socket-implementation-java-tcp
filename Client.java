import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {

            Socket s = new Socket("MSI", 4321);
            //A data output stream lets an application write primitive Java data types to an output stream in a portable way. An application can then use a data input stream to read the data back in.
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); //creating a data output stream
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Start sending message, type and then press Enter");
            String str = "";
            while(!str.equals("stop")){
                str = br.readLine();
                dos.writeUTF(str);
            }
            dos.close(); //closing the data output stream
            br.close(); // closing the buffer
            s.close(); // closing the connection
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
