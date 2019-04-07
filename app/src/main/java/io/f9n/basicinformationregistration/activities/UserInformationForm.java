package io.f9n.basicinformationregistration.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import io.f9n.basicinformationregistration.R;
import io.f9n.basicinformationregistration.models.User;

public class UserInformationForm extends AppCompatActivity {
    @BindView(R.id.name) EditText nameEditText;
    @BindView(R.id.surname) EditText surnameEditText;
    @BindView(R.id.tc) EditText tcEditText;
    @BindView(R.id.email) EditText emailEditText;
    @BindView(R.id.phone) EditText phoneEditText;
    @BindView(R.id.profile_photo) ImageView profilePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.clear_button)
    public void handleToClearText(View v) {
        this.clearEditTexts(this.nameEditText, this.surnameEditText, this.tcEditText, this.emailEditText, this.phoneEditText);
    }

    private void clearEditTexts(EditText... objects) {
        for (EditText obj : objects) {
            obj.setText("");
        }
    }

    @OnClick(R.id.save_button)
    public void handleToSave(View v) {
        String name = this.nameEditText.getText().toString();
        String surname = this.surnameEditText.getText().toString();
        String tc = this.tcEditText.getText().toString();
        String email = this.emailEditText.getText().toString();
        String phone = this.phoneEditText.getText().toString();

        User user = new User(name, surname, tc, email, phone);
        Log.i("user_information_form", user.toString());

        if (user.isNotValid()) {
            Toast.makeText(this, R.string.error_message_of_wrong_user_informations, Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, UserInformation.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
