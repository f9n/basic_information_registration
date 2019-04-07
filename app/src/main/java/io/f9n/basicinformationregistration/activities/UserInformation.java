package io.f9n.basicinformationregistration.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import io.f9n.basicinformationregistration.R;
import io.f9n.basicinformationregistration.models.User;


public class UserInformation extends AppCompatActivity {
    @BindView(R.id.name_and_surname_text) TextView nameNsurnameText;
    @BindView(R.id.tc) TextView tcText;
    @BindView(R.id.email) TextView emailText;
    @BindView(R.id.phone) TextView phoneText;

    User user;

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
        ButterKnife.bind(this);

        Intent intent = getIntent();
        user = intent.getParcelableExtra("user");
        Log.i("user_information", user.toString());

        this.bindUserVariablesToViews();
    }

    @OnClick(R.id.lectures_button)
    public void handleToDisplayLectures(View v) {
        // Intent intent = new Intent(this, Lectures.class);
        // startActivity(intent);
    }

    @OnClick(R.id.phone)
    public void handleToCall(View v) {
        String phoneNumber = phoneText.getText().toString();
        Log.i("user_information", String.format("Phone Number: %s", phoneNumber));
        Uri callNumber = Uri.parse(String.format("tel:%s", phoneNumber));
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(callNumber);
        startActivity(intent);
    }

    @OnClick(R.id.email)
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
