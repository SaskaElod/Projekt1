package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginbutton;
    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent=new Intent(this,VotingActivity.class);
        loginbutton=findViewById(R.id.login_button);
        username=findViewById(R.id.name_editText);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name = username.getText().toString();
                //Log.d("aaaaaaaaaa",name);
                if(name==" ")
                {
                    Toast.makeText(MainActivity.this, "Need to write username!", Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("username", name);
                    startActivity(intent);
                }
            }
        });
    }
}
