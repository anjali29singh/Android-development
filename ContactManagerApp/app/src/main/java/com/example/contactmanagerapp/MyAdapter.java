package com.example.contactmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ContactLayoutBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {

    private ArrayList<Contacts> contacts;

    public MyAdapter(ArrayList<Contacts> contacts){

        this.contacts = contacts;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactLayoutBinding  contactLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.contact_layout,parent,false);

        return new ContactViewHolder(contactLayoutBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {


        Contacts currentContact = contacts.get(position);
        holder.contactLayoutBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {

        if(contacts!=null) return contacts.size();
        else return 0;
    }

    static class ContactViewHolder extends  RecyclerView.ViewHolder{


         private ContactLayoutBinding contactLayoutBinding;

        public ContactViewHolder(@NonNull ContactLayoutBinding contactLayoutBinding) {
            super(contactLayoutBinding.getRoot());
            this.contactLayoutBinding = contactLayoutBinding;
        }
    }

    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }
}
