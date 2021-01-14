package com.example.perpus.entity;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Book implements Parcelable, Cloneable {

    private Long id;

    private String title;

    private String isbn;

    private String author;

    private String publisher;

    private String description;

    protected Book(Parcel in){
        if (in.readByte() == 0){
            id = null;
        } else {
            id = in.readLong();
        }

        title = in.readString();
        isbn = in.readString();
        author = in.readString();
        publisher = in.readString();
        description = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null){
            dest.writeByte((byte)0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(title);
        dest.writeString(isbn);
        dest.writeString(author);
        dest.writeString(publisher);
        dest.writeString(description);

    }
}
