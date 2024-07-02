package com.example.quietarrival;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.SharedPreferences;

import com.example.quietarrival.models.GeofenceData;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.Priority;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PlaceCurrent extends  BaseActivity    {


    private FusedLocationProviderClient mFusedLocationClient;
    private RadioButton buttonPlacePick;
    private  RadioButton buttonPlaceList;

    private  static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private static final String TAG ="";
//code for requesting location permission

    private  double currentLatitude;
    private  double currentLongitude;
    private TextView mLatValue;
    private TextView mLongValue;

    //code for continuous update

    private final int LOC_UPDATE_INTERVAL= 10000 ;
    private  final int LOC_FASTEST_UPDATE= 5000;
    protected LocationRequest.Builder mLocationRequest;
    protected Location mCurrLocation ;

    //check location setting


    protected static  final int REQUEST_CHECK_SETTINGS=0x1;
    protected LocationSettingsRequest  mLocationSettingRequest;

    private  boolean mHaveLocPerm = false;


    //geofence
     private ArrayList<Geofence> mGeofenceList;
     private List<GeofenceData> mGeofenceDataList;

     private boolean mGeofenceAdded ;

     private PendingIntent mGeofencePendingIntent;

     private SharedPreferences mSharedPreferences;

     private Button mAddGeofenceButton;

     private Button mAddsilenZoneButton;

     private Button mRemoveGeofenceButton;

     protected  Double mLatvalSilent;
     protected  Double mLongvalSilent;

     protected  Button mList;

     private Gson gson;


     //add Geofence Dialogue

    private String name;
    protected double latitude;
    protected double longitude;
    protected String sradius;
    protected  int radius;

    final Context context = this;
    private Button buttonGeofence;

    @Override
    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_place_current,frameLayout);

        buttonPlacePick = findViewById(R.id.btn1);
        buttonPlacePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaceCurrent.this,PickPlace.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        buttonPlaceList =  findViewById(R.id.btn3);

        buttonPlaceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaceCurrent.this,PlaceList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                startActivity(intent);
            }
        });

        mDrawerList.setItemChecked(position,true);
        setTitle(listArray[position]);

        //geofence code start

        mGeofenceList = new ArrayList<>();
        mGeofenceDataList = new ArrayList<>();
        mGeofencePendingIntent = null;
        mSharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_NAME,MODE_PRIVATE);

        mGeofenceAdded = mSharedPreferences.getBoolean(Constants.GEOFENCES_ADDED_KEY,false);
        populateGeofenceList();

        mLatValue =  findViewById(R.id.valLat);

        mLongValue =findViewById(R.id.valLong);

        mCurrLocation = null;

        //build the play service client object

        mFusedLocationClient  = LocationServices.getFusedLocationProviderClient(this);


            //setting location rquest;
            mLocationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,10000).setMinUpdateIntervalMillis(5000);

            //check the status of location settings

        //checkLocationSettings();

        //buildLocationSettingsRequest();

        //add geofence dialogue;

        GeofenceController.getInstance().init(context);

        final Context Controllercontext = this;

        buttonGeofence = findViewById(R.id.addGeofence);

        buttonGeofence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //custom dialog
            Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.geofence_dialogue);
                dialog.setTitle("Add A Zone");

                Button dialogButtonCancel = dialog.findViewById(R.id.dialogButtonCancel);
                Button dialogButtonSave = dialog.findViewById(R.id.dialogButtonSave);

                if(mCurrLocation==null){

                    Snackbar.make(v,"Location is not ready yet , still you can add it manually",Snackbar.LENGTH_LONG)
                            .setAction("Action",null).show();

                    //if button is clicked , close the custom dialog

                    dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    //                    ((EditText)dialog.findViewById(R.id.dialogueLatitude)).setHint(String.format(v.getResources().getString(R.string.Hint_Latitude), Constants.Geometry.MinLatitude, Constants.Geometry.MaxLatitude));
//                    ((EditText)dialog.findViewById(R.id.dialogueLongitude)).setHint(String.format(v.getResources().getString(R.string.Hint_Longitude), Constants.Geometry.MinLongitude, Constants.Geometry.MaxLongitude));
//                    ((EditText)dialog.findViewById(R.id.dialogueRadious)).setHint(String.format(v.getResources().getString(R.string.Hint_Radius), Constants.Geometry.MinRadius, Constants.Geometry.MaxRadius));

                    dialogButtonSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            name = ((EditText)dialog.findViewById(R.id.dialogueName)).getText().toString();
                            String slat = ((EditText)dialog.findViewById(R.id.dialogueLongitude)).getText().toString();

                            String slong = ((EditText)dialog.findViewById(R.id.dialogueLongitude)).getText().toString();

                            latitude = Double.parseDouble(slat);
                            longitude = Double.parseDouble(slong);
                            sradius = ((EditText)dialog.findViewById(R.id.dialogueRadius)).getText().toString();

                            radius = Integer.parseInt(sradius);
                            GeofenceDataProvider.setvalue(name, latitude, longitude, radius);
                            populateGeofenceList();
                            if (mGeofencesAdded) {
                                addListtoGeofenceAfterSilentZoneadded();

                            }
                            dialog.dismiss();

                        }

                    });

                    dialog.show();



                }
                else{
                    String  slat = String.valueOf(mCurrLocation.getLatitude());

                    if(slat!=null) ((EditText)dialog.findViewById(R.id.dialogueLatitude)).setText(slat);

                    latitude = mCurrLocation.getLatitude();
                    String slong = String.valueOf(mCurrLocation.getLongitude());

                    if(slong!=null) ((EditText)dialog.findViewById(R.id.dialogueLongitude)).setText(slong);

                    longitude = mCurrLocation.getLongitude();


                    // if button is clicked, close the custom dialog
                    dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();


                        }
                    });


                    dialogButtonSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            name = ((EditText) dialog.findViewById(R.id.dialogueName)).getText().toString();
                            sradius = ((EditText) dialog.findViewById(R.id.dialogueRadious)).getText().toString();
                            radius = Integer.parseInt(sradius);
                            GeofenceDataProvider.setvalue(name, latitude, longitude, radius);
                            populateGeofenceList();
                            if (mGeofencesAdded) {
                                addListtoGeofenceAfterSilentZoneadded();

                            }

                            dialog.dismiss();
                        }
                    });
                    dialog.show();



                }

            }
        });

    }







}
