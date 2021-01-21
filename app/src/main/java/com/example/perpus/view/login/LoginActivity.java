package com.example.perpus.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.perpus.R;
import com.example.perpus.entity.User;
import com.example.perpus.session.SessionManager;
import com.example.perpus.view.dashboard.DashboardActivity;
import com.example.perpus.view.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.text_username)
    AppCompatEditText textUsername;

    @BindView(R.id.text_password)
    AppCompatEditText textPassword;

    @BindView(R.id.button_login)
    AppCompatButton buttonLogin;

    @BindView(R.id.button_link_register)
    AppCompatButton buttonLinkRegister;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this, this);

    }


    private void validation() {
        if (textUsername.getText().length() < 5) {
            textUsername.setError("Silahkan masukan Username yang Benar");
        } else if (textPassword.getText().length() < 3) {
            textPassword.setError("Silahkan masukan password dengan benar");
        } else {
            User user = new User();
            user.setUsername(textUsername.getText().toString());
            user.setPassword(textPassword.getText().toString());

            buttonLogin.setEnabled(false);

            presenter.doLogin(user);
        }
    }

    @Override
    public void onLoginSuccess(User user) {
        startActivity(new Intent(this, DashboardActivity.class));
        SessionManager.getInstance(this).doLogin();

        buttonLogin.setEnabled(true);
    }

    @Override
    public void onLoginFailed(String statusCode) {
        buttonLogin.setEnabled(true);
    }


    @OnClick({R.id.button_login, R.id.button_link_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                validation();
                break;
            case R.id.button_link_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}