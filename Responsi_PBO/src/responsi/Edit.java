/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Edit {
     public boolean edit(Barang b){
    String query = "UPDATE `barang` SET `nama`=?,`massa`=?,`harga`=? WHERE `id`=?";
    PreparedStatement ps;
     System.out.println("idEdit " + b.getId());
     try {
      ConnecterDB cdb = new ConnecterDB();
      ps = cdb.getConnection().prepareStatement(query);
      ps.setString(1, b.getNama());
      ps.setInt(2, b.getMassa());
      ps.setInt(3, b.getHarga());
      ps.setInt(4, b.getId());
      int i = ps.executeUpdate();

      return i == 1; // jika change pin success
      
    } catch (SQLException ex) {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
