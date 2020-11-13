package com.example.lazada;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Adapter extends ArrayAdapter {
    ArrayList<Bean> arrayList = new ArrayList<>();

    public String formatNumberCurrency(int number)
    {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return "₫" + formatter.format(Double.parseDouble(String.valueOf(number)));
    }

    public Adapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        arrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.adapter, null);

        ImageView img = (ImageView) v.findViewById(R.id.img);
        TextView title = (TextView) v.findViewById(R.id.title);
        TextView price = (TextView) v.findViewById(R.id.price);
        TextView discount = (TextView) v.findViewById(R.id.discount);
        TextView country = (TextView) v.findViewById(R.id.country);
        img.setImageResource(arrayList.get(position).getImg());
        title.setText(arrayList.get(position).getTitle());
        price.setText(formatNumberCurrency(arrayList.get(position).getPrice()));
        discount.setText(formatNumberCurrency(arrayList.get(position).getDiscount()));
        country.setText(arrayList.get(position).getCountry());
        return v;

    }

}
