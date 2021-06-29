/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import mainproyekOOP.entities.EntityPegawai;
import mainproyekOOP.helper.PegawaiHelper;
import mainproyekOOP.viewframe.FormInputDataPeg;
import mainproyekOOP.viewframe.ViewLaporanDataPegawai;

/**
 *
 * @author Faisal
 */
public class InputDataPegController implements ActionListener {
    
    
    FormInputDataPeg vInputDaPeg;
    FormInputDataPeg vUpdateDaPeg;
    ViewLaporanDataPegawai vListPegawai;
    public InputDataPegController() {
        //inisialisasi tampilan masukan data pegawai
        vInputDaPeg = new FormInputDataPeg();
        vInputDaPeg.buttonSave.addActionListener(this);
        vInputDaPeg.buttonCancel.addActionListener(this);
        
        //inisialsisasi tampilan list pegawai
        vListPegawai = new ViewLaporanDataPegawai();
        vListPegawai.buttonAdd.addActionListener(this);
        vListPegawai.buttonDelete.addActionListener(this);
        vListPegawai.buttonEdit.addActionListener(this);
        vListPegawai.buttonCancel.addActionListener(this);
        vListPegawai.buttonRefresh.addActionListener(this);
        
        //inisialisasi tampilan update pegawai
        vUpdateDaPeg = new FormInputDataPeg();
        vUpdateDaPeg.buttonSave.addActionListener(this);
        vUpdateDaPeg.buttonCancel.addActionListener(this);
    
    }
    
    public void showListPegawaiForUser(){
        vListPegawai.buttonCancel.setVisible(true);
        vListPegawai.buttonAdd.setVisible(false);
        vListPegawai.buttonDelete.setVisible(false);
        vListPegawai.buttonEdit.setVisible(false);
        vListPegawai.buttonRefresh.setVisible(false);
        vListPegawai.setVisible(true);
        fillTableListPegawai();
        
    }
    
    public void showFormInputPeg(){
        vInputDaPeg.setVisible(true);
    }
    
    public void showMenuUtama(){
        MenuUtamaController vMenu = new MenuUtamaController();
        vMenu.showMenuUtama();
    }

    public void saveAddPegawai() {
        //Lakukan validasi tidak boleh kosong
        if (vInputDaPeg.txtNama.getText().isEmpty()) {
            //jika nama kosong
            JOptionPane.showMessageDialog(vInputDaPeg, "Kolom nama tidak boleh kosong!");
        } else if (vInputDaPeg.taAlamat.getText().isEmpty()) {
            //jika alamat kosong
            JOptionPane.showMessageDialog(vInputDaPeg, "Kolom alamat tidak boleh kosong!");
        } else if (vInputDaPeg.txtNip.getText().isEmpty()){
            //jika NIP kosong
            JOptionPane.showMessageDialog(vInputDaPeg, "Kolom NIP tidak boleh kosong!");
        } else if (vInputDaPeg.txtPendidikan.getText().isEmpty()){
            //jika pendidikan akhir kosong
            JOptionPane.showMessageDialog(vInputDaPeg, "Kolom Pendidikan tidak boleh kosong!");
        } else if (vInputDaPeg.txtStatus.getText().isEmpty()){
            //jika status kosong
            JOptionPane.showMessageDialog(vInputDaPeg, "Kolom Status tidak boleh kosong!");
        } else if (vInputDaPeg.txtTempatLahir.getText().isEmpty()){
            //jika tempat lahir kosong
            JOptionPane.showMessageDialog(vInputDaPeg, "Kolom tempat lahir tidak boleh kosong!");
        } else {
            //jika semua kolom isian sudah benar
            //Buat pegawai baru
            EntityPegawai p = new EntityPegawai();
            //isi objek pegawai
            p.setNIP(vInputDaPeg.txtNip.getText());
            p.setNama(vInputDaPeg.txtNama.getText());           
            p.setTempatLahir(vInputDaPeg.txtTempatLahir.getText());
            
            int thn = Integer.parseInt(vInputDaPeg.cbThnLahir.getSelectedItem().toString())-1900;
            int bln = vInputDaPeg.cbBlnLahir.getSelectedIndex();
            int tgl = Integer.parseInt(vInputDaPeg.cbTglLahir.getSelectedItem().toString());
            
            Date tglLahir = new Date(thn,bln,tgl);
            p.setTanggalLahir(tglLahir);
            
           
            if (vInputDaPeg.rL.isSelected()) {
                p.setJenisKelamin("L");
            } else {
                p.setJenisKelamin("P");
            }
            p.setAlamat(vInputDaPeg.taAlamat.getText());
            //cobacoba
           
            p.setNoTelp(vInputDaPeg.txtNoTelp.getText());
            p.setAgama(vInputDaPeg.cboxAgama.getSelectedItem().toString());
            p.setStatus(vInputDaPeg.txtStatus.getText());
            p.setIdJabatan(Integer.parseInt(vInputDaPeg.txtJabatan.getText()));
            p.setGajiPokok(Long.parseLong(vInputDaPeg.txtGajiPokok.getText()));           
            p.setPendidikanAkhir(vInputDaPeg.txtPendidikan.getText());
            
            int thnMsuk = Integer.parseInt(vInputDaPeg.cbThnMsk.getSelectedItem().toString())-1900;
            int blnMsuk = vInputDaPeg.cbBlnMsk.getSelectedIndex();
            int tglMsuk = Integer.parseInt(vInputDaPeg.cbTglMsk.getSelectedItem().toString());
            Date tglMasuk = new Date(thnMsuk,blnMsuk,tglMsuk);
            
            p.setTanggalMasuk(tglMasuk);
            
            PegawaiHelper ph = new PegawaiHelper();
            ph.save(p);
            this.fillTableListPegawai();
            //hide view add pegawai
            vInputDaPeg.setVisible(false);
        }
    }

