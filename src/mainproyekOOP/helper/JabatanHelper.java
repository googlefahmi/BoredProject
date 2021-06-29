/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mainproyekOOP.entities.EntityJabatan;
/**
 *
 * @author Faisal
 */
public class JabatanHelper extends KoneksiDatabase {
    public boolean save(EntityJabatan p) {
        //Buat SQL untuk menyimpan data 
        String sql = "INSERT INTO Tb_Jabatan(ID_Jabatan,Nama_Jabatan)"
                    +"values(?,?)";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, p.getIdJabatan());
            ps.setString(2, p.getNamaJabatan());
            
            
            
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            //Mengambil nilai auto_Increment jika ada
            ResultSet autoNumbers = ps.getGeneratedKeys();
            if (autoNumbers.next()) {
                this.newId = autoNumbers.getInt(1);
                p.setIdJabatan(this.newId);
            } 
            //Tutup Koneksi
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
