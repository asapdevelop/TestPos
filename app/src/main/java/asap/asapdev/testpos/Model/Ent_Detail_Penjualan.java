package asap.asapdev.testpos.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ent_Detail_Penjualan {
    @SerializedName("id_detail_penjualan")
    @Expose
    private String id_detail_penjualan;

    @SerializedName("faktur_penjualan")
    @Expose
    private String faktur_penjualan;

    @SerializedName("kode_barang")
    @Expose
    private String kode_barang;

    @SerializedName("harga_jual")
    @Expose
    private String harga_jual;

    @SerializedName("jumlah")
    @Expose
    private String jumlah;

    @SerializedName("total")
    @Expose
    private String total;

    public String getId_detail_penjualan() {
        return id_detail_penjualan;
    }

    public void setId_detail_penjualan(String id_detail_penjualan) {
        this.id_detail_penjualan = id_detail_penjualan;
    }

    public String getFaktur_penjualan() {
        return faktur_penjualan;
    }

    public void setFaktur_penjualan(String faktur_penjualan) {
        this.faktur_penjualan = faktur_penjualan;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(String harga_jual) {
        this.harga_jual = harga_jual;
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
