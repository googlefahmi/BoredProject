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
public class MenuPetugasGajiController implements ActionListener{

    ViewMenuUtama vMenuContGaji = new ViewMenuUtama();
    public MenuPetugasGajiController() {
    
    vMenuContGaji.btnPenggajian.addActionListener(this);
    vMenuContGaji.btnDaftarPegawai.addActionListener(this);
    vMenuContGaji.btnDataSekolah.addActionListener(this);
    vMenuContGaji.btnLogout.addActionListener(this);
    
    vMenuContGaji.btnAbsensi.setVisible(false);
    vMenuContGaji.btnInputPegawai.setVisible(false);
    vMenuContGaji.btnPenggajian.setVisible(true);
    vMenuContGaji.btnDaftarPegawai.setVisible(true);
    vMenuContGaji.btnDataSekolah.setVisible(true);
    vMenuContGaji.btnLogout.setVisible(true);
    }

    //Tampil Menu Utama
  
    public void showMenuUtama(){
        vMenuContGaji.setVisible(true);
    }
   
    
    //Tampil Penggajian

    public void showPenggajian(){
        SlipGajiController vGaji = new SlipGajiController();
        vGaji.showListGaji();
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
        if(e.getSource()==vMenuContGaji.btnPenggajian){
            showPenggajian();
        }
        else if(e.getSource()==vMenuContGaji.btnDaftarPegawai){
            showDataPegawai();
        }
        else if(e.getSource()==vMenuContGaji.btnDataSekolah){
            showDataSekolah();
        }
        else if(e.getSource()==vMenuContGaji.btnLogout){
            vMenuContGaji.setVisible(false);
            showSelamatDatang();
        }
    }

    
}
