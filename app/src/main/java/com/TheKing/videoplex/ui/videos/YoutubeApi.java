package com.TheKing.videoplex.ui.videos;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class YoutubeApi extends AsyncTask<String, String, String> {
    VideoFragment videoFragment;

    public YoutubeApi(VideoFragment vf) {
        videoFragment = vf;
    }

    protected String doInBackground(String... params)
    {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.d("TheKing--> Response: ", "> " + line);   //here u ll get whole response...... :-)

            }

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    protected void onPostExecute(String result) {
        // TODO: check this.exception
        // TODO: do something with the feed

        Log.d("TheKing--> Post = ", "> " + result);
        //Solution to this problem
        //https://stackoverflow.com/questions/1688099/converting-json-data-to-java-object/1688182#1688182

        videoFragment.onReceiveYoutubeApi(result);


    }
    private String onProcessedData(String result){
        return result;
    }
}