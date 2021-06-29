/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.entities;

import java.sql.Date;

/**
 *
 * @author Faisal
 */
public class EntityDaftarAbsen {
    private int idAbsensi;
    private String NIP;
    private String tglAbsen;
    private String jamMasuk;
    private String jamKeluar;
    private String kehadiran;
    private String keterangan;

    private EntityPegawai pegawai;
    /**
     * @return the idAbsensi
     */
    public int getIdAbsensi() {
        return idAbsensi;
    }

    /**
     * @param idAbsensi the idAbsensi to set
     */
    public void setIdAbsensi(int idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    /**
     * @return the tglAbsen
     */
    public String getTglAbsen() {
        return tglAbsen;
    }

    /**
     * @param tglAbsen the tglAbsen to set
     */
    public void setTglAbsen(String tglAbsen) {
        this.tglAbsen = tglAbsen;
    }

    /**
     * @return the jamMasuk
     */
    public String getJamMasuk() {
        return jamMasuk;
    }

    /**
     * @param jamMasuk the jamMasuk to set
     */
    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    /**
     * @return the jamKeluar
     */
    public String getJamKeluar() {
        return jamKeluar;
    }

    /**
     * @param jamKeluar the jamKeluar to set
     */
    public void setJamKeluar(String jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    /**
     * @return the kehadiran
     */
    public String getKehadiran() {
        return kehadiran;
    }

    /**
     * @param kehadiran the kehadiran to set
     */
    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the NIP
     */
    public String getNIP() {
        return NIP;
    }

    /**
     * @param NIP the NIP to set
     */
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    /**
     * @return the pegawai
     */
    public EntityPegawai getPegawai() {
        return pegawai;
    }

    /**
     * @param pegawai the pegawai to set
     */
    public void setPegawai(EntityPegawai pegawai) {
        this.pegawai = pegawai;
    }
            
}
