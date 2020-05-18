package ru.fmeter.escort_handbook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private ActionBar actionBar;
    private TextView text_content;
    private ImageView iContent;
    private Typeface futura;
    private SharedPreferences def_pref;
    private int category = 0;
    private int position = 0;

    private int [] array_dut = {R.string.td_100, R.string.td_150, R.string.td_500, R.string.td_600, R.string.td_online, R.string.td_ble, R.string.tl_ble, R.string.du_180,
            R.string.dgv_200, R.string.escort_net, R.string.i_4, R.string.du_ble, R.string.db_2};
    private int [] array_materials = {R.string.menu_materials_passports, R.string.menu_materials_manuals, R.string.menu_materials_acts, R.string.menu_materials_configs, R.string.menu_materials_firmware};

    private int [] array_image_dut = {R.drawable.td_100, R.drawable.td_150, R.drawable.td_500, R.drawable.td_600, R.drawable.td_online,
            R.drawable.td_ble_base, R.drawable.tl_ble, R.drawable.du_180, R.drawable.dgv_200, R.drawable.escort_net, R.drawable.i4, R.drawable.du_ble, R.drawable.db_2};
    private int [] array_image_materials = {R.drawable.passports, R.drawable.manuals, R.drawable.acts, R.drawable.configs, R.drawable.firmware};
    private int [] array_image_faq = {R.drawable.img_faq_question};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        reciveIntent();
    }

    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }

        switch (category){
            case 0:
                text_content.setText(array_dut[position]);
                iContent.setImageResource(array_image_dut[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.dut_array)[position]);
                break;
            case 1:
                text_content.setText(array_materials[position]);
                iContent.setImageResource(array_image_materials[position]);
                actionBar.setTitle(getResources().getStringArray(R.array.materials_array)[position]);
                break;
            case 2:
                // Для пункта Видеоинструкции создано отдельное активити
                break;
            case 3:
                if (position == 21)
                text_content.setText(R.string.faq_content_txt);
                else if (position == 23)
                text_content.setText(R.string.faq_content2_txt);
                else
                text_content.setText(getResources().getStringArray(R.array.faq_array_content)[position]);

                iContent.setImageResource(array_image_faq[0]);
                actionBar.setTitle(getResources().getStringArray(R.array.faq_array)[position]);
                break;
            case 4:
                // Для пункта Контакты создано отдельное активити
                break;
            case 5:
                // Для пункта О нас создано отдельное активити
                break;
        }
    }

    private void init(){
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        text_content = findViewById(R.id.text_mian_content);
        iContent = findViewById(R.id.imageContent);
        futura = Typeface.createFromAsset(this.getAssets(), "Fonts/FuturaMediumC.ttf");
        text_content.setTypeface(futura);
        Linkify.addLinks(text_content, Linkify.ALL);
        text_content.setMovementMethod(LinkMovementMethod.getInstance());
        text_content.setLinkTextColor(Color.parseColor("#0000ff"));
        actionBar = getSupportActionBar();
        String text = def_pref.getString("main_text_size", "Средний");
        if(text != null) {
            switch (text) {
                case "Большой":
                    text_content.setTextSize(24);
                    break;
                case "Средний":
                    text_content.setTextSize(18);
                    break;
                case "Маленький":
                    text_content.setTextSize(14);
                    break;
            }
        }
    }
}
