package com.yuk.yuuuk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.yuk.mylibrary.GetAssets;

import java.security.SecureRandom;


/**
 * Read file json to string
 * Then convert String to Pojo
 * http://stackoverflow.com/questions/13814503/reading-a-json-file-in-android
 * http://stackoverflow.com/questions/19945411/android-java-how-can-i-parse-a-local-json-file-from-assets-folder-into-a-listvi
 * <p>
 * convert from string to object pojo => https://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 **/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetAssets getAssets = new GetAssets();

        byte[] key = new byte[64];
        new SecureRandom().nextBytes(key);
        Log.wtf("encrypt", "=> " + key);

        if (getAssets.loadJSONFromAsset(this) != null) {
            Gson gson = new Gson();
            PojoEmploye pojoEmploye = gson.fromJson(getAssets.loadJSONFromAsset(this), PojoEmploye.class);
            Log.wtf("empId", "=> " + pojoEmploye.empId);
            Log.wtf("name", "=> " + pojoEmploye.name);
            Log.wtf("designation", "=> " + pojoEmploye.designation);
            Log.wtf("department", "=> " + pojoEmploye.department);
            Log.wtf("salary", "=> " + pojoEmploye.salary);
        }


    }
}
