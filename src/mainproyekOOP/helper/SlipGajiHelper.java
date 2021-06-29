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
import java.util.*;
import java.sql.*;
import mainproyekOOP.entities.EntityPegawai;
import mainproyekOOP.entities.EntitySlipGaji;
/**
 *
 * @author Faisal
 */
public class SlipGajiHelper extends KoneksiDatabase {
    public boolean save(EntitySlipGaji p) {
        //Buat SQL untuk menyimpan data 
        String sql = "INSERT INTO Tb_Slip_Gaji(NIP,Gaji_Pokok,Tunjangan_Jabatan,Tunjangan_Kehadiran,Tunjangan_MasaKerja,"
                    + "Tunjangan_Pendidikan,Pajak_Penghasilan,Iuran_Wajib_Pegawai,Tanggal_Penerimaan_Gaji,Total_Gaji)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, p.getNIP());
            ps.setLong(2, p.getGajiPokok());
            ps.setLong(3, p.getTjgJabatan());
            ps.setLong(4, p.getTjgKehadiran());
            ps.setLong(5, p.getTjgMasaKerja());
            ps.setLong(6, p.getTjgPendidikan());            
            ps.setLong(7, p.getPajakPenghasilan());
            ps.setLong(8, p.getIuranWajib());
            ps.setString(9, p.getTglTerimaGaji());
            ps.setLong(10, p.getTotalGaji());
            
            
            
            //Eksekusi sql yang sudah dibuat
            count = ps.executeUpdate();
            //Mengambil nilai auto_Increment jika ada
            /*
            ResultSet autoNumbers = ps.getGeneratedKeys();
            if (autoNumbers.next()) {
                this.newId = autoNumbers.getInt(1);
                p.setNIP(""+this.newId);
            } 
             * 
             */
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
    
    public boolean update(EntitySlipGaji p) {
        //Buat SQL untuk menyimpan data 
        String sql = "UPDATE Tb_Slip_Gaji SET NIP=?,Gaji_Pokok=?,Tunjangan_Jabatan=?,Tunjangan_Kehadiran=?,"
                    + "Tunjangan_MasaKerja=?,Tunjangan_Pendidikan=?,Pajak_Penghasilan=?,Iuran_Wajib_Pegawai=?,"
                    + "Tanggal_Penerimaan_Gaji=?,Total_Gaji=?, WHERE Kode_Slip=?"; 
                
                
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNIP());
            ps.setLong(2, p.getGajiPokok());
            ps.setLong(3, p.getTjgJabatan());
            ps.setLong(4, p.getTjgKehadiran());
            ps.setLong(5, p.getTjgMasaKerja());
            ps.setLong(6, p.getTjgPendidikan());            
            ps.setLong(7, p.getPajakPenghasilan());
            ps.setLong(8, p.getIuranWajib());
            ps.setString(9, p.getTglTerimaGaji());
            ps.setLong(10, p.getTotalGaji());
            ps.setInt(11, p.getKodeSlip());
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

    public boolean delete(int kodeSlip) {
        //Buat SQL untuk menghapus data        
        String sql = "DELETE FROM Tb_Slip_Gaji WHERE Kode_Slip=?";
        int count = 0;
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, kodeSlip);
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

    

    public EntitySlipGaji get(int KodeSlip) {
        EntitySlipGaji gaji = null;
        //Buat SQL untuk membaca data Pegawai
        String sql = "SELECT * FROM Tb_Slip_Gaji sg LEFT JOIN Tb_Pegawai p ON sg.NIP = p.NIP WHERE Kode_Slip=?";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, KodeSlip);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            if (rs.next()) {

                gaji = new EntitySlipGaji();
                
                gaji.setKodeSlip(rs.getInt("Kode_Slip"));
                gaji.setNIP(rs.getString("NIP"));
                gaji.setGajiPokok(rs.getLong("Gaji_Pokok"));
                gaji.setTjgJabatan(rs.getLong("Tunjangan_Jabatan"));
                gaji.setTjgKehadiran(rs.getLong("Tunjangan_Kehadiran"));
                gaji.setTjgMasaKerja(rs.getLong("Tunjangan_MasaKerja"));
                gaji.setTjgPendidikan(rs.getLong("Tunjangan_Pendidikan"));
                gaji.setTglTerimaGaji(rs.getString("Tanggal_Penerimaan_Gaji"));
                gaji.setIuranWajib(rs.getLong("Iuran_Wajib_Pegawai"));
                gaji.setPajakPenghasilan(rs.getLong("Pajak_Penghasilan"));
                
                EntityPegawai p = new EntityPegawai();
                p.setNama(rs.getString("Nama"));
                gaji.setPegawai(p);
                
            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return gaji;
    }
    
    
    public ArrayList<EntitySlipGaji> getList() {
        ArrayList<EntitySlipGaji> list = new ArrayList<EntitySlipGaji>();
        String sql = "SELECT * FROM Tb_Slip_Gaji sg LEFT JOIN Tb_Pegawai p ON sg.NIP = p.NIP"; //di join ke tabel pegawai
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            while (rs.next()) {
                EntitySlipGaji gaji= new EntitySlipGaji();// tambahkan nama
                gaji.setKodeSlip(rs.getInt("Kode_Slip"));
                gaji.setNIP(rs.getString("NIP"));
                gaji.setGajiPokok(rs.getLong("Gaji_Pokok"));
                gaji.setTjgJabatan(rs.getLong("Tunjangan_Jabatan"));
                gaji.setTjgKehadiran(rs.getLong("Tunjangan_Kehadiran"));
                gaji.setTjgMasaKerja(rs.getLong("Tunjangan_MasaKerja"));
                gaji.setTjgPendidikan(rs.getLong("Tunjangan_Pendidikan"));
                gaji.setIuranWajib(rs.getLong("Iuran_Wajib_Pegawai"));
                gaji.setPajakPenghasilan(rs.getLong("Pajak_Penghasilan"));
                gaji.setTglTerimaGaji(rs.getString("Tanggal_Penerimaan_Gaji"));
                
                //masukan ke dalam list
                EntityPegawai p = new EntityPegawai();
                p.setNama(rs.getString("Nama"));
                gaji.setPegawai(p);
                
                list.add(gaji);

            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
