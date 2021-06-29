/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Faisal
 */
public class ViewMenuUtama extends JFrame{

    JLabel lblJudul = new JLabel("MENU UTAMA");
    
    
    public JButton btnPenggajian = new JButton("Penggajian");
    public JButton btnAbsensi = new JButton("Absensi");
    public JButton btnInputPegawai = new JButton("Data Pegawai");
    public JButton btnDaftarPegawai = new JButton("Daftar Pegawai");
    public JButton btnDataSekolah = new JButton("Sekilas Data Sekolah");
    public JButton btnLogout = new JButton("Logout");
    
    
    public ViewMenuUtama() {
    this.setTitle("Menu Utama");
    this.setSize(700, 350);
    this.getContentPane().setLayout(null);
    this.initComponents();
    this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    
    private void initComponents(){
        this.getContentPane().add(this.lblJudul);
        this.lblJudul.setFont(new Font("Cooper Black", Font.BOLD, 20));
        this.getContentPane().add(this.btnPenggajian);
        this.getContentPane().add(this.btnAbsensi);
        this.getContentPane().add(this.btnInputPegawai);
        this.getContentPane().add(this.btnDaftarPegawai);
        this.getContentPane().add(this.btnDataSekolah);
        this.getContentPane().add(this.btnLogout);
        
        //atur posisi
        lblJudul.setBounds(250,20,200,40);
        btnPenggajian.setBounds(20,70,160,30);
        btnAbsensi.setBounds(20,105,160,30);
        btnInputPegawai.setBounds(20,140,160,30);
        btnDaftarPegawai.setBounds(20,175,160,30);
        btnDataSekolah.setBounds(20,210,160,30);
        btnLogout.setBounds(450,240,150,30);
        
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/app-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 720, 350);
    }
    
    
}
