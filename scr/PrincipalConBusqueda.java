package scr;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import scr.excepciones.ErrorEnConversionException;
import scr.modelos.Encabezado;
import scr.modelos.Titulo;
import scr.modelos.TituloOmdb;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Encabezado encabezado = new Encabezado();
        encabezado.muestraEncabezado();
        //** variables del curso:
        Scanner lectura = new Scanner(System.in);
        //** lista de peliculas
        List<TituloOmdb> titulos = new ArrayList<>();
        //** se agrega el while()
        Integer cuenta =1;
        //Gson gson2 = new Gson();
        Gson gson2 = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy
                        .UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (true) {
            System.out.println("Escriba nombre de la pelicula #"+cuenta+" para buscarla\n <<salir>> para salir del programa: ");
            var busqueda = lectura.nextLine();
            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }
            cuenta++;
            String clave = System.getenv("apk_key");
            String direccion = "https://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=" + clave;
            //**
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //**

                //** ahora con el nuevo gson2
                TituloOmdb miTituloOmdb2 = gson2.fromJson(json, TituloOmdb.class);

                Titulo miTitulo3 = new Titulo(miTituloOmdb2);
                System.out.println("✅ titulo encontrado: " + miTitulo3);
                System.out.println("-------------------------------------");
                titulos.add(miTituloOmdb2);

            }
            catch (NumberFormatException e) {
                System.out.println("⚠\uFE0F Acaba de ocurrir un error! NumberFormatException ");
                System.out.println("Descripcion del error: " + e.getMessage());
                System.out.println("Causa del error: " + e.getCause());
            }
            catch (IllegalArgumentException e) {
                System.out.println("⚠\uFE0F Acaba de ocurrir un error! IllegalArgumentException");
                System.out.println("Descripcion del error: " + e.getMessage());
                System.out.println("Causa del error: " + e.getCause());
            }
            catch (ErrorEnConversionException e) {
                System.out.println("⚠\uFE0F se ha generado la execepcion propia!!");
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("⚠\uFE0F Acaba de ocurrir un error Inesperado!");
                System.out.println("Descripcion del error: " + e.getMessage());
                System.out.println("Causa del error: " + e.getCause());
            }
        }
        //**
        // archivos
        System.out.println("*******************************");
        System.out.println("** Crear Archivos JSON **");
        System.out.println("la lista contiene: "+ (cuenta-1) + " titulos: "+titulos);
        String nombreArchivo="titulos.json";
        FileWriter escritura = new FileWriter(nombreArchivo);
        //escritura.write(miTituloOmdb2.toString());
        escritura.write(gson2.toJson(titulos));
        escritura.close();
        System.out.println("\uD83D\uDCC2 Archivo " + nombreArchivo + " creado y guardado con exito!");
        System.out.println("⚙\uFE0F Finaliza el programa, asi sucedan excepciones");
    }
}