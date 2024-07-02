package com.example.quietarrival;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.quietarrival.models.GeofenceData;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeofenceController {

    private Context context;
    private Gson gson;

    private SharedPreferences prefs;
    private  GeofenceControllerListener listener;

    private  FusedLocationProviderClient fusedLocationProviderClient;

    private  final String TAG = GeofenceController.class.getName();

    public List<GeofenceData> mGeofenceData;
    public List<GeofenceData>getGeofenceData(){
     return mGeofenceData;
    }

    private List<GeofenceData> GeofenceDataToRemove;

    private  static GeofenceController INSTANCE;

    public static GeofenceController getInstance(){

        if(INSTANCE==null){

            INSTANCE = new GeofenceController();
        }
        return INSTANCE;
    }


    public void init(Context context){

        this.context = context.getApplicationContext();

        gson = new Gson();
        mGeofenceData = new ArrayList<>();
        GeofenceDataToRemove = new ArrayList<>();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        prefs = context.getSharedPreferences("Geofence", Context.MODE_PRIVATE);

        getGsonData();
    }


    public void saveGson(GeofenceData data) {
        this.context= context.getApplicationContext();


        String json = gson.toJson(data);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(data.getId(), json);
        //editor.putString("CHECK","ok");
        editor.apply();
    }

    private  void getGsonData(){

        Map<String,?> keys = prefs.getAll();

        for(Map.Entry<String,?>entry :keys.entrySet()){

            String jsonString  = prefs.getString(entry.getKey(),null);
            GeofenceData geofenceData = gson.fromJson(jsonString,GeofenceData.class);
            mGeofenceData.add(geofenceData);
        }
    }

    public  void removeGeofences(GeofenceData mGeofenceDataToRemove){


        Log.e(TAG,"remove block started");

        SharedPreferences.Editor editor = prefs.edit();

        editor.remove(mGeofenceDataToRemove.getId());

        editor.apply();;
        Log.e(TAG,"yes");

        Log.e("TAG","ID: " +mGeofenceDataToRemove.getId()+" name: " + mGeofenceDataToRemove.getName());
        Log.e(TAG,"I m in remove block");



    }

    private  void removeSavedGeofences(){


        SharedPreferences.Editor editor = prefs.edit();
        for (GeofenceData mGeofence : GeofenceDataToRemove) {
            int index = mGeofenceData.indexOf(mGeofence);
            editor.remove(mGeofence.getId());
            mGeofenceData.remove(index);
            editor.apply();
        }
        Log.e(TAG,"i'm in remove saved geofences block");


    }
    private void sendError() {
        if (listener != null) {
            listener.onError();
        }
    }


    //connection failed listenere

    //connection callback listener





    public interface GeofenceControllerListener {
        void onGeofencesUpdated();
        void onError();
    }

}
