package com.example.android.listgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    //String[] arrayStrings;
    ArrayList<String> arrayListProduct;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    int choiseItemPosition;
    private static final String PREFERENCES = "PREFERENCES_PRODUCTS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        arrayListProduct = new ArrayList<>();
        //arrayStrings = new String[]{"мясо", "молоко", "сахар"};
        listView = findViewById(R.id.listViewProduct);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrayListProduct);

        SharedPreferences preferencesRestore = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        for(int i = 0; i < preferencesRestore.getInt("length", 0); i++){
            arrayListProduct.add(preferencesRestore.getString(String.valueOf(i), ""));
        }

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                choiseItemPosition = i;
            }
        });

    }

    public void onClickButtonAdd(View view) {
        EditText editTextProduct = findViewById(R.id.editTextProducts);
        String item = editTextProduct.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте покупку", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListProduct.add(item);
            arrayAdapter.notifyDataSetChanged();
            editTextProduct.setText("");
        }
    }

    public void onClickButtonRemove(View view) {
        if(arrayListProduct.isEmpty()){
            Toast toast = Toast.makeText(this,"Список пуст", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListProduct.remove(choiseItemPosition);
            arrayAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onSaveData();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        onSaveData();
    }

    void onSaveData(){
        String[] items = arrayListProduct.toArray(new String[0]);
        SharedPreferences preferencesSave = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencesSave.edit();
        for(int i = 0; i < items.length; i++){
            editor.putString(String.valueOf(i), items[i]);
        }
        editor.putInt("length", items.length);
        editor.apply();
    }
}
