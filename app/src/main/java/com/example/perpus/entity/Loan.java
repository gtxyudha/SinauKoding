package com.example.perpus.entity;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Loan implements Parcelable, Cloneable {
    public enum StatusLoan{
        BORROWED,
        RETURNED;

        @Getter
        private String name;
    }

    private String typeIdentity;

    private String numberIdentity;

    private int duration;

    private Date loanDate;

    private Date returnDate;

    private StatusLoan status;

    private Book book;

    private User user;

    public Loan(Parcel in){
        typeIdentity = in.readString();
        numberIdentity = in.readString();
        duration = in.readInt();
        long tmpLoanDate = in.readLong();
        loanDate = tmpLoanDate == -1 ? null : new Date(tmpLoanDate);
        long tmpReturnDate = in.readLong();
        returnDate = tmpReturnDate == -1 ? null : new Date(tmpReturnDate);
        book = in.readParcelable(Book.class.getClassLoader());
        user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Loan> CREATOR = new Creator<Loan>() {
        @Override
        public Loan createFromParcel(Parcel in) {
            return new Loan(in);
        }

        @Override
        public Loan[] newArray(int size) {
            return new Loan[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(typeIdentity);
        dest.writeString(numberIdentity);
        dest.writeInt(duration);
        dest.writeLong(loanDate != null ? loanDate.getTime() : -1);
        dest.writeLong(returnDate != null ? returnDate.getTime() : -1);
        dest.writeParcelable(book, flags);
        dest.writeParcelable(user, flags);
    }
}
