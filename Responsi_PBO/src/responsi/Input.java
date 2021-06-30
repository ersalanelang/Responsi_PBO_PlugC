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
public class Input {
    public boolean input(Barang b) {
    String query = "INSERT INTO `barang`(`nama`, `massa`, `harga`) VALUES (?,?,?)";
    PreparedStatement ps;  
    
     try {
      ConnecterDB cdb = new ConnecterDB();
      ps = cdb.getConnection().prepareStatement(query);
      ps.setString(1, b.getNama());
      ps.setInt(2, b.getMassa());
      ps.setInt(3, b.getHarga());

      // jika berhasil
      if (ps.executeUpdate() > 0) {
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
  }
}
