package com.example.perpus.view.loan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;

import com.example.perpus.R;
import com.example.perpus.entity.Book;
import com.example.perpus.entity.Loan;
import com.example.perpus.entity.User;
import com.example.perpus.session.SessionManager;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoanActivity extends AppCompatActivity implements LoanView {

    @BindView(R.id.text_title_book)
    TextView textTitleBook;

    @BindView(R.id.text_bookcode)
    TextView textBookcode;

    @BindView(R.id.text_name)
    TextView textName;

    @BindView(R.id.spinner_identitas)
    AppCompatSpinner spinnerIdentitas;

    @BindView(R.id.input_nomor_identitas)
    TextInputEditText inputNomorIdentitas;

    @BindView(R.id.input_loan_duration)
    TextInputEditText inputLoanDuration;

    @BindView(R.id.button_submit)
    AppCompatButton buttonSubmit;

    private LoanPresenter presenter;

    private User currentUser;

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        ButterKnife.bind(this);

        presenter = new LoanPresenter(this);

        currentUser = SessionManager.getInstance(this).getCurrentLogin();

        book = getIntent() != null ? getIntent().getParcelableExtra("book") : new Book();

        if (book != null){
            textTitleBook.setText(book.getTitle());
            textBookcode.setText(book.getIsbn());
        }
        textName.setText(currentUser.getProfileName());




    }

    @Override
    public void onSaveSuccess(Loan loan) {
        finish();

        buttonSubmit.setEnabled(true);
    }

    @Override
    public void onSaveFailed(String statusCode) {

    }

    @Override
    public void onFindFailed(String statusCode) {
        buttonSubmit.setEnabled(true);
    }

    @Override
    public void onFindSuccess(List<Loan> loanList) {

    }

    @OnClick(R.id.button_submit)
    public void onClick() {
        validation();
        buttonSubmit.setEnabled(false);
    }

    private void validation(){
        if (inputNomorIdentitas.length() < 5) {
            inputNomorIdentitas.setError("Masukkan Nomor Identitas yang Benar");
        } else if (Integer.parseInt(inputLoanDuration.getText().toString()) <= 0 && inputLoanDuration.length() < 0){
            inputLoanDuration.setError("Masukkan durasi peminjamanan");
        } else {
            Loan loan = new Loan();
            loan.setBook(book);
            loan.setUser(currentUser);
            loan.setTypeIdentity(spinnerIdentitas.getSelectedItem().toString());
            loan.setNumberIdentity((inputNomorIdentitas.getText().toString()));
            loan.setDuration(Integer.parseInt(inputLoanDuration.getText().toString()));

            presenter.doSave(loan);



        }
    }
}