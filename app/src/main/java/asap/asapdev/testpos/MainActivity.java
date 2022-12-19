package asap.asapdev.testpos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout btnPenjualan, btnPembelian, btnStok, btnSales, btnLaporanPenjualan, btnLaporanPembelian;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btnPenjualan = findViewById(R.id.btnPenjualan);
        btnPembelian = findViewById(R.id.btnPembelian);
        btnStok = findViewById(R.id.btnStok);
        btnSales = findViewById(R.id.btnSales);
        btnLaporanPenjualan = findViewById(R.id.btnLaporanPenjualan);
        btnLaporanPembelian = findViewById(R.id.btnLaporanPembelian);


        btnPenjualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PenjualanActivity.class);
                startActivity(intent);
            }
        });

        btnStok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarangActivity.class);
                startActivity(intent);
            }
        });

    }
    
}