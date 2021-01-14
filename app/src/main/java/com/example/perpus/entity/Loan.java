package com.example.perpus.entity;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Loan {
    public  enum StatusLoan{
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
}
