package com.example.zad3_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DialogListener{
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.MainView);
        ArrayList<Contact> contacts = new ArrayList<>();

        contactAdapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatButton = findViewById(R.id.floatButton);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentDialog addFragment = FragmentDialog.newInstance();
                addFragment.show(fragmentManager, "Successfully Added!");
            }
        });
    }

    @Override
    public void onFinishAddDialog(Contact contacts) { contactAdapter.addContact(contacts); }
}
