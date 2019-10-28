package com.example.projekt1;

public class Onedata {
    public static final String TABLE_NAME = "users_table";

    public static final String name = "name";
    public static final String question="question";
    public static final String point="point";


    private int id;
    private String data;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + name + " STRING PRIMARY KEY AUTOINCREMENT,"
                    + question + " STRING"
                    + point + "STRING"+")";
    public Onedata(int id,String data){
        this.id = id;
        this.data=data;

   }

    public Onedata() {

    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String hobbie) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public String getName() {
        return name;
    }

    public String getPoint() {
        return point;
    }




}
