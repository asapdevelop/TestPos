package asap.asapdev.testpos.Api;

import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.Model.Ent_Detail_Pembelian;
import asap.asapdev.testpos.Model.Ent_Detail_Penjualan;
import asap.asapdev.testpos.Model.Ent_Pembelian;
import asap.asapdev.testpos.Model.Ent_Penjualan;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_Interface {

    @GET("getBarang")
    Call<Ent_Barang> getBarang();

    @GET("getDetailPembelian")
    Call<Ent_Detail_Pembelian> getDetailPembelian();

    @GET("getPembelian")
    Call<Ent_Pembelian> getPembelian();

    @GET("getPenjualan")
    Call<Ent_Penjualan> getPenjualan();

    @GET("getDetailPenjualan")
    Call<Ent_Detail_Penjualan> getDetailPenjualan();
}
