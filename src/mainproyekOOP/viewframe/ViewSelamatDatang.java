/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
/**
 *
 * @author Faisal
 */
public class ViewSelamatDatang extends JFrame {
    JLabel lblWelcome = new JLabel();
    JLabel lblWelcome1 = new JLabel();
    JLabel lblPesan = new JLabel();
    JLabel lblPesan1 = new JLabel();
    JLabel lblPesan2 = new JLabel();
    JLabel lblPesan3 = new JLabel();
    JLabel lblPesan4 = new JLabel();
    
    
    public JButton butLogin = new JButton("login");
    public JButton butExit = new JButton("keluar");
    
    
    public ViewSelamatDatang(){
        this.setTitle("Selamat Datang");
        this.setSize(600,350);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initComponents();
    }
    //method Komponen dari inisialisasi
    private void initComponents(){
        //mendapatkan Content pane
        this.getContentPane().add(this.lblWelcome);
        this.getContentPane().add(this.lblWelcome1);
        this.getContentPane().add(this.lblPesan);
        this.getContentPane().add(this.lblPesan1);
        this.getContentPane().add(this.lblPesan2);
        this.getContentPane().add(this.lblPesan3);
        this.getContentPane().add(this.lblPesan4);
        
        this.getContentPane().add(this.butLogin);
        this.getContentPane().add(this.butExit);
        
        //set posisi
        lblWelcome.setBounds(100,20,400,20);
        lblWelcome1.setBounds(175,40,400,30);
        lblPesan.setBounds(30, 110, 400,20);
        lblPesan1.setBounds(30, 140, 400,20);
        lblPesan2.setBounds(30, 170, 400,20);
        lblPesan3.setBounds(30, 200, 400,20);
        lblPesan4.setBounds(30, 230, 400,20);
        
        butLogin.setBounds(new Rectangle(400,200,100,40));
        butExit.setBounds(new Rectangle(400,245,100,40));
        
        //menambahkan isi
        lblWelcome.setFont(new Font ("Tahoma",Font.BOLD,18));
        lblWelcome1.setFont(new Font ("Tahoma",Font.BOLD,18));
        lblPesan.setFont(new Font ("Tahoma",Font.BOLD,15));
        lblPesan1.setFont(new Font ("Tahoma",Font.BOLD,15));
        lblPesan2.setFont(new Font ("Tahoma",Font.BOLD,15));
        lblPesan3.setFont(new Font ("Tahoma",Font.BOLD,15));
        
        
        
        lblWelcome.setText  ("SELAMAT DATANG DI SISTEM INFORMASI");
        lblWelcome1.setText  ("KEPEGAWAIAN SEKOLAH");
        lblPesan.setText    ("Selamat datang.");
        lblPesan1.setText   ("Sistem ini digunakan untuk mempermudah");
        lblPesan2.setText   ("proses pendataan, absensi, dan"); 
        lblPesan3.setText   ("penggajian pegawai sekolah");
        lblPesan4.setText   ("");                    
                        
  
        //MEMBUAT ICON USER
        URL locIcon = ViewSelamatDatang.class.getResource("/res/User.jpg");
        ImageIcon UserIconImg = new ImageIcon(locIcon);
        //Membuat label berisi image icon yang akan dijadikan sebagai icon user
        JLabel lbIcn = new JLabel(UserIconImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbIcn);
        //Mensetting posisi dan ukuran label background
        lbIcn.setBounds(400,100,100,85);
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/green-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 600, 350);
        
        
        
        
    }
    
 
}
