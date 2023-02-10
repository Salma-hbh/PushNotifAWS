package com.example.mypushnotificationapplication;

import androidx.appcompat.app.AppCompatActivity;

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
        final ADM adm = new ADM(this);
        if (adm.getRegistrationId() == null)
        {
            // startRegister() is asynchronous; your app is notified via the
            // onRegistered() callback when the registration ID is available.
            adm.startRegister();
            Toast.makeText(MainActivity.this,"Your reg id is" + adm.getRegistrationId(), Toast.LENGTH_SHORT).show();
            etToken.setText(adm.getRegistrationId());
        }

    }
}