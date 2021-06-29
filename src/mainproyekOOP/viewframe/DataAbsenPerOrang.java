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
public class DataAbsenPerOrang extends JFrame {
    
    JLabel lblHeader = new JLabel("ABSENSI PEGAWAI");
    JLabel lblNama = new JLabel("Nama");
    JLabel lblNIP = new JLabel("NIP");
    
    JButton buttonExit = new JButton("Kembali");
    
    public DataAbsenPerOrang(){
        this.setTitle("Data Absen Pegawai");
        this.setSize(700,350);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initComponents();
    }
    
    private void initComponents(){
        
        String kolom[]= {"No.","Hari Tanggal","Kehadiran","Keterangan","Petugas Absensi"};
        String isi[][] = {{"1","Senin,19/5/2014","Hadir","NULL","Sugianto"},
                          {"2","Selasa,20/5/2014","Hadir","NULL","Sugianto"},
                          {"","","","",""},
                          {"","","","",""},
                          {"","","","",""},
                          {"","","","",""},
                          {"","","","",""},
                          {"","","","",""},
                          {"","","","",""},
                          {"","","","",""},
                         };
        
        JTable tblAbsen = new JTable (isi,kolom);
        JScrollPane pane = new JScrollPane(tblAbsen);
        //set ukuran scrollpane
        pane.setBounds(5,100,675,150);
        //getContentpane
        this.getContentPane().add(pane);
        this.getContentPane().add(buttonExit);
        this.getContentPane().add(lblNama);
        this.getContentPane().add(lblNIP);
        this.getContentPane().add(lblHeader);
        
        buttonExit.setBounds(new Rectangle(480, 260, 80, 25));
        lblHeader.setFont( new Font("Tahoma",Font.BOLD,20));
        lblHeader.setBounds(245,20,400,30);
        lblNama.setBounds(20,50,100,20);
        lblNIP.setBounds(20,75,100,20);
        
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/app-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 700, 700);
        
    }
    
    public static void main(String[] args) {
        DataAbsenPerOrang a = new DataAbsenPerOrang();
        a.setVisible(true);
    }
    
}
