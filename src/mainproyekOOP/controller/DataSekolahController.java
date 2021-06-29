/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import mainproyekOOP.viewframe.ViewDataSekolah;

/**
 *
 * @author Faisal
 */
public class DataSekolahController implements ActionListener {
    ViewDataSekolah vDataSekolah;
    public DataSekolahController() {
    vDataSekolah = new ViewDataSekolah();
    vDataSekolah.buttonKembali.addActionListener(this);
    
    }

    public void showDataSekolah(){
        vDataSekolah.setVisible(true);
    }
    
    public void showMenuUtama(){
        MenuUtamaController vMenu = new MenuUtamaController();
        vMenu.showMenuUtama();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vDataSekolah.buttonKembali){
           vDataSekolah.setVisible(false);
       }
    }
    
}
