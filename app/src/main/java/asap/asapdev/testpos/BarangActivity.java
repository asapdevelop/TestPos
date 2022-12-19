package asap.asapdev.testpos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import asap.asapdev.testpos.Adapter.BarangAdapter;
import asap.asapdev.testpos.SQLite.CRUD;

public class BarangActivity extends AppCompatActivity {
    private static final String TAG = "BarangActivity";
    private RecyclerView rvBarang;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fabTambahBarang;
    private CRUD crud;
    private BarangAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        rvBarang = findViewById(R.id.rvBarang);
        fabTambahBarang = findViewById(R.id.fabTambahBarang);
        crud = new CRUD(BarangActivity.this);
        layoutManager = new LinearLayoutManager(this);
        rvBarang.setLayoutManager(layoutManager);

        adapter = new BarangAdapter(this, crud.getData_Barang());
        rvBarang.setAdapter(adapter);

        fabTambahBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + crud.getData_Barang().size());
                Intent intent = new Intent(BarangActivity.this, TambahBarangActivity.class);
                startActivity(intent);
            }
        });
    }
}