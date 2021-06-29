/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Date;
import java.util.Calendar;
 import java.text.DateFormat; 
import java.text.SimpleDateFormat;
/**
 *
 * @author Faisal
 */
public class ViewAbsensiPegawai extends JFrame {

    JLabel lblHeader = new JLabel("ABSENSI PEGAWAI");
    JLabel lblTanggal = new JLabel("Tanggal");   
    public JButton btnCancel = new JButton("Batal");
    public JButton btnSave = new JButton("Simpan");
    public JButton btnEdit = new JButton("Ubah");
    public JButton btnDelete = new JButton("Hapus");
    public JButton btnRefresh = new JButton("Refresh");
    public JButton btnLoad = new JButton("Load");
    
    //JLabel lblKodeAbsensi = new JLabel("Kode Absensi");
    JLabel lblNIP = new JLabel("NIP");
    JLabel lblNama = new JLabel("Nama");
    JLabel lblKehadiran = new JLabel("Kehadiran");
    JLabel lblJmMsk = new JLabel("Jam Masuk");
    JLabel lblJmKluar = new JLabel("Jam Keluar");
    JLabel lblKeterangan = new JLabel("Keterangan");
    
   // public JTextField tfKodeAbsensi = new JTextField();
    public JTextField tfNIP = new JTextField();
    public JTextField tfNama = new JTextField();
    public JTextField tfTanggal = new JTextField();
    public JTextField tfJmMsk = new JTextField();
    public JTextField tfJmKluar = new JTextField();
    public JRadioButton rbHadir = new JRadioButton("Hadir");
    public JRadioButton rbTdkHadir = new JRadioButton("Tidak Hadir");
    public JTextArea taKeterangan = new JTextArea();
    public JTable tbAbsensi = new JTable();
    public ViewAbsensiPegawai() {
        this.setTitle("Absensi Pegawai");
        this.setSize(1000,600);
        this.getContentPane().setLayout(null);
        
        this.initComponents();
    }
    
    private void initComponents(){
        
        
        tbAbsensi = new JTable ();
        JScrollPane pane = new JScrollPane(tbAbsensi);
        //set ukuran scrollpane
        pane.setBounds(5,100,950,150);
        //getContentpane
        this.getContentPane().add(pane);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(lblHeader);
        this.getContentPane().add(btnSave);
        this.getContentPane().add(btnEdit);
        this.getContentPane().add(btnDelete);
        this.getContentPane().add(btnRefresh);
        this.getContentPane().add(btnLoad);
        
//        this.getContentPane().add(tfKodeAbsensi);
        this.getContentPane().add(tfNIP);
        this.getContentPane().add(tfNama);
        this.getContentPane().add(tfTanggal);
        this.getContentPane().add(rbHadir);
        this.getContentPane().add(rbTdkHadir);
        this.getContentPane().add(tfJmMsk);
        this.getContentPane().add(tfJmKluar);
        this.getContentPane().add(taKeterangan);
        
       // this.getContentPane().add(lblKodeAbsensi);
        this.getContentPane().add(lblNIP);
        this.getContentPane().add(lblNama);
        this.getContentPane().add(lblTanggal);
        this.getContentPane().add(lblKehadiran);
        this.getContentPane().add(lblJmMsk);
        this.getContentPane().add(lblJmKluar);
        this.getContentPane().add(lblKeterangan);
        
        ButtonGroup bgAbsen = new ButtonGroup();
        bgAbsen.add(rbHadir);
        bgAbsen.add(rbTdkHadir);
        rbHadir.setOpaque(false);
        rbTdkHadir.setOpaque(false);
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date tanggal = new Date();
        String tglMasuk = dateFormat.format(tanggal);
        tfTanggal.setEditable(false);
        tfTanggal.setText(tglMasuk);
        
        
        
        //Atur Posisi
        
       // lblKodeAbsensi.setBounds(new Rectangle(5, 270, 130, 20));
        lblNIP.setBounds(new Rectangle(5, 300, 80, 20));
        lblNama.setBounds(new Rectangle(5, 330, 80, 20));
        lblTanggal.setBounds(new Rectangle(5, 360, 80, 20));
        lblKehadiran.setBounds(new Rectangle(5, 390, 80, 20));       
        lblJmMsk.setBounds(new Rectangle(5, 420, 80, 20));
        lblJmKluar.setBounds(new Rectangle(5, 450, 80, 20));
        lblKeterangan.setBounds(new Rectangle(5, 480, 80, 60));
        
//        tfKodeAbsensi.setBounds(new Rectangle(150, 270, 50, 20));
        tfNIP.setBounds(new Rectangle(150, 300, 170, 20));
        tfNama.setBounds(new Rectangle(150, 330, 170, 20));
        tfTanggal.setBounds(new Rectangle(150, 360, 170, 20));
        rbHadir.setBounds(new Rectangle(150, 390, 100, 20));
        rbTdkHadir.setBounds(new Rectangle(260, 390, 100, 20));
        tfJmMsk.setBounds(new Rectangle(150, 420, 170, 20));
        tfJmKluar.setBounds(new Rectangle(150, 450, 170, 20));
        taKeterangan.setBounds(new Rectangle(150, 480, 170, 60));
          
        
        btnLoad.setBounds(new Rectangle(400, 300, 80, 30));
        btnSave.setBounds(new Rectangle(400, 335, 80, 30));
        btnEdit.setBounds(new Rectangle(400, 370, 80, 30));
        btnDelete.setBounds(new Rectangle(400, 405, 80, 30));
        btnCancel.setBounds(new Rectangle(400, 450, 80, 30));
        btnRefresh.setBounds(new Rectangle(5,60,80,30));
        
        lblHeader.setFont( new Font("Tahoma",Font.BOLD,20));
        lblHeader.setBounds(380,20,400,30);
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/app-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 1000, 700);
        
    }
    
    public static void main(String[] args) {
        ViewAbsensiPegawai aa = new ViewAbsensiPegawai();
        aa.setVisible(true);
    }
}
