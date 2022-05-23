package ru.vgtrofimov.nasharik;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PlayNasharik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nasharik);


        // Toast.makeText(this, "Загрузка", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AndroidLauncher.class);
        PlayNasharik pl = this;

        new CountDownTimer(500, 500) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        pl.finish();
                    }
                });

            }
        }.start();

    }
}