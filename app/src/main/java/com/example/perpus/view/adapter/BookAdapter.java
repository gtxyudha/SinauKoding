package com.example.perpus.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perpus.R;
import com.example.perpus.entity.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.VarianViewHolder> {

    private Context context;

    private List<Book> bookList;

    private BookAdapterListener listener;

    public BookAdapter(Context context, List<Book> bookList, BookAdapterListener listener) {
        this.context = context;
        this.bookList = bookList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public VariantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new VarianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VarianViewHolder holder, int position) {
        if (bookList.size() > 0){
            Book book = bookList.get(position);

            holder.imageBook.setImageResource(R.drawable.ic_launcher_background);
            holder.titleBook.setText(book.getTitle());
            holder.bookCode.setText(book.getIsbn());
            holder.description.setText(book.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }



    public class VarianViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.image_book)
        AppCompatImageView imageBook;

        @BindView(R.id.title_book)
        AppCompatTextView titleBook;

        @BindView(R.id.book_code)
        AppCompatTextView bookCode;

        @BindView(R.id.description)
        AppCompatTextView description;

        @BindView(R.id.button_pinjam)
        AppCompatButton buttonPinjam;

        public VarianViewHolder(@NonNull View itemView){
            super(itemView);

            ButterKnife.bind(this, itemView);

            buttonPinjam.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button_pinjam){
                listener.onBorrow(bookList.get(getAdapterPosition()));
            }
        }
    }
}
