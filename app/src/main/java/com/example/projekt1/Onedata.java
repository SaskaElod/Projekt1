package com.example.projekt1;

public class Onedata {
    public static final String name = "name";
    public static final String question="question";
    public static final String point="point";

    private int id;
    private String data;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + name + "("
                    + question + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + point + " TEXT"
                    + ")";
    public Onedata(int id,String data){
        this.id = id;
        this.data=data;

   }

    public int getid() {
        return id;
    }

    public String getData() {
        return data;
    }
    public void setData(String data){
        this.data=data;
    }
    public void setId(int id)
    {
        this.id=id;
    }
}
