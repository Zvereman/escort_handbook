package ru.fmeter.escort_handbook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private SharedPreferences def_pref;
    private Typeface futura;
    private TextView tvAnton, tvSanych, tvRinat, tvTimur, tvGrowth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        init();

    }

    private void init(){
        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.menu_about);
        futura = Typeface.createFromAsset(this.getAssets(), "Fonts/FuturaMediumC.ttf");

        tvAnton = findViewById(R.id.tv_about_anton);
        tvSanych = findViewById(R.id.tv_about_sanych);
        tvRinat = findViewById(R.id.tv_about_rinat);
        tvTimur = findViewById(R.id.tv_about_timur);
        tvGrowth = findViewById(R.id.tv_about_growth);

        tvAnton.setTypeface(futura);
        tvSanych.setTypeface(futura);
        tvRinat.setTypeface(futura);
        tvTimur.setTypeface(futura);
        tvGrowth.setTypeface(futura);

        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        String text = def_pref.getString("main_text_size", "Средний");
        if(text != null) {
            switch (text) {
                case "Большой":
                    tvAnton.setTextSize(20);
                    tvSanych.setTextSize(20);
                    tvRinat.setTextSize(20);
                    tvTimur.setTextSize(20);
                    tvGrowth.setTextSize(20);
                    break;
                case "Средний":
                    tvAnton.setTextSize(16);
                    tvSanych.setTextSize(16);
                    tvRinat.setTextSize(16);
                    tvTimur.setTextSize(16);
                    tvGrowth.setTextSize(16);
                    break;
                case "Маленький":
                    tvAnton.setTextSize(14);
                    tvSanych.setTextSize(14);
                    tvRinat.setTextSize(14);
                    tvTimur.setTextSize(14);
                    tvGrowth.setTextSize(14);
                    break;
            }
        }
    }
}
