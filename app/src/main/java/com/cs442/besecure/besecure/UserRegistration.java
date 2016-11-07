package com.cs442.besecure.besecure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sneha on 11/6/2016.
 */


public class UserRegistration extends AppCompatActivity {
    EditText name, mobile_no, email;
    SharedPreferences regpage;
    SharedPreferences.Editor edit;
    SharedPreferences asetting;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;
    Button addbt;
    String regexStr = "^[0-9]{10}$";
    String emailstr = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public void onCreate(Bundle savedInstanceState) {
        Log.d("User Registration", "Oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Log.d("User Registration", "setcontentview");
        SharedPreferences wmbPreference = PreferenceManager
                .getDefaultSharedPreferences(this);
        // boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {
            // run your one time code here

            asetting = getSharedPreferences("signal", 0);
            editor = asetting.edit();
            editor.putString("gmsg", "Hi I am safe !");
            editor.putString("ymsg", "Hi I am in critical situation !");
            editor.putString("rmsg", "Hi I am in trouble, please help me !");
            editor.putInt("gtime", 0);
            editor.putInt("ytime", 0);
            editor.putInt("rtime", 0);
            editor.commit();

            regpage = getSharedPreferences("reg", 0);
            edit = regpage.edit();
            // final DBAdapter dba = new DBAdapter(this);
            name = (EditText) findViewById(R.id.name);
            mobile_no = (EditText) findViewById(R.id.mobile_no);

            email = (EditText) findViewById(R.id.email);
            addbt = (Button) findViewById(R.id.button1);

            addbt.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    try {

                        // Toast.makeText(Reg.this, "hello",
                        // Toast.LENGTH_LONG).show();

                        if (name.getText().toString().equals("")
                                || mobile_no.getText().toString().equals("")
                                || email.getText().toString().equals("")) {
                            Toast.makeText(UserRegistration.this, "Please Fill All Data",
                                    Toast.LENGTH_SHORT).show();

                        } else

2z                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstTime", true);
                            editor.commit();
                            if (mobile_no.getText().toString().matches(regexStr)) {
                                if (email.getText().toString()
                                        .matches(emailstr)) {

									/*
									 * dba.open();
									 *
									 *
									 * dba.insertUserdetail(name.getText().toString
									 * (
									 * ),uname.getText().toString(),pas.getText(
									 * ).toString(),cpas.getText().toString());
									 * dba.close();
									 */
                                    edit.putString("name", name.getText()
                                            .toString());
                                    edit.putString("mobile", mobile_no.getText()
                                            .toString());
                                    edit.putString("email", email.getText()
                                            .toString());
                                    edit.commit();

                                    showMessage();
                                    /*//Snehal
                                    Intent intent_first = new Intent(UserRegistration.this, Widget_Setting.class);
                                    startActivity(intent_first);

                                    finish();*/

                                } else {
                                    Toast.makeText(UserRegistration.this,
                                            "Enter Valid Email Address",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }

                            else {
                                Toast.makeText(UserRegistration.this,
                                        "Invalid Mobile number",
                                        Toast.LENGTH_LONG).show();
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("com.ems.AddNew" + e.getMessage());
                    }

                }
            });

        } else {
            //Snehal
          //  Intent in = new Intent(getApplicationContext(),
            //        wid_act_setting.class);
           // startActivity(in);
           // finish();
        }

    }

    public void showMessage() {
        Toast.makeText(this, "Data Succesfully saved", Toast.LENGTH_LONG)
                .show();
    }
}
