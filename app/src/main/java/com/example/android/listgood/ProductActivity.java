package com.example.android.listgood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProductActivity extends AppCompatActivity {
    String[] arrayStrings;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        arrayStrings = new String[]{"мясо", "молоко", "сахар"};
        listView = findViewById(R.id.listViewProduct);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayStrings);
        listView.setAdapter(arrayAdapter);

    }
}
