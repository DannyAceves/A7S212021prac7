package mx.edu.tesoem.isc.aed.a7s212021prac7;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Archivos {
    public final String NombreArchivo="Datos.txt";
    public ArrayList<String> Datos  = new ArrayList<>();

    public boolean Grabar(Context context, ArrayList<String> Datos){
        try {
            OutputStreamWriter archivo= new OutputStreamWriter(context.openFileOutput(NombreArchivo, Activity.MODE_PRIVATE));
            for (String dato : Datos)
                archivo.write(dato+ "\n");
            archivo.flush();
            archivo.close();
        }catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean Leer(Context context){
        try{
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(NombreArchivo));
            BufferedReader br = new BufferedReader(archivo);
            String linea;
            while((linea = br.readLine()) != null){
                Datos.add(linea);
            }
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public ArrayList<String>getDatos(){
        return Datos;
    }

    public void Agregar (String dato, ArrayList<String> Datos){
        this.Datos = Datos;
        this.Datos.add(dato);

    }

    public boolean Verificar(Context context){
        String[] archivos = context.fileList();
        for (String archivo : archivos)
            if(archivo.equals(NombreArchivo)) return true;
            return false;
        }
}
