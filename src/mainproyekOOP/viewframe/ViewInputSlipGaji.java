/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;
import java.awt.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Faisal
 */
public class ViewInputSlipGaji extends JFrame {

    JLabel lblJudul = new JLabel("DATA GAJI PEGAWAI");
    JLabel lblNama = new JLabel("Nama");
    JLabel lblNip = new JLabel("NIP");
    JLabel lblGaji = new JLabel("GAJI");
    JLabel lblGajiPokok = new JLabel("Gaji Pokok");
    JLabel lblTjgKehadiran = new JLabel("Tunjangan Kehadiran");
    JLabel lblTjgPendidikan = new JLabel("Tunjangan Pendidikan");
    JLabel lblTjgJabatan = new JLabel("Tunjangan Jabatan");
    JLabel lblTjgMasaKerja = new JLabel("Tunjangan Masa Kerja");
    JLabel lblPotongan = new JLabel("POTONGAN");
    JLabel lblPajakPenghasilan = new JLabel("Pajak Penghasilan");
    JLabel lblIuranWajib = new JLabel("Iuran Wajib");
    JLabel lblTanggalTerima = new JLabel("Tanggal Terima");
    JLabel lblTotalGaji = new JLabel("Total Gaji Diterima");
    
    public int kode_slip=0;
    public String NIP="";
    public JTextField txtNip = new JTextField();
    public JTextField txtNama = new JTextField();
    public JTextField txtTjgKehadiran = new JTextField();
    public JTextField txtTjgPendidikan = new JTextField();
    public JTextField txtTjgJabatan = new JTextField();
    public JTextField txtTjgMasaKerja = new JTextField();
    public JTextField txtGajiPokok = new JTextField();
    public JTextField txtPajakPenghasilan = new JTextField();
    public JTextField txtIuranWajib = new JTextField();
    public JTextField txtTanggalTerima = new JTextField();
    public JTextField txtTotalGaji = new JTextField();
    public JButton buttonSave = new JButton("Simpan");
    public JButton buttonCancel = new JButton("Batal");
    public JButton buttonEdit = new JButton("Ubah");
    public JButton buttonLoad = new JButton("Load");
    
    public ViewInputSlipGaji() {
    this.setTitle("Slip Gaji");
    this.setSize(720,720);
    this.getContentPane().setLayout(null);
    this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    this.initComponents();
    
    
    }
    
    private void initComponents(){
        
        this.getContentPane().add(this.buttonCancel);
        this.getContentPane().add(this.buttonEdit);
        this.getContentPane().add(this.buttonSave);
        this.getContentPane().add(this.lblGaji);
        this.getContentPane().add(this.lblGajiPokok);
        this.getContentPane().add(this.lblIuranWajib);
        this.getContentPane().add(this.lblJudul);
        this.getContentPane().add(this.lblNama);
        this.getContentPane().add(this.lblNip);
        this.getContentPane().add(this.lblPajakPenghasilan);
        this.getContentPane().add(this.lblTanggalTerima);
        this.getContentPane().add(this.lblTjgJabatan);
        this.getContentPane().add(this.lblTjgKehadiran);
        this.getContentPane().add(this.lblTjgMasaKerja);
        this.getContentPane().add(this.lblTjgPendidikan);
        this.getContentPane().add(this.lblTotalGaji);
        this.getContentPane().add(this.lblPotongan);
        
        
        lblJudul.setBounds (new Rectangle(300,20,250,20));
        lblNip.setBounds(new Rectangle(20, 45, 250, 25));
        lblNama.setBounds(new Rectangle(20, 80, 250, 25));
        lblGaji.setBounds(new Rectangle(20, 115, 250, 25));
        lblGajiPokok.setBounds(new Rectangle(20, 140, 250, 25));
        lblTjgJabatan.setBounds(new Rectangle(20, 175, 250, 25));
        lblTjgKehadiran.setBounds(new Rectangle(20, 210, 250, 25));
        lblTjgMasaKerja.setBounds(new Rectangle(20, 245, 250, 25));
        lblTjgPendidikan.setBounds(new Rectangle(20, 280, 250, 25));
        lblPotongan.setBounds(new Rectangle(20, 315, 250, 25));
        lblPajakPenghasilan.setBounds(new Rectangle(20, 345, 250, 25));
        lblIuranWajib.setBounds(new Rectangle(20, 380, 250, 25));
        lblTanggalTerima.setBounds(new Rectangle(20, 415, 250, 25));
        lblTotalGaji.setBounds(new Rectangle(20, 450, 250, 25));
    
     
        this.getContentPane().add(this.txtGajiPokok);
        this.getContentPane().add(this.txtIuranWajib);
        this.getContentPane().add(this.txtNama);
        this.getContentPane().add(this.txtNip);
        this.getContentPane().add(this.txtPajakPenghasilan);
        this.getContentPane().add(this.txtTanggalTerima);
        this.getContentPane().add(this.txtTjgJabatan);
        this.getContentPane().add(this.txtTjgKehadiran);
        this.getContentPane().add(this.txtTjgMasaKerja);
        this.getContentPane().add(this.txtTjgPendidikan);
        this.getContentPane().add(this.txtTotalGaji);
        this.getContentPane().add(this.buttonCancel);
        this.getContentPane().add(this.buttonSave);
        this.getContentPane().add(this.buttonLoad);
        
        lblJudul.setBounds (new Rectangle(300,20,300,20));
        txtNip.setBounds(new Rectangle(280, 50, 300, 25));
        buttonLoad.setBounds(new Rectangle(590, 50, 100, 25));
        txtNama.setBounds(new Rectangle(280, 85, 300, 25));
        txtNama.setEditable(false);
        txtGajiPokok.setBounds(new Rectangle(280, 140, 300, 25));
        txtTjgJabatan.setBounds(new Rectangle(280, 175, 300, 25));
        txtTjgKehadiran.setBounds(new Rectangle(280, 210, 300, 25));
        txtTjgMasaKerja.setBounds(new Rectangle(280, 245, 300, 25));
        txtTjgPendidikan.setBounds(new Rectangle(280, 280, 300, 25));
        txtPajakPenghasilan.setBounds(new Rectangle(280, 345, 300, 25));
        txtIuranWajib.setBounds(new Rectangle(280, 380, 300, 25));
        txtTanggalTerima.setBounds(new Rectangle(280, 415, 300, 25));
        txtTotalGaji.setBounds(new Rectangle(280, 450, 300, 25));
        txtTotalGaji.setEditable(false);
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date tanggal = new Date();
        String tglTerima = dateFormat.format(tanggal);
        txtTanggalTerima.setEditable(false);
        txtTanggalTerima.setText(tglTerima);
        
        buttonSave.setBounds(new Rectangle(280, 520, 120, 30));
        buttonCancel.setBounds(new Rectangle(420, 520, 120, 30));
        
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
        URL lokasiSave = ViewInputSlipGaji.class.getResource("/res/saveIcon.jpg");
        ImageIcon saveImg = new ImageIcon(lokasiSave);
        
        URL  lokasiBatal = ViewInputSlipGaji.class.getResource("/res/batalIcon.jpg");
        ImageIcon batalImg = new ImageIcon(lokasiBatal);
        
        //Menambahkan icon ke tombol
        buttonSave.setIcon(saveImg);
        buttonCancel.setIcon(batalImg);
    }
    
    public static void main(String[] args) {
        ViewInputSlipGaji vSlip = new ViewInputSlipGaji();
        vSlip.setVisible(true);
    }
    
   
}