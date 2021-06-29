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
import mainproyekOOP.entities.EntityDaftarAbsen;
import mainproyekOOP.entities.EntityPegawai;
import mainproyekOOP.helper.AbsensiHelper;
import mainproyekOOP.helper.PegawaiHelper;
import mainproyekOOP.viewframe.*;

/**
 *
 * @author Faisal
 */
public class AbsensiController implements ActionListener {
    
    ViewAbsensiPegawai vListAbsensiPeg;
    ViewAbsensiPegawai vAddAbsensi;
    ViewAbsensiPegawai vUpdateAbsensiPegawai;
    public AbsensiController() {
        //LIST
    vAddAbsensi = new ViewAbsensiPegawai();
    vAddAbsensi.btnSave.addActionListener(this);      
        //Add
    vListAbsensiPeg = new ViewAbsensiPegawai();
    vListAbsensiPeg.btnCancel.addActionListener(this);
    vListAbsensiPeg.btnRefresh.addActionListener(this);
    vListAbsensiPeg.btnEdit.addActionListener(this);
    vListAbsensiPeg.btnDelete.addActionListener(this);
    vListAbsensiPeg.btnSave.addActionListener(this);
    vListAbsensiPeg.btnLoad.addActionListener(this);
        //UPDATE
    vUpdateAbsensiPegawai = new ViewAbsensiPegawai();
    vUpdateAbsensiPegawai.btnSave.addActionListener(this);
    vUpdateAbsensiPegawai.btnCancel.addActionListener(this);
    vUpdateAbsensiPegawai.btnRefresh.addActionListener(this);
    vUpdateAbsensiPegawai.btnEdit.addActionListener(this);
    
    }
    
    public void showAbsensi(){
        vListAbsensiPeg.setVisible(true);
    }

    public void showMenuUtama(){
        MenuUtamaController backTo = new MenuUtamaController();
        backTo.showMenuUtama();
    }
    
    public void saveAddAbsensi() {
        //Lakukan validasi tidak boleh kosong
        
            //jika semua kolom isian sudah benar
            //Buat pegawai baru
            EntityDaftarAbsen ab = new EntityDaftarAbsen();
            //isi objek pegawai
            ab.setNIP(vListAbsensiPeg.tfNIP.getText());
            ab.setTglAbsen(vListAbsensiPeg.tfTanggal.getText());
            ab.setJamMasuk(vListAbsensiPeg.tfJmMsk.getText());
            ab.setJamKeluar(vListAbsensiPeg.tfJmKluar.getText());
            if(vListAbsensiPeg.rbHadir.isSelected()){
                ab.setKehadiran("HADIR");
            }
            else{
                ab.setKehadiran("TIDAK HADIR");
            }
            ab.setKeterangan(vListAbsensiPeg.taKeterangan.getText());
            
          
            AbsensiHelper ah = new AbsensiHelper();
            ah.save(ab);
            this.fillTableListAbsensi();
            //hide view add pegawai
            
        }
  
    
      
    //Controll untuk perubahan data
    public void showViewUpdateAbsensi() {
        
        //mengambil id_pegawai terpilih yang akan diupdate
        int idAbsen = (Integer.parseInt((String) this.vListAbsensiPeg.tbAbsensi.getModel().getValueAt(
                this.vListAbsensiPeg.tbAbsensi.getSelectedRow(), 0)));
        //Mengambil data pegawai yang akan diedit dari db
        AbsensiHelper ah = new AbsensiHelper();
        EntityDaftarAbsen ab = ah.get(idAbsen);
        
        
        if (ab != null) {
            //Jika Data p tidak kosong maka tampilakan di frame update data
            vUpdateAbsensiPegawai.tfNIP.setText(ab.getNIP());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date tanggal = new Date();
            String tglAbsen = dateFormat.format(tanggal);
            ab.setTglAbsen(tglAbsen);
            vUpdateAbsensiPegawai.tfJmMsk.setText(ab.getJamMasuk());
            vUpdateAbsensiPegawai.tfJmKluar.setText(ab.getJamKeluar());
            if(ab.getKehadiran().equalsIgnoreCase("HADIR")){
                vUpdateAbsensiPegawai.rbHadir.setSelected(true);
            }
            else if(ab.getKehadiran().equalsIgnoreCase("TIDAK HADIR")){
                vUpdateAbsensiPegawai.rbTdkHadir.setSelected(true);
            }
            vUpdateAbsensiPegawai.taKeterangan.setText(ab.getKeterangan());
            
   
            //MEnampilkan form/frame update data pegawai        
            vUpdateAbsensiPegawai.setVisible(true);
        }
    }
    
