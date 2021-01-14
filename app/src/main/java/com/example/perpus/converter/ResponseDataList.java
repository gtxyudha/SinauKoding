package com.example.perpus.converter;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDataList<T> implements Parcelable {

    @SerializedName("data")
    private List<T> data;

    @SerializedName("status")
    private String status;

    protected ResponseDataList(Parcel in){
        this.status = in.readString();
    }

    public static final Creator<ResponseDataList> CREATOR = new Creator<ResponseDataList>() {
        @Override
        public ResponseDataList createFromParcel(Parcel in) {
            return ResponseDataList(in);
        }

        @Override
        public ResponseDataList[] newArray(int size) {
            return new ResponseDataList[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
