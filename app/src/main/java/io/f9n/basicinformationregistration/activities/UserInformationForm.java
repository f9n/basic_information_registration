package io.f9n.basicinformationregistration.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import io.f9n.basicinformationregistration.R;
import io.f9n.basicinformationregistration.models.User;

public class UserInformationForm extends AppCompatActivity {
    private EditText nameEditText, surnameEditText, tcEditText, emailEditText, phoneEditText;
    private ImageView profilePhoto;

    private void bind() {
        this.nameEditText = (EditText) findViewById(R.id.name);
        this.surnameEditText = (EditText) findViewById(R.id.surname);
        this.tcEditText = (EditText) findViewById(R.id.tc);
        this.emailEditText = (EditText) findViewById(R.id.email);
        this.phoneEditText = (EditText) findViewById(R.id.phone);
        this.profilePhoto = (ImageView) findViewById(R.id.profile_photo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information_form);

        this.bind();
    }

    public void handleClearText(View v) {
        this.clearEditTexts(this.nameEditText, this.surnameEditText, this.tcEditText, this.emailEditText, this.phoneEditText);
    }

    private void clearEditTexts(EditText... objects) {
        for (EditText obj : objects) {
            obj.setText("");
        }
    }

    public void handleSave(View v) {
        String name = this.nameEditText.getText().toString();
        String surname = this.surnameEditText.getText().toString();
        String tc = this.tcEditText.getText().toString();
        String email = this.emailEditText.getText().toString();
        String phone = this.phoneEditText.getText().toString();

        User user = new User(name, surname, tc, email, phone);
        Log.i("user_information_form", user.toString());

        if (user.isValid()) {
            Toast.makeText(this, R.string.error_message_of_wrong_user_informations, Toast.LENGTH_LONG).show();
            return;
        }

        // Intent intent = new Intent(this, UserInformation.class);
        // intent.putExtra("user", user);
        // startActivity(intent);
    }
}
