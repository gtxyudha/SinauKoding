package com.example.perpus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.perpus.R;
import com.example.perpus.entity.Book;
import com.example.perpus.session.SessionManager;
import com.example.perpus.view.dashboard.DashboardActivity;
import com.example.perpus.view.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private static MainActivity INSTANCE;

    public static synchronized MainActivity getInstance(){
        return INSTANCE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (SessionManager.getInstance(this).isLogin()){
            startActivity(new Intent(this, DashboardActivity.class));
        } else{
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}