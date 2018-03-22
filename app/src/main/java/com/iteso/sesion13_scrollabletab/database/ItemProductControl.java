package com.iteso.sesion13_scrollabletab.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iteso.sesion13_scrollabletab.Beans.itemProduct;

import java.util.ArrayList;

/**
 * Created by Jorge Urrea on 21/03/2018.
 */

public class ItemProductControl {

    public long addItemProduct(itemProduct product, DataBaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DataBaseHandler.KEY_PRODUCT_TITLE, product.getTitle());
        values.put(DataBaseHandler.KEY_PRODUCT_IMAGE, product.getImage());
        values.put(DataBaseHandler.KEY_PRODUCT_CATEGORY, product.getCategory().getId());
        // Inserting Row
        inserted = db.insert(DataBaseHandler.TABLE_PRODUCT, null, values);
        db = null;
        values = null;
        inserted = 0;
        db = dh.getWritableDatabase();
        values = new ContentValues();

        values.put(DataBaseHandler.KEY_PRODUCT_ID, product.getCode());
        values.put(DataBaseHandler.KEY_STORE_ID, product.getStore().getId());

        inserted = db.insert(DataBaseHandler.TABLE_STORE,null,values);

        // Closing database connection
        try {db.close();} catch (Exception e) {}
        db = null; values = null;
        return inserted;
    }


    public ArrayList<itemProduct> getItemProductsByCategory(int idCategory, DataBaseHandler dh){
        ArrayList<itemProduct> Products = new ArrayList<>();
        itemProduct product = new itemProduct();
        String selectQuery = "SELECT P." + DataBaseHandler.KEY_PRODUCT_ID + ","
                + "P." + DataBaseHandler.KEY_PRODUCT_TITLE + ","
                + "P." + DataBaseHandler.KEY_PRODUCT_IMAGE + " FROM "
                + DataBaseHandler.TABLE_PRODUCT + " P,"
                + DataBaseHandler.TABLE_CATEGORY + " C WHERE P."
                + DataBaseHandler.KEY_CATEGORY_ID + "= " + idCategory;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToNext()) {
            product.setCode(cursor.getInt(0));
            product.setTitle(cursor.getString(1));
            product.setImage(cursor.getInt(2));
            Products.add(product);
        }
        try {cursor.close();db.close();
        } catch (Exception e) {}
        db = null;
        cursor = null;
        return Products;
    }
}
