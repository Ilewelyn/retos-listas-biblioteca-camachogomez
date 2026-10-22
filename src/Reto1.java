/*Autor: Jenny Alexandra Camacho Gómez
*22/10/26
*/
package src;
class Nodo {
    String libro;
    Nodo siguiente;
    
    Nodo(String libro) { 
        this.libro = libro; 
    }
}

class ListaSimple {
    private Nodo cabeza;

    // se insertara un libro al final de la lista 
    public void insertarFinal(String libro) {
        Nodo nuevo = new Nodo(libro);
        if (cabeza == null) {
            // Si la lista se encuentra vacia el nuevo tomara la cabeza
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) { // TODO 2: condición para detenerse en el ÚLTIMO nodo
                // avanzamos por la lista hasta encontrar el último nodo
                actual = actual.siguiente;
            }
            // aqui se conecta el ultimo nodo de la lista con el nuevo libro
            actual.siguiente = nuevo;
        }
    }

    // en esta parte devuelve verdadero si el libro existe 
    public boolean buscar(String libro) {
        Nodo actual = cabeza;
        while (actual != null) {
            // se compara el libro actual con el cual estamos comparando 
            if (actual.libro.equals(libro)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // aqui se elimina la priemra aparicion del lirbo
    public boolean eliminar(String libro) {
        if (cabeza == null) return false;
        
        if (cabeza.libro.equals(libro)) {
            // eliminar la cabeza
            // si aqui el libro a eliminar es el primero, la cadena se mueve all siguiente nodo
            cabeza = cabeza.siguiente;
            return true;
        }
        
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.libro.equals(libro)) {

                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.libro + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class Reto1 {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        
        // agregue cuatro libros 
        lista.insertarFinal("Noches blancas");
        lista.insertarFinal("Los hermanos Karamázov");
        lista.insertarFinal("La metamorfosis");
        lista.insertarFinal("Crimen y castigo");

        System.out.println("Catálogo inicial de la biblioteca:");
        lista.mostrar();

        // se busca un lirbo existente y otro no existente 
        System.out.println("Buscando 'La metamorfosis': " + lista.buscar("La metamorfosis"));
        System.out.println("Buscando 'El idiota': " + lista.buscar("El idiota"));

        lista.eliminar("Noches blancas");       // Elimina la cabeza
        lista.eliminar("La metamorfosis");    // Elimina un nodo intermedio
        lista.eliminar("Crimen y castigo");     // Elimina el último

        System.out.println("Catálogo después de eliminar varios libros:");
        lista.mostrar();
    }
}