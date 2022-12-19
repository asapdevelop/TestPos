package asap.asapdev.testpos.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ent_Detail_Pembelian {
    @SerializedName("id_detail_pembelian")
    @Expose
    private String id_detail_pembelian;

    @SerializedName("faktur_pembelian")
    @Expose
    private String faktur_pembelian;

    @SerializedName("kode_barang")
    @Expose
    private String kode_barang;

    @SerializedName("harga_beli")
    @Expose
    private String harga_beli;

    @SerializedName("jumlah")
    @Expose
    private String jumlah;

    @SerializedName("total")
    @Expose
    private String total;

    public String getId_detail_pembelian() {
        return id_detail_pembelian;
    }

    public void setId_detail_pembelian(String id_detail_pembelian) {
        this.id_detail_pembelian = id_detail_pembelian;
    }

    public String getFaktur_pembelian() {
        return faktur_pembelian;
    }

    public void setFaktur_pembelian(String faktur_pembelian) {
        this.faktur_pembelian = faktur_pembelian;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(String harga_beli) {
        this.harga_beli = harga_beli;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
