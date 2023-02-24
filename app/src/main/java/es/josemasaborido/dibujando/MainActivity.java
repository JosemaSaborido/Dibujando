package es.josemasaborido.dibujando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnDibujar;
    private Audio audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnDibujar = findViewById(R.id.btnDibujar);
        this.btnDibujar.setOnClickListener(this);
        this.audio = new Audio();

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PaletaDibujo.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.audio.init(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.audio.pause();
    }
}