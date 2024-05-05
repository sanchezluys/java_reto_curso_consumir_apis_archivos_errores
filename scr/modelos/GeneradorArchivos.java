package scr.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivos {

    public void guardarJson(Pelicula pelicula) throws IOException {
        Gson gson2 = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy
                        .UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        // archivos
        System.out.println("*******************************");
        System.out.println("** Creando Archivo JSON en proceso...");
        //System.out.println("la lista contiene: "+ (cuenta-1) + " titulos: "+titulos);
        String nombreArchivo=pelicula.title()+".json";
        FileWriter escritura = new FileWriter(nombreArchivo);
        escritura.write(gson2.toJson(pelicula));
        escritura.close();
        System.out.println("\uD83D\uDCC2 Archivo " + nombreArchivo + " creado y guardado con exito!");
        return;
    }
}
