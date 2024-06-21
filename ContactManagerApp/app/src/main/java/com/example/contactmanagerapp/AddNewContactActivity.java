package com.example.contactmanagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.contactmanagerapp.databinding.ActivityMainBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AddNewContactClickHandler handler;
   private Contacts contacts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_contact);
        contacts = new Contacts();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);

    handler = new AddNewContactClickHandler(contacts,this);

    }
}