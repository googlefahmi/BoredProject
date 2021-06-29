/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainproyekOOP.viewframe.ViewMenuUtama;

/**
 *
 * @author USER
 */
public class MenuPetugasAbsensiController implements ActionListener {
    ViewMenuUtama vMenuContAbsensi = new ViewMenuUtama();
    public MenuPetugasAbsensiController() {
        
    vMenuContAbsensi.btnAbsensi.addActionListener(this);
    vMenuContAbsensi.btnDaftarPegawai.addActionListener(this);
    vMenuContAbsensi.btnDataSekolah.addActionListener(this);
    vMenuContAbsensi.btnLogout.addActionListener(this);
        
    vMenuContAbsensi.btnInputPegawai.setVisible(false);
    vMenuContAbsensi.btnPenggajian.setVisible(false);   
    vMenuContAbsensi.btnAbsensi.setVisible(true);
    vMenuContAbsensi.btnDaftarPegawai.setVisible(true);
    vMenuContAbsensi.btnDataSekolah.setVisible(true);
    vMenuContAbsensi.btnLogout.setVisible(true);
    }
    
    
    //Tampil Menu Utama
  
    public void showMenuUtama(){
        vMenuContAbsensi.setVisible(true);
    }
   
    
    //Tampil Penggajian

    public void showAbsensi(){
        AbsensiController vAbsensi = new AbsensiController();
        vAbsensi.showAbsensi();
    }
   
    //Tampil Data Pegawai Keseluruhan

    public void showDataPegawai(){
        InputDataPegController vDataPeg = new InputDataPegController();      
        vDataPeg.showListPegawaiForUser();
    }
    
    //Tampil Sekilas Data Sekolah

    public void showDataSekolah(){
        
        DataSekolahController vDataSek = new DataSekolahController();
        vDataSek.showDataSekolah();
    }
    
    private void showSelamatDatang() {
       SelamatDatangController back = new SelamatDatangController();
        back.showSelamatDatangView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vMenuContAbsensi.btnAbsensi){
            showAbsensi();
        }
        else if(e.getSource()==vMenuContAbsensi.btnDaftarPegawai){
            showDataPegawai();
        }
        else if(e.getSource()==vMenuContAbsensi.btnDataSekolah){
            showDataSekolah();
        }
        else if(e.getSource()==vMenuContAbsensi.btnLogout){
            vMenuContAbsensi.setVisible(false);
            showSelamatDatang();
        }
    }

}
