package com.example.tarunmittal.uda3pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b1 = (Button) findViewById(R.id.Quiz);
        View textView = findViewById(R.id.w);
        textView.setVisibility(View.VISIBLE);

    }
    public void dothis(View view)
    {
        Intent i=new Intent(Second.this,Third.class);
        startActivity(i);

    }
    }

