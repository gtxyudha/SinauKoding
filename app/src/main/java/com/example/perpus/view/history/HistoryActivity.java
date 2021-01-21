package com.example.perpus.view.history;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.perpus.R;
import com.example.perpus.entity.Loan;
import com.example.perpus.entity.User;
import com.example.perpus.session.SessionManager;
import com.example.perpus.view.adapter.HistoryLoanAdapter;
import com.example.perpus.view.loan.LoanPresenter;
import com.example.perpus.view.loan.LoanView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity implements LoanView {

    @BindView(R.id.recycler_loan)
    RecyclerView recyclerLoan;

    private HistoryLoanAdapter loanAdapter;

    private LoanPresenter presenter;

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        presenter = new LoanPresenter(this);

        currentUser = SessionManager.getInstance(this).getCurrentLogin();

        Loan loan = new Loan();
        loan.setUser(currentUser);

        presenter.doFind(new Gson().toJson(loan));

    }

    @Override
    public void onSaveSuccess(Loan loan) {

    }

    @Override
    public void onSaveFailed(String statusCode) {

    }

    @Override
    public void onFindFailed(String statusCode) {

    }

    @Override
    public void onFindSuccess(List<Loan> loanList) {
        loanAdapter = new HistoryLoanAdapter(loanList);
        recyclerLoan.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerLoan.setAdapter(loanAdapter);
    }
}