package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Feedback extends AppCompatActivity {

    TextView exp;
    Button fbbutton;
    EditText editto, editsub, editbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editto =  (EditText)findViewById(R.id.toedit);
        editsub = (EditText)findViewById(R.id.subedit);
        editbody = (EditText)findViewById(R.id.bodyedit);
        fbbutton = (Button)findViewById(R.id.sendfb);
        exp = (TextView)findViewById(R.id.experience);
        YoYo.with(Techniques.FadeInUp).duration(2000).repeat(0).playOn(exp);
        fbbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String recipientList = editto.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = editsub.getText().toString();
        String body = editbody.getText().toString();

        Intent imail = new Intent(Intent.ACTION_SEND);
        imail.putExtra(Intent.EXTRA_EMAIL, recipients);
        imail.putExtra(Intent.EXTRA_SUBJECT, subject);
        imail.putExtra(Intent.EXTRA_TEXT, body);
        imail.setType("message/rfc822");
        startActivity(Intent.createChooser(imail, "choose an email client to send feedback"));
    }
}
