package com.marshmallow_permissions_demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
    }
    //set up toolbar
    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void allowLocationPermission(View view) {
        //Check if permission is granted or not
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
            MarshMallowPermission.requestLocationPermission(MainActivity.this);
        else
            Toast.makeText(MainActivity.this, "Permission is already granted.", Toast.LENGTH_SHORT).show();
    }

    public void allowStoragePermission(View view) {
        //Check if permission is granted or not
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            MarshMallowPermission.requestStoragePermission(MainActivity.this);
        else
            Toast.makeText(MainActivity.this, "Permission is already granted.", Toast.LENGTH_SHORT).show();
    }

    public void allowSmsPermission(View view) {
        //Check if permission is granted or not
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED)
            MarshMallowPermission.requestReadSMSPermission(MainActivity.this);
        else
            Toast.makeText(MainActivity.this, "Permission is already granted.", Toast.LENGTH_SHORT).show();
    }

    public void allowContactsPermission(View view) {
        //Check if permission is granted or not
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)
            MarshMallowPermission.requestContactsPermission(MainActivity.this);
        else
            Toast.makeText(MainActivity.this, "Permission is already granted.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MarshmallowIntentId.ACCESS_FINE_LOCATION_INTENT_ID:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // task you need to do.
                    Toast.makeText(MainActivity.this, "Location Permission granted.", Toast.LENGTH_SHORT).show();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Location Permission denied.", Toast.LENGTH_SHORT).show();
                }
                break;
            case MarshmallowIntentId.ACCESS_CONTACTS_INTENT_ID:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // task you need to do.
                    Toast.makeText(MainActivity.this, "Contact Permission granted.", Toast.LENGTH_SHORT).show();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Contact Permission denied.", Toast.LENGTH_SHORT).show();
                }
                break;
            case MarshmallowIntentId.READ_SMS_INTENT_ID:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // task you need to do.
                    Toast.makeText(MainActivity.this, "SMS Permission granted.", Toast.LENGTH_SHORT).show();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "SMS Permission denied.", Toast.LENGTH_SHORT).show();
                }
                break;
            case MarshmallowIntentId.WRITE_EXTERNAL_STORAGE_PERMISSION:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // task you need to do.
                    Toast.makeText(MainActivity.this, "Storage Permission granted.", Toast.LENGTH_SHORT).show();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Storage Permission denied.", Toast.LENGTH_SHORT).show();
                }
                break;


        }
    }
}
