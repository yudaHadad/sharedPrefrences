package com.example.jbt.sharedprefrences;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jbt on 01/03/2017.
 */

public class MySettingsAct extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_prefrences);

        Preference exitButton= (Preference) findPreference("exit");
        exitButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                finish();
                return true;
            }
        });

        CheckBoxPreference isShowTextCB= (CheckBoxPreference) findPreference("login");
        isShowTextCB.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                return true;
            }
        });

        EditTextPreference emailET = (EditTextPreference) findPreference("email");
        emailET.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                String email = (String) o;

                if (!email.contains("@"))
                {
                    Toast.makeText(MySettingsAct.this, "your email is'nt correct", Toast.LENGTH_SHORT).show();
                    return false;
                }

                return true;
            }
        });

        EditTextPreference passwordET = (EditTextPreference) findPreference("password");
        passwordET.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                String password = (String) o;

                if (password.length()<8)
                {
                    Toast.makeText(MySettingsAct.this, "your password is'nt correct", Toast.LENGTH_SHORT).show();
                    return false;
                }

                return true;
            }
        });



    }
}
