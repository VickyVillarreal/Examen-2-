package com.iteso.sesion13_scrollabletab.Beans;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.ParseException;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.sesion13_scrollabletab.ActivityMain;
import com.iteso.sesion13_scrollabletab.AdapterProduct;
import com.iteso.sesion13_scrollabletab.R;

import org.w3c.dom.Text;

/**
 * Created by Jorge Urrea on 26/02/2018.
 */

public class itemProduct implements Parcelable {
    private String title, location, phone, description;
    private int image;
    private int thumbnail;
    private int code;
    private Store store;
    private Category category;

    public itemProduct() {
    }

    public itemProduct(String title, String location, String phone, String description, int image, int thumbnail, int code, Store store, Category category) {
        this.title = title;
        this.location = location;
        this.phone = phone;
        this.description = description;
        this.image = image;
        this.thumbnail = thumbnail;
        this.code = code;
        this.store = store;
        this.category = category;
    }

    @Override
    public String toString() {
        return "itemProduct{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", thumbnail=" + thumbnail +
                ", code=" + code +
                ", store=" + store +
                ", category=" + category +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static Creator<itemProduct> getCREATOR() {
        return CREATOR;
    }

    protected itemProduct(Parcel in) {
        title = in.readString();
        location = in.readString();
        phone = in.readString();
        description = in.readString();
        image = in.readInt();
        thumbnail = in.readInt();
        code = in.readInt();
        store = in.readParcelable(Store.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public static final Creator<itemProduct> CREATOR = new Creator<itemProduct>() {
        @Override
        public itemProduct createFromParcel(Parcel in) {
            return new itemProduct(in);
        }

        @Override
        public itemProduct[] newArray(int size) {
            return new itemProduct[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeString(description);
        dest.writeInt(image);
        dest.writeInt(thumbnail);
        dest.writeInt(code);
        dest.writeParcelable(store, flags);
        dest.writeParcelable(category, flags);
    }
}