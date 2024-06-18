package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    //if you need to use context inside your ViewModel
    //you should use AndroidViewModel
    //because it has application context

    private Repository myRepository;
    private LiveData<List<Contacts>> allContacts;


    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contacts>> getAllContacts(){

        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contact){

        myRepository.addContact(contact);
    }
    public void deleteContact(Contacts contact){
        myRepository.deleteContact(contact);
    }
}
