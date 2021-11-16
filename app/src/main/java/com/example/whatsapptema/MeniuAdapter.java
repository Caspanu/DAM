package com.example.whatsapptema;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MeniuAdapter extends BaseAdapter {
    private List<Conversatie> lista;

    public MeniuAdapter(List<Conversatie> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl = LayoutInflater.from(parent.getContext());
        View itemView = infl.inflate(R.layout.item_meniuri, parent, false);

        TextView tvNume = itemView.findViewById(R.id.tv_nume);
        TextView tvMesaj = itemView.findViewById(R.id.tv_mesaj);
        TextView tvData = itemView.findViewById(R.id.tv_data);

        Conversatie current = lista.get(position);
        tvNume.setText(current.getNume());
        tvMesaj.setText(current.getMesaj());
        tvData.setText(current.getData());
        return itemView;
    }

    public void update_list(List<Conversatie> lst){
        this.lista.clear();
        this.lista.addAll(lst);
        notifyDataSetChanged();
    }
}
