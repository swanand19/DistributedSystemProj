import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverIp = "192.168.1.10"; // Replace with Server's IP
        int port = 5000;

        try (Socket socket = new Socket(serverIp, port)) {
            System.out.println("Connected to server.");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true) {
                System.out.print("Enter message: ");
                message = console.readLine();
                if (message.equalsIgnoreCase("exit")) break;

                writer.write(message);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
