package ru.fmeter.escort_handbook;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import ru.fmeter.escort_handbook.settings.Settings_Activity;
import ru.fmeter.escort_handbook.utils.CustomArrayAdapter;
import ru.fmeter.escort_handbook.utils.ListItemClass;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView list;
    private CustomArrayAdapter adapter;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private int category_index;

    private int [] array_dut_img = {R.drawable.td_100, R.drawable.td_150, R.drawable.td_500, R.drawable.td_600, R.drawable.td_online,
            R.drawable.td_ble, R.drawable.tl_ble, R.drawable.du_180, R.drawable.dgv_200, R.drawable.escort_net, R.drawable.i4, R.drawable.du_ble, R.drawable.db_2};
    private int [] array_materials_img = {R.drawable.passports, R.drawable.manuals, R.drawable.acts, R.drawable.configs, R.drawable.firmware};
    private int [] array_faq_img = {R.drawable.img_faq_question};

    private List<ListItemClass> listItemMain;
    private ListItemClass listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.lv_main_content);
        listItemMain = new ArrayList<>();

        fillArray(R.string.menu_dut, getResources().getStringArray(R.array.dut_array), getResources().getStringArray(R.array.dut_array_sec), array_dut_img,0);
        adapter = new CustomArrayAdapter(this, R.layout.list_view_item, listItemMain, getLayoutInflater());
        list.setAdapter(adapter);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_dut);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent i = new Intent(MainActivity.this, Settings_Activity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.nav_dut){
            fillArray(R.string.menu_dut, getResources().getStringArray(R.array.dut_array), getResources().getStringArray(R.array.dut_array_sec), array_dut_img,0);
        } else if (id == R.id.nav_materials){
            fillArray(R.string.menu_material, getResources().getStringArray(R.array.materials_array), getResources().getStringArray(R.array.materials_array_sec), array_materials_img,1);
        } else if (id == R.id.nav_video){
            Intent intent = new Intent(MainActivity.this, VideoView.class);
            startActivity(intent);
        } else if (id == R.id.nav_faq){
            fillArray(R.string.menu_faq, getResources().getStringArray(R.array.faq_array), getResources().getStringArray(R.array.faq_array_sec), array_faq_img,3);
        } else if (id == R.id.id_contacts){
            Intent intent = new Intent(MainActivity.this, Contacts.class);
            startActivity(intent);
        } else if (id == R.id.id_about){
            Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
            startActivity(intent);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title, String[] nameArr, String[] secName, int[] image, int index){
        toolbar.setTitle(title);

        if(adapter != null)
        adapter.clear();

        for(int i = 0; i < nameArr.length; i++){
            listItem = new ListItemClass();
            listItem.setName(nameArr[i]);
            listItem.setSecond_name(secName[i]);
            if(image.length == 1){
                listItem.setImage_id(image[0]);
            } else {
                listItem.setImage_id(image[i]);
            }
            listItemMain.add(listItem);
        }

        if(adapter != null)
        adapter.notifyDataSetChanged();

        category_index = index;
    }
}