    //Controll untuk perubahan data
    public void showViewUpdatePegawai() {
        //mengambil id_pegawai terpilih yang akan diupdate
        String idpeg = (String) this.vListPegawai.tblDataPegawai.getModel().getValueAt(
                this.vListPegawai.tblDataPegawai.getSelectedRow(), 0);
        //Mengambil data pegawai yang akan diedit dari db
        PegawaiHelper ph = new PegawaiHelper();
        EntityPegawai p = ph.get(idpeg);
        
        
        if (p != null) {
            //Jika Data p tidak kosong maka tampilakan di frame update data

            vUpdateDaPeg.txtNip.setText(p.getNIP());
            vUpdateDaPeg.txtNama.setText(p.getNama());
            vUpdateDaPeg.txtStatus.setText(p.getStatus());
            if(p.getJenisKelamin().equalsIgnoreCase("L")){
                vUpdateDaPeg.rL.setSelected(true);
            }else{
                vUpdateDaPeg.rP.setSelected(true);
            }
            vUpdateDaPeg.taAlamat.setText(p.getAlamat());
            vUpdateDaPeg.cboxAgama.setSelectedItem(p.getAgama());           
            vUpdateDaPeg.txtTempatLahir.setText(p.getTempatLahir());
            Date tglLahir = p.getTanggalLahir();            
            vUpdateDaPeg.cbTglLahir.setSelectedItem(tglLahir.getDate());
            vUpdateDaPeg.cbBlnLahir.setSelectedIndex(tglLahir.getMonth());
            vUpdateDaPeg.cbThnLahir.setSelectedIndex(tglLahir.getYear());
            vUpdateDaPeg.txtNoTelp.setText(p.getNoTelp());
            vUpdateDaPeg.txtStatus.setText(p.getStatus());
            vUpdateDaPeg.txtJabatan.setText(String.valueOf(p.getIdJabatan()));
            vUpdateDaPeg.txtPendidikan.setText(p.getPendidikanAkhir());
            vUpdateDaPeg.txtGajiPokok.setText(String.valueOf(p.getGajiPokok()));
            Date tglMasuk = p.getTanggalMasuk();
            vUpdateDaPeg.cbTglMsk.setSelectedItem(tglMasuk.getDate());
            vUpdateDaPeg.cbBlnMsk.setSelectedIndex(tglMasuk.getMonth());
            vUpdateDaPeg.cbThnMsk.setSelectedIndex(tglMasuk.getYear());
   
            //MEnampilkan form/frame update data pegawai        
            vUpdateDaPeg.setVisible(true);
        }
    }
    
