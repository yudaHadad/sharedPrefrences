package com.example.jbt.sharedprefrences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.loginBtn)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, MySettingsAct.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String email= preferences.getString("email", "user@com");
        ((TextView) findViewById(R.id.emailTV)).setText(email);

        String password= preferences.getString("password", "abcd1234");
        ((TextView) findViewById(R.id.passwordTV)).setText(password);

        boolean isShowText = preferences.getBoolean("login", false);

        if (!isShowText)
        {
            ((Button) findViewById(R.id.loginBtn)).setVisibility(View.INVISIBLE);
        }



    }
}
