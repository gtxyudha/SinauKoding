package com.example.perpus.view.dashboard;

import com.example.perpus.callback.ListCallBack;
import com.example.perpus.converter.ResponseDataList;
import com.example.perpus.entity.Book;
import com.example.perpus.network.service.BookService;

import retrofit2.Call;

public class DashboardPresenter {
    private DashboardView view;

    public DashboardPresenter(DashboardView view) {
        this.view = view;
    }

    public void dofindBook(){
        Call<ResponseDataList<Book>> call = BookService.getInstance().defindBook(null, 0, 100);
        call.enqueue(new ListCallBack<Book>() {
            @Override
            public void onDefaultResponse(ResponseDataList<Book> response) {
                if (response.getData().size() > 0){
                    view.onFindSuccess(response.getData());
                }
            }
        });
    }

}
