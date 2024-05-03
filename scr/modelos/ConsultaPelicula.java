package scr.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    /**
     * Colocar el numero de la pelicula 1-6.
     * @param numeroPelicula el nombre completo del profesor
     */
    public Pelicula buscaPelicula(int numeroPelicula) {
        HeaderModelo header = new HeaderModelo();
        String direccion = header.getApi()+numeroPelicula;
        //
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        //
        return new Gson().fromJson(response.body(), Pelicula.class);
    }
}
