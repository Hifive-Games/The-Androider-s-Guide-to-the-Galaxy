package me.t3sl4.galaxyguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import me.t3sl4.essentials.JSON.Serializator;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Serializator seri = new Serializator();
    }

}
