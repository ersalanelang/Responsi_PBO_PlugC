/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class MainMenu_GUI {
   //DEKLARASI KOMPONEN
    JFrame window = new JFrame("Ersalan Elang / 123190163");

    JButton btnInput = new JButton("Input Barang");
    JButton btnShow = new JButton("Lihat Barang");
  
    JLabel lTitle1 = new JLabel("Main Menu");
  
    public MainMenu_GUI(){
        window.setLayout(null);
        window.setSize(230, 160);
        window.setVisible(true);
        window.setLocationRelativeTo(null); // center
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
        
        //ADD COMPONENT
        window.add(btnInput);
        window.add(btnShow);
        window.add(lTitle1);
    
        // SETT BOUNDS
        // sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
        lTitle1.setBounds(78, 5, 200, 30);
    
        btnInput.setBounds(0, 45, 215, 30);
        btnShow.setBounds(0, 80, 215, 30);
    
        // ACTION LISTENER
        btnInput.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new InputData_GUI();
        });
        btnShow.addActionListener((ActionEvent arg0) -> {
            window.dispose();
            new ShowBarang_GUI();
        });
    }
}
