import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Set;

public class Order {
    private HashMap<String, Integer> data = new HashMap<String, Integer>();
    private static int orderID = 0;

    public void addOrder(String name) {
        try {
            int value = (int) data.get(name);
            data.put(name, value + 1);
        } catch (Exception e) {
            data.put(name, 1);
        }
    }

    public void removeOrder(String name) {
        try {
            int value = (int) data.get(name);
            if (value - 1 > 0) {
                data.put(name, value - 1);
            } else if (value - 1 == 0) {
                Total.removePrice(name);
                data.remove(name);
            }
        } catch (Exception e) {

        }
    }

    public void resetOrder() {
        data = new HashMap<String, Integer>();
    }

    public void addOrderID() {
        orderID++;
    }

    public int getOrderID() {
        return orderID;
    }

    public static int getOrderNum() {
        return orderID;
    }

    public HashMap<String, Integer> getOrder() {
        return data;
    }
    
}
