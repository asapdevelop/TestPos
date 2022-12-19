package asap.asapdev.testpos.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper{
    public Context context;
    public static final String DATABASE_NAME = "db_pos.db";
    public static final int DATABASE_VERSION = 1;

    //Tabel Barang
    public static final String TABLE_BARANG = "tb_barang";
    public static final String KODE_BARANG = "kode_barang";
    public static final String NAMA_BARANG = "nama_barang";
    public static final String HARGA_BELI = "harga_beli";
    public static final String HARGA_JUAL = "harga_jual";
    public static final String JUMLAH_BARANG = "jumlah_barang";
    public static final String SATUAN = "satuan";
    public static final String CREATE_TABLE_BARANG = "CREATE TABLE " + TABLE_BARANG + "("
            + KODE_BARANG + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAMA_BARANG + " VARCHAR(50), "
            + HARGA_BELI + " INTEGER, "
            + HARGA_JUAL + " INTEGER, "
            + JUMLAH_BARANG + " INTEGER, "
            + SATUAN + " VARCHAR(20));";
    public static final String DROP_TABLE_BARANG = "DROP TABLE IF EXISTS " + TABLE_BARANG;

    //Tabel Penjualan
    public static final String TABLE_PENJUALAN = "tb_penjualan";
    public static final String FAKTUR_PENJUALAN = "faktur_penjualan";
    public static final String TANGGAL_PENJUALAN = "tanggal_penjualan";
    public static final String ITEM_PENJUALAN = "item_penjualan";
    public static final String TOTAL_PENJUALAN = "total_penjualan";
    public static final String BAYAR = "bayar";
    public static final String KEMBALIAN = "kembalian";
    public static final String CREATE_TABLE_PENJUALAN = "CREATE TABLE " + TABLE_PENJUALAN + "("
            + FAKTUR_PENJUALAN + " VARCHAR(10) PRIMARY KEY, "
            + TANGGAL_PENJUALAN + " DATE, "
            + ITEM_PENJUALAN + " INTEGER, "
            + TOTAL_PENJUALAN + " INTEGER, "
            + BAYAR + " INTEGER, "
            + KEMBALIAN + " INTEGER);";
    public static final String DROP_TABLE_PENJUALAN = "DROP TABLE IF EXISTS " + TABLE_PENJUALAN;

    //Tabel Detail Penjualan
    public static final String TABLE_DETAIL_PENJUALAN = "tb_detail_penjualan";
    public static final String ID_DETAIL_PENJUALAN = "id_detail_penjualan";
    public static final String KODE_BARANG_DETAIL_PENJUALAN = "kode_barang_detail_penjualan";
    public static final String HARGA_JUAL_DETAIL_PENJUALAN = "harga_jual_detail_penjualan";
    public static final String JUMLAH_BARANG_DETAIL_PENJUALAN = "jumlah_barang_detail_penjualan";
    public static final String SUB_TOTAL_DETAIL_PENJUALAN = "sub_total_detail_penjualan";
    public static final String CREATE_TABLE_DETAIL_PENJUALAN = "CREATE TABLE " + TABLE_DETAIL_PENJUALAN + "("
            + ID_DETAIL_PENJUALAN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FAKTUR_PENJUALAN + " VARCHAR(10), "
            + KODE_BARANG_DETAIL_PENJUALAN + " VARCHAR(10), "
            + HARGA_JUAL_DETAIL_PENJUALAN + " INTEGER, "
            + JUMLAH_BARANG_DETAIL_PENJUALAN + " INTEGER, "
            + SUB_TOTAL_DETAIL_PENJUALAN + " INTEGER);";
    public static final String DROP_TABLE_DETAIL_PENJUALAN = "DROP TABLE IF EXISTS " + TABLE_DETAIL_PENJUALAN;

    //Tabel Pembelian
    public static final String TABLE_PEMBELIAN = "tb_pembelian";
    public static final String FAKTUR_PEMBELIAN = "faktur_pembelian";
    public static final String TANGGAL_PEMBELIAN = "tanggal_pembelian";
    public static final String ITEM_PEMBELIAN = "item_pembelian";
    public static final String TOTAL_PEMBELIAN = "total_pembelian";
    public static final String CREATE_TABLE_PEMBELIAN = "CREATE TABLE " + TABLE_PEMBELIAN + "("
            + FAKTUR_PEMBELIAN + " VARCHAR(10) PRIMARY KEY, "
            + TANGGAL_PEMBELIAN + " DATE, "
            + ITEM_PEMBELIAN + " INTEGER, "
            + TOTAL_PEMBELIAN + " INTEGER);";
    public static final String DROP_TABLE_PEMBELIAN = "DROP TABLE IF EXISTS " + TABLE_PEMBELIAN;

    //Tabel Detail Pembelian
    public static final String TABLE_DETAIL_PEMBELIAN = "tb_detail_pembelian";
    public static final String ID_DETAIL_PEMBELIAN = "id_detail_pembelian";
    public static final String KODE_BARANG_DETAIL_PEMBELIAN = "kode_barang_detail_pembelian";
    public static final String HARGA_BELI_DETAIL_PEMBELIAN = "harga_beli_detail_pembelian";
    public static final String JUMLAH_BARANG_DETAIL_PEMBELIAN = "jumlah_barang_detail_pembelian";
    public static final String SUB_TOTAL_DETAIL_PEMBELIAN = "sub_total_detail_pembelian";
    public static final String CREATE_TABLE_DETAIL_PEMBELIAN = "CREATE TABLE " + TABLE_DETAIL_PEMBELIAN + "("
            + ID_DETAIL_PEMBELIAN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FAKTUR_PEMBELIAN + " VARCHAR(10), "
            + KODE_BARANG_DETAIL_PEMBELIAN + " VARCHAR(10), "
            + HARGA_BELI_DETAIL_PEMBELIAN + " INTEGER, "
            + JUMLAH_BARANG_DETAIL_PEMBELIAN + " INTEGER, "
            + SUB_TOTAL_DETAIL_PEMBELIAN + " INTEGER);";
    public static final String DROP_TABLE_DETAIL_PEMBELIAN = "DROP TABLE IF EXISTS " + TABLE_DETAIL_PEMBELIAN;

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_BARANG);
            db.execSQL(CREATE_TABLE_PENJUALAN);
            db.execSQL(CREATE_TABLE_DETAIL_PENJUALAN);
            db.execSQL(CREATE_TABLE_PEMBELIAN);
            db.execSQL(CREATE_TABLE_DETAIL_PEMBELIAN);
        } catch (Exception e) {
            Toast.makeText(context, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE_BARANG);
            db.execSQL(DROP_TABLE_PENJUALAN);
            db.execSQL(DROP_TABLE_DETAIL_PENJUALAN);
            db.execSQL(DROP_TABLE_PEMBELIAN);
            db.execSQL(DROP_TABLE_DETAIL_PEMBELIAN);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

