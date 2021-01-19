package com.example.perpus.view.dashboard;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perpus.R;
import com.example.perpus.entity.Book;
import com.example.perpus.view.adapter.BookAdapter;
import com.example.perpus.view.adapter.BookAdapterListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements BookAdapterListener, DashboardView {

    @BindView(R.id.recycleview_book)
    RecyclerView recycleviewBook;

    private BookAdapter bookAdapter;

    private DashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        presenter = new DashboardPresenter(this);
        presenter.dofindBook();
    }

    @Override
    public void onBorrow(Book book) {

    }

    @Override
    public void onFindSuccess(List<Book> bookList) {
        bookAdapter = new BookAdapter(this, bookList, this);

        recycleviewBook.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recycleviewBook.setAdapter(bookAdapter);
    }

    @Override
    public void onFindFailed(String statusCode) {
        Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
    }
}