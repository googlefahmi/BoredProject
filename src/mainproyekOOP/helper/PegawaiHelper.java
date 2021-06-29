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
/**
 *
 * @author Faisal
 */


public class PegawaiHelper extends KoneksiDatabase {
    public boolean save(EntityPegawai p) {
        //Buat SQL untuk menyimpan data 
        String sql = "INSERT INTO Tb_Pegawai(NIP,Nama,Status,Alamat,Jenis_Kelamin,Agama,"
                    +"Tempat_Lahir,Tanggal_lahir,No_Telp,ID_Jabatan,Pendidikan_Akhir,Gaji_Pokok,Tgl_Msk_Kerja)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, p.getNIP());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getStatus());
            ps.setString(4, p.getAlamat());
            ps.setString(5, p.getJenisKelamin());
            ps.setString(6, p.getAgama());            
            ps.setString(7, p.getTempatLahir());
            ps.setDate(8, p.getTanggalLahir());
            ps.setString(9, p.getNoTelp());
            ps.setInt(10, p.getIdJabatan());
            ps.setString(11, p.getPendidikanAkhir());
            ps.setLong(12, p.getGajiPokok());
            ps.setDate(13, p.getTanggalMasuk());
            
            
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
    
    public boolean update(EntityPegawai p) {
        //Buat SQL untuk menyimpan data 
        String sql = "UPDATE Tb_Pegawai SET nama=?,status=?,alamat=?,jenis_Kelamin=?,"
                    +"Agama=?,Tempat_lahir=?,Tanggal_lahir=?,No_Telp=?,ID_Jabatan=?,"
                    +"Pendidikan_Akhir=?,Gaji_Pokok=?,Tgl_Msk_Kerja=? WHERE NIP=?";
        int count = 0;
        try {
            //Konekkan ke DB
            this.connect();
            //MEnyiampkan statement
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getStatus());
            ps.setString(3, p.getAlamat());
            ps.setString(4, p.getJenisKelamin());
            ps.setString(5, p.getAgama());
            ps.setString(6, p.getTempatLahir());
            ps.setDate(7, p.getTanggalLahir());
            ps.setString(8, p.getNoTelp());
            ps.setInt(9, p.getIdJabatan());
            ps.setString(10, p.getPendidikanAkhir());
            ps.setLong(11, p.getGajiPokok());
            ps.setDate(12, p.getTanggalMasuk());
            ps.setString(13, p.getNIP());
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

    public boolean delete(String NIP) {
        //Buat SQL untuk menghapus data        
        String sql = "DELETE FROM Tb_Pegawai WHERE NIP=?";
        int count = 0;
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, NIP);
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

    public EntityPegawai get(String NIP) {
        EntityPegawai peg = null;
        //Buat SQL untuk membaca data Pegawai
        String sql = "SELECT * FROM Tb_Pegawai WHERE NIP=?";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, NIP);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            if (rs.next()) {

                peg = new EntityPegawai();
                peg.setNIP(rs.getString("NIP"));
                peg.setNama(rs.getString("Nama"));
                peg.setStatus(rs.getString("Status"));
                peg.setAlamat(rs.getString("Alamat"));
                peg.setJenisKelamin(rs.getString("Jenis_kelamin"));
                peg.setAgama(rs.getString("Agama"));
                peg.setTempatLahir(rs.getString("Tempat_lahir"));
                peg.setTanggalLahir(rs.getDate("tanggal_Lahir"));
                peg.setNoTelp(rs.getString("no_Telp"));              
                peg.setIdJabatan(rs.getInt("id_Jabatan"));
                peg.setPendidikanAkhir(rs.getString("pendidikan_Akhir"));
                peg.setGajiPokok(rs.getLong("Gaji_Pokok"));
                peg.setTanggalMasuk(rs.getDate("Tgl_Msk_Kerja"));
             
            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return peg;
    }
    
    
    public ArrayList<EntityPegawai> getList() {
        ArrayList<EntityPegawai> list = new ArrayList<EntityPegawai>();
        String sql = "SELECT * FROM Tb_Pegawai";
        try {
            this.connect();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Baca data yang dihasilkan
            while (rs.next()) {
                EntityPegawai peg= new EntityPegawai();
                peg.setNIP(rs.getString("NIP"));
                peg.setNama(rs.getString("nama"));
                peg.setStatus(rs.getString("status"));
                peg.setAlamat(rs.getString("Alamat"));
                peg.setJenisKelamin(rs.getString("jenis_kelamin"));
                peg.setAgama(rs.getString("agama"));
                peg.setTempatLahir(rs.getString("Tempat_lahir"));
                peg.setTanggalLahir(rs.getDate("Tanggal_lahir"));               
                peg.setNoTelp(rs.getString("no_Telp"));               
                peg.setIdJabatan(rs.getInt("id_Jabatan"));
                peg.setPendidikanAkhir(rs.getString("pendidikan_Akhir"));
                peg.setGajiPokok(rs.getLong("Gaji_Pokok"));
                peg.setTanggalMasuk(rs.getDate("Tgl_Msk_Kerja"));
                //masukan ke dalam list
                list.add(peg);

            }
            this.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
}
