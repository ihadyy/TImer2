package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private boolean flag = true;
    private int num = 0,num1=0;
    private Thread count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.Timer);
        }
    public void start(View view) {
        count = new Thread(() -> {
            try {
                flag=true;
                while (flag) {
                    num++;
                    txt.setText(+num1 + ""+":"+num+ "");
                    if(num==59)
                    {
                        num=0;
                        num1++;
                        txt.setText(+num1 + ""+":"+num+ "");
                    }
                    Thread.sleep(1000);


                }
            } catch (Exception e) {

            }
        });
        count.start();

    }
    public void reset (View view)
    {
        txt.setText("00:00");
        flag=false;
    }
    public void Stop(View view) {
        flag=false;
        Thread.interrupted();
    }
    }
