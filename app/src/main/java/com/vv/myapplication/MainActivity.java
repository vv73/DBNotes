package com.vv.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note = (EditText) findViewById(R.id.note);

    }

    public void addNote(View view) {
        Toast.makeText(this, note.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
}
