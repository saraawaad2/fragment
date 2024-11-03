package com.homework.fragment_contactslist;

import android.icu.text.DateFormat;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected {
    public static ArrayList<Person> nas;
    TextView tvDate;
    String CurrentDate;
    Calendar calendar = Calendar.getInstance();
    FragmentManager fragmentManager;
    Contacts contacts;
    details_frag detailsFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = findViewById(R.id.time);
        fragmentManager = this.getSupportFragmentManager();
        CurrentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        tvDate.setText(CurrentDate);
        contacts = (Contacts) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        intArray();
        detailsFrag = (details_frag) fragmentManager.findFragmentById(R.id.fragmentContainerView4);
    }

    private void intArray() {
        nas = new ArrayList<>();
        nas.add(new Person("Elon Musk", "05543009002", R.drawable.elonmusk));
        nas.add(new Person("Adeel Ammam", "05543009002", R.drawable.adelammam));
        nas.add(new Person("Ahmad helmi", "05543009092", R.drawable.ahmad));
        nas.add(new Person("Ali","054700934",R.drawable.ali));
    }

    @Override
    public void onItemClicked(int Index) {
        if (!nas.isEmpty()) {
            detailsFrag.updateTexts(nas.get(Index).getName(), nas.get(Index).getPhone());
        } else
            return;

    }
}
