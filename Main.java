import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Libro {
    private String nombre;
    private String autor;
    private long isbn;  // Cambiado a long para coincidir con el tipo en el menú

    public Libro(String nombre, String autor, long isbn) {  // Cambiado el parámetro a nombre
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    @Override
    public String toString() {
        return "Titulo: " + nombre + ", Autor: " + autor + ", ISBN: " + isbn;
    }
}

class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();  // Inicializar la lista de libros
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    public void buscarLibro(String nombre) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getNombre().equalsIgnoreCase(nombre)) {  // Paréntesis corregido
                System.out.println("Libro encontrado en la posición: " + i);
                System.out.println(libros.get(i));
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void eliminarLibro(String nombre) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getNombre().equalsIgnoreCase(nombre)) {
                libros.remove(i);
                System.out.println("Libro eliminado correctamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
    
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }

    public void ordenarLibros() {
        Collections.sort(libros, Comparator.comparing(Libro::getNombre));
        System.out.println("Libros ordenados alfabéticamente.");
    }

    public void editarLibro(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < libros.size()) {
            libros.get(indice).setNombre(nuevoNombre);
            System.out.println("Libro editado correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("==================================");
            System.out.println("BIBLIOTECA - MENÚ DE OPCIONES");
            System.out.println("==================================");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Ordenar libros alfabéticamente");
            System.out.println("6. Editar libro indicando índice");
            System.out.println("7. Salir");
            System.out.println("==================================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del libro: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    long isbn = scanner.nextLong();  // Cambiado a long
                    scanner.nextLine(); // Limpiar el buffer
                    agregarLibro(new Libro(nombre, autor, isbn));
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del libro a buscar: ");
                    nombre = scanner.nextLine();
                    buscarLibro(nombre);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del libro a eliminar: ");
                    nombre = scanner.nextLine();
                    eliminarLibro(nombre);
                    break;
                case 4:
                    listarLibros();
                    break;
                case 5:
                    ordenarLibros();
                    break;
                case 6:
                    System.out.print("Ingrese el índice del libro a editar: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nuevo nombre del libro: ");
                    String nuevoNombre = scanner.nextLine();  // Variable definida
                    editarLibro(indice, nuevoNombre);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.mostrarMenu();
    }
    
}
