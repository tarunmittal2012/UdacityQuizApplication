package com.example.tarunmittal.uda3pro;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Score extends AppCompatActivity {
TextView mTextView,mTextView1,mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mTextView= (TextView) findViewById(R.id.displayMarks);
        mTextView.setText(getIntent().getExtras().getString("score"));

        mTextView1= (TextView) findViewById(R.id.pname);
        mTextView2= (TextView) findViewById(R.id.displayMsg);
        mTextView1.setText(getIntent().getExtras().getString("name"));
        mTextView2.setText(getIntent().getExtras().getString("display"));
        mTextView2.setVisibility(View.VISIBLE);
        String a=mTextView.getText().toString();
        //String p=String.valueOf(a);
      /* int b=Integer.parseInt(a);
        if(b>9)
        {
            mTextView2.setText(R.string.display1);
        }
      else  if(b>=7 && b<9)
        {
mTextView2.setText(R.string.display2);
        }
        else if(b>=4 && b<7)
        {
            mTextView2.setText(R.string.display3);
        }
        else if(b>2 && b<4)
        {
            mTextView2.setText(R.string.display4);
        }
        else
        {
            mTextView2.setText(R.string.display5);
        }
*/
    }
    public void share(View view)
    {
        String mblNumVar = "+91 8077346814";
        Intent smsMsgAppVar = new Intent(Intent.ACTION_VIEW);
        smsMsgAppVar.setData(Uri.parse("sms:" +  mblNumVar));
        smsMsgAppVar.putExtra("sms_body", "Hello my name is"+ mTextView1.getText().toString()+" "+ "I get" +mTextView.getText().toString());
        startActivity(smsMsgAppVar);
    }

    @Override
    public void onBackPressed() {

    }
}
