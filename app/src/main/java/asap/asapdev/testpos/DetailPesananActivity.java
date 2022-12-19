package asap.asapdev.testpos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import asap.asapdev.testpos.Adapter.DetailPenjualanAdapter;
import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.Model.Ent_Detail_Penjualan;
import asap.asapdev.testpos.Model.Ent_Penjualan;
import asap.asapdev.testpos.SQLite.CRUD;
import asap.asapdev.testpos.Util.ListTemporary;

public class DetailPesananActivity extends AppCompatActivity {
    private static final String TAG = "DetailPesananActivity";
    private TextView tvTotalTransaksi, tvKembalian;
    private EditText etBayar;
    private Button btnBayar;
    private CRUD crud;
    private ListTemporary listTemporary;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DetailPenjualanAdapter adapter;
    private String date;
    private double bayar = 0, kembalian = 0;
    private String lastId;
    private List<Ent_Penjualan> listPenjualan = new ArrayList<>();
    private List<Ent_Barang> listBarang = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);

        tvTotalTransaksi = findViewById(R.id.tvTotalTransaksi);
        tvKembalian = findViewById(R.id.tvKembalian);
        etBayar = findViewById(R.id.etBayar);
        btnBayar = findViewById(R.id.btnBayar);
        crud = new CRUD(DetailPesananActivity.this);
        listTemporary = new ListTemporary();
        recyclerView = findViewById(R.id.rvDetailBarang);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        listPenjualan.addAll(crud.getData_Penjualan());
        listBarang.addAll(crud.getData_Barang());
        if (listPenjualan.size()==0){
            lastId = "1";
        } else {
            lastId = String.valueOf(Integer.parseInt(listPenjualan.get(listPenjualan.size()-1).getFaktur_penjualan())+1);
        }

        listTemporary.lastId = lastId;

        tvTotalTransaksi.setText("Rp. " + doubleToStringNoDecimal(Double.valueOf(listTemporary.total)));
        etBayar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    bayar = Double.valueOf(s.toString());
                    double total = Double.valueOf(listTemporary.total);
                    kembalian = bayar - total;
                    tvKembalian.setText("Rp. " + doubleToStringNoDecimal(kembalian));
                } else {
                    tvKembalian.setText("Rp. 0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        adapter = new DetailPenjualanAdapter(DetailPesananActivity.this);
        recyclerView.setAdapter(adapter);

        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etBayar.getText().toString().isEmpty()) {
                    etBayar.setError("Harap isi nominal pembayaran");
                } else {
                    Ent_Penjualan penjualan = new Ent_Penjualan();
                    penjualan.setFaktur_penjualan(lastId);
                    penjualan.setTanggal_penjualan(date);
                    penjualan.setItem_penjualan(String.valueOf(listTemporary.listDetailPenjualan.size()));
                    penjualan.setTotal_penjualan(String.valueOf(listTemporary.total));
                    penjualan.setBayar(String.valueOf(bayar));
                    penjualan.setKembalian(String.valueOf(kembalian));
                    crud.InsertData_Penjualan(penjualan);

                    for (int a=0; a<listTemporary.listDetailPenjualan.size(); a++){
                        Ent_Detail_Penjualan detail_penjualan = new Ent_Detail_Penjualan();
                        detail_penjualan.setFaktur_penjualan(String.valueOf(lastId));
                        Log.d(TAG, "onClick: " + detail_penjualan.getFaktur_penjualan());
                        detail_penjualan.setKode_barang(listTemporary.listDetailPenjualan.get(a).getKode_barang());
                        detail_penjualan.setHarga_jual(listTemporary.listDetailPenjualan.get(a).getHarga_jual());
                        detail_penjualan.setJumlah(listTemporary.listDetailPenjualan.get(a).getJumlah());
                        detail_penjualan.setTotal(listTemporary.listDetailPenjualan.get(a).getTotal());
                        crud.InsertData_DetailPenjualan(listTemporary.listDetailPenjualan.get(a));
                        for (int b=0; b<listBarang.size(); b++){
                            if (listBarang.get(b).getKode_barang().equals(listTemporary.listDetailPenjualan.get(a).getKode_barang())){
                                int stok = Integer.parseInt(listBarang.get(b).getJumlah_barang()) - Integer.parseInt(listTemporary.listDetailPenjualan.get(a).getJumlah());
                                crud.Update_Stok(String.valueOf(stok), listBarang.get(b).getKode_barang());
                            }
                        }
                    }

                    listTemporary.listDetailPenjualan.clear();
                    listTemporary.total = 0;
                    Toast.makeText(DetailPesananActivity.this, "Sukses Input Data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(DetailPesananActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public static String doubleToStringNoDecimal(double d) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###");
        return formatter.format(d);
    }
}