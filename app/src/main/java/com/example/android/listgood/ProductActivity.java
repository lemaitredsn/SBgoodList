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

public class ProductActivity extends AppCompatActivity {
    //String[] arrayStrings;
    ArrayList<String> arrayListProduct;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        arrayListProduct = new ArrayList<>();
        //arrayStrings = new String[]{"мясо", "молоко", "сахар"};
        listView = findViewById(R.id.listViewProduct);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListProduct);
        listView.setAdapter(arrayAdapter);

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
            arrayListProduct.remove(0);
            arrayAdapter.notifyDataSetChanged();
        }

    }
}
