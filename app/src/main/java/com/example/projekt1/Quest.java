package com.example.projekt1;

public class Quest {

    String username;
    String question;
    String answer;
    public static String[] textArray = {"username"};
    public static String[] questArray = {"question"};
    public static String[] answerArray = {"Answer"};

    public Quest(String text, String comment, String date)
    {
        this.username = username;
        this.question = question;
        this.answer = answer;
    }

    public String getText()
    {
        return username;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

}

