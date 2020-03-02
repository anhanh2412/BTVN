package com.example.btvnlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int number;
    ArrayList<String> arrayList;
    ListView lv;
    Button bt_add, bt_update;
    EditText edit_name;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWight();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        lv.setAdapter(arrayAdapter);
        setEvenAdd();
        setContact();;

    }

    public void setWight(){
        arrayList = new ArrayList<>();
        lv = findViewById(R.id.lv);
        bt_add = findViewById(R.id.bt_add);
        bt_update = findViewById(R.id.bt_update);
        edit_name = findViewById(R.id.edit_name);
    }

    public void setEvenAdd(){
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edit_name.getText().toString().trim();
                if(TextUtils.isEmpty(monHoc)){
                    Toast.makeText(MainActivity.this, "mời bạn nhập tên môn học", Toast.LENGTH_LONG).show();
                }else{
                    arrayList.add(monHoc);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    public void setContact(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                number = position;
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                arrayList.set(number, name);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("dl", arrayList.get(position));
                startActivity(intent);
                return false;
            }
        });
    }

}
