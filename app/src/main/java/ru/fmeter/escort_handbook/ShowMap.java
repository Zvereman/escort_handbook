package ru.fmeter.escort_handbook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

public class ShowMap extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.menu_map_scheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);

        PhotoView photoView = findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.img_show_map);
    }
}
