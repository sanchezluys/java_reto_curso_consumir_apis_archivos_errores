package scr.modelos;

public record TituloOmdb(String title, String year, String runtime) {

    @Override
    public String toString() {
        return "(" +
                "Nombre='" + title + '\'' +
                ", FechaDeLanzamiento='" + year + '\'' +
                ", DuracionEnMinutos='" + runtime + '\'' +
                ')';
    }
}
