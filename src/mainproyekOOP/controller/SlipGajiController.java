/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import mainproyekOOP.entities.EntityPegawai;
import mainproyekOOP.entities.EntitySlipGaji;
import mainproyekOOP.helper.PegawaiHelper;
import mainproyekOOP.helper.SlipGajiHelper;
import mainproyekOOP.viewframe.ViewInputSlipGaji;
import mainproyekOOP.viewframe.ViewLaporanDataGaji;
import mainproyekOOP.viewframe.ViewLaporanDataPegawai;
/**
 *
 * @author Faisal
 */
public class SlipGajiController implements ActionListener {

    ViewInputSlipGaji vInputGaji; 
    ViewInputSlipGaji vUpdateGaji;
    ViewLaporanDataGaji vListGaji;
    
    public SlipGajiController() {
    //dari class ViewInputSlipGaji
    vInputGaji = new ViewInputSlipGaji();
    vInputGaji.buttonCancel.addActionListener(this);
    vInputGaji.buttonSave.addActionListener(this);
    vInputGaji.buttonLoad.addActionListener(this);
    //Input Gaji dari ViewLaporanDataGaji
    vListGaji = new ViewLaporanDataGaji();
    vListGaji.buttonAdd.addActionListener(this);
    vListGaji.buttonCancel.addActionListener(this);
    vListGaji.buttonDelete.addActionListener(this);
    vListGaji.buttonEdit.addActionListener(this);
    //Update Gaji
    vUpdateGaji = new ViewInputSlipGaji();
    vUpdateGaji.buttonSave.addActionListener(this);
    vUpdateGaji.buttonCancel.addActionListener(this);
    vUpdateGaji.buttonLoad.setVisible(false);
    vUpdateGaji.txtNip.setEditable(false);
    }

    public void showSlipGaji(){
        vInputGaji.setVisible(true);
    }
    
    public void showListGaji(){
        this.fillTableListGaji();
        vListGaji.setVisible(true);
    }
    
    public void showMenuUtama(){
        MenuUtamaController vMenu = new MenuUtamaController();
        vMenu.showMenuUtama();
    }
    
    public void saveAddGaji() {
        //Lakukan validasi tidak boleh kosong
        if (vInputGaji.txtNip.getText().isEmpty()) {
            //jika nama kosong
            JOptionPane.showMessageDialog(vInputGaji, "Kolom NIP tidak boleh kosong!");
        }else if(vInputGaji.txtGajiPokok.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Gaji pokok tidak boleh kosong!");
        }else if(vInputGaji.txtIuranWajib.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Iuran tidak boleh kosong!");
        }else if(vInputGaji.txtPajakPenghasilan.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Pajak Penghasilan tidak boleh kosong!");
        }else if(vInputGaji.txtTanggalTerima.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tanggal Terima tidak boleh kosong!");
        }else if(vInputGaji.txtTjgKehadiran.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tunjangan Kehadiran tidak boleh kosong!");
        }else if(vInputGaji.txtTjgMasaKerja.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tunjangan Masa Kerja tidak boleh kosong!");
        }else if(vInputGaji.txtTjgPendidikan.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tunjangan Pendidikan tidak boleh kosong!");
        }
        else {
            //jika semua kolom isian sudah benar
            //Buat pegawai baru
            EntitySlipGaji sg = new EntitySlipGaji();
            
            //isi objek pegawai
            
            sg.setNIP(vInputGaji.txtNip.getText());
            sg.setGajiPokok(Long.parseLong(vInputGaji.txtGajiPokok.getText()));
            sg.setIuranWajib(Long.parseLong(vInputGaji.txtIuranWajib.getText()));
            sg.setPajakPenghasilan(Long.parseLong(vInputGaji.txtPajakPenghasilan.getText()));
            
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date tanggal = new Date();
            String tglTerima = dateFormat.format(tanggal);
            sg.setTglTerimaGaji(tglTerima);
              
            sg.setTglTerimaGaji(vInputGaji.txtTanggalTerima.getText());
            sg.setTjgJabatan(Long.parseLong(vInputGaji.txtTjgJabatan.getText()));
            sg.setTjgKehadiran(Long.parseLong(vInputGaji.txtTjgKehadiran.getText()));
            sg.setTjgMasaKerja(Long.parseLong(vInputGaji.txtTjgMasaKerja.getText()));
            sg.setTjgPendidikan(Long.parseLong(vInputGaji.txtTjgPendidikan.getText()));
            sg.getTotalGaji();
            
            SlipGajiHelper gh = new SlipGajiHelper();
            gh.save(sg);
            
            this.fillTableListGaji();
            //hide view add pegawai
            vInputGaji.setVisible(false);
        }
    }
    
