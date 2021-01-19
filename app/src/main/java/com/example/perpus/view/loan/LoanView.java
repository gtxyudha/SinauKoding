package com.example.perpus.view.loan;

import com.example.perpus.entity.Loan;

import java.util.List;

public interface LoanView {
    void onSaveSuccess(Loan loan);

    void onSaveFailed(String statusCode);

    void onFindFailed(String statusCode);

    void onFindSuccess(List<Loan> loanList);


}
