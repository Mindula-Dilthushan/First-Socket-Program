import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception{

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Server is Starting Now....");

            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = serverSocket.accept();

            System.out.println("Client Connected");

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String msg = br.readLine();
            System.out.println("Client Message : "+msg);

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            System.out.print("Enter Server : ");
            String txt = scanner.nextLine();
            pw.println(txt);
            pw.flush();

            InputStreamReader isr2 = new InputStreamReader(socket.getInputStream());
            BufferedReader br2 = new BufferedReader(isr2);

            String msg2 = br2.readLine();
            System.out.println("Client Message : "+msg2);

        }catch (Exception e){

        }
    }
}
