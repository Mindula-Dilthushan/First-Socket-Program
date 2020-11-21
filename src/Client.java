import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);

            Socket socket = new Socket("localhost",9999);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            System.out.print("Enter Client : ");
            String txt = scanner.nextLine();
            pw.println(txt);
            pw.flush();

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String msg = br.readLine();
            System.out.println("Server Message : "+msg);
        }catch (Exception e){

        }
    }
}
