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

public class HouseholdActivity extends AppCompatActivity {
    ArrayList<String> arrayListHousehold;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household);
        listView = findViewById(R.id.listViewHousehold);
        arrayListHousehold = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListHousehold);
        listView.setAdapter(arrayAdapter);
    }

    public void onClickButtonAdd(View view) {
        EditText editTextTools = findViewById(R.id.editTextHousehold);
        String item = editTextTools.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте покупку", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListHousehold.add(item);
            arrayAdapter.notifyDataSetChanged();
            editTextTools.setText("");
        }
    }

    public void onClickButtonRemove(View view) {
        if(arrayListHousehold.isEmpty()){
            Toast toast = Toast.makeText(this,"Список пуст", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListHousehold.remove(0);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
