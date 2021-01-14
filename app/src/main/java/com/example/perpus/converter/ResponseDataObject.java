package com.example.perpus.converter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseDataObject<T> implements Parcelable {

    @SerializedName("data")
    private T data;

    @SerializedName("status")
    private String status;

    protected ResponseDataObject(Parcel in){
        this.status = in.readString();
    }

    public static final Creator<ResponseDataObject> CREATOR = new Creator<ResponseDataObject>() {
        @Override
        public ResponseDataObject createFromParcel(Parcel in) {
            return new ResponseDataObject(in);
        }

        @Override
        public ResponseDataObject[] newArray(int size) {
            return new ResponseDataObject[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
    }
}
