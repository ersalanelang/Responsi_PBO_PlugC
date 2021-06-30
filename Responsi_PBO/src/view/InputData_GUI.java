/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import responsi.Barang;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import responsi.Input;

/**
 *
 * @author Asus
 */
public class InputData_GUI {
    
  Barang b = new Barang();
  Input inputBarang = new Input();
  
  //KOMPONEN
  JFrame window = new JFrame("Input Data");
  JLabel lNama = new JLabel("Nama");
  JLabel lMassa = new JLabel("Massa (kg)");
  JLabel lHarga = new JLabel("Harga Satuan");
  
  JTextField tfNama = new JTextField(35);
  JTextField tfMassa = new JTextField(35);
  JTextField tfHarga = new JTextField(35);
  
  JButton btnInput = new JButton("Input");
  JButton btnReset = new JButton("reset");
  JButton btnKembali = new JButton("Kembali");
 
  public InputData_GUI(){
    window.setLayout(null);
    window.setSize(380, 280);
    window.setVisible(true);
    window.setLocationRelativeTo(null); // center
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
    
//ADD COMPONENT
    window.add(lNama);
    window.add(lMassa);   
    window.add(lHarga);
    window.add(tfNama);
    window.add(tfMassa);   
    window.add(tfHarga);

    window.add(btnInput);
    window.add(btnReset);
    window.add(btnKembali);
       
// SETT BOUNDS
// sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
    btnInput.setBounds(180, 160, 100, 30);
    btnReset.setBounds(70, 160, 100, 30);
    btnKembali.setBounds(70, 195, 210, 30);
    
    lNama.setBounds(20, 35, 80, 30);
    tfNama.setBounds(160, 35, 150, 30);
    
    lMassa.setBounds(20, 70, 130, 30);
    tfMassa.setBounds(160, 70, 150, 30);
    
    lHarga.setBounds(20, 105, 130, 30);
    tfHarga.setBounds(160, 105, 150, 30);
      
    // ACTION LISTENER
    btnInput.addActionListener((var arg0) -> {
        String nama = tfNama.getText();
        int massa = 0, harga = 0;
        try{
            harga = Integer.valueOf(tfHarga.getText());
            massa = Integer.valueOf(tfMassa.getText());

            if (nama.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama Harus Di Isi");
                tfNama.requestFocusInWindow();
            }
            else if(harga < 0 || massa < 0){
                JOptionPane.showMessageDialog(null,"Bilangan Harus Positif", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            }else{
                b.setBarang(nama, massa, harga); // set barang
                if (inputBarang.input(b)) {
                    window.dispose();
                    new MainMenu_GUI();
                    JOptionPane.showMessageDialog(null, "Input Berhasil", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Input Gagal", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                } 
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Angka bree jangan Huruf", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);   
        }
    });

    btnReset.addActionListener((ActionEvent arg0) -> {
      tfNama.setText("");
      tfMassa.setText("");
      tfHarga.setText("");
    });
    btnKembali.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new MainMenu_GUI();
    });
  }
}
