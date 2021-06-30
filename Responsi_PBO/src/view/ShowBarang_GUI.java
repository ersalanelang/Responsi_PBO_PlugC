/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import responsi.Barang;
import responsi.Data;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class ShowBarang_GUI {
    
    Data rd = new Data();
    Barang b = new Barang();

    JFrame window = new JFrame("Data Barang");
    
    JTable tabel;
    
    DefaultTableModel tableModel;
    
    JScrollPane scrollPane;
    
    Object namaKolom[] = {"Id", "Nama", "Massa", "Harga"};
    
    JButton btnKembali = new JButton("Kembali");

    public ShowBarang_GUI() {
        window.setLayout(null);
        window.setSize(500, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE); // running program berhenti jika tombol close ditekan
    
        // SET BOUNDS
        // sett bounds(m,n,o,p) >>> (sumbu-x,sumbu-y,panjang komponen, tinggi komponen)
        btnKembali.setBounds(0, 430, 500, 30);
    
        if(rd.readDataBarang()== null){
            tabel = new JTable(null, namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        }else{
            tabel = new JTable(rd.readDataBarang(), namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        }
    
    scrollPane = new JScrollPane(tabel);
    window.add(scrollPane);
    window.add(btnKembali);
    
    scrollPane.setBounds(5, 10, 480, 300);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
    tabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
        // ACTIONLISTENER
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tabel.rowAtPoint(evt.getPoint());
                int col = tabel.columnAtPoint(evt.getPoint());
                System.out.println("row " + row);
                if(rd.getData(b,row)){
                    System.out.println("id Lihat " + b.getId());
                    window.dispose();
                    new InfoBarang_GUI(b);
                }
            }   
        });
    btnKembali.addActionListener((ActionEvent arg0) -> {
        window.dispose();
        new MainMenu_GUI();
    });
  }
}
