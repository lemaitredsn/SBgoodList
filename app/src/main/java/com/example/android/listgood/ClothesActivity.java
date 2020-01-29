package com.example.android.listgood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClothesActivity extends AppCompatActivity {
    ArrayList<String>arrayListClothes;
    ArrayAdapter<String>arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        listView = findViewById(R.id.listViewClothes);
        arrayListClothes = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListClothes);
        listView.setAdapter(arrayAdapter);
    }

    public void onClickButtonAdd(View view) {
        EditText editTextClothes = findViewById(R.id.editTextClothes);
        String item = editTextClothes.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте покупку", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListClothes.add(item);
            arrayAdapter.notifyDataSetChanged();
            editTextClothes.setText("");
        }
    }

    public void onClickButtonRemove(View view) {
        if(arrayListClothes.isEmpty()){
            Toast toast = Toast.makeText(this,"Список пуст", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListClothes.remove(0);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
