package com.example.contactmanagerapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    private  MyAdapter myAdapter;
    private ActivityMainBinding binding;
    private  MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        handler = new MainActivityClickHandler(this);
        binding.setClickHanlder(handler);

        //recyclerview
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //database;
        contactDatabase = ContactDatabase.getDbInstance(this);

        //view model
        MyViewModel viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);
        //insert a new contact

        Contacts newContact = new Contacts("Anjali","anjaisingh@gmia.com");
        viewModel.addNewContact(newContact);

        //loading the data from room database
        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for(Contacts c:contacts){
                    Log.v("TAG", "onChanged: "+c.getName());
                    contactsArrayList.add(c);

                }

                myAdapter.notifyDataSetChanged();
            }


        });
        //adapter
        myAdapter = new MyAdapter(contactsArrayList);
        recyclerView.setAdapter(myAdapter);

    }
}