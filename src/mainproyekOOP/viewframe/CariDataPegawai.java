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
public class CariDataPegawai extends JFrame {
    
    JLabel lblCari = new JLabel("Nama");
    JTextField tfCari = new JTextField();
    JButton bCari = new JButton("Mulai");
    
    
    public CariDataPegawai(){
        this.setTitle("Cari Data");
        this.setSize(300, 150);
        this.getContentPane().setLayout(null);
        this.initComponents();
        
    }
    
    private void initComponents(){
        
        this.getContentPane().add(lblCari);
        this.getContentPane().add(tfCari);
        this.getContentPane().add(bCari);
        
        lblCari.setBounds(new Rectangle (20,45,50,20));
        tfCari.setBounds(new Rectangle (70,45,170,20));
        bCari.setBounds(new Rectangle (150,75,80,20));
        
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
