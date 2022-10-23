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
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    private String sp1SelectedItem;
    private String sp2SelectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fr = "frets_final.png";


        Spinner sp1= (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.spinner1_items, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);

        // リスナーを登録
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner sp1 = (Spinner)parent;
                sp1SelectedItem = (String)sp1.getSelectedItem();

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

                String l1;
                l1 = sp1SelectedItem+sp2SelectedItem+".png";

                try (InputStream istream2 = assets.open(l1)){
                    Bitmap bitmap = BitmapFactory.decodeStream(istream2);
                    layer1.setImageBitmap(bitmap);
                } catch (Exception e){
                    e.printStackTrace();
                }


            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });



        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner2_items, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);

        // リスナーを登録
        sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent2,
                                       View view, int position, long id) {
                Spinner sp2 = (Spinner)parent2;
                sp2SelectedItem = (String)sp2.getSelectedItem();

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

                String l1;
                l1 = sp1SelectedItem+sp2SelectedItem+".png";

                try (InputStream istream2 = assets.open(l1)){
                    Bitmap bitmap = BitmapFactory.decodeStream(istream2);
                    layer1.setImageBitmap(bitmap);
                } catch (Exception e){
                    e.printStackTrace();
                }


            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent2) {
                //
            }
        });

    }
}