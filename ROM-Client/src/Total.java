import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class Total {
    private static JSONArray obj;
    private static HashMap<String, Double> allprice = new HashMap<>();

    public static void addPrice(String key, Double value) {
        allprice.put(key, value);
    }

    public static void removePrice(String key) {
        allprice.remove(key);
    }

    public static Double getTotal() {
        Double totalPrice = 0.0;
        for (String key : allprice.keySet()) {
            totalPrice += allprice.get(key);
        }
        return totalPrice;
    }

    public static String getPrice(String key, int count) {
        String total = "0.0";
        Json data = new Json();
        obj = data.openJson("data/menu.json");
        for (int i = 0; i < obj.size(); i++) {
            JSONObject obj1 = (JSONObject) obj.get(i);
            if (obj1.get("name").toString().equals(key)) {
                double price = Double.parseDouble("" + obj1.get("price"));
                total = String.format("%.02f ", (price * count));
                break;
            }
        }
        return total;
    }

    public static void reset() {
        allprice = new HashMap<>();
    }

    public static HashMap<String, Double> getAllprice() {
        return allprice;
    }
}
