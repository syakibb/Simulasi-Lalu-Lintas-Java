package Main;

import javax.swing.JFrame;

public class MainFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulasi Lalu Lintas Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(new SimulasiPanel());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
