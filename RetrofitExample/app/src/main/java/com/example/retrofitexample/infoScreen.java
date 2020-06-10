package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class infoScreen extends AppCompatActivity {
    private EditText name, age, salary, image;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        salary = (EditText) findViewById(R.id.salary);
        image = (EditText) findViewById(R.id.image);
        submit = (Button) findViewById(R.id.enter);
        Intent i = getIntent();
        String screen1 = i.getStringExtra("text");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = name.getText().toString();
                String umar = age.getText().toString();
                String sal = salary.getText().toString();
                String pic = image.getText().toString();

                Intent intent = new Intent(infoScreen.this,dataScreen.class);
                intent.putExtra("nam",nam);
                intent.putExtra("umar",umar);
                intent.putExtra("sal",sal);
                intent.putExtra("pic",pic);
                intent.putExtra("text",screen1);

                startActivity(intent);
            }
        });

    }
}
