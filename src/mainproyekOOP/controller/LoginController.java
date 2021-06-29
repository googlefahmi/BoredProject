/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;
import mainproyekOOP.controller.MenuUtamaController;
import mainproyekOOP.viewframe.ViewLogin;
import mainproyekOOP.viewframe.ViewMenuUtama;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mainproyekOOP.viewframe.ViewSelamatDatang;

/**
 *
 * @author Faisal
 */
public class LoginController implements ActionListener {

    ViewLogin vLoginCont;
    public LoginController(){
        vLoginCont = new ViewLogin();
        vLoginCont.btnLogin.addActionListener(this);
        vLoginCont.btnBatal.addActionListener(this);
    }
    
    public void showLoginView(){
        vLoginCont.setVisible(true);
    }
    
    public void showSelamatDatang(){
       ViewSelamatDatang vSelDtg = new ViewSelamatDatang();
       vSelDtg.setVisible(true);
    }
    
    private void showMenuUtama(){
        MenuUtamaController menuCont = new MenuUtamaController();
        menuCont.showMenuUtama();
        
    }
    
    private void showMenuUtamaAbsensi(){
        MenuPetugasAbsensiController menuPetugasAbsensi = new MenuPetugasAbsensiController();
        menuPetugasAbsensi.showMenuUtama();
    }
    
    private void showMenuUtamaGaji(){
        MenuPetugasGajiController menuPetugasGaji = new MenuPetugasGajiController();
        menuPetugasGaji.showMenuUtama();
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String nama = vLoginCont.taUsername.getText();
        String pass = vLoginCont.taPassword.getText();
        
        if(e.getSource()==vLoginCont.btnLogin){
                
                if((nama.equals("Admin"))&& (pass.equals("admin"))){                    
                    vLoginCont.setVisible(false);
                    showMenuUtama();      
                }
                else if((nama.equals("Absen"))&& (pass.equals("absen"))){                    
                    vLoginCont.setVisible(false);
                    showMenuUtamaAbsensi();      
                }
                else if((nama.equals("Gaji"))&& (pass.equals("gaji"))){                    
                    vLoginCont.setVisible(false);
                    showMenuUtamaGaji();      
                }                       
                else {
                    JOptionPane.showMessageDialog(null, "Access Denied!");
                }    
        }
        else if(e.getSource()==vLoginCont.btnBatal){
            SelamatDatangController back = new SelamatDatangController();
            back.showSelamatDatangView();
        }
                
                
    }
    
}
