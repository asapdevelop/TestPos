package asap.asapdev.testpos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.SQLite.CRUD;

public class TambahBarangActivity extends AppCompatActivity {
    private EditText etNamaBarang, etHargaBeli, etHargaJual, etJumlahBarang, etSatuan;
    private Button btnTambahBarang;
    private CRUD crud;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        etNamaBarang = findViewById(R.id.etNamaBarang);
        etHargaBeli = findViewById(R.id.etHargaBeli);
        etHargaJual = findViewById(R.id.etHargaJual);
        etJumlahBarang = findViewById(R.id.etJumlahBarang);
        etSatuan = findViewById(R.id.etSatuan);
        btnTambahBarang = findViewById(R.id.btnTambahBarang);

        crud = new CRUD(TambahBarangActivity.this);


        btnTambahBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ent_Barang barang = new Ent_Barang();
                barang.setNama_barang(etNamaBarang.getText().toString());
                barang.setHarga_beli(etHargaBeli.getText().toString());
                barang.setHarga_jual(etHargaJual.getText().toString());
                barang.setJumlah_barang(etJumlahBarang.getText().toString());
                barang.setSatuan(etSatuan.getText().toString());
                crud.InsertData_Barang(barang);
            }
        });
    }
}