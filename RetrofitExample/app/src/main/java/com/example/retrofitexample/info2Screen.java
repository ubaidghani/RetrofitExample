package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class info2Screen extends AppCompatActivity {
    private EditText id;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2_screen);
        id = (EditText) findViewById(R.id.userId);
        submit = (Button)findViewById(R.id.submit);
        Intent i = getIntent();
        String screen = i.getStringExtra("text");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uId = id.getText().toString();
                Intent intent = new Intent(info2Screen.this,dataScreen.class);
                intent.putExtra("id",uId);
                intent.putExtra("text",screen);
                startActivity(intent);
            }
        });
    }
}
