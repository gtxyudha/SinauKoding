package com.example.perpus.entity;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User implements Cloneable, Parcelable {

    private Long id;

    private String profileName;

    private String username;

    private String password;

    private String address;

    private String token;

    protected User(Parcel in){
        if (in.readByte() == 0){
            id = null;
        } else {
            id = in.readLong();
        }
        profileName = in.readString();
        username = in.readString();
        password = in.readString();
        address = in.readString();
        token = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }

        dest.writeString(profileName);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(address);
        dest.writeString(token);

    }
}
