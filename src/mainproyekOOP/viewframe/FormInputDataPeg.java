/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import sun.util.calendar.JulianCalendar;
/**
 *
 * @author Faisal
 */
public class FormInputDataPeg extends JFrame {
    //public String id_Pegawai = "";
    public int idJabatan = 0;
    JLabel lblJudul = new JLabel("DATA PEGAWAI");
    JLabel lblNip = new JLabel("NIP");
    JLabel lblNama = new JLabel("Nama");
    JLabel lblTtl = new JLabel("Tempat Lahir");
    JLabel lblTglLahir = new JLabel ("Tanggal Lahir");
    JLabel lblJK = new JLabel("Jenis Kelamin");
    JLabel lblAlamat = new JLabel("Alamat");
    JLabel lblNotelp = new JLabel("No Telp");
    JLabel lblAgama = new JLabel("Agama");
    JLabel lblStatus = new JLabel("Status");
    JLabel lblJabatan = new JLabel("ID_Jabatan");
    JLabel lblGajiPokok = new JLabel("Gaji Pokok");
    JLabel lblPendidikan = new JLabel("Pendidikan");
    JLabel lblTglMasuk = new JLabel("Tanggal Masuk Kerja");
    
    
    
    public JTextField txtNip = new JTextField();
    public JTextField txtNama = new JTextField();
    public JComboBox cbTglLahir = new JComboBox();
    public JComboBox cbBlnLahir = new JComboBox();
    public JComboBox cbThnLahir = new JComboBox();
    public JTextField txtTempatLahir = new JTextField();
    public JRadioButton rL = new JRadioButton("L");
    public JRadioButton rP = new JRadioButton("P");
    public JTextArea taAlamat = new JTextArea();
    public JTextField txtNoTelp = new JTextField();
    public JTextField txtStatus = new JTextField();
    public JComboBox cboxAgama = new JComboBox();
    public JTextField txtJabatan = new JTextField();
    public JTextField txtGajiPokok = new JTextField();
    public JTextField txtPendidikan = new JTextField();
    public JComboBox cbTglMsk = new JComboBox();
    public JComboBox cbBlnMsk = new JComboBox();
    public JComboBox cbThnMsk = new JComboBox();
    public JButton buttonSave = new JButton("Simpan");
    public JButton buttonCancel = new JButton("Batal");
    public JButton buttonEdit = new JButton("Ubah");
        
    public FormInputDataPeg(){
       this.setTitle("Input Data Pegawai");
       this.setSize(720,720);
       this.getContentPane().setLayout(null);
       this.initComponents();
       this.setDefaultCloseOperation(HIDE_ON_CLOSE); 
    }
    
