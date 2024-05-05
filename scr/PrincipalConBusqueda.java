package scr;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import scr.excepciones.ErrorEnConversionException;
import scr.modelos.*;

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
        ConsultaPelicula consulta = new ConsultaPelicula();
        //** variables del curso:
        Scanner lectura = new Scanner(System.in);
        //** lista de peliculas
        List<TituloOmdb> titulos = new ArrayList<>();
        //** se agrega el while()
        int cuenta =1;

        try {
            while (true) {
                System.out.println("Indique el número de la pelicula Star Wars (" + cuenta + ")\n<<0>> para salir del programa");
                int busqueda = lectura.nextInt();
                lectura.nextLine();
                if (busqueda == 0) {
                    break;
                }
                cuenta++;
                Pelicula pelicula = consulta.buscaPelicula(busqueda);
                System.out.println("✅ Pelicula #" + busqueda + " econtrada con exito! ");
                GeneradorArchivos generaArchivo = new GeneradorArchivos();
                generaArchivo.guardarJson(pelicula);
            }
        }
        catch (IOException e){
            System.out.println("********************************");
            System.out.println("Mensaje Error IOException: "+ e.getMessage());
            System.out.println("\uD83C\uDF19 Error!! Aplicación Finalizada \uD83C\uDF19");
        }
        catch (NumberFormatException e){
            System.out.println("********************************");
            System.out.println("Mensaje Error NumberFormatException: "+ e.getMessage());
            System.out.println("\uD83C\uDF19 Error!! Aplicación Finalizada \uD83C\uDF19");
        }
        catch (RuntimeException e)
        {
            System.out.println("********************************");
            System.out.println("Mensaje Error RuntimeException: "+ e.getMessage());
            System.out.println("\uD83C\uDF19 Error!! Aplicación Finalizada \uD83C\uDF19");
        }


        //**

        System.out.println("⚙\uFE0F Finalizando el programa...\nHasta Pronto! ✈\uFE0F");
    }
}