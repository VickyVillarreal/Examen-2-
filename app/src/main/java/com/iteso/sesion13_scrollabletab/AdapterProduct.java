package com.iteso.sesion13_scrollabletab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.sesion13_scrollabletab.Beans.itemProduct;

import java.util.ArrayList;

/**
 * Created by Jorge Urrea on 26/02/2018.
 */

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    private ArrayList<itemProduct> mDataSet;
    private Context context;


    public AdapterProduct(Context context, ArrayList<itemProduct> myDataSet) {
        mDataSet = myDataSet;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button mDetail;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder(View v) {
            super(v);
            mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            mDetail = (Button) v.findViewById(R.id.item_product_detail);
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mProductImage = (ImageView) v.findViewById(R.id.item_product_image);
            mProductThumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
        }}



    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mProductStore.setText(mDataSet.get(position).getStore().getName());
        holder.mProductLocation.setText(
                mDataSet.get(position).getStore().getCity().getName() + ", Jalisco");
        holder.mProductPhone.setText(mDataSet.get(position).getStore().getPhone());
        switch(mDataSet.get(position).getImage()){
                case 0:
                    holder.mProductImage.setImageResource(R.drawable.mac); break;
                case 1:
                    holder.mProductImage.setImageResource(R.drawable.alienware); break;
                case 2:
                    holder.mProductImage.setImageResource(R.drawable.lanix);break;
            }

            switch (mDataSet.get(position).getThumbnail()){
            case 0:
                holder.mProductThumbnail.setImageResource(R.drawable.bestbuy);
                 break;
            case 1:
                holder.mProductThumbnail.setImageResource(R.drawable.dell);
                break;
            case 2:
                holder.mProductThumbnail.setImageResource(R.drawable.logotienda);
                break;
        }


        holder.mProductPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + mDataSet.get(position).getStore().getPhone()));
                context.startActivity(intent);
            }
        });


        holder.mEventLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                itemProduct productItem = new itemProduct();
                productItem.setTitle(mDataSet.get(position).getTitle());
                productItem.setStore(mDataSet.get(position).getStore());
                productItem.setPhone(mDataSet.get(position).getPhone());
                productItem.setLocation(mDataSet.get(position).getLocation());
                productItem.setCode(mDataSet.get(position).getCode());
                productItem.setImage(mDataSet.get(position).getImage());

                Intent intent = new Intent(context, ActivityProduct.class);
                intent.putExtra("ITEM", productItem);
                ((ActivityMain) context).startActivityForResult(intent,mDataSet.get(position).getCode());
            }
        });

    }
    public int getItemCount(){
        return mDataSet.size();
    }



}

