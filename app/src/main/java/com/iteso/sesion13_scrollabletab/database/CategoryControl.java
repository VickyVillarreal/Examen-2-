package com.iteso.sesion13_scrollabletab.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.sesion13_scrollabletab.Beans.Category;
import com.iteso.sesion13_scrollabletab.Beans.City;
import com.iteso.sesion13_scrollabletab.Beans.Store;

import java.util.ArrayList;

/**
 * Created by Jorge Urrea on 20/03/2018.
 */

public class CategoryControl {
    public ArrayList<Category> getCategories(DataBaseHandler dh){
        ArrayList<Category> categories=new ArrayList<Category>();
        Category category=new Category();
        String selectQuery = "SELECT C." + DataBaseHandler.KEY_CATEGORY_ID + ","
                + "C." + DataBaseHandler.KEY_CATEGORY_NAME+ ","
                + " FROM "
                + DataBaseHandler.TABLE_CATEGORY + " C ";
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while(cursor.moveToNext()){
            category.setId(cursor.getInt(0));
            category.setName(cursor.getString(1));
            categories.add(category);
        }
        try {cursor.close();db.close();
        } catch (Exception e) {}
        db = null;
        cursor = null;
        // return store
        return categories;
    }
}
