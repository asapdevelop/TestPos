package asap.asapdev.testpos.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.Model.Ent_Detail_Penjualan;
import asap.asapdev.testpos.Model.Ent_Penjualan;
import asap.asapdev.testpos.R;
import asap.asapdev.testpos.SQLite.CRUD;
import asap.asapdev.testpos.Util.ListTemporary;

public class PenjualanAdapter extends RecyclerView.Adapter<PenjualanAdapter.Holder> {
    private static final String TAG = "PenjualanAdapter";
    private Context context;
    private List<Ent_Barang> barangList;
    private CRUD crud;
    private ListTemporary listTemporary;


    public PenjualanAdapter(Context context, List<Ent_Barang> barangList) {
        this.context = context;
        this.barangList = barangList;
        crud = new CRUD(context);
        listTemporary = new ListTemporary();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_penjualan, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        if (Integer.parseInt((String) holder.tvJumlah.getText()) == 0) {
            holder.btnTambah.setVisibility(View.VISIBLE);
            holder.lnAfter.setVisibility(View.GONE);
        } else {
            holder.btnTambah.setVisibility(View.GONE);
            holder.lnAfter.setVisibility(View.VISIBLE);
        }

        holder.tvNama.setText(barangList.get(position).getNama_barang());
        holder.tvHarga.setText(barangList.get(position).getHarga_jual());
        holder.tvStok.setText("Stok : " + barangList.get(position).getJumlah_barang());

        holder.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnTambah.setVisibility(View.GONE);
                holder.lnAfter.setVisibility(View.VISIBLE);
                holder.tvJumlah.setText("1");
                Ent_Detail_Penjualan ent_detail_penjualan = new Ent_Detail_Penjualan();
                ent_detail_penjualan.setFaktur_penjualan("a");
                ent_detail_penjualan.setKode_barang(barangList.get(position).getKode_barang());
                ent_detail_penjualan.setHarga_jual(barangList.get(position).getHarga_jual());
                ent_detail_penjualan.setJumlah("1");
                ent_detail_penjualan.setTotal(barangList.get(position).getHarga_jual());
                listTemporary.listDetailPenjualan.add(ent_detail_penjualan);
                listTemporary.total = listTemporary.total + Integer.parseInt(barangList.get(position).getHarga_jual());
            }
        });

        holder.tvTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jumlah = Integer.parseInt((String) holder.tvJumlah.getText());
                jumlah++;
                holder.tvJumlah.setText(String.valueOf(jumlah));
                for (int i = 0; i < listTemporary.listDetailPenjualan.size(); i++) {
                    if (listTemporary.listDetailPenjualan.get(i).getKode_barang().equals(barangList.get(position).getKode_barang())) {
                        listTemporary.listDetailPenjualan.get(i).setJumlah(String.valueOf(jumlah));
                        listTemporary.listDetailPenjualan.get(i).setTotal(String.valueOf(Integer.parseInt(barangList.get(position).getHarga_jual()) * jumlah));
                        listTemporary.total = listTemporary.total + Integer.parseInt(barangList.get(position).getHarga_jual());
                    }
                }
            }
        });

        holder.tvKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jumlah = Integer.parseInt((String) holder.tvJumlah.getText());
                jumlah--;
                holder.tvJumlah.setText(String.valueOf(jumlah));
                if (jumlah == 0) {
                    holder.btnTambah.setVisibility(View.VISIBLE);
                    holder.lnAfter.setVisibility(View.GONE);
                    for (int i = 0; i < listTemporary.listDetailPenjualan.size(); i++) {
                        if (listTemporary.listDetailPenjualan.get(i).getKode_barang().equals(barangList.get(position).getKode_barang())) {
                            listTemporary.listDetailPenjualan.remove(i);
                            listTemporary.total = listTemporary.total - Integer.parseInt(barangList.get(position).getHarga_jual());
                        }
                    }
                }
                for (int i = 0; i < listTemporary.listDetailPenjualan.size(); i++) {
                    if (listTemporary.listDetailPenjualan.get(i).getKode_barang().equals(barangList.get(position).getKode_barang())) {
                        listTemporary.listDetailPenjualan.get(i).setJumlah(String.valueOf(jumlah));
                        listTemporary.listDetailPenjualan.get(i).setTotal(String.valueOf(Integer.parseInt(barangList.get(position).getHarga_jual()) * jumlah));
                        listTemporary.total = listTemporary.total - Integer.parseInt(barangList.get(position).getHarga_jual());
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvHarga, tvStok, tvJumlah, tvTambah, tvKurang, btnTambah;
        private ImageView imageView;
        private LinearLayout lnList, lnAfter;

        public Holder(@NonNull View itemView) {
            super(itemView);
            lnList = itemView.findViewById(R.id.lnList);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvStok = itemView.findViewById(R.id.tvStok);
            imageView = itemView.findViewById(R.id.image);
            btnTambah = itemView.findViewById(R.id.btnTambah);
            tvJumlah = itemView.findViewById(R.id.tvJumlah);
            tvTambah = itemView.findViewById(R.id.tvTambah);
            tvKurang = itemView.findViewById(R.id.tvKurang);
            lnAfter = itemView.findViewById(R.id.lnAfter);
        }
    }
}

