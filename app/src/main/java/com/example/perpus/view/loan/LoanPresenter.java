package com.example.perpus.view.loan;

import com.example.perpus.callback.ListCallBack;
import com.example.perpus.callback.SingleCallback;
import com.example.perpus.converter.ResponseDataList;
import com.example.perpus.converter.ResponseDataObject;
import com.example.perpus.entity.Loan;
import com.example.perpus.network.service.LoanService;

import java.text.ParseException;

import retrofit2.Call;

public class LoanPresenter {

    private LoanView view;
    public LoanPresenter(LoanView view) {
        this.view = view;
    }

    public void doSave(Loan param){
        Call<ResponseDataObject<Loan>> call = LoanService.getInstance().defind(param);
        call.enqueue(new SingleCallback<Loan>() {
            @Override
            public void onDefaultResponse(ResponseDataObject<Loan> response) throws ParseException {
                if (response.getData() != null){
                    view.onSaveSuccess(response.getData());
                }
            }

            @Override
            public void onDefaultFailure(Throwable t) {
                super.onDefaultFailure(t);
            }

            @Override
            public void onGetStatus(String status) {
                super.onGetStatus(status);
            }
        });
    }

    public void doFind(String param){
        Call<ResponseDataList<Loan>> call = LoanService.getInstance().defind(param, 0, 100);
        call.enqueue(new ListCallBack<Loan>() {
            @Override
            public void onDefaultResponse(ResponseDataList<Loan> response) {
                if (response.getData().size() > 0){
                    view.onFindSuccess(response.getData());
                }
            }
        });
    }


}
