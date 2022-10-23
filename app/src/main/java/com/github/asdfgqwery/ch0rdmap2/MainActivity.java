package com.github.asdfgqwery.ch0rdmap2;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fr = "frets_final.png";


        Spinner sp1= (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner1_items, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);

        //Spinner spinner = (Spinner)parent;
        String sp1SelectedItem = (String)sp1.getSelectedItem();


        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner2_items, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);

        String sp2SelectedItem = (String)sp2.getSelectedItem();


        ImageView fret = findViewById(R.id.fret);
        ImageView layer1 = findViewById(R.id.layer1);
        AssetManager assets = getResources().getAssets();

        //Fret
        try (InputStream istream1 = assets.open(fr)){
            Bitmap bitmap = BitmapFactory.decodeStream(istream1);
            fret.setImageBitmap(bitmap);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Layer1
        String l1;
        l1 = sp1SelectedItem+sp2SelectedItem+".png";

        try (InputStream istream2 = assets.open(l1)){
            Bitmap bitmap = BitmapFactory.decodeStream(istream2);
            layer1.setImageBitmap(bitmap);
        } catch (Exception e){
            e.printStackTrace();
        }




    }
}