    private void initComponents(){
        //menambahkan get.content.pane().add(komponennya)
        
        this.getContentPane().add(this.lblJudul);
        this.getContentPane().add(this.lblNip);
        this.getContentPane().add(this.lblNama);
        this.getContentPane().add(this.lblTtl);
        this.getContentPane().add(this.lblTglLahir);
        this.getContentPane().add(this.lblJK);
        this.getContentPane().add(this.lblAlamat);
        this.getContentPane().add(this.lblNotelp);
        this.getContentPane().add(this.lblAgama);
        this.getContentPane().add(this.lblStatus);
        this.getContentPane().add(this.lblJabatan);
        this.getContentPane().add(this.lblGajiPokok);
        this.getContentPane().add(this.lblPendidikan);
        this.getContentPane().add(this.lblTglMasuk);
        
        
        //mengatur ukuran label
        lblJudul.setBounds (new Rectangle(300,20,100,20));
        lblNip.setBounds(new Rectangle(20, 50, 50, 25));
        lblNama.setBounds(new Rectangle(20, 80, 50, 25));
        lblTtl.setBounds(new Rectangle(20, 110, 200, 25));
        lblTglLahir.setBounds(new Rectangle(20, 140, 200, 25));
        lblJK.setBounds(new Rectangle(20, 170, 150, 25));
        lblAlamat.setBounds(new Rectangle(20, 200, 50, 25));
        lblNotelp.setBounds(new Rectangle(20, 310, 50, 25));
        lblAgama.setBounds(new Rectangle(20, 340, 50, 25));
        lblStatus.setBounds(new Rectangle(20, 370, 50, 25));
        lblJabatan.setBounds(new Rectangle(20, 400, 70, 25));
        lblGajiPokok.setBounds(new Rectangle(20, 430, 70, 25));
        lblPendidikan.setBounds(new Rectangle(20, 460, 200, 25));
        lblTglMasuk.setBounds(new Rectangle(20, 490, 200, 25));
        
        
        //menambahkan konten teks inputan
        
        this.getContentPane().add(this.txtNip);
        this.getContentPane().add(this.txtNama);
        this.getContentPane().add(this.cbTglLahir);
        this.getContentPane().add(this.cbBlnLahir);
        this.getContentPane().add(this.cbThnLahir);
        this.getContentPane().add(this.txtTempatLahir);
        this.getContentPane().add(this.rL);
        this.getContentPane().add(this.rP);
        this.getContentPane().add(this.taAlamat);
        this.getContentPane().add(this.txtNoTelp);
        this.getContentPane().add(this.cboxAgama);
        cboxAgama.addItem("");
        cboxAgama.addItem("Islam");
        cboxAgama.addItem("Katolik");
        cboxAgama.addItem("Protestan");
        cboxAgama.addItem("Hindu");
        cboxAgama.addItem("Budha");
        this.getContentPane().add(this.txtStatus);
        this.getContentPane().add(this.txtJabatan);
        this.getContentPane().add(this.txtGajiPokok);
        this.getContentPane().add(this.txtPendidikan);
        this.getContentPane().add(this.cbTglMsk);
        this.getContentPane().add(this.cbBlnMsk);
        this.getContentPane().add(this.cbThnMsk);
        this.getContentPane().add(this.buttonSave);
        this.getContentPane().add(this.buttonCancel);
        this.getContentPane().add(this.buttonEdit);
        
        //atur posisi inputan tsb
        
        txtNip.setBounds(new Rectangle(280, 50, 260, 25));
        txtNama.setBounds(new Rectangle(280, 80, 260, 25));
        txtTempatLahir.setBounds(new Rectangle(280, 110, 260, 25));
        cbTglLahir.setBounds(new Rectangle(280, 140, 60, 25));
        cbBlnLahir.setBounds(new Rectangle(345, 140, 120, 25));
        cbThnLahir.setBounds(new Rectangle(470, 140, 100, 25));
        rL.setBounds(new Rectangle(280, 170, 40, 25));
        rP.setBounds(new Rectangle(350, 170, 40, 25));
        taAlamat.setBounds(new Rectangle(280, 200, 260, 90));
        txtNoTelp.setBounds(new Rectangle(280, 310, 260, 25));
        cboxAgama.setBounds(new Rectangle(280, 340, 260, 25));
        txtStatus.setBounds(new Rectangle(280,370, 260, 25));
        txtJabatan.setBounds(new Rectangle(280, 400, 260, 25));
        txtGajiPokok.setBounds(new Rectangle(280, 430, 260, 25));
        txtPendidikan.setBounds(new Rectangle(280, 460, 260, 25));
        cbTglMsk.setBounds(new Rectangle(280, 490, 60, 25));
        cbBlnMsk.setBounds(new Rectangle(345, 490, 120, 25));
        cbThnMsk.setBounds(new Rectangle(470, 490, 100, 25));
        
        String[] bln = {"Januari","Februari","Maret","April",
                        "Mei","Juni","Juli","Agustus",
                        "September","Oktober","November","Desember"};
                          
        
        for(int i=1;i<=31;i++){
            cbTglLahir.addItem(i);
            cbTglMsk.addItem(i);
        }
        
        for(int i=0;i<bln.length;i++){
            cbBlnLahir.addItem(bln[i]);
            cbBlnMsk.addItem(bln[i]);
        }
        
        for(int i=1900;i<2014;i++){
            cbThnLahir.addItem(i);
            cbThnMsk.addItem(i);
        }
        
        
        
        buttonSave.setBounds(new Rectangle(280, 540, 120, 30));
        buttonCancel.setBounds(new Rectangle(420, 540, 120, 30));
        
        
        //mengelompokkan button group Laki2 dan Perempuan
        ButtonGroup bg = new ButtonGroup();
        bg.add(rL);
        bg.add(rP);
        rL.setOpaque(false);
        rP.setOpaque(false);
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/app-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 750, 750);
        
        //Membuat icon dari image di package res
        URL lokasiSave = FormInputDataPeg.class.getResource("/res/saveIcon.jpg");
        ImageIcon saveImg = new ImageIcon(lokasiSave);
        
        URL  lokasiBatal = FormInputDataPeg.class.getResource("/res/batalIcon.jpg");
        ImageIcon batalImg = new ImageIcon(lokasiBatal);
        
        //Menambahkan icon ke tombol
        buttonSave.setIcon(saveImg);
        buttonCancel.setIcon(batalImg);
        
    }
    
    public static void main(String[] args) {
        FormInputDataPeg aa = new FormInputDataPeg();
        aa.setVisible(true);
    }
   
}
