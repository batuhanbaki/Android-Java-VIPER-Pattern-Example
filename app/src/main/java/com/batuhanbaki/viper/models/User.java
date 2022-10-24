package com.batuhanbaki.viper.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String Id;
    private String PhoneNumber;
    private String RememberToken;
    private String RememberTokenEndDate;
    private String CreatedAt;
    private String UpdatedAt;
    private String Token;
    private String TokenEndDate;


    public User(String id, String phoneNumber, String rememberToken, String rememberTokenEndDate, String createdAt, String updatedAt, String token, String tokenEndDate) {
        Id = id;
        PhoneNumber = phoneNumber;
        RememberToken = rememberToken;
        RememberTokenEndDate = rememberTokenEndDate;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
        Token = token;
        TokenEndDate = tokenEndDate;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getRememberToken() {
        return RememberToken;
    }

    public void setRememberToken(String rememberToken) {
        RememberToken = rememberToken;
    }

    public String getRememberTokenEndDate() {
        return RememberTokenEndDate;
    }

    public void setRememberTokenEndDate(String rememberTokenEndDate) {
        RememberTokenEndDate = rememberTokenEndDate;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getTokenEndDate() {
        return TokenEndDate;
    }

    public void setTokenEndDate(String tokenEndDate) {
        TokenEndDate = tokenEndDate;
    }


    public User(Parcel in) {
        this.Id = in.readString();
        this.PhoneNumber = in.readString();
        this.RememberToken = in.readString();
        this.RememberTokenEndDate = in.readString();
        this.CreatedAt = in.readString();
        this.UpdatedAt = in.readString();
        this.Token = in.readString();
        this.TokenEndDate = in.readString();
    }

    public void readFromParcel(Parcel in) {
        this.Id = in.readString();
        this.PhoneNumber = in.readString();
        this.RememberToken = in.readString();
        this.RememberTokenEndDate = in.readString();
        this.CreatedAt = in.readString();
        this.UpdatedAt = in.readString();
        this.Token = in.readString();
        this.TokenEndDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Id);
        dest.writeString(this.PhoneNumber);
        dest.writeString(this.RememberToken);
        dest.writeString(this.RememberTokenEndDate);
        dest.writeString(this.CreatedAt);
        dest.writeString(this.UpdatedAt);
        dest.writeString(this.Token);
        dest.writeString(this.TokenEndDate);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
