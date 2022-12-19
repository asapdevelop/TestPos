package asap.asapdev.testpos.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ent_Barang {
    @SerializedName("kode_barang")
    @Expose
    private String kode_barang;

    @SerializedName("nama_barang")
    @Expose
    private String nama_barang;

    @SerializedName("harga_beli")
    @Expose
    private String harga_beli;

    @SerializedName("harga_jual")
    @Expose
    private String harga_jual;

    @SerializedName("jumlah_barang")
    @Expose
    private String jumlah_barang;

    @SerializedName("satuan")
    @Expose
    private String satuan;

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(String harga_beli) {
        this.harga_beli = harga_beli;
    }

    public String getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(String harga_jual) {
        this.harga_jual = harga_jual;
    }

    public String getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(String jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

}
