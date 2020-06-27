package ru.fmeter.escort_handbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ru.fmeter.escort_handbook.utils.CustomArrayAdapter;
import ru.fmeter.escort_handbook.utils.ListItemClass;

public class VideoView extends AppCompatActivity {
    private ActionBar actionBar;
    private List<ListItemClass> listItemMain;
    private ListItemClass listItem;
    private CustomArrayAdapter adapter;
    private ListView listVideoinstructions;
    private int [] array_video_img = {R.drawable.instruct_img_default, R.drawable.instruct_td_ble_umka310br, R.drawable.instruct_td_ble_queclink, R.drawable.instruct_img_default,
            R.drawable.instruct_img_default, R.drawable.instruct_du_ble_rotation_control,
             R.drawable.instruct_du_ble_angle_control, R.drawable.instruct_du_ble_shovel, R.drawable.instruct_du_ble_blade, R.drawable.instruct_img_default, R.drawable.instruct_img_default,
             R.drawable.instruct_img_default, R.drawable.instruct_img_default, R.drawable.instruct_img_default, R.drawable.instruct_img_default,
            R.drawable.instruct_img_default, R.drawable.instruct_img_default,
             R.drawable.instruct_img_default, R.drawable.instruct_img_default, R.drawable.instruct_img_default, R.drawable.instruct_kalibr_tarir_dut,
            R.drawable.instruct_cnt_dut, R.drawable.instruct_dut_tarirovka_analog, R.drawable.instruct_dut_suhaya_kalibrovka};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);
        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.menu_video);

        listVideoinstructions = findViewById(R.id.LvVideoinstructions);

        listItemMain = new ArrayList<>();

        fillArray(getResources().getStringArray(R.array.videoinstructions_array_ttl),getResources().getStringArray(R.array.videoinstructions_array_sec_ttl), array_video_img);
        adapter = new CustomArrayAdapter(this, R.layout.list_view_item, listItemMain, getLayoutInflater());
        listVideoinstructions.setAdapter(adapter);

        listVideoinstructions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(VideoView.this, VideoContent.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    private void fillArray(String[] nameArr, String[] secName, int[] image){

        if(adapter != null)
            adapter.clear();

        for(int i = 0; i < nameArr.length; i++){
            listItem = new ListItemClass();
            listItem.setName(nameArr[i]);
            listItem.setSecond_name(secName[i]);
            listItem.setImage_id(image[i]);

            listItemMain.add(listItem);
        }

        if(adapter != null)
            adapter.notifyDataSetChanged();
    }
}
