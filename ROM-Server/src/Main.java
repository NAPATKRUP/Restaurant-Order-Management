import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class Main {
    private static JSONArray json;
    private static ArrayList now;

    public static void main(String[] args) {
        Network.createSocket();
        new SplashScreen();
        new GUI();
        now = new ArrayList();
        while (true) {
            json = Network.readSocket();
            if(now.size() > 0) {
                for(int i=1; i<=now.size(); i++) {
                    JSONArray last = (JSONArray) now.get(now.size()-i);
                    last.remove(last.size()-1);
                    last.add(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                }
            }
            json.add(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
            now.add(json);
//            System.out.println(now);
            GUI.reframe(0);
        }
    }

    public static ArrayList getNow() {
        return now;
    }

    public static void removeNow(int fin) {
        for (int i = 0; i < now.size(); i++) {
            JSONArray check = (JSONArray) now.get(i);
            if ((int) check.get(check.size() - 3) == fin) {
                now.remove(i);
            }
        }
    }

    public static Object[][] genTable(int position) {
        JSONArray data = (JSONArray) now.get(position);
        Object[][] mysave = new Object[data.size()-3][2];
        for(int i=0; i<data.size()-3; i++) {
            JSONObject item = (JSONObject) data.get(i);
            mysave[i][0] = "  " + item.get("name");
            mysave[i][1] = item.get("total");
        }
        return mysave;
    }

    public static int getIDOrder(int position) {
        JSONArray data = (JSONArray) now.get(position);
        return (int) data.get(data.size() - 3);
    }

    public static long getSendtime(int position) {
        JSONArray data = (JSONArray) now.get(position);
        return (long) data.get(data.size() - 2);
    }

    public static long getGivetime(int position) {
        JSONArray data = (JSONArray) now.get(position);
        return (long) data.get(data.size() - 1);
    }
}
