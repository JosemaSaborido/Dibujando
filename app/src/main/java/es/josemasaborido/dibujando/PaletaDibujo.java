package es.josemasaborido.dibujando;

import static es.josemasaborido.dibujando.R.id.lytAreaDibujo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PaletaDibujo extends AppCompatActivity {
    private Toolbar toolbar;
    private ConstraintLayout cl;
    private AreaDibujo areaDibujo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paleta_dibujo);
        cl= findViewById(lytAreaDibujo);
        toolbar = findViewById(R.id.toolbar);
        areaDibujo = new AreaDibujo(getApplicationContext());
        cl.addView(areaDibujo);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudibujo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itmAmarillo:
                mostrarMensaje(item);
                this.areaDibujo.setPincelSelecionado(1);
                break;
            case R.id.itmRojo:
                mostrarMensaje(item);
                this.areaDibujo.setPincelSelecionado(2);
                break;
            case R.id.itmVerde:
                mostrarMensaje(item);
                this.areaDibujo.setPincelSelecionado(3);
                break;
            case R.id.itmEstrella:
                mostrarMensaje(item);
                this.areaDibujo.setPincelSelecionado(4);
                break;
            case R.id.itmCara:
                mostrarMensaje(item);
                this.areaDibujo.setPincelSelecionado(5);
                break;
            case R.id.itmBorrar:
                this.areaDibujo.borrar();
                break;
            case R.id.itmVolver:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    private void mostrarMensaje(MenuItem item){
        StringBuilder sb = new StringBuilder();
        sb.append("Has elegido la paleta ");
        switch(item.getTitle().toString()){
            case "Amarillo":
                sb.append("circulo amarillo");
                break;
            case "Rojo":
                sb.append("circulo rojo");
                break;
            case "Verde":
                sb.append("circulo verde");
                break;
            case "Estrella":
                sb.append("estrella");
                break;
            case "Cara":
                sb.append("cara Josema");
                break;

        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }
}