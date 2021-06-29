/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;

/**
 *
 * @author Faisal
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;


public class ViewDataSekolah extends JFrame {

    JLabel titleBaris1 = new JLabel("DINAS PENDIDIKAN REPUBLIK INDONESIA");
    JLabel titleBaris2 = new JLabel("SMP NEGERI 1 MURIA");
    JLabel titleBaris3 = new JLabel("DEPOK");
   
    JLabel idSekolah = new JLabel("ID Sekolah: SEK123");
    JLabel namaSekolah = new JLabel("Nama: SMPN 1 MURIA");
    JLabel alamatSekolah = new JLabel("Alamat: Jl. Soekarno-Hatta no. 2 Depok");
    JLabel contactSekolah = new JLabel("email/telp/fax: muria@gmail.com/(021)562344");
    
    public JButton buttonKembali = new JButton("Kembali");
    
    public ViewDataSekolah() {
    
        this.setTitle("Data Sekolah");
        this.setSize(800,500);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.initComponents();
    
    }
    
    private void initComponents(){
        //menambahkan konten frame
        this.getContentPane().add(this.titleBaris1);
        this.getContentPane().add(this.titleBaris2);
        this.getContentPane().add(this.titleBaris3);
        this.getContentPane().add(this.idSekolah);
        this.getContentPane().add(this.namaSekolah);
        this.getContentPane().add(this.alamatSekolah);
        this.getContentPane().add(this.contactSekolah);
        this.getContentPane().add(this.buttonKembali);
        
        //Mengatur font
        this.titleBaris1.setFont(new Font ("Calibri",Font.BOLD, 25));
        this.titleBaris2.setFont(new Font ("Calibri",Font.BOLD, 25));
        this.titleBaris3.setFont(new Font ("Calibri",Font.BOLD, 25));
        
        //mengatur posisi komponen
        this.titleBaris1.setBounds(170, 20, 700, 30);
        this.titleBaris2.setBounds(280, 55, 400, 30);
        this.titleBaris3.setBounds(360, 90, 400, 30);
        this.idSekolah.setBounds(170, 160, 400, 20);
        this.namaSekolah.setBounds(170, 185, 400, 30);
        this.alamatSekolah.setBounds(170, 220, 400, 30);
        this.contactSekolah.setBounds(170, 255, 400, 30);
        this.buttonKembali.setBounds(500, 380, 120, 30);
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/green-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 800, 500);
        
        //mencari lokasi gambar
        URL  lokasiBatal = FormInputDataPeg.class.getResource("/res/batalIcon.jpg");
        ImageIcon batalImg = new ImageIcon(lokasiBatal);
        
        //Menambahkan icon ke tombol
        
        buttonKembali.setIcon(batalImg);
    }
    
   
}