    public void saveUpdateAbsensi(){
         
            EntityDaftarAbsen ab = new EntityDaftarAbsen();
            AbsensiHelper ah = new AbsensiHelper();
            //isi objek pegawai
            ab.setNIP(vUpdateAbsensiPegawai.tfNIP.getText());
            ab.setTglAbsen(vUpdateAbsensiPegawai.tfTanggal.getText());
            ab.setJamMasuk(vUpdateAbsensiPegawai.tfJmMsk.getText());
            ab.setJamKeluar(vUpdateAbsensiPegawai.tfJmKluar.getText());
            if(vUpdateAbsensiPegawai.rbHadir.isSelected()){
                ab.setKehadiran("HADIR");
            }
            else{
                ab.setKehadiran("TIDAK HADIR");
            }
            ab.setKeterangan(vUpdateAbsensiPegawai.taKeterangan.getText());
            
          
            
            ah.update(ab);
            this.fillTableListAbsensi();
            //hide view add pegawai
        
    }
    private void fillTableListAbsensi() {
       //membuat kelas yang menangani koneksi ke tabel mpegawai
        AbsensiHelper ah = new AbsensiHelper();
        //Mengambil seluruh data dari tabel mpegawai
        ArrayList listPegawai = ah.getList();
        //Membuat header untuk jtabel
        String[] header = {"No","NIP","Nama","Tanggal","Kehadiran","Jam Masuk",
                           "Jam Keluar","Keterangan"};
        PegawaiHelper ph = new PegawaiHelper();
        
        //Membuat model untuk jtabel
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int no = 1;
        //MEngisi model dengan data yang dianbil dari tabel mpegawai
        for (Object o : listPegawai) {
            //EntityPegawai peg = (EntityPegawai)o;
            EntityDaftarAbsen dftAbsen = (EntityDaftarAbsen) o;
            
            //menambahkan/memasukan data ke model
            model.addRow(new Object[]{dftAbsen.getIdAbsensi(), dftAbsen.getNIP(),
                                      dftAbsen.getPegawai().getNama(),dftAbsen.getTglAbsen(), 
                                      dftAbsen.getKehadiran(), dftAbsen.getJamMasuk(),
                                      dftAbsen.getJamKeluar(), dftAbsen.getKeterangan()});
                        
        }
        //memasukan/menampilkan model di jtable
        this.vListAbsensiPeg.tbAbsensi.setModel(model);
        //membuat kolom 0 (idPEgawai) di hidden
        this.vListAbsensiPeg.tbAbsensi.getColumnModel().getColumn(0).setMinWidth(0);
        this.vListAbsensiPeg.tbAbsensi.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
     //Controll untuk menampilkan list data
    public void showViewListAbsensi() {
        //memanggil method untuk mengisi tabel dengan data dari db
        this.fillTableListAbsensi();
        //MEnampilkan form/frame data absensi       
        vListAbsensiPeg.setVisible(true);
    }
    
    private void deleteAbsensi() {
        //Mengkonfirmasi apakah benar akan didelete
        int status = JOptionPane.showConfirmDialog(vListAbsensiPeg,
                "Apakah Anda yakin akan menghapus data ini?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        //Jika jawaban = yes, maka diproses
        if (status == JOptionPane.YES_OPTION) {
            //Membuat kelas yg menangani koneksi ke tabel mpegawai
            AbsensiHelper ah = new AbsensiHelper();
            //mengambil id_pegawai terpilih yang akan dihapus
            int idAbsen = Integer.parseInt(this.vListAbsensiPeg.tbAbsensi.getModel().getValueAt(
                    this.vListAbsensiPeg.tbAbsensi.getSelectedRow(), 0).toString());
            //hapus dengan memanfaatkan Helper
            ah.delete(idAbsen);
            //tampilkan ulang data ke tabel
            this.fillTableListAbsensi();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //List
        //event mapping untuk komponen vAddAbsensi
        if(e.getSource()==vListAbsensiPeg.btnSave){           
            saveAddAbsensi();
        }
        
       //event mapping untuk komponen viewListAbsensi
        if (e.getSource() == vListAbsensiPeg.btnRefresh) {
            
            this.showViewListAbsensi();
        }else if (e.getSource() == vListAbsensiPeg.btnDelete) {
            try{
                deleteAbsensi();
            }catch(Exception edt){
                JOptionPane.showMessageDialog(vListAbsensiPeg, "Klik baris yang akan dihapus!");
            }
        }
        else if (e.getSource() == vListAbsensiPeg.btnEdit) {
            
            showViewUpdateAbsensi();
        }else if(e.getSource() == vListAbsensiPeg.btnLoad){
            PegawaiHelper ph = new PegawaiHelper();
            String nama = (String) vListAbsensiPeg.tfNIP.getText();
            try{
            EntityPegawai pegawai = ph.get(nama);
            
            vListAbsensiPeg.tfNama.setText(pegawai.getNama());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(vListAbsensiPeg, "Maaf, Pegawai Tidak Terdaftar");
            }
        }
        else if (e.getSource() == vListAbsensiPeg.btnCancel){
            vListAbsensiPeg.setVisible(false);
            //showMenuUtama();
        }
            
        //event mapping untuk komponen viewUpdatePegawai
        if (e.getSource() == vUpdateAbsensiPegawai.btnSave) {
            saveUpdateAbsensi();
        }
        else if (e.getSource() == vUpdateAbsensiPegawai.btnRefresh) {
            showViewListAbsensi();
        }
        else if (e.getSource() == vUpdateAbsensiPegawai.btnCancel) {
            showViewListAbsensi();
        }
    }

    
}


    
    
    
    
    
    
    
       
  