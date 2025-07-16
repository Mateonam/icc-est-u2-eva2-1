package controllers;
import models.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.List;

public class LibroController {
    

    public Set<Book> procesarLibros(List<Book> libros) {
    // Comparador personalizado:
        Comparator<Book> comparador = (b1, b2) -> {
            int cmpTitulo = b2.getTitulo().compareTo(b1.getTitulo()); // Orden descendente por título
            if (cmpTitulo != 0) return cmpTitulo;

            int cmpAnio = Integer.compare(b1.getAnio(), b2.getAnio()); // Orden ascendente por año
            if (cmpAnio != 0) return cmpAnio;

            // Si el título y año son iguales, se consideran duplicados → devuelve 0
            return 0;
        };

        Set<Book> librosOrdenados = new TreeSet<>(comparador);

        librosOrdenados.addAll(libros);

        return librosOrdenados;
}

}
