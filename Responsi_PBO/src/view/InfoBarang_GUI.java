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
import responsi.Hapus;
import responsi.Total;

/**
 *
 * @author Asus
 */
public class InfoBarang_GUI {
    
  Hapus hapus = new Hapus();
  Total total = new Total();
//DEKLARASI KOMPONEN
  JFrame window = new JFrame("Detail Barang");
  JLabel lNama = new JLabel("Nama");
  JLabel lMassa = new JLabel("Massa (gr)");
  JLabel lHarga = new JLabel("Harga");
  JLabel lJumlah = new JLabel("Jumlah");

  JLabel lDataNama = new JLabel();
  JLabel lDataMassa = new JLabel();
  JLabel lDataHarga = new JLabel();
  JLabel lTotal = new JLabel("Hasil Total");
  JLabel lHasilTotal = new JLabel();

  JTextField tfJumlah = new JTextField();
  
  JButton btnHapus = new JButton("Hapus");
  JButton btnEdit = new JButton("Edit");
  JButton btnBack = new JButton("Kembali");
  JButton btnTotalHarga = new JButton("Total Harga");
  
  public InfoBarang_GUI(Barang b) {
    window.setLayout(null);
    window.setSize(380, 420);
    window.setVisible(true);
    window.setLocationRelativeTo(null); // center
    window.setResizable(false);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan

// SET DISABLE TEXT FIELD
    
//ADD COMPONENT
    window.add(lNama);
    window.add(lMassa);
    window.add(lHarga);
    window.add(lJumlah);
    window.add(tfJumlah);
    window.add(lDataMassa);
    window.add(lDataNama);
    window.add(lDataHarga);
    window.add(lTotal);
    window.add(lHasilTotal);
    window.add(btnHapus);
    window.add(btnEdit);
    window.add(btnBack);
    window.add(btnTotalHarga);

// SETT BOUNDS
// sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
    lNama.setBounds(80, 35, 200, 30);
    lMassa.setBounds(80, 75, 100, 30);
    lHarga.setBounds(80, 115, 200, 30);
    lJumlah.setBounds(80, 155, 70, 30);
    lTotal.setBounds(80, 195, 70, 30);

    lDataNama.setBounds(170, 35, 120, 30);
    lDataMassa.setBounds(170, 75, 120, 30);
    lDataHarga.setBounds(170, 115, 120, 30);
    tfJumlah.setBounds(170, 155, 120, 30);
    lHasilTotal.setBounds(170, 195, 120, 30);

    btnHapus.setBounds(235, 315, 80, 30);
    btnEdit.setBounds(145, 315, 80, 30);
    btnBack.setBounds(55, 315, 80, 30);
    btnTotalHarga.setBounds(135, 265, 100, 30);


// SETT DATA
    lDataHarga.setText(String.valueOf(b.getHarga()));
    lDataNama.setText(b.getNama());
    lDataMassa.setText(String.valueOf(b.getMassa()));
    lHasilTotal.setVisible(false);
    lTotal.setVisible(false);
    
    System.out.println("id detail " + b.getId());
// ACTION LISTENER
    btnHapus.addActionListener((ActionEvent arg0) -> {
      if(hapus.deleteData(b)){
        JOptionPane.showMessageDialog(null, "Hapus Data Berhasil","Pesan",JOptionPane.INFORMATION_MESSAGE);
      }else{
        JOptionPane.showMessageDialog(null, "Hapus Data Gagal","Pesan",JOptionPane.INFORMATION_MESSAGE);
      }
      window.dispose();
      new ShowBarang_GUI();
    });

    btnEdit.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new EditBarang_GUI(b);
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      window.dispose();
      new ShowBarang_GUI();
    });
    btnTotalHarga.addActionListener((ActionEvent arg0) -> {
      
      try{
        int jumlah = Integer.valueOf(tfJumlah.getText());
        
        lHasilTotal.setText(total.calculate(jumlah, b.getHarga()));
        lHasilTotal.setVisible(true);
        lTotal.setVisible(true);
      }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Pastikan Kolom Jumlah Sudah Di isi"+ "\nInput Jumlah Harus Numeric Positif","Pesan Kesalahan",JOptionPane.INFORMATION_MESSAGE);
        tfJumlah.requestFocus();
      }
    });
  }
}
