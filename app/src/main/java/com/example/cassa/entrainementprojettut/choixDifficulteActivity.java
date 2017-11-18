package com.example.cassa.entrainementprojettut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choixDifficulteActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_difficulte);

        Intent intent = getIntent();
        String activityToLaunch = intent.getStringExtra("Activity");

        mButton1 = (Button)findViewById(R.id.niveau1_btn);
        mButton2 = (Button)findViewById(R.id.niveau2_btn);
        mButton3 = (Button)findViewById(R.id.niveau3_btn);

        if(activityToLaunch.equals("Addition"))
        {
            final Intent addition = new Intent(choixDifficulteActivity.this, AdditionActivity.class);
            addition.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            mButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addition.putExtra("diff",1);
                    startActivity(addition);

                }
            });
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addition.putExtra("diff",2);
                    startActivity(addition);

                }
            });
            mButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addition.putExtra("diff",3);
                    startActivity(addition);
                }
            });
        }
        else if(activityToLaunch.equals("MysteryWord"))
        {
            final Intent mysteryWord = new Intent(choixDifficulteActivity.this, MysteryWordActivity.class);
            mysteryWord.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            mButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mysteryWord.putExtra("diff",1);
                    startActivity(mysteryWord);

                }
            });
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mysteryWord.putExtra("diff",2);
                    startActivity(mysteryWord);

                }
            });
            mButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mysteryWord.putExtra("diff",3);
                    startActivity(mysteryWord);
                }
            });
        }
    }
}

