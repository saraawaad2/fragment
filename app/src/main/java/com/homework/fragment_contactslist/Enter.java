package com.homework.fragment_contactslist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Enter extends Fragment {
    private EditText name, phoneNum;
    private Button btnSave;

    public Enter() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter, container, false);
        name=view.findViewById(R.id.editName);
        phoneNum=view.findViewById(R.id.editPhone);
        btnSave=view.findViewById(R.id.BtnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().isEmpty()||phoneNum.getText().toString().trim().isEmpty())
                    Toast.makeText(getActivity(),"please fill deatiles",Toast.LENGTH_SHORT).show();
                else{
                    String Name,phone;
                    Name=name.getText().toString().trim();
                    phone=phoneNum.getText().toString().trim();
                    MainActivity.nas.add(new Person(Name,phone));
                    Toast.makeText(getActivity(),"person added successfuly",Toast.LENGTH_SHORT).show();
                    Contacts.notifyDataSetChanged();
                }
            }
        });
        return view;
    }
}
