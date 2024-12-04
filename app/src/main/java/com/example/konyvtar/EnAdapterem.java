package com.example.konyvtar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class EnAdapterem extends BaseAdapter {

    private ArrayList<Konyv> konyvekLista;
    private LayoutInflater inflater;
    private Context context;

    public EnAdapterem(Context context, ArrayList<Konyv> konyvekLista) {
        this.context = context;
        this.konyvekLista = konyvekLista;
    }

    public ArrayList<Konyv> getList(){
        return this.konyvekLista;
    }

    public void removeFromList(int position){
        try {
            this.konyvekLista.remove(position);
        }finally {

        }
    }

    @Override
    public int getCount() {
        return this.konyvekLista.size();
    }

    @Override
    public Object getItem(int position) {
        return this.konyvekLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_my_item, parent, false);
        Konyv konyv = konyvekLista.get(position);


        TextView szerzo = convertView.findViewById(R.id.itemszerzo);
        TextView oldalszam = convertView.findViewById(R.id.itemOldalszam);
        TextView cim = convertView.findViewById(R.id.itemszerzo);



        szerzo.setText(konyv.getSzerzo());
        oldalszam.setText(String.valueOf(konyv.getOldalszam()));
        cim.setText(konyv.getCim());




        return convertView;
    }

}
