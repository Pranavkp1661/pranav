package com.example.newtrainigproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity {
    Button btGetLocation;
    TextView tvLatitude;
    TextView tvLongitude;
    EditText etAddressLocation;
    TextView tvTime;
    Button btRefreshLocation;
    Button btEditLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        btGetLocation = findViewById(R.id.btGetLocation);
        tvLatitude = findViewById(R.id.tvLatitude);
        tvLongitude = findViewById(R.id.tvLongitude);
        etAddressLocation = findViewById(R.id.etAddressLocation);
        tvTime=findViewById(R.id.tvTime);
        btEditLocation=findViewById(R.id.btEditLocation);
        btRefreshLocation=findViewById(R.id.btRefreshLocation);
        context = this;

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        btGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getTheLocation();
                    SimpleDateFormat sdf = new SimpleDateFormat("'Date:' dd.MM.yyyy  '\n' 'Time:' HH:mm:ss ");
                    String currentDateAndTime = sdf.format(new Date());
                    tvTime.setText(currentDateAndTime);
                } else {
                    ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
        btRefreshLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTheLocation();
                Toast.makeText(context,"Refreshed",Toast.LENGTH_LONG).show();
            }
        });
        btEditLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAddressLocation.setFocusable(true);
                etAddressLocation.setClickable(true);
                Toast.makeText(context,"Editing Enabled",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getTheLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(context, Locale.getDefault());

                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        tvLatitude.setText("LATITUDE=" + addresses.get(0).getLatitude());
                        tvLongitude.setText("LONGITUDE=" + addresses.get(0).getLongitude());
                        etAddressLocation.setText("ADDRESS LINE=" + addresses.get(0).getAddressLine(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}