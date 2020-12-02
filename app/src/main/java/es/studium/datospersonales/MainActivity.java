package es.studium.datospersonales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView nombre;
    TextView apellidos;
    TextView edad;
    TextView genero;
    TextView estado;
    EditText etiqueta;
    TextView hijos;

    EditText nombreIn;
    EditText apellidosIn;
    EditText edadIn;

    RadioGroup gen;

    RadioButton hombre;
    RadioButton mujer;

    SwitchCompat hijoSwitch;

    Spinner spinner;

    ImageButton btnSpa;
    ImageButton btnIng;

    Button aceptar;
    Button limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.textView);
        apellidos = findViewById(R.id.textView2);
        edad = findViewById(R.id.textView3);
        genero = findViewById(R.id.textView4);
        estado = findViewById(R.id.textView5);
        hijos = findViewById(R.id.textView6);
        etiqueta = findViewById(R.id.editTextTextMultiLine);

        nombreIn = findViewById(R.id.editTextTextPersonName);
        apellidosIn = findViewById(R.id.editTextTextPersonName2);
        edadIn = findViewById(R.id.editTextNumber);

        hombre = findViewById(R.id.radioButton);
        mujer = findViewById(R.id.radioButton2);

        gen = findViewById(R.id.radioGroup);

        hijoSwitch = findViewById(R.id.switch1);

        spinner = findViewById(R.id.spinner);

        final ArrayAdapter<CharSequence> adapter_esp = ArrayAdapter.createFromResource(this, R.array.adapter_esp, android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> adapter_ing = ArrayAdapter.createFromResource(this, R.array.adapter_ing, android.R.layout.simple_spinner_dropdown_item);

        btnSpa = findViewById(R.id.imageButton);
        btnIng = findViewById(R.id.imageButton2);

        btnSpa.setImageResource(R.drawable.spanish);
        btnIng.setImageResource(R.drawable.ingles);

        aceptar = findViewById(R.id.button);
        limpiar = findViewById(R.id.button2);


        adapter_esp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_ing.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter_esp);

        btnSpa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                nombre.setText(R.string.nombre_esp);
                nombreIn.setHint(getText(R.string.nombreIn_esp));
                apellidos.setText(R.string.apellidos_esp);
                apellidosIn.setHint(getText(R.string.apellidosIn_esp));
                edad.setText(R.string.edad_esp);
                genero.setText(R.string.genero_esp);
                estado.setText(R.string.estado_esp);
                hombre.setText(R.string.radio1_esp);
                mujer.setText(R.string.radio2_esp);
                hijos.setText(R.string.hijos_esp);
                hijoSwitch.setTextOff(getText(R.string.no_esp));
                hijoSwitch.setTextOn(getText(R.string.si_esp));
                spinner.setAdapter(adapter_esp);
                aceptar.setText(R.string.aceptar_esp);
                limpiar.setText(R.string.limpiar_esp);

            }
        });

        btnIng.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                nombre.setText(R.string.nombre_ing);
                nombreIn.setHint(getText(R.string.nombreIn_ing));
                apellidos.setText(R.string.apellidos_ing);
                apellidosIn.setHint(getText(R.string.apellidosIn_ing));
                edad.setText(R.string.edad_ing);
                genero.setText(R.string.genero_ing);
                estado.setText(R.string.estado_ing);
                hombre.setText(R.string.radio1_ing);
                mujer.setText(R.string.radio2_ing);
                hijos.setText(R.string.hijos_ing);
                hijoSwitch.setTextOff(getText(R.string.no_ing));
                hijoSwitch.setTextOn(getText(R.string.si_ing));
                spinner.setAdapter(adapter_ing);
                aceptar.setText(R.string.aceptar_ing);
                limpiar.setText(R.string.limpiar_ing);


            }

        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nombreIn.getText().toString().equals("")) {
                        if(nombre.getText().equals("nombre")){
                        etiqueta.append("Por favor introduzca un nombre \n");
                    }
                    if(nombre.getText().equals("name")){
                        etiqueta.append("Type your name please \n");
                    }
                }

                if (apellidosIn.getText().toString().equals("")) {
                    if(nombre.getText().equals("nombre")){
                        etiqueta.append("Por favor introduzca un apellido \n");
                    }
                    if(nombre.getText().equals("name")){
                        etiqueta.append("Type your surname please \n");
                    }
                }

                if (edadIn.getText().toString().equals("")) {
                    if(nombre.getText().equals("nombre")){
                        etiqueta.append("Por favor introduzca un nombre \n");
                    }
                    if(nombre.getText().equals("name")){
                        etiqueta.append("Type your name please \n");
                    }
                }

                else if ((!nombreIn.getText().toString().equals(""))&&(!apellidosIn.getText().toString().equals(""))&&(!edadIn.getText().toString().equals(""))) {

                    int numero = Integer.parseInt(edadIn.getText().toString());
                    String mayoria;
                    if (numero>=18) {
                        mayoria = "mayor de edad";
                    } else {
                        mayoria = "menor de edad";
                    }

                    String texto="";
                    if (hombre.isChecked()) {
                        texto=hombre.getText().toString();
                    } else if(mujer.isChecked()) {
                        texto=mujer.getText().toString();
                    }

                    String conHijos;
                    if (hijoSwitch.isChecked()) {
                        conHijos = "con hijos.";
                    }
                    else {
                        conHijos = "sin hijos.";
                    }


                    String info = apellidosIn.getText() + ", " + nombreIn.getText() + ", " + mayoria + ", " + texto + " " + spinner.getSelectedItem() + " y " + conHijos;

                    Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();


                }

            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nombreIn.setText(null);
                apellidosIn.setText(null);
                edadIn.setText(null);
                gen.clearCheck();
                spinner.setSelection(0, true);
                hijoSwitch.setChecked(false);
            }
        });

    }

}