    public void cancelUpdatePegawai() {
        vUpdateDaPeg.setVisible(false);
    }

    
    public void saveUpdatePegawai() {
        //Lakukan validasi tidak boleh kosong
        if (vUpdateDaPeg.txtNama.getText().isEmpty()) {
            //jika nama kosong
            JOptionPane.showMessageDialog(vUpdateDaPeg, "Kolom nama tidak boleh kosong!");
        } else if (vUpdateDaPeg.taAlamat.getText().isEmpty()) {
            //jika alamat kosong
            JOptionPane.showMessageDialog(vUpdateDaPeg, "Kolom alamat tidak boleh kosong!");
        } else if (vUpdateDaPeg.txtNip.getText().isEmpty()){
            //jika NIP kosong
            JOptionPane.showMessageDialog(vUpdateDaPeg, "Kolom NIP tidak boleh kosong!");
        } else if (vUpdateDaPeg.txtPendidikan.getText().isEmpty()){
            //jika pendidikan akhir kosong
            JOptionPane.showMessageDialog(vUpdateDaPeg, "Kolom Pendidikan tidak boleh kosong!");
        } else if (vUpdateDaPeg.txtStatus.getText().isEmpty()){
            //jika status kosong
            JOptionPane.showMessageDialog(vUpdateDaPeg, "Kolom Status tidak boleh kosong!");
        }  else if (vUpdateDaPeg.txtTempatLahir.getText().isEmpty()){
            //jika tempat lahir kosong
            JOptionPane.showMessageDialog(vUpdateDaPeg, "Kolom tempat lahir tidak boleh kosong!");
        } 
        
        else {
            //jika semua kolom isian sudah benar
            //Buat helper mpegawai
            PegawaiHelper ph = new PegawaiHelper();
            //ambil objek yang mau diupdate dari db
             
            EntityPegawai p = ph.get(vUpdateDaPeg.txtNip.getText());
            //perbaharui isi objek pegawai
            p.setNIP(vUpdateDaPeg.txtNip.getText());
            p.setNama(vUpdateDaPeg.txtNama.getText());
            p.setAlamat(vUpdateDaPeg.taAlamat.getText());
            if (vUpdateDaPeg.rL.isSelected()) {
                p.setJenisKelamin("L");
            } else {
                p.setJenisKelamin("P");
            }
            p.setTempatLahir(vUpdateDaPeg.txtTempatLahir.getText());
            
            int thn = Integer.parseInt(vUpdateDaPeg.cbThnLahir.getSelectedItem().toString())-1900;
            int bln = vUpdateDaPeg.cbBlnLahir.getSelectedIndex();
            int tgl = Integer.parseInt(vUpdateDaPeg.cbTglLahir.getSelectedItem().toString());
            
            Date tglLahir = new Date(thn,bln,tgl);
            
            p.setTanggalLahir(tglLahir);            
            p.setNoTelp(vUpdateDaPeg.txtNoTelp.getText());
            p.setAgama(vUpdateDaPeg.cboxAgama.getSelectedItem().toString());
            p.setGajiPokok(Integer.parseInt(vUpdateDaPeg.txtGajiPokok.getText()));
            p.setIdJabatan(Integer.parseInt(vUpdateDaPeg.txtJabatan.getText()));
            p.setStatus(vUpdateDaPeg.txtStatus.getText());
            p.setPendidikanAkhir(vUpdateDaPeg.txtPendidikan.getText());
            
            int thnMsuk = Integer.parseInt(vUpdateDaPeg.cbThnMsk.getSelectedItem().toString())-1900;
            int blnMsuk = vUpdateDaPeg.cbBlnMsk.getSelectedIndex();
            int tglMsuk = Integer.parseInt(vUpdateDaPeg.cbTglMsk.getSelectedItem().toString());
            Date tglMasuk = new Date(thnMsuk,blnMsuk,tglMsuk);
            p.setTanggalMasuk(tglMasuk);
            
           
            //Simpan perubahan ke dalam db            
            ph.update(p);
            
            //refresh atau tampilkan ulang data ke dalam tabel
            this.fillTableListPegawai();
            //hide view add pegawai
            vUpdateDaPeg.setVisible(false);
        }
    }
    
