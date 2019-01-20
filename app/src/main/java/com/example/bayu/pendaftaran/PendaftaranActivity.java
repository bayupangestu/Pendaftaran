package com.example.bayu.pendaftaran;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.Calendar;

public class PendaftaranActivity extends AppCompatActivity {

    private static final String TAG = "PendaftaranActiviy";

    private LinearLayout tambah;
    Spinner spAgama,spjaket,sppilihan1,sppilihan2,spjalur,sptahun;
    private EditText tanggallahir;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private CheckBox checkbox;
    private ImageButton buttonsidemenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
        spAgama = (Spinner) findViewById(R.id.spinneragama);
        spjaket = (Spinner) findViewById(R.id.spinnerjaket);
        sppilihan1 = (Spinner) findViewById(R.id.spinerpilihan1);
        sppilihan2 = (Spinner) findViewById(R.id.spinerpilihan2);
        spjalur = (Spinner) findViewById(R.id.spinnerjalurmasuk);
        sptahun = (Spinner) findViewById(R.id.spinnertahun);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pendaftaran Test-On Site");


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(PendaftaranActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.agama));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAgama.setAdapter(myAdapter);

        ArrayAdapter<String> Adapterjaket = new ArrayAdapter<String>(PendaftaranActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.jaket));

        Adapterjaket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjaket.setAdapter(Adapterjaket);

        ArrayAdapter<String> Adapterpilihan1 = new ArrayAdapter<String>(PendaftaranActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pilihan));

        Adapterjaket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sppilihan1.setAdapter(Adapterpilihan1);

        ArrayAdapter<String> Adapterpilihan2 = new ArrayAdapter<String>(PendaftaranActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pilihan));

        Adapterjaket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sppilihan2.setAdapter(Adapterpilihan2);

        ArrayAdapter<String> Adapterjalurmasuk = new ArrayAdapter<String>(PendaftaranActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.masuk));

        Adapterjalurmasuk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spjalur.setAdapter(Adapterjalurmasuk);

        ArrayAdapter<String> Adaptertahun = new ArrayAdapter<String>(PendaftaranActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tahun));

        Adaptertahun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptahun.setAdapter(Adaptertahun);

        tanggallahir = (EditText) findViewById(R.id.etxtanggallahir);

        tanggallahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        PendaftaranActivity.this, android.R.style.Theme_Material_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                tanggallahir.setText(date);

            }
        };

        checkbox = (CheckBox) findViewById(R.id.cbcek);
        tambah = (LinearLayout) findViewById(R.id.layouttambahsekolah);

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkbox.isChecked()) {
                    tambah.setVisibility(View.VISIBLE);
                } else if (!checkbox.isChecked()) {
                    tambah.setVisibility(View.GONE);
                }
            }
        });

        buttonsidemenu = (ImageButton) findViewById(R.id.sidemenubtn);
        buttonsidemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSideMenu();
            }
        });

    }

    public void openSideMenu(){
        Intent intent = new Intent(this, SideMenu.class);
        startActivity(intent);
    }

}
