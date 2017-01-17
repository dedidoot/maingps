package com.yuk.mylibrary;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dedi on 17/01/17.
 * That's it
 */

public class GetAssets {

    public String loadJSONFromAsset(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("jsonku.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            Log.wtf("Exception 2", "=> " + ex.getMessage());
            return null;
        }

        return json;
    }

}
