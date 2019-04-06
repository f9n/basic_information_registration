package io.f9n.basicinformationregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwdEditText;

    private void bind() {
        this.usernameEditText = (EditText) findViewById(R.id.username);
        this.passwdEditText = (EditText) findViewById(R.id.passwd);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bind();
    }

    public void handleLogIn(View v) {
        String username = usernameEditText.getText().toString();
        String passwd = passwdEditText.getText().toString();
        String defaultAdminName = getString(R.string.default_admin_name);
        String defaultAdminPasswd = getString(R.string.default_admin_passwd);

        Log.i("login", String.format("Username: %s, Password: %s", username, passwd));

        if (username.equals(defaultAdminName) && passwd.equals(defaultAdminPasswd)) {
            Log.i("login", "successful");
            // gitIntent intent = new Intent(this. HomeActivity.class);
            // startActivity(intent);
        } else {
            Log.i("login", "unsuccessful");
            Toast.makeText(this, R.string.error_message_of_wrong_login, Toast.LENGTH_LONG).show();
        }
    }

}
