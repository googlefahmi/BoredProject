/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author Faisal
 */
public class ViewLogin extends JFrame {
   
    public JLabel lblUsername = new JLabel("Username");
    public JLabel lblPassword = new JLabel("Password");
    
    public JTextField taUsername = new JTextField();
    public JPasswordField taPassword = new JPasswordField();
    
    public JButton btnLogin = new JButton("Login");
    public JButton btnBatal = new JButton("Batal");
    
    public ViewLogin(){
        this.setTitle("Login Form");
        this.getContentPane().setLayout(null);
        this.setSize(400,150);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.initComponents();
    }
     
     private void initComponents(){
        
        this.getContentPane().add(this.lblUsername);
        this.getContentPane().add(this.taUsername);      
        this.getContentPane().add(this.lblPassword);        
        this.getContentPane().add(this.taPassword);
        
        this.getContentPane().add(this.btnLogin);
        this.getContentPane().add(this.btnBatal);
       
        
        lblUsername.setBounds(20,20,100,20);
        taUsername.setBounds(150,20,150,20);
        lblPassword.setBounds(20,50,100,20);
        taPassword.setBounds(150,50,150,20);
        btnLogin.setBounds(40,80,100,20);
        btnBatal.setBounds(150,80,100,20);
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/app-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 600, 350);
    }
    
}
