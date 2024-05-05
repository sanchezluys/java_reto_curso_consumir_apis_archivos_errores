package scr.modelos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        String direccion = header.getApi()+ String.valueOf(numeroPelicula);
        //
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy
                        .UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        //
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);
        }
        catch (Exception e) {
            throw new RuntimeException("❎ Error! Pelicula no encontrada");
        }
    }
}
