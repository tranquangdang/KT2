package com.example.lazada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList arrayList =new ArrayList<>();
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setLongClickable(true);
        arrayList.add(new Bean(R.drawable.grey_test, "Nước mắm", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Xì dầu", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Hạt nêm", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Dầu hào", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Dầu ăn", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Loa kara", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Loa kara", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Loa kara", 3000000, 3400000, "Vietnam"));
        arrayList.add(new Bean(R.drawable.grey_test, "Loa kara", 3000000, 3400000, "Vietnam"));

        adapter = new Adapter(this,R.layout.adapter,arrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View view, int position , long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("Bạn có muốn xóa sản phẩm").setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = dialog.create();
                alert.setTitle("Xóa sản phẩm");
                alert.show();
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}