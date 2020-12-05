package mx.edu.tesoem.isc.aed.a7s212021prac7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtNombre;
    TextView lblcontenido;
    ArrayList <String> Datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        lblcontenido = findViewById(R.id.lblcontenido);
        Cargarinfo();
    }

    public void Grabar(View v){
        Archivos conexion = new Archivos();
        conexion.Agregar(txtNombre.getText().toString(),Datos);
        Datos = conexion.getDatos();
        if(conexion.Grabar(this,Datos)){
            Toast.makeText(this,"Grabación Correcta",Toast.LENGTH_SHORT).show();
            Cargarinfo();
        }else{
            Toast.makeText(this,"Error de grabación",Toast.LENGTH_SHORT).show();
        }
    }

    public void Cargarinfo(){
        Archivos conexion = new Archivos();
        String dato="";
        if (conexion.Verificar(this)){
            if (conexion.Leer(this)){
                Datos=conexion.getDatos();
                for (String elemento : Datos){
                    dato+=elemento + "\n";
                }
                lblcontenido.setText(dato);
            }else{
                Toast.makeText(this, "No existe el archivo, grabé la información para su creación",Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "No existe el archivo, grabé la información para su creación",Toast.LENGTH_LONG).show();
        }
    }
}