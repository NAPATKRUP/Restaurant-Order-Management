import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

public class Json {
    public JSONArray openJson(String path) {
        JSONParser jsonParser = new JSONParser();
        JSONArray obj = null;
        try {
            FileReader fopen = new FileReader(path);
            obj = (JSONArray) jsonParser.parse(fopen);
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj;
    }

    public JSONArray toJson(HashMap<String, Integer> data, Order order, LocalDateTime time) {
        JSONArray list = new JSONArray();
        for (String key : data.keySet()) {
            JSONObject temp = new JSONObject();
            temp.put("name", key);
            temp.put("total", data.get(key));
            list.add(temp);
        }
        list.add(order.getOrderID());
        list.add(time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        return list;
    }
}
