package com.example.perpus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.perpus.entity.Book;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textView.setText("Sinau Koding Android");

        Book book = new Book();
        book.setId((long)1);
        book.setTitle("Sinau Koding 1");
        book.setIsbn("4492928302");

        textView.setText(book.getTitle());





    }
}