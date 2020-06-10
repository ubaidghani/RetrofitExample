package com.example.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Profile {


    private static int id;
    private static String employee_name;
    private static String employee_salary;
    private static int employee_age;
    private static String profile_image;

    public Profile(String name, String sal, int age, String image) {
        this.employee_name = name;
        this.employee_salary = sal;
        this.employee_age = age;
        this.profile_image = image;
    }

    public static int getId() {
        return id;
    }

    public static String getEmployee_name() {
        return employee_name;
    }

    public static String getEmployee_salary() {
        return employee_salary;
    }

    public static int getEmployee_age() {
        return employee_age;
    }

    public static String getProfile_image() {
        return profile_image;
    }
}
