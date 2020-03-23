import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

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
}