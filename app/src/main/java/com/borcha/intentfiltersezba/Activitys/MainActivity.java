package com.borcha.intentfiltersezba.Activitys;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.borcha.intentfiltersezba.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MYACTIVITY_VESTI_SVE="com.borcha.action.vesti.sve";
    public static final String MYACTIVITY_VESTI_SPORT="com.borcha.action.vesti.sport";
    public static final String MYACTIVITY_VESTI_HRONIKA="com.borcha.action.vesti.hronika";
    public static final String MYACTIVITY_VESTI_KULTURA="com.borcha.action.vesti.klutura";


    Button btnVest;


       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVest=(Button)findViewById(R.id.btnVest);
        btnVest.setOnClickListener(this);


       }

    @Override
    public void onClick(View v) {
       posaljiSMS("069239389498");
    }


    private void VestHronika(){
        Intent intHronika = new Intent();
        intHronika.setAction(MYACTIVITY_VESTI_HRONIKA);

        startActivity(intHronika);

    }


    private void posaljiSMS(String _br) {
        Uri uriSms=Uri.parse("smsto:" + _br);
        Intent  intSms=new Intent();
        intSms.setAction(Intent.ACTION_SENDTO);
        intSms.setData(uriSms);
        intSms.putExtra(Intent.EXTRA_PHONE_NUMBER,_br);

        startActivity(intSms);


    }


    private void VestSport(){
        Intent intent=new Intent();
        intent.setAction(MYACTIVITY_VESTI_SPORT);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);

    }

    private void VestKultura(){
        Intent intent=new Intent();
        intent.setAction(MYACTIVITY_VESTI_KULTURA);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);

    }
    private void sveVesti(){
        Intent intent=new Intent();
        intent.setAction(MYACTIVITY_VESTI_SVE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);

    }
}
