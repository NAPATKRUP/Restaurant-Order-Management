import java.io.*;
import java.net.*;

import org.json.simple.*;

public class Network implements Runnable {
    private String HOST;
    private int PORT;
    private JSONArray list;

    public Network(JSONArray list) {
        this.list = list;
    }

    public void run() {
        sendSocket(list);
    }

    public void sendSocket(JSONArray list) {
        Config config = new Config();
        HOST = config.getHOST();
        PORT = config.getPORT();
        if (!list.isEmpty()) {
            try {
                Socket socket = new Socket(HOST, PORT);
                ObjectOutputStream object = new ObjectOutputStream(socket.getOutputStream());
                object.writeObject(list);
                object.flush();
                object.close();
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
