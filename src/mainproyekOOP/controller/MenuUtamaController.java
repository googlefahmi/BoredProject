/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.controller;
import mainproyekOOP.viewframe.ViewMenuUtama;
import mainproyekOOP.viewframe.ViewSelamatDatang;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import mainproyekOOP.viewframe.FormInputDataPeg;
import mainproyekOOP.viewframe.ViewAbsensiPegawai;
/**
 *
 * @author Faisal
 */
public class MenuUtamaController implements ActionListener{

    ViewMenuUtama vMenuCont;
   
    public MenuUtamaController() {
        vMenuCont = new ViewMenuUtama();
        vMenuCont.btnPenggajian.addActionListener(this);
        vMenuCont.btnAbsensi.addActionListener(this);
        vMenuCont.btnInputPegawai.addActionListener(this);
        vMenuCont.btnDaftarPegawai.addActionListener(this);
        vMenuCont.btnDataSekolah.addActionListener(this);
        vMenuCont.btnLogout.addActionListener(this);
        
    }
    //Tampil Menu Utama
    public void showMenuUtama(){
        vMenuCont.setVisible(true);
    }
    //Tampil Menu utama untuk petugas Gaji
    public void showMenuUtamaPGaji(){
        vMenuCont.setVisible(true);
        vMenuCont.btnPenggajian.setVisible(true);
        vMenuCont.btnAbsensi.setEnabled(false);
        vMenuCont.btnInputPegawai.setEnabled(false);
        vMenuCont.btnDaftarPegawai.setVisible(true);
        vMenuCont.btnDataSekolah.setVisible(true);
        vMenuCont.btnLogout.setVisible(true);
    }
    
    //Tampil Penggajian
    public void showPenggajian(){
        SlipGajiController vGaji = new SlipGajiController();
        vGaji.showListGaji();
    }
   
    //Tampil Absensi
    public void showAbsensi(){
        AbsensiController vAbsenPeg = new AbsensiController();
        vAbsenPeg.showViewListAbsensi();
    }
    
    //Tampil Data Pegawai PerOrangan
    public void showDataSatuPegawai(){
       InputDataPegController vDataSatuPeg = new InputDataPegController();
       vDataSatuPeg.showFormInputPeg();
        
    }
  
    //Tampil Data Pegawai Keseluruhan
    public void showDataPegawai(){
        InputDataPegController vDataPeg = new InputDataPegController();
        vDataPeg.showViewListPegawai();
    }
  
    //Tampil Sekilas Data Sekolah
    public void showDataSekolah(){
        
        DataSekolahController vDataSek = new DataSekolahController();
        vDataSek.showDataSekolah();
    }
    
    //Tampil menu selamat datang
    public void showSelamatDatang(){
        SelamatDatangController back = new SelamatDatangController();
        back.showSelamatDatangView();
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vMenuCont.btnPenggajian){
            //vMenuCont.setVisible(false);
            showPenggajian();
        }
        else if(e.getSource()==vMenuCont.btnAbsensi){
            //vMenuCont.setVisible(false);
            showAbsensi();
        }
        else if(e.getSource()==vMenuCont.btnDaftarPegawai){
            //vMenuCont.setVisible(false);
            showDataPegawai();
        }
        else if(e.getSource()==vMenuCont.btnInputPegawai){
            //vMenuCont.setVisible(false);
            showDataSatuPegawai();
        }
        else if(e.getSource()==vMenuCont.btnDataSekolah){
            vMenuCont.setVisible(false);
            showDataSekolah();
        }
        else if(e.getSource()==vMenuCont.btnLogout){
            vMenuCont.setVisible(false);
            showSelamatDatang();
           
        }
    }
    
}
