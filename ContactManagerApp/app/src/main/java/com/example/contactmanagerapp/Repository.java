package com.example.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

public class Repository {

    // the available data sources

    private  final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;
    public Repository(Application application) {

        ContactDatabase database = ContactDatabase.getDbInstance(application);
        this.contactDAO = database.getContactDAO();
        // to allow background thread to execute
        executor = Executors.newSingleThreadExecutor();
        //used for updating the UI
        handler = new Handler(Looper.getMainLooper());
    }

    public  void addContact (Contacts contact){
        executor.execute(new Runnable() {
            @Override
            public void run() {

                contactDAO.insert(contact);
            }
        });

    }

    public void deleteContact(Contacts contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {

                contactDAO.delete(contact);
            }
        });

    }

    public LiveData<List<Contacts>> getAllContacts(){

        return  contactDAO.getAllContacts();
    }

}
