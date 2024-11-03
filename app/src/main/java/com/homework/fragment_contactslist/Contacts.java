package com.homework.fragment_contactslist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Contacts extends Fragment {
 public static    RecyclerView recyclerView;
    public static RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    public static    RecyclerView.LayoutManager manager;

    public Contacts() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_contacts, container, false);
        recyclerView= recyclerView.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        manager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(manager);
        adapter=new PersonAdapter(this.getActivity(),MainActivity.nas);
        recyclerView.setAdapter(adapter);
        return view;
    }
    public static void notifyDataSetChanged(){
        adapter.notifyDataSetChanged();
    }
}