    private void fillTableListPegawai() {
        //membuat kelas yang menangani koneksi ke tabel mpegawai
        PegawaiHelper ph = new PegawaiHelper();
        //Mengambil seluruh data dari tabel mpegawai
        ArrayList listPegawai = ph.getList();
        //Membuat header untuk jtabel
        String[] header = {"NIP","Nama","Status","Alamat","L/P","Agama",
                           "Tempat Lahir","Tanggal Lahir","No. Telp","ID Jabatan",
                           "Pendidikan Akhir","Gaji Pokok","Tanggal Masuk"};
        //Membuat model untuk jtabel
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int no = 1;
        //MEngisi model dengan data yang dianbil dari tabel mpegawai
        for (Object o : listPegawai) {
            EntityPegawai p = (EntityPegawai) o;
            //menambahkan/memasukan data ke model
            model.addRow(new Object[]{p.getNIP(), p.getNama(),p.getStatus(), p.getAlamat(),
                        p.getJenisKelamin(), p.getAgama(), p.getTempatLahir(),
                        p.getTanggalLahir(),p.getNoTelp(),p.getIdJabatan(),
                        p.getPendidikanAkhir(),p.getGajiPokok(),p.getTanggalMasuk()});
        }
        //memasukan/menampilkan model di jtable
        this.vListPegawai.tblDataPegawai.setModel(model);
        //membuat kolom 0 (idPEgawai) di hidden
        //this.vListPegawai.tblDataPegawai.getColumnModel().getColumn(0).setMinWidth(0);
        //this.vListPegawai.tblDataPegawai.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    
    //Controll untuk menampilkan list data
    public void showViewListPegawai() {
        //memanggil method untuk mengisi tabel dengan data dari db
        this.fillTableListPegawai();
        //MEnampilkan form/frame data pegawai        
        vListPegawai.setVisible(true);
    }
    
    private void deletePegawai() {
        //Mengkonfirmasi apakah benar akan didelete
        int status = JOptionPane.showConfirmDialog(vListPegawai,
                "Apakah Anda yakin akan menghapus data ini?", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        //Jika jawaban = yes, maka diproses
        if (status == JOptionPane.YES_OPTION) {
            //Membuat kelas yg menangani koneksi ke tabel mpegawai
            PegawaiHelper ph = new PegawaiHelper();
            //mengambil id_pegawai terpilih yang akan dihapus
            String idpeg = (String) this.vListPegawai.tblDataPegawai.getModel().getValueAt(
                    this.vListPegawai.tblDataPegawai.getSelectedRow(), 0);
            //hapus dengan memanfaatkan Helper
            ph.delete(idpeg);
            //tampilkan ulang data ke tabel
            this.fillTableListPegawai();
        }
    }

    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        //event mapping untuk komponen vInputDaPeg
        if(e.getSource()==vInputDaPeg.buttonSave){           
            saveAddPegawai();
            //JOptionPane.showMessageDialog(null, "Data Disimpan");
        }
        else if(e.getSource()==vInputDaPeg.buttonCancel){           
            vInputDaPeg.setVisible(false);
            
        }
       //event mapping untuk komponen viewListPegawai
        if (e.getSource() == vListPegawai.buttonAdd) {
            this.showFormInputPeg();
        } else if (e.getSource() == vListPegawai.buttonEdit) {
            try{
                showViewUpdatePegawai();
            }catch(Exception edt){
                JOptionPane.showMessageDialog(vUpdateDaPeg, "Klik baris yang akan diubah!");
            }
            
        } else if (e.getSource() == vListPegawai.buttonDelete) {
            try{
                deletePegawai();
            }catch(Exception edt){
                JOptionPane.showMessageDialog(vUpdateDaPeg, "Klik baris yang akan diubah!");
            }
            
        } else if (e.getSource() == vListPegawai.buttonCancel) {
            vListPegawai.setVisible(false);
            //showMenuUtama();
        } else if(e.getSource() == vListPegawai.buttonRefresh){
            vListPegawai.setVisible(false);
            showViewListPegawai();
        }
        //event mapping untuk komponen viewUpdatePegawai
        if (e.getSource() == vUpdateDaPeg.buttonSave) {
            saveUpdatePegawai();
        } else if (e.getSource() == vUpdateDaPeg.buttonCancel) {
            cancelUpdatePegawai();
        }
    }
    
}
