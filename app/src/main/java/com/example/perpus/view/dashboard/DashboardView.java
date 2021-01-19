package com.example.perpus.view.dashboard;

import com.example.perpus.entity.Book;

import java.util.List;

public interface DashboardView {
    void onFindSuccess(List<Book> bookList);

    void onFindFailed(String statusCode);

}
