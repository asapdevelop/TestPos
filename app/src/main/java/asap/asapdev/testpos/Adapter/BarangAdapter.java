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

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.Holder> {

    private Context context;
    private List<Ent_Barang> barangList;

    public BarangAdapter(Context context, List<Ent_Barang> barangList) {
        this.context = context;
        this.barangList = barangList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_barang, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tvNama.setText(barangList.get(position).getNama_barang());
        holder.tvHarga.setText(barangList.get(position).getHarga_jual());
        holder.tvStok.setText("Stok : " + barangList.get(position).getJumlah_barang() + " " + barangList.get(position).getSatuan());
    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvHarga, tvStok;
        private ImageView imageView;
        private LinearLayout lnList;

        public Holder(@NonNull View itemView) {
            super(itemView);
            lnList = itemView.findViewById(R.id.lnList);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvStok = itemView.findViewById(R.id.tvStok);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
