package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] countries = { "1", "2", "3", "4", "5"};
    TextView textView1;
   final  int w=2;
    final  int w1=1;
    final  int w2=3;
    final  int w3=2;
    private AdapterView<?> parent;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second_layout);
            textView1=(TextView) findViewById(R.id.textView1);
            registerForContextMenu(textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.textView1:
                menu.add(1,w,1,"Один");
                menu.add(2,w1,2,"Два");
                menu.add(3,w2,3,"Три");
                break;
        }
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case  w:
                Toast.makeText(MainActivity.this, "Вы нажали один", Toast.LENGTH_SHORT).show();
                break;
            case  w1:
                Toast.makeText(MainActivity.this, "Вы нажали 2", Toast.LENGTH_SHORT).show();
                break;
            case  w2:
                Toast.makeText(MainActivity.this, "Вы нажали 3", Toast.LENGTH_SHORT).show();
                break;
        }
    return super.onContextItemSelected(item);}

    @SuppressLint("NonConstantResourceId")
    public  boolean onOptionsItemSelected (MenuItem item){

        int id= item.getItemId();
        if (id==R.id.action_option){
            Toast.makeText(MainActivity.this, "Нажата иконка настроек", Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.action_p){
         Toast.makeText(MainActivity.this, "Нажата иконка сохранить", Toast.LENGTH_SHORT).show();

        }
        item.setCheckable(true);
        switch (id) {
            case R.id.action_open:
            case R.id.action_save:
            case R.id.action_one:
            case R.id.action_two:
                case R.id.action_fore:
            case R.id.action_five:
                case R.id.action_free:
                item.setChecked(!item.isChecked());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}