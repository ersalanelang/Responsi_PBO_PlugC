/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package responsi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Data {
  
  
  private int countRow() {
    String query = "SELECT * FROM `barang`";
    PreparedStatement ps;
    ResultSet rs;

    int n = 0;
    try {
      ConnecterDB myConnection = new ConnecterDB();
      ps = myConnection.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      while (rs.next()) {
        n++;
      }
      return n ;

    } catch (SQLException ex) {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
    }
    return -4;
  }
  
  public String[][] readDataBarang() {
    String query = "SELECT * FROM `barang`";
    PreparedStatement ps;
    ResultSet rs;
    
    // untuk menghitung jumlah baris
    int cr = countRow();
    
    // untuk menyimpan data
    String data[][] = new String[cr][4];

    try {
      ConnecterDB myConnection = new ConnecterDB();
      ps = myConnection.getConnection().prepareStatement(query);
      rs = ps.executeQuery();

      int n = 0; // untuk menjumahkan baris(row)
      while (rs.next()) { //konversi tabel ke string
        data[n][0] = rs.getString(1);
        data[n][1] = rs.getString(2);
        data[n][2] = rs.getString(3);
        data[n][3] = rs.getString(4);
        n++;
      }
      return data;
    } catch (SQLException ex) {
      System.out.println("Read Data Gagal");
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    } 
  }
  
  public boolean getData(Barang b, int n){
    // query untuk baris tertentu
    String query = "SELECT * FROM `barang` LIMIT " + String.valueOf(n) + ",1";
    PreparedStatement ps;
    ResultSet rs;
    
    try {
      ConnecterDB cdb = new ConnecterDB();
      ps = cdb.getConnection().prepareStatement(query);
      
      rs = ps.executeQuery();
      if (rs.next()) {
        int id = rs.getInt(1);
        String nama = rs.getString(2);
        int massa = rs.getInt(3);
        int harga = rs.getInt(4);
        
        // SET DATA
        b.setBarang(nama, massa, harga);
        b.setId(id);
        System.out.println("id getData " + b.getId());
        System.out.println(b.getNama());
        System.out.println(b.getMassa());
        System.out.println(b.getHarga());
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  } 
}