    //Controll untuk perubahan data
    public void showViewUpdateGaji() {
        //mengambil id_pegawai terpilih yang akan diupdate
         int idGaji =  (Integer.parseInt((String)this.vListGaji.tblDataGajiPegawai.getModel().getValueAt(
                this.vListGaji.tblDataGajiPegawai.getSelectedRow(), 0)));
         
         
         
        //Mengambil data pegawai yang akan diedit dari db
        SlipGajiHelper gh = new SlipGajiHelper();
        EntitySlipGaji sg = gh.get(idGaji);
        EntityPegawai pegawai = new EntityPegawai();
        //Mengambil data jabatan yang akan diedit dari database
        
        if (sg != null) {
            //Jika Data p tidak kosong maka tampilakan di frame update data
            
            vUpdateGaji.txtNip.setText(sg.getNIP());
            vUpdateGaji.txtNama.setText(sg.getPegawai().getNama());
            vUpdateGaji.txtGajiPokok.setText(String.valueOf(sg.getGajiPokok()));
            vUpdateGaji.txtIuranWajib.setText(String.valueOf(sg.getIuranWajib()));
            vUpdateGaji.txtPajakPenghasilan.setText(String.valueOf(sg.getPajakPenghasilan()));
            vUpdateGaji.txtTjgJabatan.setText(String.valueOf(sg.getTjgJabatan()));
            vUpdateGaji.txtTjgKehadiran.setText(String.valueOf(sg.getTjgKehadiran()));
            vUpdateGaji.txtTjgMasaKerja.setText(String.valueOf(sg.getTjgMasaKerja()));
            vUpdateGaji.txtTjgPendidikan.setText(String.valueOf(sg.getTjgPendidikan()));
            vUpdateGaji.txtTanggalTerima.setText(String.valueOf(sg.getTglTerimaGaji()));
            vUpdateGaji.txtTotalGaji.setText(String.valueOf(sg.getTotalGaji()));
            
   
           
            //MEnampilkan form/frame update data pegawai        
            vUpdateGaji.setVisible(true);
        }
    }
    
    public void cancelUpdateGaji() {
        vUpdateGaji.setVisible(false);
    }
    
   
    public void saveUpdateGaji() {
        //Lakukan validasi tidak boleh kosong
        if (vUpdateGaji.txtNip.getText().isEmpty()) {
            //jika nama kosong
            JOptionPane.showMessageDialog(vInputGaji, "Kolom NIP tidak boleh kosong!");
        }else if(vUpdateGaji.txtGajiPokok.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Gaji pokok tidak boleh kosong!");
        }else if(vUpdateGaji.txtIuranWajib.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Iuran tidak boleh kosong!");
        }else if(vUpdateGaji.txtPajakPenghasilan.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Pajak Penghasilan tidak boleh kosong!");
        }else if(vUpdateGaji.txtTanggalTerima.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tanggal Terima tidak boleh kosong!");
        }else if(vUpdateGaji.txtTjgKehadiran.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tunjangan Kehadiran tidak boleh kosong!");
        }else if(vUpdateGaji.txtTjgMasaKerja.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tunjangan Masa Kerja tidak boleh kosong!");
        }else if(vUpdateGaji.txtTjgPendidikan.getText().isEmpty()){
            JOptionPane.showMessageDialog(vInputGaji, "Kolom Tunjangan Pendidikan tidak boleh kosong!");
        }
        else {
            //jika semua kolom isian sudah benar
            //Buat helper gaji
            SlipGajiHelper sh = new SlipGajiHelper();
            
            //ambil objek yang mau diupdate dari db
            
            EntitySlipGaji sg = sh.get(vUpdateGaji.kode_slip);
            
            //perbaharui isi objek pegawai
            sg.setNIP(vUpdateGaji.txtNip.getText());
            sg.setGajiPokok(Long.parseLong(vUpdateGaji.txtGajiPokok.getText()));
            sg.setIuranWajib(Long.parseLong(vUpdateGaji.txtIuranWajib.getText()));
            sg.setPajakPenghasilan(Long.parseLong(vUpdateGaji.txtPajakPenghasilan.getText()));
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date tanggal = new Date();
            String tglTerima = dateFormat.format(tanggal);
            sg.setTglTerimaGaji(tglTerima);
            sg.setTjgJabatan(Long.parseLong(vUpdateGaji.txtTjgJabatan.getText()));
            sg.setTjgKehadiran(Long.parseLong(vUpdateGaji.txtTjgKehadiran.getText()));
            sg.setTjgMasaKerja(Long.parseLong(vInputGaji.txtTjgMasaKerja.getText()));
            sg.setTjgPendidikan(Long.parseLong(vUpdateGaji.txtTjgPendidikan.getText()));
            sg.getTotalGaji();
            
           
            //Simpan perubahan ke dalam db            
            sh.update(sg);
            
            //refresh atau tampilkan ulang data ke dalam tabel
            this.fillTableListGaji();
            //hide view add pegawai
            vUpdateGaji.setVisible(false);
        }
    }
    
