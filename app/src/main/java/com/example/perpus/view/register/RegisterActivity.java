package com.example.perpus.view.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.perpus.R;
import com.example.perpus.entity.User;
import com.example.perpus.view.login.LoginActivity;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegisterView {


    @BindView(R.id.text_username)
    EditText textUsername;

    @BindView(R.id.text_password)
    TextInputLayout textPassword;

    @BindView(R.id.text_confirm_password)
    TextInputLayout textConfirmPassword;

    @BindView(R.id.text_profil_name)
    EditText textProfilName;

    @BindView(R.id.text_address)
    EditText textAddress;

    @BindView(R.id.button_register)
    AppCompatButton buttonRegister;

    private String emailPattern = "[a-zA-Z0-9._-+@[a-z]+\\+[a-z]+";

    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new RegisterPresenter(this);

        textUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!(textUsername.getText().toString().trim().matches(emailPattern) && textUsername.length() > 0)) {
                    textUsername.setError("Masukan username dengan benar");
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void validate() {
        if (textUsername.length() < 3) {
            textUsername.setError("Masukan username dengan benar");
        } else if (textPassword.length < 5) {
            textPassword.setError("Password minimal 5 Karakter");
        } else if (!textPassword.getText().toString().equals(textConfirmPassword.getText().toString())) {
            textConfirmPassword.setError("Password tidak sama");
        } else if (textProfilName.length() < 2) {
            textProfilName.setError("Masukkan Profil Name dengan benar");
        } else if (text_address.length() < 3) {
            text_address.setError("Masukkan alamat dengan benar");
        } else {
            User user = new User();
            user.setUsername(textUsername.getText().toString());
            user.setPassword(textPassword.getText().toString());
            user.setProfileName(textProfilName.getText().toString());
            user.setAddress(text_address.getText().toString());

            presenter.doRegister(user);
        }

    }


    @Override
    public void onRegisterSuccess(User user) {
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onRegisterFailed(String statusCode) {

    }

    @OnClick(R.id.button_register)
    public void onClick() {
        validate();
    }
}