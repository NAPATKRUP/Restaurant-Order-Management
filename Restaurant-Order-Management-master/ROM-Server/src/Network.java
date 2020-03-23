import java.net.*;
import java.io.*;
import org.json.simple.*;

public class Network {
    private static ServerSocket socket;
    private static int PORT;
    private static JSONArray data;

    public static void createSocket() {
        Config config = new Config();
        PORT = config.getPORT();
        try {
            socket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static JSONArray readSocket() {
        try {
            Socket connection = socket.accept();
            ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
            data = (JSONArray) input.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return data;
    }
}
