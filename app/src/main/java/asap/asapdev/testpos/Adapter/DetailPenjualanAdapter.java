package asap.asapdev.testpos.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import asap.asapdev.testpos.Model.Ent_Barang;
import asap.asapdev.testpos.Model.Ent_Detail_Penjualan;
import asap.asapdev.testpos.R;
import asap.asapdev.testpos.SQLite.CRUD;
import asap.asapdev.testpos.Util.ListTemporary;

public class DetailPenjualanAdapter extends RecyclerView.Adapter<DetailPenjualanAdapter.Holder> {
    Context context;
    List<Ent_Detail_Penjualan> detailPenjualanList;
    CRUD crud;
    List<Ent_Barang> barangList;

    public DetailPenjualanAdapter(Context context) {
        this.context = context;
        detailPenjualanList = ListTemporary.getListDetailPenjualan();
        crud = new CRUD(context);
        barangList = crud.getData_Barang();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_penjualan, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        for (int a=0; a<barangList.size(); a++) {
            if (detailPenjualanList.get(position).getKode_barang().equals(barangList.get(a).getKode_barang())) {
                holder.tvNama.setText(barangList.get(a).getNama_barang());
            }
        }
        holder.tvJumlahBarang.setText(detailPenjualanList.get(position).getJumlah());
        holder.tvTotalHarga.setText("Rp. "+doubleToStringNoDecimal(Double.parseDouble(detailPenjualanList.get(position).getTotal())));
    }

    @Override
    public int getItemCount() {
        return detailPenjualanList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvJumlahBarang, tvTotalHarga;
        private LinearLayout lnList;
        public Holder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvJumlahBarang = itemView.findViewById(R.id.tvJumlahBarang);
            tvTotalHarga = itemView.findViewById(R.id.tvTotalHarga);
        }
    }

    public static String doubleToStringNoDecimal(double d) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###");
        return formatter.format(d);
    }

}
