package asap.asapdev.testpos.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ent_Penjualan {
    @SerializedName("faktur_penjualan")
    @Expose
    private String faktur_penjualan;

    @SerializedName("tanggal_penjualan")
    @Expose
    private String tanggal_penjualan;

    @SerializedName("item_penjualan")
    @Expose
    private String item_penjualan;

    @SerializedName("total_penjualan")
    @Expose
    private String total_penjualan;

    @SerializedName("bayar")
    @Expose
    private String bayar;

    @SerializedName("kembalian")
    @Expose
    private String kembalian;

    public String getFaktur_penjualan() {
        return faktur_penjualan;
    }

    public void setFaktur_penjualan(String faktur_penjualan) {
        this.faktur_penjualan = faktur_penjualan;
    }

    public String getTanggal_penjualan() {
        return tanggal_penjualan;
    }

    public void setTanggal_penjualan(String tanggal_penjualan) {
        this.tanggal_penjualan = tanggal_penjualan;
    }

    public String getItem_penjualan() {
        return item_penjualan;
    }

    public void setItem_penjualan(String item_penjualan) {
        this.item_penjualan = item_penjualan;
    }

    public String getTotal_penjualan() {
        return total_penjualan;
    }

    public void setTotal_penjualan(String total_penjualan) {
        this.total_penjualan = total_penjualan;
    }

    public String getBayar() {
        return bayar;
    }

    public void setBayar(String bayar) {
        this.bayar = bayar;
    }

    public String getKembalian() {
        return kembalian;
    }

    public void setKembalian(String kembalian) {
        this.kembalian = kembalian;
    }
}
