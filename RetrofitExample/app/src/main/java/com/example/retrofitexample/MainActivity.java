package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button userProfiles,addProfile,specificProfile,deleteProfile;
    String text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userProfiles = (Button) findViewById(R.id.userProfiles);
        addProfile = (Button) findViewById(R.id.addProfile);
        specificProfile = (Button) findViewById(R.id.specificProile);
        deleteProfile = (Button) findViewById(R.id.deleteProfile);


        userProfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "userProfiles";
                Intent intent = new Intent(MainActivity.this, dataScreen.class);
                intent.putExtra("text",text);
                startActivity(intent);
            }
        });

        addProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "addProfile";
                Intent intent = new Intent(MainActivity.this, infoScreen.class);
                intent.putExtra("text",text);
                startActivity(intent);
            }
        });

        specificProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "specificProfile";
                Intent intent = new Intent(MainActivity.this, info2Screen.class);
                intent.putExtra("text",text);
                startActivity(intent);
            }
        });

        deleteProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text = "deleteProfile";
                Intent intent = new Intent(MainActivity.this, info2Screen.class);
                intent.putExtra("text",text);
                startActivity(intent);
            }
        });


    }
}
