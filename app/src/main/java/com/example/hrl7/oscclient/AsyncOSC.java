package com.example.hrl7.oscclient;

        import java.io.IOException;
        import java.net.InetSocketAddress;
        import android.app.Activity;
        import android.os.AsyncTask;

        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.content.Context;
        import android.widget.Toast;
        import com.example.hrl7.oscclient.BasicOscListener;
        import com.example.hrl7.oscclient.OscMessage;
        import com.example.hrl7.oscclient.OscClient;
        import com.example.hrl7.oscclient.OscServer;

/**
 * Created by hrl7 on 2014/12/03.
 */
public class AsyncOSC extends AsyncTask<String,  Void, String> {

        private Activity mainActivity;
    private OscClient sender;

    private OscServer server;
        public AsyncOSC (Activity activity) {

           mainActivity = activity;
        }

        @Override
        protected String doInBackground(String ... str) {
            sender = new OscClient(true);
            String destination = "172.25.0.32";
            int destPort = 12000;
            InetSocketAddress addr = new InetSocketAddress(destination, destPort);
            try {
                sender.connect(addr);
                OscMessage msg = new OscMessage("/mouse");
                msg.addArgument(10.0f);
                sender.sendPacket(msg);
                System.out.println("Connected");
            } catch (Exception e) {
                System.out.println("Connection error");

                e.printStackTrace();
            }
            return "Sent";
        }


        @Override
        protected void onPostExecute(String result) {
            System.out.println(result);
        }
    }

