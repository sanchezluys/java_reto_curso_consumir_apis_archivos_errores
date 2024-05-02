package scr;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import scr.modelos.Titulo;
import scr.modelos.TituloOmdb;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//
public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            //** variables del curso:
            String profesor="Bruno Darío Fernández Ellerbach";
            //**
            Scanner lectura = new Scanner(System.in);
            System.out.println("********** ALURA LATAM ***************");
            System.out.println("** CURSO JAVA APIS/ARCHIVOS/ERRORES ***");
            System.out.println("** Profesor: " + profesor + " ***");
            System.out.println("**************************************************");
            //**
            System.out.println("**************************************************");
            System.out.println("** USANDO API DE https://www.omdbapi.com/      ***");
            System.out.println("**************************************************");
            System.out.println("Escriba el nombre de una pelicula para buscarla: ");
            var busqueda = lectura.nextLine();
            String clave = System.getenv("apk_key");
            String direccion = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=" + clave;
            //**
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //**
            System.out.println(response.body());
            //**
            //** con Gson
            System.out.println("** Ahora con la libreria de Gson Instalada **");
            Gson gson = new Gson();
            // se va a la documentacion de la libreria
            String json=response.body();
            System.out.println("Gson: "+ gson.fromJson(json, Titulo.class));
            //**
            Titulo miTitulo = gson.fromJson(json, Titulo.class);
            System.out.println("Titulo: " + miTitulo);
            System.out.println("Nombre: " + miTitulo.getNombre());
            // da null, es necesario que en la clase Titulo exista el nombre, pero en el json existe es Title
            // es necesario hacer la conversion en la clase Titulo, con anotaciones @SerializedName
            System.out.println("Con las anotaciones: ");
            System.out.println("Nombre->Title: "+ miTitulo.getNombre()+ " Año Lanzamiento -> Year: " + miTitulo.getFechaDeLanzamiento());
            System.out.println("*********************************");
            System.out.println("Se agrega el constructor toString() a la clase Titulo");
            System.out.println("Nombre->Title: "+ miTitulo);
            System.out.println("*********************************");
            System.out.println("* Usando DTO Data transfer Objet  con RECORD **");
            System.out.println("1. Se agrega la clase record: TituloOmdb");

            TituloOmdb miTituloOmdb =gson.fromJson(json, TituloOmdb.class);
            System.out.println("miTituloOmdb: "+ miTituloOmdb);
            // se crea otro gson que tome en cuenta las mayusculas del json ejm: Title
            System.out.println("2. Se agrega la clase record: gson2");
            Gson gson2 = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy
                            .UPPER_CAMEL_CASE).create();
            System.out.println("gson2: " + gson2);
            //** ahora con el nuevo gson2
            TituloOmdb miTituloOmdb2 = gson2.fromJson(json, TituloOmdb.class);
            System.out.println("miTituloOmdb2: "+ miTituloOmdb2);
            //* se crea el nuevo constructor
            // ahora se activa el try-catch para el manejo de errores

            Titulo miTitulo3 = new Titulo(miTituloOmdb2);
            System.out.println("titulo 3: " + miTitulo3);
            //**

        }
        catch (NumberFormatException e){
            System.out.println("Acaba de ocurrir un error! NumberFormatException ");
            System.out.println("Descripcion del error: " + e.getMessage());
            System.out.println("Causa del error: " + e.getCause());
        }
        catch (IllegalArgumentException e){
            System.out.println("Acaba de ocurrir un error! IllegalArgumentException");
            System.out.println("Descripcion del error: " + e.getMessage());
            System.out.println("Causa del error: " + e.getCause());
        }
        catch (Exception e){
            System.out.println("Acaba de ocurrir un error Inesperado!");
            System.out.println("Descripcion del error: " + e.getMessage());
            System.out.println("Causa del error: " + e.getCause());
        }
        System.out.println("Finaliza el programa, asi suceda un error");
        //** ahora corrigiendo con .replace()
        try {
            Scanner lectura = new Scanner(System.in);
            System.out.println("****************************************");
            System.out.println("Correccion de peliculas con espacios agregando .replace()");
            System.out.println("****************************************");
            System.out.println("Escriba el nombre la pelicula con espacios, ejemplo: *top gun* para buscarla: ");
            var busqueda = lectura.nextLine();
            String clave = System.getenv("apk_key");
            String direccion = "https://www.omdbapi.com/?t=" + busqueda.replace(" ","+") + "&apikey=" + clave;
            //**
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            //**
            System.out.println(response.body());

            System.out.println("nueva direccion corregida con .replace(), sin errores"+ direccion);
        }
        catch (IllegalArgumentException e){
            System.out.println("Se ha dado una excepcion");
        }


    }
}

