package com.example.mockitoexampleproject.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mockitoexampleproject.Contract;
import com.example.mockitoexampleproject.LoginPresenter;
import com.example.mockitoexampleproject.R;
import com.example.mockitoexampleproject.data.LoginCredentials;
import com.example.mockitoexampleproject.data.LoginRepositoryImpl;

public class LoginActivity extends AppCompatActivity implements Contract.LoginView {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(new LoginRepositoryImpl(), this);

        final EditText emailView = findViewById(R.id.email);
        final EditText passwordView = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = emailView.getText().toString();
                String password = passwordView.getText().toString();

                LoginCredentials credentials = new LoginCredentials(email, password);
                presenter.login(credentials);
            }

        });
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getBaseContext(), "successfully completed", Toast.LENGTH_SHORT).show();
        System.out.println("successfully completed");
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
        System.out.println(message);

    }
}
