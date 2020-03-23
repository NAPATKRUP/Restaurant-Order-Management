import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock extends JLabel implements Runnable {
    public void run() {
        while (true) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss ");
            LocalDateTime now = LocalDateTime.now();
            this.setText("" + dtf.format(now));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public String getCurrentTime() {
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss ");
        LocalDateTime now = LocalDateTime.now();
        return tf.format(now);
    }

    public String getCurrentDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return df.format(now);
    }
}
