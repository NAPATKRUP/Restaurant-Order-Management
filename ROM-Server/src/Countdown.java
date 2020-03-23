import javax.swing.*;


public class Countdown extends JLabel implements Runnable {
    private long gettime = 0;
    private long nowtime = 0;
    private long sec = 0;

    public Countdown(long x, long y) {
        this.nowtime = y;
        this.gettime = x;
        this.sec = Math.abs((gettime - nowtime)/1000);
    }

    public void run() {
        while (true) {
            if (sec < 60){
                this.setText(sec+"s ");
            } else if (sec < 3600){
                this.setText((sec/60)+"m ");
            } else {
                this.setText((sec/3600)+"hr ");
            }
            try {
                Thread.sleep(1000);
                sec++;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}