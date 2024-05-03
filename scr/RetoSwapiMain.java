package scr;

import scr.modelos.ConsultaPelicula;
import scr.modelos.HeaderModelo;
import scr.modelos.Pelicula;

import java.util.Scanner;

public class RetoSwapiMain {
    public static void main(String[] args) {
        // seteamos el header
        HeaderModelo header = new HeaderModelo();
        ConsultaPelicula consulta= new ConsultaPelicula();
        Pelicula pelicula= consulta.buscaPelicula(1);
        //
        header.setProfesor("Bruno Darío Fernández Ellerbach");
        header.setAcademia("Alura Latam");
        header.setCurso("Java, Consumir APIS, Archivos y manejo de errores");
        header.setProyecto("Usando API de StarWars SWAPI");
        header.setApi("https://swapi.dev/api/films/");
        //
        header.imprimirEncabezado();
        //
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el número de la pelicula: ");
        teclado.nextInt();

    }
}
