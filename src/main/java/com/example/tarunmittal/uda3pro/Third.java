package com.example.tarunmittal.uda3pro;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Third extends AppCompatActivity {

    int x=0;
    String q;
    int y=0;
    Button submit,reset,start;
    TextView timeTextView;
    RadioGroup mGroup, mGroup2,mGroup3,mGroup4,mGroup5,mGroup6,mGroup7,mGroup8,mGroup9,group;
    int count=0;
    LinearLayout l1;
    private EditText mEditText;
    CountDownTimer mCountDownTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        reset= (Button) findViewById(R.id.reset);
        start= (Button) findViewById(R.id.startQuiz);
        l1= (LinearLayout) findViewById(R.id.l1);
        mEditText= (EditText) findViewById(R.id.name);
        submit= (Button) findViewById(R.id.submit);
        mGroup= (RadioGroup) findViewById(R.id.rg1);
         group= (RadioGroup) findViewById(R.id.rg2);
        mGroup2= (RadioGroup) findViewById(R.id.rg3);
        mGroup3= (RadioGroup) findViewById(R.id.rg4);
        mGroup4= (RadioGroup) findViewById(R.id.rg5);
        mGroup5= (RadioGroup) findViewById(R.id.rg6);
        mGroup6= (RadioGroup) findViewById(R.id.rg7);
        mGroup7= (RadioGroup) findViewById(R.id.rg8);
        mGroup8= (RadioGroup) findViewById(R.id.rg9);
        mGroup9= (RadioGroup) findViewById(R.id.rg10);
        timeTextView= (TextView) findViewById(R.id.time);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(y==0) {
                    mGroup.clearCheck();
                    mGroup2.clearCheck();
                    mGroup3.clearCheck();
                    group.clearCheck();
                    mGroup4.clearCheck();
                    mGroup5.clearCheck();
                    mGroup6.clearCheck();
                    mGroup7.clearCheck();
                    mGroup8.clearCheck();
                    mGroup9.clearCheck();
                    count = 0;
                    Toast.makeText(getApplicationContext(), "All Questions are set to reset", Toast.LENGTH_LONG).show();

                    y=1;
                }
                }


        });
    }
    public  void  start(final View view)
    {
        if(TextUtils.isEmpty(mEditText.getText().toString()))
        {
            mEditText.setError("Enter the name");
            mEditText.requestFocus();
        }
        else {
            if (x == 0) {
                        l1.setVisibility(View.VISIBLE);
                mEditText.setVisibility(View.GONE);
                start.setVisibility(View.GONE);

                mCountDownTimer = new CountDownTimer(600000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        long millis = millisUntilFinished;
                        String text = String.format(Locale.getDefault(), "Time Remaining %02d min: %02d sec",
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                        timeTextView.setText(text);
                    }
                    public void onFinish() {
                        setSubmit(view);
                     }
                }.start();
                x=1;
            }
        }
    }
    public void setSubmit(View v) {
        String score1="Total Marks: "+ count;
        String p=mEditText.getText().toString();
            Intent intent = new Intent(Third.this, Score.class);
            intent.putExtra("score", score1);
            intent.putExtra("name", p);
            intent.putExtra("display",q);
            startActivity(intent);
    }
    public void setAnswer(View view)
    {
        int  k=view.getId();
        switch (k)
        {
            case R.id.ans1:count++;
                break;
            case R.id.ans2:count++;
                break;
            case R.id.ans3:count++;
                break;
            case R.id.ans4:count++;
                break;
            case R.id.ans5:count++;
                break;
            case R.id.ans6:count++;
                break;
            case R.id.ans7:count++;
                break;
            case R.id.ans8:count++;
                break;
            case R.id.ans9:count++;
                break;
            case R.id.ans10:count++;
                break;
        }
                    if(count>=9)
        {
            q="Congratulation you are star";
        }
        else  if(count>=7 && count<9)
        {
           q="Good Keep it up";  }
        else if(count>=4 && count<7)
        {
            q="Please improve your skills";
         }
        else if(count>=2 && count<4)
        {
            q="You need to work hard";
        }
        else if(count<2)
        {
           q="Work hard on your skills";
        }
     }

}
