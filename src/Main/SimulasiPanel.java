package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimulasiPanel extends JPanel implements ActionListener {

    private Timer timer;
    private int carX = -100;
    private int speed = 2;

    public SimulasiPanel() {
        timer = new Timer(15, this);
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;

        // 1. Menggambar latar belakang (langit)
        g2d.setColor(new Color(135, 206, 235)); // Warna Sky Blue
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 2. Menggambar jalan
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 250, getWidth(), 150);
        
        // 3. Menggambar garis putus-putus di jalan
        g2d.setColor(Color.WHITE);
        for(int i = 0; i < getWidth(); i += 40){
            g2d.fillRect(i, 310, 25, 5);
        }

        // 4. Menggambar mobil pada posisi carX saat ini
        drawCar(g2d, carX, 230);
    }

    /**
    * Metode helper untuk menggambar mobil.
    */
    private void drawCar(Graphics2D g2d, int x, int y) {
        // Menggambar badan mobil
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y + 20, 100, 40);

        // Menggambar atap mobil
        g2d.setColor(new Color(255, 100, 100)); // Merah lebih muda
        g2d.fillRect(x + 15, y, 70, 30);
        
        // Menggambar jendela
        g2d.setColor(new Color(173, 216, 230)); // Light Blue
        g2d.fillRect(x + 55, y + 5, 25, 15);

        // Menggambar roda (lingkaran hitam)
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x + 10, y + 50, 25, 25); // Roda belakang
        g2d.fillOval(x + 65, y + 50, 25, 25); // Roda depan
    }

    /**
     * Metode ini akan dipanggil oleh Timer setiap 15 milidetik.
     * Berisi logika untuk memperbarui state animasi.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Memperbarui posisi mobil
        carX += speed;

        // Jika mobil sudah melewati layar sebelah kanan,
        // kembalikan posisinya ke awal (sebelah kiri).
        if (carX > getWidth()) {
            carX = -100;
        }

        // Meminta Swing untuk menggambar ulang panel.
        repaint();
    }
}