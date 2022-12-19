package asap.asapdev.testpos.Util;

import java.util.ArrayList;
import java.util.List;

import asap.asapdev.testpos.Model.Ent_Detail_Pembelian;
import asap.asapdev.testpos.Model.Ent_Detail_Penjualan;

public class ListTemporary {
    public static final List<Ent_Detail_Penjualan> listDetailPenjualan = new ArrayList<>();
    public static final List<Ent_Detail_Pembelian> listDetailPembelian = new ArrayList<>();
    public static int total = 0;
    public static String lastId = "";

    public static List<Ent_Detail_Penjualan> getListDetailPenjualan() {
        return listDetailPenjualan;
    }

}
