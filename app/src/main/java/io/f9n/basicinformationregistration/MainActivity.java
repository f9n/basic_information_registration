package io.f9n.basicinformationregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import io.f9n.basicinformationregistration.activities.UserInformationForm;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.username) EditText usernameEditText;
    @BindView(R.id.passwd) EditText passwdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button) void handleToLogIn(View v) {
        String username = usernameEditText.getText().toString();
        String passwd = passwdEditText.getText().toString();
        String defaultAdminName = getString(R.string.default_admin_name);
        String defaultAdminPasswd = getString(R.string.default_admin_passwd);

        Log.i("login", String.format("Username: %s, Password: %s", username, passwd));

        if (username.equals(defaultAdminName) && passwd.equals(defaultAdminPasswd)) {
            Log.i("login", "successful");
            Intent intent = new Intent(this, UserInformationForm.class);
            startActivity(intent);
        } else {
            Log.i("login", "unsuccessful");
            Toast.makeText(this, R.string.error_message_of_wrong_login, Toast.LENGTH_LONG).show();
        }
    }

}
