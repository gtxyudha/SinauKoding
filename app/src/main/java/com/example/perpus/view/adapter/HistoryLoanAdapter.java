package com.example.perpus.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perpus.R;
import com.example.perpus.entity.Loan;
import com.example.perpus.utils.DateUtils;

import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class HistoryLoanAdapter extends RecyclerView.Adapter<HistoryLoanAdapter.VarianViewHolder> {

    private List<Loan> loanList;

    public HistoryLoanAdapter(List<Loan> loanList){
        this.loanList = loanList;
    }


    @NonNull
    @Override
    public VarianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);

        return new VarianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VarianViewHolder holder, int position) {
        Loan loan = loanList.get(position);

        holder.textJudulBuku.setText(loan.getBook().getTitle());
        holder.textKodeBuku.setText(loan.getBook().getIsbn());
        holder.textBorrowDate.setText(loan.getLoanDate() != null ? DateUtils.converterToDateFromData(loan.getLoanDate()) : "-");
        holder.textReturnDate.setText(loan.getReturnDate() != null ? DateUtils.converterToDateFromData(loan.getReturnDate().toString()) : "-");

    }

    @Override
    public int getItemCount(){
        return loanList.size();
    }

    public class VarianViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.text_judul_buku)
        AppCompatTextView textJudulBuku;

        @BindView(R.id.text_kode_buku)
        AppCompatTextView textKodeBuku;

        @BindView(R.id.text_borrow_date)
        AppCompatTextView textBorrowDate;

        @BindView(R.id.text_return_date)
        AppCompatTextView textReturnDate;
    }



}
