package Program;

/**
 * Nama : Vian Azis Tio Riwanto 
 * Nim  : E31191848
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class BorderLoading extends JWindow {

    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel lblLogo = new JLabel(new ImageIcon(getClass().getResource("/Image/Splash Logo.png")));
    private JProgressBar barisProgres = new JProgressBar();
    private int time = 0;
    private Timer timer;

    //deklarasi konstruktor
    public BorderLoading() {
        //menyiapkan variabel warna
        Color Warna = Color.white;
        //mengatur baris progress
        barisProgres.setValue(0);
        barisProgres.setPreferredSize(new Dimension(500, 20));
        barisProgres.setBackground(Color.white);
        barisProgres.setForeground(Color.DARK_GRAY);
        barisProgres.setStringPainted(true);
        //mengatur warna garis pinggir
        barisProgres.setBorder(new LineBorder(Warna, 1));
        lblLogo.setBorder(new LineBorder(Warna, 1));
        //meletakkan objek ke kontainer
        getContentPane().add(lblLogo, BorderLayout.NORTH);
        getContentPane().add(barisProgres, BorderLayout.CENTER);
        //mengatur lama window logo tampil pada layar monitor
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                time++;
                barisProgres.setValue(time);
                if (25 <= time) {
                    time += 5;
                }
                if (barisProgres.getPercentComplete() == 1.0) {
                    timer.stop();
                    dispose();
                    try {
                        //menjalankan menu utama
                        new LoginFrame().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(BorderLoading.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        timer.start();
        //menempatkan objek ke memori sebelum ditampilkan 
        pack();
        //mengatur lokasi window tepat di tengah layar monitor
        setLocation(dimensi.width / 2 - getWidth() / 2, dimensi.height / 2 - getHeight() / 2);
        //menempaktkan window ke layar monitor\
        show();
    }
}