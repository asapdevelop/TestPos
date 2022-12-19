package asap.asapdev.testpos.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.R;
import asap.asapdev.testpos.SQLite.CRUD;

public class PenjualanAdapter extends RecyclerView.Adapter<PenjualanAdapter.Holder> {
    private Context context;
    private List<Ent_Barang> barangList;
    private CRUD crud;

    public PenjualanAdapter(Context context, List<Ent_Barang> barangList, CRUD crud) {
        this.context = context;
        this.barangList = barangList;
        crud = new CRUD(context);
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
            }
        });

        holder.tvTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jumlah = Integer.parseInt((String) holder.tvJumlah.getText());
                jumlah++;
                holder.tvJumlah.setText(String.valueOf(jumlah));
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
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvHarga, tvStok, tvJumlah, tvTambah, tvKurang;
        private ImageView imageView;
        private Button btnTambah;
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

