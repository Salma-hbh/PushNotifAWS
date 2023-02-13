package com.example.mypushnotificationapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.amazon.device.messaging.ADMMessageReceiver;

public class Receiver extends ADMMessageReceiver
{

    public Receiver(Context context, Intent intent)
    {
        String registrationId = intent.getStringExtra("registration_id");
        if (registrationId != null) {
            System.out.println(registrationId);
        } else {
            System.out.println("Failed");
        }
        //super(MyADMLegacyMessageHandler.class);
        //boolean ADMLatestAvailable = false ;
        //try{
        //    Class.forName( "com.amazon.device.messaging.ADMMessageReceiver" );
        //    ADMLatestAvailable = true ;
        //}
        //catch (ClassNotFoundException e)
       // {
        //    System.out.print(e);
        //}
        // This is needed for backward compatibility

        // Where available, prefer using the new job based
        //if (ADMLatestAvailable) {
        //    Object JOB_ID="amzn1.application-oa2-client.632d1b308ab7444ca26491bbb884ce03";
        //    registerJobServiceClass(MyADMLegacyMessageHandler.class, JOB_ID);
        //}

    }

    private void registerJobServiceClass(Class<MyADMLegacyMessageHandler> myADMLegacyMessageHandlerClass, Object job_id) {
    }
    // Nothing else is required here; your broadcast receiver automatically
    // forwards intents to your service for processing.
}
