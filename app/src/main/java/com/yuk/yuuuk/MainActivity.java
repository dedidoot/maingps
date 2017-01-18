package com.yuk.yuuuk;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

import com.google.gson.Gson;
import com.yuk.mylibrary.GetAssets;
import com.yuk.yuuuk.databinding.AkuBisa;
import com.yuk.yuuuk.databinding.AkuBisa2;

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

    AkuBisa akuBisa;
    // AkuBisa2 akuBisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        akuBisa = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // akuBisa = DataBindingUtil.setContentView(this, R.layout.activity_main2);

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

        inicializarTabs();
    }

    private void inicializarTabs() {
        akuBisa.tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        akuBisa.tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                Log.wtf("onTabChanged", "=> " + s);
            }
        });

        TabHost.TabSpec tab1 = akuBisa.tabHost.newTabSpec("tab1");
        TabHost.TabSpec tab2 = akuBisa.tabHost.newTabSpec("tab2");

        tab1.setIndicator("yah 1", null);
        tab2.setIndicator("yah 2", null);

        akuBisa.tabHost.addTab(tab1, CustomFragment.class, null);
        akuBisa.tabHost.addTab(tab2, CustomFragment2.class, null);


    }

   /* private void inicializarTabs2FIx() {

        akuBisa.tabHost.setup();

        //Tab 1
        TabHost.TabSpec spec = akuBisa.tabHost.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        akuBisa.tabHost.addTab(spec);

        //Tab 2
        spec = akuBisa.tabHost.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");
        akuBisa.tabHost.addTab(spec);

        //Tab 3
        spec = akuBisa.tabHost.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        akuBisa.tabHost.addTab(spec);

    }*/
}
