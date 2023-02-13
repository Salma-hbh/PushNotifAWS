package com.example.mypushnotificationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.amazon.device.messaging.ADM;

public class MainActivity extends AppCompatActivity {
    EditText etToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etToken = findViewById(R.id.etToken);
        boolean ADMAvailable = false;
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            ADMAvailable = true;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        if (ADMAvailable) {
            final ADM adm = new ADM(this);
            if (adm.isSupported()) {
                adm.startRegister();
            }
            Toast.makeText(MainActivity.this, "Your reg id is" + adm.getRegistrationId(), Toast.LENGTH_SHORT).show();
            etToken.setText(adm.getRegistrationId());
           // if (adm.getRegistrationId() == null) {
           //     // startRegister() is asynchronous; your app is notified via the
           //     // onRegistered() callback when the registration ID is available.
           //     adm.startRegister();
           //     Toast.makeText(MainActivity.this, "Your reg id is" + adm.getRegistrationId(), Toast.LENGTH_SHORT).show();
           //     etToken.setText(adm.getRegistrationId());
           // }


        }
    }
}