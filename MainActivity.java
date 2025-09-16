package com.example.healthplaces;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseHelper db;
    ArrayList<Model> list;
    Adapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        db = new DatabaseHelper(this);

        list = new ArrayList<>();
        loadData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> {
            Toast.makeText(this, "اضافة مكان جديد (هنربط Activity تانية لاحقا)", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadData() {
        list.clear();
        Cursor cursor = db.getAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "لا يوجد بيانات", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                list.add(new Model(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
            }
        }
    }
}
