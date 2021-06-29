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
import mainproyekOOP.entities.EntityDaftarAbsen;
import mainproyekOOP.entities.EntityPegawai;
/**
 *
 * @author USER
 */
public class AbsensiHelper extends KoneksiDatabase {
    public boolean save(EntityDaftarAbsen ab) {
        //Buat SQL untuk menyimpan data 
        String sql = "INSERT INTO Tb_Daftar_Absen(NIP,Tanggal,Jam_Masuk,Jam_Keluar,"
                    + "Kehadiran,Keterangan)"
                    + "VALUES(?,?,?,?,?,?)";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         
            ps.setString(1, ab.getNIP());
            ps.setString(2, ab.getTglAbsen());
            ps.setString(3, ab.getJamMasuk());
            ps.setString(4, ab.getJamKeluar());
            ps.setString(5, ab.getKehadiran());            
            ps.setString(6, ab.getKeterangan());
            
           
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            //Mengambil nilai auto_Increment jika ada
            
            ResultSet autoNumbers = ps.getGeneratedKeys();//menampung hasil dari ekseskusi sebuah statement
            if (autoNumbers.next()) {
                this.newId = autoNumbers.getInt(1);
                ab.setIdAbsensi(this.newId);
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
    
    //SQL Untuk Update Data
    public boolean update(EntityDaftarAbsen ab) {
        //Buat SQL untuk menyimpan data 
        String sql = "UPDATE Tb_Daftar_Absen SET NIP=?,Tanggal=?,Jam_Masuk=?,Jam_Keluar=?,"
                    + "Kehadiran=?,Keterangan=? WHERE Kode_Absensi = ?";

                
                
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ab.getNIP());
            ps.setString(2, ab.getTglAbsen());
            ps.setString(3, ab.getJamMasuk());
            ps.setString(4, ab.getJamKeluar());
            ps.setString(5, ab.getKehadiran());            
            ps.setString(6, ab.getKeterangan());
            ps.setInt(7, ab.getIdAbsensi());
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
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
    
    //SQL untuk hapus data
    public boolean delete(int kodeAbsensi) {
        //Buat SQL untuk menghapus data        
        String sql = "DELETE FROM Tb_Daftar_Absen WHERE kode_Absensi=?";
        int count = 0;
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, kodeAbsensi);
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            this.disconnect();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    

     public EntityDaftarAbsen get(int kodeAbsensi) {
        EntityDaftarAbsen m = null;
        //Buat SQL untuk membaca data Pegawai
        String sql = "SELECT * FROM tb_Daftar_absen sg LEFT JOIN Tb_Pegawai p ON sg.NIP = p.NIP WHERE kode_Absensi=?";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, kodeAbsensi);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            if (rs.next()) {
                m = new EntityDaftarAbsen();
                m.setIdAbsensi(rs.getInt("kode_Absensi"));
                m.setNIP(rs.getString("NIP"));
                m.setTglAbsen(rs.getString("Tanggal"));
                m.setJamMasuk(rs.getString("Jam_Masuk"));
                m.setJamKeluar(rs.getString("Jam_Keluar"));
                m.setKehadiran(rs.getString("Kehadiran"));
                m.setKeterangan(rs.getString("Keterangan"));
                
                EntityPegawai p = new EntityPegawai();
                p.setNama(rs.getString("Nama"));
                m.setPegawai(p);
                
                
            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return m;
    }


public ArrayList<EntityDaftarAbsen> getList() {
        ArrayList<EntityDaftarAbsen> list = new ArrayList<EntityDaftarAbsen>();
        String sql = "SELECT * FROM Tb_Daftar_Absen sg LEFT JOIN Tb_Pegawai p ON sg.NIP = p.NIP";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            while (rs.next()) {
                EntityDaftarAbsen m = new EntityDaftarAbsen();
                m.setIdAbsensi(rs.getInt("kode_Absensi"));
                m.setNIP(rs.getString("NIP"));
                m.setTglAbsen(rs.getString("Tanggal"));
                m.setJamMasuk(rs.getString("Jam_Masuk"));
                m.setJamKeluar(rs.getString("Jam_Keluar"));
                m.setKehadiran(rs.getString("Kehadiran"));
                m.setKeterangan(rs.getString("Keterangan"));
                
                EntityPegawai p = new EntityPegawai();
                p.setNama(rs.getString("Nama"));
                m.setPegawai(p);
                //masukan ke dalam list
                list.add(m);

            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }


}
