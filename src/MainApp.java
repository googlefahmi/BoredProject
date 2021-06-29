

import mainproyekOOP.controller.MenuUtamaController;
import mainproyekOOP.helper.KoneksiDatabase;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faisal
 */
public class MainApp {
    public static void main(String[] args) {
      
       MenuUtamaController mUtama = new MenuUtamaController();
       mUtama.showMenuUtama();
        
         
       
        
        /*
        KoneksiDatabase a = new KoneksiDatabase();
        a.connect();
        if(a.connect()!=true){
            System.out.println("Gagal");
        }
        else{
            System.out.println("Berhasil");
        }
         * 
         */
          
         
    }
}
