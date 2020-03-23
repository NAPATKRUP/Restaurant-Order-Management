import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GUI implements ActionListener {
    private static JFrame fr;
    private static JPanel p0, p1, p2, p3, p4, p5, pt, pc, pb;
    private static JButton btn0, btn1, btn2, btn3, btn4, btn5, btn_l, btn_r;
    private static int positionShow = 0;

    public GUI() {
        fr = new JFrame("Restaurant Order Management - Server");
        // icon for windows
        fr.setIconImage(new ImageIcon("img/icon.png").getImage());

        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        pt = new JPanel();
        pc = new JPanel();
        pb = new JPanel();
        p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));

        btn0 = new JButton("Finish");
        btn1 = new JButton("Finish");
        btn2 = new JButton("Finish");
        btn3 = new JButton("Finish");
        btn4 = new JButton("Finish");
        btn5 = new JButton("Finish");
        btn_l = new JButton(" Back");
        btn_r = new JButton("Next ");
        btn_r.setHorizontalTextPosition(SwingConstants.LEFT);

        btn_l.setFont(new Font("Courier New", Font.BOLD, 18));
        btn_r.setFont(new Font("Courier New", Font.BOLD, 18));

        btn_l.setIcon(new ImageIcon("img/left-arrow.png"));
        btn_r.setIcon(new ImageIcon("img/left-right.png"));

        btn0.setIcon(new ImageIcon("img/checked.png"));
        btn1.setIcon(new ImageIcon("img/checked.png"));
        btn2.setIcon(new ImageIcon("img/checked.png"));
        btn3.setIcon(new ImageIcon("img/checked.png"));
        btn4.setIcon(new ImageIcon("img/checked.png"));
        btn5.setIcon(new ImageIcon("img/checked.png"));

        btn0.setBackground(new Color(240, 168, 65));
        btn1.setBackground(new Color(240, 168, 65));
        btn2.setBackground(new Color(240, 168, 65));
        btn3.setBackground(new Color(240, 168, 65));
        btn4.setBackground(new Color(240, 168, 65));
        btn5.setBackground(new Color(240, 168, 65));
        btn_l.setBackground(Color.darkGray);
        btn_l.setForeground(Color.WHITE);
        btn_l.setPreferredSize(new Dimension(50, 50));
        btn_r.setBackground(Color.darkGray);
        btn_r.setForeground(Color.WHITE);



        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn_l.addActionListener(this);
        btn_r.addActionListener(this);

        pt.setLayout(new GridLayout(1, 2));
        pt.setBackground(Color.darkGray);
        JLabel brand = new JLabel();
        brand.setIcon(new ImageIcon("img/logo.png"));
        brand.setVerticalAlignment(JLabel.CENTER);
        brand.setHorizontalAlignment(JLabel.LEFT);
        pt.add(brand);

        JPanel timestamp = new JPanel();
        timestamp.setLayout(new GridLayout(2, 1));
        timestamp.setBackground(Color.darkGray);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        JLabel date = new JLabel(dtf.format(now) + " ");
        Clock time = new Clock();
        Thread thread = new Thread(time);
        thread.start();
        date.setForeground(Color.white);
        time.setForeground(Color.white);
        date.setFont(new Font("Courier New", Font.BOLD, 14));
        time.setFont(new Font("Courier New", Font.BOLD, 14));
        date.setHorizontalAlignment(JLabel.RIGHT);
        time.setHorizontalAlignment(JLabel.RIGHT);
        date.setIcon(new ImageIcon("img/calendar.png"));
        time.setIcon(new ImageIcon("img/time.png"));
        timestamp.add(date);
        timestamp.add(time);
        pt.add(timestamp);

        pc.setLayout(new GridLayout(2, 3));
        pc.setBorder(BorderFactory.createMatteBorder(4,4,5,8, new Color(121, 179, 247)));
        pc.add(p0); pc.add(p1); pc.add(p2);
        pc.add(p3); pc.add(p4); pc.add(p5);
        pb.setLayout(new GridLayout(1, 2));
        pb.add(btn_l); pb.add(btn_r);

        fr.add(pt, BorderLayout.NORTH);
        fr.add(pc, BorderLayout.CENTER);
        fr.add(pb, BorderLayout.SOUTH);
        fr.setSize(1100, 750);
        fr.setVisible(true);
        fr.setResizable(false);
        centerWindow(fr);
        fr.setDefaultCloseOperation(3);

    }

    public static void reframe(int p) {
        genCard(p0, p1, p2, p3, p4, p5, p);
    }


    public static void genCard(JPanel p0, JPanel p1, JPanel p2, JPanel p3, JPanel p4, JPanel p5, int p) {
        TableModel model;
        String column[] = {"Order", "Total"};
        try {
            p0 = new JPanel();
            p1 = new JPanel();
            p2 = new JPanel();
            p3 = new JPanel();
            p4 = new JPanel();
            p5 = new JPanel();
            p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
            p0.setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(121, 179, 247)));
            p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
            p1.setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(121, 179, 247)));
            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
            p2.setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(121, 179, 247)));
            p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
            p3.setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(121, 179, 247)));
            p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
            p4.setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(121, 179, 247)));
            p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
            p5.setBorder(BorderFactory.createMatteBorder(4,4,4,4, new Color(121, 179, 247)));
            for (int i = p; i < (p + 6 >= Main.getNow().size() ? Main.getNow().size() : p + 6); i++) {
                model = new DefaultTableModel(Main.genTable(i), column) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                JLabel l = new JLabel();
                JPanel panel = new JPanel();
                JLabel countdown = new JLabel();
                Countdown time = new Countdown(Main.getSendtime(i), Main.getGivetime(i));
                Thread thread = new Thread(time);
                thread.start();
                panel.setLayout(new GridLayout(1, 2));
                panel.setBackground(Color.darkGray);
                l.setForeground(Color.WHITE);
                l.setText(String.format(" Order %04d", Main.getIDOrder(i)));
                l.setHorizontalAlignment(JLabel.LEFT);
                // set order id, time font
                l.setFont(new Font("Courier New", Font.BOLD, 22));
                time.setFont(new Font("Courier New", Font.BOLD, 20));
                time.setForeground(Color.WHITE);
                time.setHorizontalAlignment(JLabel.RIGHT);
                panel.add(l);
                panel.add(time);
                // center cell
                JTable table = new JTable(model);
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment( JLabel.CENTER );
                table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);

                // set table font
                table.getTableHeader().setFont(new Font("Courier New", Font.BOLD, 16));
                table.getTableHeader().setBackground(new Color(121, 179, 247));
                table.setRowHeight(table.getRowHeight() + 10);
                table.setFont(new Font("Courier New", Font.BOLD, 18));
                JScrollPane sp = new JScrollPane(table);
                if (i == p) {
                    p0.add(panel);
                    p0.add(sp);
                    btn0.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p0.add(btn0);
                } else if (i == p + 1) {
                    p1.add(panel);
                    p1.add(sp);
                    btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p1.add(btn1);
                } else if (i == p + 2) {
                    p2.add(panel);
                    p2.add(sp);
                    btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p2.add(btn2);
                } else if (i == p + 3) {
                    p3.add(panel);
                    p3.add(sp);
                    btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p3.add(btn3);
                } else if (i == p + 4) {
                    p4.add(panel);
                    p4.add(sp);
                    btn4.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p4.add(btn4);
                } else if (i == p + 5) {
                    p5.add(panel);
                    p5.add(sp);
                    btn5.setAlignmentX(Component.CENTER_ALIGNMENT);
                    p5.add(btn5);
                }
            }
            pc.removeAll();
            pc.add(p0); pc.add(p1); pc.add(p2);
            pc.add(p3); pc.add(p4); pc.add(p5);
            pc.revalidate();
            pc.repaint();
        } catch (Exception ex) {}
    }

    public void centerWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btn0)) {
            Main.removeNow(Main.getIDOrder(positionShow));
            positionShow = 0;
            reframe(0);
        } else if (ae.getSource().equals(btn1)) {
            Main.removeNow(Main.getIDOrder(positionShow+1));
            positionShow = 0;
            reframe(0);
        } else if (ae.getSource().equals(btn2)) {
            Main.removeNow(Main.getIDOrder(positionShow+2));
            positionShow = 0;
            reframe(0);
        } else if (ae.getSource().equals(btn3)) {
            Main.removeNow(Main.getIDOrder(positionShow+3));
            positionShow = 0;
            reframe(0);
        } else if (ae.getSource().equals(btn4)) {
            Main.removeNow(Main.getIDOrder(positionShow+4));
            positionShow = 0;
            reframe(0);
        } else if (ae.getSource().equals(btn5)) {
            Main.removeNow(Main.getIDOrder(positionShow+5));
            positionShow = 0;
            reframe(0);
        } else if (ae.getSource().equals(btn_l)) {
            positionShow = Math.max(0, positionShow - 1);
            reframe(positionShow);
        } else if (ae.getSource().equals(btn_r)) {
            positionShow = Math.min(Main.getNow().size() - 6, positionShow + 1);
            reframe(positionShow);
        }
    }
}
