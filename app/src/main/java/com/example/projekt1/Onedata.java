package com.example.projekt1;

public class Onedata {
    private String name;
    private String question;
    private String point;

    public Onedata(String name,String question,String point){
        this.name = name;
        this.question=question;
        this.point=point;
   }

    public String getName() {
        return name;
    }

    public String getQuestion() {
        return question;
    }

    public String getPoint() {
        return point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
