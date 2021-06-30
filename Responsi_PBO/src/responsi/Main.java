/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import view.MainMenu_GUI;

/**
 *
 * @author Asus
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ConnecterDB cdb = new ConnecterDB();
    if (cdb.getConnection() == null);
    else new MainMenu_GUI();
  }
  
}
