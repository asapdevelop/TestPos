package asap.asapdev.testpos.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.Model.Ent_Detail_Pembelian;
import asap.asapdev.testpos.Model.Ent_Detail_Penjualan;
import asap.asapdev.testpos.Model.Ent_Pembelian;
import asap.asapdev.testpos.Model.Ent_Penjualan;
import asap.asapdev.testpos.Util.ListTemporary;
import asap.asapdev.testpos.Util.SharedPref;

public class CRUD {
    private static final String TAG = "CRUD";
    Helper helper;
    SharedPref sharedPref;
    Context context;
    ListTemporary listTemporary;

    public CRUD(Context context) {
        helper = new Helper(context);
        sharedPref = new SharedPref(context);
        this.context = context;
        listTemporary = new ListTemporary();
    }

    //Insert Barang
    public long InsertData_Barang(Ent_Barang barang) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Helper.KODE_BARANG, barang.getKode_barang());
        contentValues.put(Helper.NAMA_BARANG, barang.getNama_barang());
        contentValues.put(Helper.HARGA_BELI, barang.getHarga_beli());
        contentValues.put(Helper.HARGA_JUAL, barang.getHarga_jual());
        contentValues.put(Helper.JUMLAH_BARANG, barang.getJumlah_barang());
        contentValues.put(Helper.SATUAN, barang.getSatuan());
        long result = db.insert(Helper.TABLE_BARANG, null, contentValues);

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Sukses", Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    //Insert Penjualan
    public long InsertData_Penjualan(Ent_Penjualan penjualan) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Helper.FAKTUR_PENJUALAN, penjualan.getFaktur_penjualan());
        contentValues.put(Helper.TANGGAL_PENJUALAN, penjualan.getTanggal_penjualan());
        contentValues.put(Helper.ITEM_PENJUALAN, penjualan.getItem_penjualan());
        contentValues.put(Helper.TOTAL_PENJUALAN, penjualan.getTotal_penjualan());
        contentValues.put(Helper.BAYAR, penjualan.getBayar());
        contentValues.put(Helper.KEMBALIAN, penjualan.getKembalian());
        long result = db.insert(Helper.TABLE_PENJUALAN, null, contentValues);
        Log.d(TAG, "InsertData_Penjualan: " + result);
        return result;
    }

    //Update Stok
    public long Update_Stok(String value, String idBarang) {
        SQLiteDatabase dbb = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Helper.JUMLAH_BARANG, value);

        long update_stok = dbb.update(Helper.TABLE_BARANG, contentValues, helper.KODE_BARANG + "=?", new String[]{idBarang});
        return update_stok;
    }

    //Insert Detail Penjualan
    public long InsertData_DetailPenjualan(Ent_Detail_Penjualan detailPenjualan) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Helper.FAKTUR_PENJUALAN, listTemporary.lastId);
        contentValues.put(Helper.KODE_BARANG_DETAIL_PENJUALAN, detailPenjualan.getKode_barang());
        contentValues.put(Helper.HARGA_JUAL_DETAIL_PENJUALAN, detailPenjualan.getHarga_jual());
        contentValues.put(Helper.JUMLAH_BARANG_DETAIL_PENJUALAN, detailPenjualan.getJumlah());
        contentValues.put(Helper.SUB_TOTAL_DETAIL_PENJUALAN, detailPenjualan.getTotal());
        long result = db.insert(Helper.TABLE_DETAIL_PENJUALAN, null, contentValues);
        return result;
    }

    //Insert Pembelian
    public long InsertData_Pembelian(Ent_Pembelian pembelian) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Helper.FAKTUR_PEMBELIAN, pembelian.getFaktur_pembelian());
        contentValues.put(Helper.TANGGAL_PEMBELIAN, pembelian.getTanggal_pembelian());
        contentValues.put(Helper.ITEM_PEMBELIAN, pembelian.getItem_pembelian());
        contentValues.put(Helper.TOTAL_PEMBELIAN, pembelian.getTotal_pembelian());
        long result = db.insert(Helper.TABLE_PEMBELIAN, null, contentValues);
        return result;
    }
    //Insert Detail Pembelian
    public long InsertData_DetailPembelian(Ent_Detail_Pembelian detailPembelian) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Helper.FAKTUR_PEMBELIAN, detailPembelian.getFaktur_pembelian());
        contentValues.put(Helper.KODE_BARANG_DETAIL_PEMBELIAN, detailPembelian.getKode_barang());
        contentValues.put(Helper.HARGA_BELI_DETAIL_PEMBELIAN, detailPembelian.getHarga_beli());
        contentValues.put(Helper.JUMLAH_BARANG_DETAIL_PEMBELIAN, detailPembelian.getJumlah());
        contentValues.put(Helper.SUB_TOTAL_DETAIL_PEMBELIAN, detailPembelian.getTotal());
        long result = db.insert(Helper.TABLE_DETAIL_PEMBELIAN, null, contentValues);
        return result;
    }

    //Get Barang
    @SuppressLint("Range")
    public List<Ent_Barang> getData_Barang() {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABLE_BARANG, null);
        List<Ent_Barang> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Ent_Barang barang = new Ent_Barang();
            barang.setKode_barang(cursor.getString(cursor.getColumnIndex(Helper.KODE_BARANG)));
            barang.setNama_barang(cursor.getString(cursor.getColumnIndex(Helper.NAMA_BARANG)));
            barang.setHarga_beli(cursor.getString(cursor.getColumnIndex(Helper.HARGA_BELI)));
            barang.setHarga_jual(cursor.getString(cursor.getColumnIndex(Helper.HARGA_JUAL)));
            barang.setJumlah_barang(cursor.getString(cursor.getColumnIndex(Helper.JUMLAH_BARANG)));
            barang.setSatuan(cursor.getString(cursor.getColumnIndex(Helper.SATUAN)));
            list.add(barang);
        }
        return list;
    }

    //Get Penjualan
    @SuppressLint("Range")
    public List<Ent_Penjualan> getData_Penjualan() {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABLE_PENJUALAN, null);
        List<Ent_Penjualan> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Ent_Penjualan penjualan = new Ent_Penjualan();
            penjualan.setFaktur_penjualan(cursor.getString(cursor.getColumnIndex(Helper.FAKTUR_PENJUALAN)));
            penjualan.setTanggal_penjualan(cursor.getString(cursor.getColumnIndex(Helper.TANGGAL_PENJUALAN)));
            penjualan.setItem_penjualan(cursor.getString(cursor.getColumnIndex(Helper.ITEM_PENJUALAN)));
            penjualan.setTotal_penjualan(cursor.getString(cursor.getColumnIndex(Helper.TOTAL_PENJUALAN)));
            penjualan.setBayar(cursor.getString(cursor.getColumnIndex(Helper.BAYAR)));
            penjualan.setKembalian(cursor.getString(cursor.getColumnIndex(Helper.KEMBALIAN)));
            list.add(penjualan);
        }
        return list;
    }

    //Get Detail Penjualan
    @SuppressLint("Range")
    public List<Ent_Detail_Penjualan> getData_DetailPenjualan() {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABLE_DETAIL_PENJUALAN, null);
        List<Ent_Detail_Penjualan> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Ent_Detail_Penjualan detailPenjualan = new Ent_Detail_Penjualan();
            detailPenjualan.setFaktur_penjualan(cursor.getString(cursor.getColumnIndex(Helper.FAKTUR_PENJUALAN)));
            detailPenjualan.setKode_barang(cursor.getString(cursor.getColumnIndex(Helper.KODE_BARANG_DETAIL_PENJUALAN)));
            detailPenjualan.setHarga_jual(cursor.getString(cursor.getColumnIndex(Helper.HARGA_JUAL_DETAIL_PENJUALAN)));
            detailPenjualan.setJumlah(cursor.getString(cursor.getColumnIndex(Helper.JUMLAH_BARANG_DETAIL_PENJUALAN)));
            detailPenjualan.setTotal(cursor.getString(cursor.getColumnIndex(Helper.SUB_TOTAL_DETAIL_PENJUALAN)));
            list.add(detailPenjualan);
        }
        return list;
    }

    //Get Pembelian
    @SuppressLint("Range")
    public List<Ent_Pembelian> getData_Pembelian() {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABLE_PEMBELIAN, null);
        List<Ent_Pembelian> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Ent_Pembelian pembelian = new Ent_Pembelian();
            pembelian.setFaktur_pembelian(cursor.getString(cursor.getColumnIndex(Helper.FAKTUR_PEMBELIAN)));
            pembelian.setTanggal_pembelian(cursor.getString(cursor.getColumnIndex(Helper.TANGGAL_PEMBELIAN)));
            pembelian.setItem_pembelian(cursor.getString(cursor.getColumnIndex(Helper.ITEM_PEMBELIAN)));
            pembelian.setTotal_pembelian(cursor.getString(cursor.getColumnIndex(Helper.TOTAL_PEMBELIAN)));
            list.add(pembelian);
        }
        return list;
    }

    //Get Detail Pembelian
    @SuppressLint("Range")
    public List<Ent_Detail_Pembelian> getData_DetailPembelian() {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Helper.TABLE_DETAIL_PEMBELIAN, null);
        List<Ent_Detail_Pembelian> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Ent_Detail_Pembelian detailPembelian = new Ent_Detail_Pembelian();
            detailPembelian.setFaktur_pembelian(cursor.getString(cursor.getColumnIndex(Helper.FAKTUR_PEMBELIAN)));
            detailPembelian.setKode_barang(cursor.getString(cursor.getColumnIndex(Helper.KODE_BARANG_DETAIL_PEMBELIAN)));
            detailPembelian.setHarga_beli(cursor.getString(cursor.getColumnIndex(Helper.HARGA_BELI_DETAIL_PEMBELIAN)));
            detailPembelian.setJumlah(cursor.getString(cursor.getColumnIndex(Helper.JUMLAH_BARANG_DETAIL_PEMBELIAN)));
            detailPembelian.setTotal(cursor.getString(cursor.getColumnIndex(Helper.SUB_TOTAL_DETAIL_PEMBELIAN)));
            list.add(detailPembelian);
        }
        return list;
    }


}
