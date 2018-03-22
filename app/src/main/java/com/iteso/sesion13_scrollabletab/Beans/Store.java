package com.iteso.sesion13_scrollabletab.Beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jorge Urrea on 20/03/2018.
 */

public class Store implements Parcelable {
    private	int	id;
    private	String	name;

    public Store() {

    }

    public Store(int id, String name, String phone, int thumbnail, double latitude, double longitude, City city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.thumbnail = thumbnail;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
    }

    private	String	phone;
    private	int	thumbnail;
    private	double	latitude;
    private	double	longitude;
    private	City	city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public static Creator<Store> getCREATOR() {
        return CREATOR;
    }

    protected Store(Parcel in) {
        id = in.readInt();
        name = in.readString();
        phone = in.readString();
        thumbnail = in.readInt();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeInt(thumbnail);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
