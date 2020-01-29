package com.example.android.listgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent productIntent = new Intent(MainActivity.this, ProductActivity.class);
                    startActivity(productIntent);
                }

                if(i == 1){
                    Intent clothesIntent = new Intent(MainActivity.this, ClothesActivity.class);
                    startActivity(clothesIntent);
                }

                if(i == 2){
                    Intent toolsIntent = new Intent(MainActivity.this, ToolsActivity.class);
                    startActivity(toolsIntent);
                }

                if(i == 3){
                    Intent householdIntent = new Intent(MainActivity.this, HouseholdActivity.class);
                    startActivity(householdIntent);
                }
            }
        });
    }
}
