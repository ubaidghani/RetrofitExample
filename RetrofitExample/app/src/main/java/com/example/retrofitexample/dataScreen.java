package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.util.List;

public class dataScreen extends AppCompatActivity {
    private TextView info;
    private Button home;
    String baseurl = "https://dummy.restapiexample.com/api/v1/";
    private JsonInterface jsonInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_screen);


        String option = getIntent().getStringExtra("text");
        info = (TextView) findViewById(R.id.info);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                .build();

        jsonInterface = retrofit.create(JsonInterface.class);
        if(option.equalsIgnoreCase("userProfiles")){
            getProfile();
        }else if(option.equalsIgnoreCase("addProfile")){
            addProfile();
        }else if(option.equalsIgnoreCase("specificProfile")){
            getIndividualProfile();
        }else if(option.equalsIgnoreCase("deleteProfile")){
            deleteProfile();
        }

        home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });





    }

    private void deleteProfile() {

        int uID = Integer.parseInt(getIntent().getStringExtra("id"));
        Call<Void> call = jsonInterface.deletePost(uID);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(getApplicationContext(),"Profile Deleted Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(dataScreen.this,MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                info.setText(t.getMessage());
            }
        });
    }

    private void addProfile() {


        String naam = getIntent().getStringExtra("nam");
        int umar = Integer.parseInt(getIntent().getStringExtra("umar"));
        String sal = getIntent().getStringExtra("sal");
        String image = getIntent().getStringExtra("pic");

        Profile prof = new Profile(naam,sal,umar,image);
        Call<Profile> call = jsonInterface.addProf(prof);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()){
                    info.setText("ERROR: " + response.code());
                    return;
                }
                Profile posts = (Profile) response.body();

                String content = "";
                content += "employee_name: " + Profile.getEmployee_name() + "\n";
                content += "employee_salary: " + Profile.getEmployee_salary() + "\n";
                content += "employee_age: " + Profile.getEmployee_age() + "\n";
                content += "image: " + Profile.getProfile_image() + "\n\n";
                info.append(content);
                Toast.makeText(getApplicationContext(),"Data Uploaded Successfully",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                info.setText(t.getMessage());
            }
        });


    }

    private void getIndividualProfile(){

        int userID = Integer.parseInt(getIntent().getStringExtra("id"));
        Call<Profile> call = jsonInterface.getIndividualProfile(userID);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()){
                    info.setText("ERROR: " + response.code());
                    return;
                }
                Profile posts = (Profile) response.body();

                String content = "";
                content += "id: " + Profile.getId() + "\n";
                content += "employee_name: " + Profile.getEmployee_name() + "\n";
                content += "employee_salary: " + Profile.getEmployee_salary() + "\n";
                content += "employee_age: " + Profile.getEmployee_age() + "\n";
                content += "image: " + Profile.getProfile_image() + "\n\n";
                info.append(content);

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                info.setText(t.getMessage());
            }
        });


    }

    private void getProfile() {
        Call<Profile> call = jsonInterface.getEmployees();
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()){
                    info.setText("ERROR: " + response.code());
                    return;
                }
                Profile posts = (Profile) response.body();

                    String content = "";
                    content += "id: " + Profile.getId() + "\n";
                    content += "employee_name: " + Profile.getEmployee_name() + "\n";
                    content += "employee_salary: " + Profile.getEmployee_salary() + "\n";
                    content += "employee_age: " + Profile.getEmployee_age() + "\n";
                    content += "image: " + Profile.getProfile_image() + "\n\n";
                    info.append(content);

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                info.setText(t.getMessage());

            }
        });


    }

}
