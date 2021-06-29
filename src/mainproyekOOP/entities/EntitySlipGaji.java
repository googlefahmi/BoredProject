/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproyekOOP.entities;

/**
 *
 * @author Faisal
 */
public class EntitySlipGaji {
    private String NIP;
    private int kodeSlip;
    private long gajiPokok;
    private String tglTerimaGaji;
    private long iuranWajib;
    private long pajakPenghasilan;
    private long tjgKehadiran;
    private long tjgPendidikan;
    private long tjgJabatan;
    private long tjgMasaKerja;
    private long totalGaji;
    
    private EntityPegawai pegawai;

    
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
     * @return the kodeSlip
     */
    public int getKodeSlip() {
        return kodeSlip;
    }

    /**
     * @param kodeSlip the kodeSlip to set
     */
    public void setKodeSlip(int kodeSlip) {
        this.kodeSlip = kodeSlip;
    }

    /**
     * @return the gajiPokok
     */
    public long getGajiPokok() {
        return gajiPokok;
    }

    /**
     * @param gajiPokok the gajiPokok to set
     */
    public void setGajiPokok(long gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    /**
     * @return the tglTerimaGaji
     */
    public String getTglTerimaGaji() {
        return tglTerimaGaji;
    }

    /**
     * @param tglTerimaGaji the tglTerimaGaji to set
     */
    public void setTglTerimaGaji(String tglTerimaGaji) {
        this.tglTerimaGaji = tglTerimaGaji;
    }

    /**
     * @return the iuranWajib
     */
    public long getIuranWajib() {
        return iuranWajib;
    }

    /**
     * @param iuranWajib the iuranWajib to set
     */
    public void setIuranWajib(long iuranWajib) {
        this.iuranWajib = iuranWajib;
    }

    /**
     * @return the pajakPenghasilan
     */
    public long getPajakPenghasilan() {
        return pajakPenghasilan;
    }

    /**
     * @param pajakPenghasilan the pajakPenghasilan to set
     */
    public void setPajakPenghasilan(long pajakPenghasilan) {
        this.pajakPenghasilan = pajakPenghasilan;
    }

    /**
     * @return the tjgKehadiran
     */
    public long getTjgKehadiran() {
        return tjgKehadiran;
    }

    /**
     * @param tjgKehadiran the tjgKehadiran to set
     */
    public void setTjgKehadiran(long tjgKehadiran) {
        this.tjgKehadiran = tjgKehadiran;
    }

    /**
     * @return the tjgPendidikan
     */
    public long getTjgPendidikan() {
        return tjgPendidikan;
    }

    /**
     * @param tjgPendidikan the tjgPendidikan to set
     */
    public void setTjgPendidikan(long tjgPendidikan) {
        this.tjgPendidikan = tjgPendidikan;
    }

    /**
     * @return the tjgJabatan
     */
    public long getTjgJabatan() {
        return tjgJabatan;
    }

    /**
     * @param tjgJabatan the tjgJabatan to set
     */
    public void setTjgJabatan(long tjgJabatan) {
        this.tjgJabatan = tjgJabatan;
    }

    /**
     * @return the tjgMasaKerja
     */
    public long getTjgMasaKerja() {
        return tjgMasaKerja;
    }

    /**
     * @param tjgMasaKerja the tjgMasaKerja to set
     */
    public void setTjgMasaKerja(long tjgMasaKerja) {
        this.tjgMasaKerja = tjgMasaKerja;
    }

    /**
     * @return the totalGaji
     */
    public long getTotalGaji() {
        return totalGaji = hitungTotalGaji(gajiPokok, tjgJabatan, tjgMasaKerja, tjgPendidikan, tjgKehadiran, iuranWajib, pajakPenghasilan);
    }

    /**
     * @param totalGaji the totalGaji to set
     */
    public void setTotalGaji(long totalGaji) {
        this.totalGaji = totalGaji;
    }
    
    
    public long hitungTotalGaji(long gjPokok,long tjgJbtan,long tjgMsKrj,long tjgPend,long tjgKhdrn,long iuranWjb,long pjkPenghasilan){
        gjPokok = getGajiPokok();
        tjgJbtan = getTjgJabatan();
        tjgMsKrj = getTjgMasaKerja();
        tjgPend = getTjgPendidikan(); 
        tjgKhdrn =  getTjgKehadiran();
        iuranWjb = getIuranWajib();
        pjkPenghasilan = getPajakPenghasilan();
        this.totalGaji = gjPokok+tjgJbtan+tjgMsKrj+tjgPend+tjgKhdrn-iuranWjb-pjkPenghasilan;
        return this.totalGaji;
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
