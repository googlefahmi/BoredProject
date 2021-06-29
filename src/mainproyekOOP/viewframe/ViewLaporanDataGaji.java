/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.viewframe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.text.html.parser.Entity;
import mainproyekOOP.controller.InputDataPegController;
import mainproyekOOP.entities.EntityPegawai;
import mainproyekOOP.helper.PegawaiHelper;
/**
 *
 * @author Faisal
 */
public class ViewLaporanDataGaji extends JFrame {
    public String id_Pegawai = "";
    public JLabel lblHeader = new JLabel("LAPORAN DATA GAJI PEGAWAI");
    public JTable tblDataGajiPegawai = new JTable();
    public JButton buttonCancel = new JButton("Batal");
    public JButton buttonAdd = new JButton("Tambah");
    public JButton buttonEdit = new JButton("Ubah");
    public JButton buttonDelete = new JButton("Hapus");
    public JButton buttonRefresh = new JButton("Refresh");
      
   
    public ViewLaporanDataGaji(){
        this.setTitle("Laporan Data Gaji Pegawai");
        this.setSize(1370,500);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.initComponents();
    }
    
    private void initComponents(){
              
        tblDataGajiPegawai = new JTable();
        JScrollPane pane = new JScrollPane(tblDataGajiPegawai,
                                           JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                               
        
        
        //set ukuran scrollpane
        pane.setBounds(5,100,1350,250);
        
        pane.getHorizontalScrollBar();
        //getContentpane
        this.getContentPane().add(pane);
        this.getContentPane().add(buttonCancel);
        this.getContentPane().add(lblHeader);
        this.getContentPane().add(buttonEdit);
        this.getContentPane().add(buttonAdd);
        this.getContentPane().add(buttonDelete);
        this.getContentPane().add(buttonRefresh);
        
        
        buttonCancel.setBounds(new Rectangle(1100, 400, 100, 40));
        buttonAdd.setBounds(new Rectangle(40, 400, 100, 40));
        buttonEdit.setBounds(new Rectangle(145, 400, 100, 40));
        buttonDelete.setBounds(new Rectangle(250, 400, 100, 40));
        buttonRefresh.setBounds(new Rectangle(355, 400, 100, 40));
        
        lblHeader.setFont( new Font("Tahoma",Font.BOLD,20));
        lblHeader.setBounds(360,20,400,30);
        
        //MEMBUAT BACKGROUND
        //Membuat image icon untuk background Frame/form
        URL locBg = ViewSelamatDatang.class.getResource("/res/app-bg.jpg");
        ImageIcon BgroundImg = new ImageIcon(locBg);
        //Membuat label berisi image icon yang akan dijadikan sebagai background
        JLabel lbgr = new JLabel(BgroundImg);
        //Menambahkan komponen label background ke tampilan
        this.getContentPane().add(lbgr);
        //Mensetting posisi dan ukuran label background
        lbgr.setBounds(0, 0, 1380, 500);
       
        
    }
    
    public static void main(String[] args) {
        ViewLaporanDataGaji aa = new ViewLaporanDataGaji();
        aa.setVisible(true);
    }
    
   
}
