package com.iteso.sesion13_scrollabletab;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.sesion13_scrollabletab.Beans.itemProduct;
import com.iteso.sesion13_scrollabletab.database.DataBaseHandler;
import com.iteso.sesion13_scrollabletab.database.ItemProductControl;

import java.util.ArrayList;
import java.util.Iterator;


public class FragmentTechnology extends android.support.v4.app.Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<itemProduct> productstech;

    public FragmentTechnology() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.fragment_technology_recycler_view);

        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);


        productstech= new ArrayList<itemProduct>();
        ItemProductControl itemProductControl = new ItemProductControl();
        productstech = itemProductControl.getItemProductsByCategory(
                0, DataBaseHandler.getInstance(getActivity()));

        mAdapter = new AdapterProduct(getActivity(), productstech);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        itemProduct itemProduct = data.getParcelableExtra("ITEM");
        Iterator<itemProduct> iterator = productstech.iterator();
        int position = 0;
        while(iterator.hasNext()){
            itemProduct item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                productstech.set(position, itemProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }
    public void notifyDataSetChanged(itemProduct itemProduct){
        productstech.add(itemProduct);
        mAdapter.notifyDataSetChanged();
    }


}
