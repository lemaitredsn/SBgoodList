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

public class ToolsActivity extends AppCompatActivity {
    ArrayList<String> arrayListTools;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        listView = findViewById(R.id.listViewTools);
        arrayListTools = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListTools);
        listView.setAdapter(arrayAdapter);
    }

    public void onClickButtonAdd(View view) {
        EditText editTextTools = findViewById(R.id.editTextTools);
        String item = editTextTools.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте покупку", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListTools.add(item);
            arrayAdapter.notifyDataSetChanged();
            editTextTools.setText("");
        }
    }

    public void onClickButtonRemove(View view) {
        if(arrayListTools.isEmpty()){
            Toast toast = Toast.makeText(this,"Список пуст", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }else{
            arrayListTools.remove(0);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
