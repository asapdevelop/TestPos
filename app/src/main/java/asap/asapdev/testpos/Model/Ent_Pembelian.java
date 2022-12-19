package asap.asapdev.testpos.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ent_Pembelian {
    @SerializedName("faktur_pembelian")
    @Expose
    private String faktur_pembelian;

    @SerializedName("tanggal_pembelian")
    @Expose
    private String tanggal_pembelian;

    @SerializedName("item_pembelian")
    @Expose
    private String item_pembelian;

    @SerializedName("total_pembelian")
    @Expose
    private String total_pembelian;

    public String getFaktur_pembelian() {
        return faktur_pembelian;
    }

    public void setFaktur_pembelian(String faktur_pembelian) {
        this.faktur_pembelian = faktur_pembelian;
    }

    public String getTanggal_pembelian() {
        return tanggal_pembelian;
    }

    public void setTanggal_pembelian(String tanggal_pembelian) {
        this.tanggal_pembelian = tanggal_pembelian;
    }

    public String getItem_pembelian() {
        return item_pembelian;
    }

    public void setItem_pembelian(String item_pembelian) {
        this.item_pembelian = item_pembelian;
    }

    public String getTotal_pembelian() {
        return total_pembelian;
    }

    public void setTotal_pembelian(String total_pembelian) {
        this.total_pembelian = total_pembelian;
    }
}
