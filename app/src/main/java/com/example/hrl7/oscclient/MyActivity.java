package com.example.hrl7.oscclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.widget.Toast;
import com.example.hrl7.oscclient.BasicOscListener;
import com.example.hrl7.oscclient.OscMessage;
import com.example.hrl7.oscclient.OscClient;
import com.example.hrl7.oscclient.OscServer;

public class MyActivity extends Activity {

/*
    public class LooperListener extends BasicOscListener {
        public Context c;

        @Override
        public void handleMessage(OscMessage msg) {
            System.out.println("Message " + msg.getAddress());
            System.out.println("Type Tags " + msg.getTypeTags());

          //  Toast.makeText(MyActivity.this, "OSCmessage: " + msg.toString(), Toast.LENGTH_LONG);

        }
    }
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        AsyncOSC osc = new AsyncOSC(this);
        osc.execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
/*

    public void handleMessage(OscMessage msg) {
        System.out.println("Message " + msg.getAddress());
        System.out.println("Type Tags " + msg.getTypeTags());

    }
    */

}


