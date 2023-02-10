package com.example.mypushnotificationapplication;

import static android.provider.Settings.System.getString;

import android.content.Intent;
import android.os.Bundle;

import com.amazon.device.messaging.ADMMessageHandlerBase;

public class MyADMLegacyMessageHandler extends ADMMessageHandlerBase {
    protected MyADMLegacyMessageHandler(String className) {
        super(className);
    }

    @Override
    protected void onMessage(Intent intent) {
        // Extract the message content from the set of extras attached to
        // the com.amazon.device.messaging.intent.RECEIVE intent.

        // Create strings to access the message and timeStamp fields from the JSON data.
        final String msgKey = getString(R.string.json_data_msg_key);
        final String timeKey = getString(R.string.json_data_time_key);

        // Obtain the intent action that will be triggered in onMessage() callback.
        final String intentAction = getString(R.string.intent_msg_action);

        // Obtain the extras that were included in the intent.
        final Bundle extras = intent.getExtras();

        // Extract the message and time from the extras in the intent.
        // ADM makes no guarantees about delivery or the order of messages.
        // Due to varying network conditions, messages may be delivered more than once.
        // Your app must be able to handle instances of duplicate messages.
        final String msg = extras.getString(msgKey);
        final String time = extras.getString(timeKey);
    }

    @Override
    protected void onRegistrationError(String s) {

    }

    @Override
    protected void onRegistered(String s) {
        // You start the registration process by calling startRegister() in your Main
        // Activity. When the registration ID is ready, ADM calls onRegistered() on
        // your app. Transmit the passed-in registration ID to your server, so your
        // server can send messages to this app instance. onRegistered() is also
        // called if your registration ID is rotated or changed for any reason; your
        // app should pass the new registration ID to your server if this occurs.
        // Your server needs to be able to handle a registration ID up to 1536 characters
        // in length.

        // The following is an example of sending the registration ID to your
        // server via a header key/value pair over HTTP.
        //URL url = new URL();
        //HttpURLConnection con = null;
        //try {
        //    con = (HttpURLConnection) url.openConnection();
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}
        //con.setDoInput(true);
        //con.setUseCaches(false);
        //con.setRequestMethod("POST");
        //con.setRequestProperty("RegistrationId", newRegistrationId);
        //con.getResponse();
    }

    @Override
    protected void onUnregistered(String s) {

    }
}
