package com.iteso.sesion13_scrollabletab.Beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jorge Urrea on 20/03/2018.
 */

public class City implements Parcelable{
    private	int	id;
    private	String	name;

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

    public static Creator<City> getCREATOR() {
        return CREATOR;
    }

    protected City(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
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
    }

    public City() {
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setIdCity(int idCity) {
        this.id = idCity;

    }

    public int getIdCity() {
        return id;
    }
}