     private void deleteGaji() {
        //Mengkonfirmasi apakah benar akan didelete
        int status = JOptionPane.showConfirmDialog(vListGaji,
                "Apakah Anda yakin akan menghapus data ini?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        //Jika jawaban = yes, maka diproses
        if (status == JOptionPane.YES_OPTION) {
            //Membuat kelas yg menangani koneksi ke tabel mpegawai
            SlipGajiHelper sh = new SlipGajiHelper();
            //mengambil id_pegawai terpilih yang akan dihapus
            int idgaji = Integer.parseInt(this.vListGaji.tblDataGajiPegawai.getModel().getValueAt(
                    this.vListGaji.tblDataGajiPegawai.getSelectedRow(), 0).toString());
            //hapus dengan memanfaatkan Helper
            sh.delete(idgaji);
            //tampilkan ulang data ke tabel
            this.fillTableListGaji();
        }
    }
     private void fillTableListGaji() {
        //membuat kelas yang menangani koneksi ke tabel mpegawai
        SlipGajiHelper sh = new SlipGajiHelper();
        PegawaiHelper ph = new PegawaiHelper();
        //Mengambil seluruh data dari tabel mpegawai
        ArrayList listGaji = sh.getList();
        //Membuat header untuk jtabel
        String[] header = {"No","NIP","Nama","Gaji pokok","Tunjangan Jabatan","Tunjangan Kehadiran","Tunjangan Masa Kerja",
                           "Tunjangan Pendidikan","Iuran Wajib","Pajak Penghasilan","tgl Terima",
                           "Total Gaji"};
        //Membuat model untuk jtabel
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int no = 1;
        //MEngisi model dengan data yang dianbil dari tabel mpegawai
        for (Object o : listGaji) {
            EntitySlipGaji sg = (EntitySlipGaji) o;
            //menambahka/memasukan data ke model
            model.addRow(new Object[]{sg.getKodeSlip(),sg.getNIP(),sg.getPegawai().getNama(),sg.getGajiPokok(), sg.getTjgJabatan(),
                        sg.getTjgKehadiran(), sg.getTjgMasaKerja(), sg.getTjgPendidikan(),
                        sg.getIuranWajib(),sg.getPajakPenghasilan(),sg.getTglTerimaGaji(),
                        sg.getTotalGaji()});
        }
        //memasukan/menampilkan model di jtable
        this.vListGaji.tblDataGajiPegawai.setModel(model);
        //membuat kolom 0 (KodeSlip) di hidden
        this.vListGaji.tblDataGajiPegawai.getColumnModel().getColumn(0).setMinWidth(0);
        this.vListGaji.tblDataGajiPegawai.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
     
     
    @Override
    public void actionPerformed(ActionEvent e) {
        //dari vinput
        if(e.getSource()==vInputGaji.buttonSave){
            saveAddGaji();
        }
        else if(e.getSource()==vInputGaji.buttonCancel){
            vInputGaji.setVisible(false);           
        }
        else if(e.getSource()==vInputGaji.buttonLoad){
            
            PegawaiHelper ph = new PegawaiHelper();
            String nama = (String) vInputGaji.txtNip.getText();
            try{
            EntityPegawai pegawai = ph.get(nama);
            
            vInputGaji.txtNama.setText(pegawai.getNama());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(vInputGaji, "Maaf, Pegawai Tidak Terdaftar");
            }
            
            
            //vInputGaji.txtNama.setText(ph.get(vInputGaji.txtNip.getText()).toString());
        }
        //dari vupdate
        if(e.getSource()==vUpdateGaji.buttonSave){
            
            saveUpdateGaji();
        }
        else if(e.getSource()==vUpdateGaji.buttonCancel){
            vUpdateGaji.setVisible(false);
        }
        
        //dari list
        if(e.getSource()==vListGaji.buttonAdd){
            this.showSlipGaji();
        }
        else if(e.getSource()==vListGaji.buttonEdit){
            try{
                showViewUpdateGaji();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(vListGaji, "Klik baris yang akan diubah!");
            }
            
        }
        else if(e.getSource()==vListGaji.buttonCancel){
            vListGaji.setVisible(false);
            //showMenuUtama();
        }
        else if(e.getSource()==vListGaji.buttonDelete){
            deleteGaji();
        }
        
    }

    
    
}
