package scr;
import com.google.gson.Gson;
import scr.modelos.Titulo;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//
public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
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

    }
}

