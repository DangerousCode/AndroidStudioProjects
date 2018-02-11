package com.ye.alvaro.basico1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    private TextView txtSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        //Localizar los controles
        txtSaludo = (TextView)findViewById(R.id.txtSaludo);

        //Recuperamos la información pasada por Intent
        Bundle bundle = this.getIntent().getExtras();

        txtSaludo.setText("Hola: " + bundle.getString("NOMBRE"));
    }
}
