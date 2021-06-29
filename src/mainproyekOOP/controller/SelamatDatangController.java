/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mainproyekOOP.viewframe.ViewSelamatDatang;
/**
 *
 * @author Faisal
 */
public class SelamatDatangController  implements ActionListener {
    ViewSelamatDatang vSelamatDatang;

    public SelamatDatangController(){
        vSelamatDatang = new ViewSelamatDatang();
        vSelamatDatang.butLogin.addActionListener(this);
        vSelamatDatang.butExit.addActionListener(this);
    }
    
    public void showSelamatDatangView(){
        vSelamatDatang.setVisible(true);
    }
    
    
    private void showLoginForm(){
       LoginController vCont = new LoginController();
       vCont.showLoginView();
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vSelamatDatang.butLogin){
            vSelamatDatang.setVisible(false);
            showLoginForm();
        }
        else if (e.getSource() == vSelamatDatang.butExit)
        {
            System.exit(0);
        }
    }
}
