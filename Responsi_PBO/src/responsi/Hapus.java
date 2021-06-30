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
public class Hapus {
    public boolean deleteData(Barang b){
    String query = "DELETE FROM `barang` WHERE `id`=?";
    PreparedStatement ps;

     try {
      ConnecterDB myConnection = new ConnecterDB();
      ps = myConnection.getConnection().prepareStatement(query);
      ps.setInt(1, b.getId());

      int i = ps.executeUpdate();

      return i == 1; // jika change pin success
      
    } catch (SQLException ex) {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
  }
}
