package com.example.taller202501;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;
    Button aumentar, disminuir, cambiarFuente, cambiarColor;

    float size = 18f;
    int tipoFuente = 0;
    int colorIndex = 0;

    Typeface[] fuentes;
    int[] colores = {
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.BLACK
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mensaje = findViewById(R.id.txtmensaje);
        aumentar = findViewById(R.id.btnaumentar);
        disminuir = findViewById(R.id.btndisminuir);
        cambiarFuente = findViewById(R.id.btnfuente);
        cambiarColor = findViewById(R.id.btncolor);

        fuentes = new Typeface[]{
                Typeface.DEFAULT,
                Typeface.SERIF,
                Typeface.SANS_SERIF,
                Typeface.MONOSPACE
        };

        aumentar.setOnClickListener(view -> {
            size += 2f;
            mensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        });

        disminuir.setOnClickListener(view -> {
            if (size > 10f) {
                size -= 2f;
                mensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
            } else {
                Toast.makeText(this, "Tamaño mínimo alcanzado", Toast.LENGTH_SHORT).show();
            }
        });

        cambiarFuente.setOnClickListener(view -> {
            tipoFuente = (tipoFuente + 1) % fuentes.length;
            mensaje.setTypeface(fuentes[tipoFuente]);
        });

        cambiarColor.setOnClickListener(view -> {
            colorIndex = (colorIndex + 1) % colores.length;
            mensaje.setTextColor(colores[colorIndex]);
        });
    }
}
