package scr;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
//
public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("**************************************************");
        System.out.println("** CURSO JAVA APIS/ARCHIVOS/MANEJO DE ERRORES ***");
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
    }
}

