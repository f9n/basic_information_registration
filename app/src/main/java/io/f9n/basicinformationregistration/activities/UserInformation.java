package io.f9n.basicinformationregistration.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import io.f9n.basicinformationregistration.R;
import io.f9n.basicinformationregistration.models.User;


public class UserInformation extends AppCompatActivity {
    User user;
    TextView nameNsurnameText, tcText, emailText, phoneText;

    private void bind() {
        this.nameNsurnameText = (TextView) findViewById(R.id.name_and_surname_text);
        this.tcText = (TextView) findViewById(R.id.tc_text);
        this.emailText = (TextView) findViewById(R.id.email_text);
        this.phoneText = (TextView) findViewById(R.id.phone_text);
    }

    private void bindUserVariablesToViews() {
        String nameNsurname = String.format("%s %s", user.getName(), user.getSurname());
        nameNsurnameText.setText(nameNsurname);
        tcText.setText(user.getTc());
        emailText.setText(user.getEmail());
        phoneText.setText(user.getPhone());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        this.bind();

        Intent intent = getIntent();
        user = intent.getParcelableExtra("user");
        Log.i("user_information", user.toString());

        this.bindUserVariablesToViews();
    }

    public void handleToDisplayLectures(View v) {
        // Intent intent = new Intent(this, Lectures.class);
        // startActivity(intent);
    }

    public void handleToCall(View v) {
        String phoneNumber = phoneText.getText().toString();
        Log.i("user_information", String.format("Phone Number: %s", phoneNumber));
        Uri callNumber = Uri.parse(String.format("tel:%s", phoneNumber));
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(callNumber);
        startActivity(intent);
    }

    public void handleToSendEmail(View v) {
        String email = emailText.getText().toString();
        Log.i("user_information", String.format("Email: %s", email));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL  , email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Assignment02 - Fatih Sarhan");
        intent.putExtra(Intent.EXTRA_TEXT, "Content");
        startActivity(intent);
    }
}
