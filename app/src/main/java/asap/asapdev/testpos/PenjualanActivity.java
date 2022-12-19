package asap.asapdev.testpos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import asap.asapdev.testpos.Adapter.PenjualanAdapter;
import asap.asapdev.testpos.Model.Ent_Penjualan;
import asap.asapdev.testpos.SQLite.CRUD;
import asap.asapdev.testpos.Util.ListTemporary;

public class PenjualanActivity extends AppCompatActivity {
    private static final String TAG = "PenjualanActivity";
    private RecyclerView rvPenjualan;
    private RecyclerView.LayoutManager layoutManager;
    private CRUD crud;
    private PenjualanAdapter adapter;
    private Button btnSimpan;
    private ListTemporary listTemporary;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan);

        rvPenjualan = findViewById(R.id.rvPenjualan);
        btnSimpan = findViewById(R.id.btnSimpan);
        crud = new CRUD(PenjualanActivity.this);
        listTemporary = new ListTemporary();
        layoutManager = new LinearLayoutManager(this);
        rvPenjualan.setLayoutManager(layoutManager);


        adapter = new PenjualanAdapter(this, crud.getData_Barang());
        rvPenjualan.setAdapter(adapter);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PenjualanActivity.this, DetailPesananActivity.class);
                startActivity(intent);
            }
        });

    }


}