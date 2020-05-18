package ru.fmeter.escort_handbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Contacts extends AppCompatActivity {
    private ActionBar actionBar;
    private Animation animScale, animRotate, animMoove, animAlpha;
    private ImageView imgCallSng, imgCallRus, imgYoutube, imgTelegram, imgWhatsapp, imgViber, imgSkype, imgEmail, imgLocation, imgMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.menu_contacts);
        imgCallSng = findViewById(R.id.img_btn_call_sng);
        imgCallRus = findViewById(R.id.img_btn_call_rus);
        imgYoutube = findViewById(R.id.img_btn_youtube_ch);
        imgTelegram = findViewById(R.id.img_btn_telegram);
        imgWhatsapp = findViewById(R.id.img_btn_whatsapp);
        imgViber = findViewById(R.id.img_btn_viber);
        imgSkype = findViewById(R.id.img_btn_skype);
        imgEmail = findViewById(R.id.img_btn_mail);
        imgLocation = findViewById(R.id.img_btn_location);
        imgMap = findViewById(R.id.iv_contacts_map);
        animScale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_anim);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anim);
        animMoove = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.moove_anim);
        animAlpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_alpha_anim);

    }

    public void btnTelegram(View view) {
        imgTelegram.startAnimation(animScale);

        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=EscortSupport"));
        startActivity(browserIntent);
    }

    public void btnWhatsapp(View view) {
        imgWhatsapp.startAnimation(animScale);

        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/79600464665"));
        startActivity(browserIntent);
    }

    public void btnViber(View view) {
        imgViber.startAnimation(animScale);

        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("viber://chat?number=79600464665"));
        startActivity(browserIntent);
    }

    public void btnSkype(View view) {
        imgSkype.startAnimation(animScale);

        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("skype:escort2b"));
        startActivity(browserIntent);
    }

    public void btnEmail(View view) {
        imgEmail.startAnimation(animScale);

        Intent browserIntent = new
                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:support@fmeter.ru"));
        startActivity(browserIntent);
    }

    public void btnCallRus(View view) {
        imgCallRus.startAnimation(animRotate);

        Intent browserIntent = new
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:88007771603"));
        startActivity(browserIntent);
    }

    public void btnCallSng(View view) {
        imgCallSng.startAnimation(animRotate);

        Intent browserIntent = new
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:84951086833"));
        startActivity(browserIntent);
    }

    public void btnLocation(View view) {
        imgLocation.startAnimation(animAlpha);

        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("geo:55.8490373,49.0934571"));
        startActivity(browserIntent);
    }

    public void btnYotube(View view) {
        imgYoutube.startAnimation(animAlpha);

        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCpok8amK_3UDigunehNqbRw"));
        startActivity(browserIntent);
    }

    public void btnMap(View view) {
        imgMap.startAnimation(animScale);

        Intent i = new Intent(Contacts.this, MapActivity.class);
        startActivity(i);
    }
}
