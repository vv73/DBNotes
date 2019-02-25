package com.vv.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText note;
    DBManager dbManager;
    ListView listView;
    SimpleCursorAdapter adapter;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note = (EditText) findViewById(R.id.note);
        dbManager = DBManager.getInstance(this);
        listView = (ListView)findViewById(R.id.list);
        //data =  dbManager.getAllNotes();
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        Cursor cursor = dbManager.getAllNotes();
        adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor, new String[]{"NOTE"}, new int[]{android.R.id.text1},0);
        listView.setAdapter(adapter);
    }

    public void addNote(View view) {
        Toast.makeText(this, note.getText().toString(),
                Toast.LENGTH_SHORT).show();
        dbManager.addNote(note.getText().toString());

        Cursor cursor = dbManager.getAllNotes();
        adapter.changeCursor(cursor);
        adapter.notifyDataSetChanged();
    }

}
