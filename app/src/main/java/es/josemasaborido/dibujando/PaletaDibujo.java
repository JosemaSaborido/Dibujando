package es.josemasaborido.dibujando;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class PaletaDibujo extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paleta_dibujo);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(new AreaDibujo(this));
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
                break;
            case R.id.itmRojo:
                mostrarMensaje(item);
                break;
            case R.id.itmVerde:
                mostrarMensaje(item);
                break;
            case R.id.itmEstrella:
                mostrarMensaje(item);
                break;
            case R.id.itmCara:
                mostrarMensaje(item);
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