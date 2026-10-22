/*Autor: Jenny Alexandra Camacho Gómez
*22/10/26
*/
package src;
class NodoDoble {
    String libro;
    NodoDoble siguiente, anterior;
    
    NodoDoble(String libro) { 
        this.libro = libro; 
    }
}

class ListaDoble {
    private NodoDoble cabeza, cola;

    // Inserta un libro al inicio de la lista doble
    public void insertarInicio(String libro) {
        NodoDoble nuevo = new NodoDoble(libro);
        if (cabeza == null) {
            // TODO 1: cabeza y cola apuntan al nuevo nodo
            // Si la lista esta vacia, el nuevo libro es el primero y el ultimo al mismo tiempo
            cabeza = nuevo;
            cola = nuevo;
        } else {
            // TODO 2: enlazar nuevo.siguiente con la cabeza actual
            nuevo.siguiente = cabeza;
            // TODO 3: enlazar cabeza.anterior con el nuevo
            cabeza.anterior = nuevo;
            // TODO 4: actualizar la cabeza
            cabeza = nuevo;
        }
    }

    // Elimina un libro buscando por su nombre
    public boolean eliminar(String libro) {
        NodoDoble actual = cabeza;
        while (actual != null && !actual.libro.equals(libro)) {
            actual = actual.siguiente;
        }
        if (actual == null) return false;
        
        // TODO 5: si 'actual' tiene anterior, ¿a quién debe apuntar anterior.siguiente? Si no, ¿qué cambia?
        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            cabeza = actual.siguiente; // Si no tiene anterior, significa que era la cabeza
        }
        
        // TODO 6: si 'actual' tiene siguiente, ¿a quién debe apuntar siguiente.anterior? Si no, ¿qué cambia?
        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            cola = actual.anterior; // Si no tiene siguiente, significa que era la cola
        }
        
        return true;
    }

    // Muestra la lista de adelante hacia atrás
    public void mostrarAdelante() { 
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.libro + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Muestra la lista de atrás hacia adelante (recorrido inverso)
    public void mostrarInverso() {
        NodoDoble actual = cola;
        while (actual != null) {
            // TODO 7: imprima y retroceda
            // Imprimimos el libro y nos movemos hacia atras usando el puntero anterior
            System.out.print(actual.libro + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}

public class Reto2 {
    public static void main(String[] args) {
        ListaDoble historial = new ListaDoble();
        
        // Agregando libros al inicio
        historial.insertarInicio("Crimen y castigo");
        historial.insertarInicio("Los hermanos Karamázov");
        historial.insertarInicio("Noches blancas");
        historial.insertarInicio("La metamorfosis");

        System.out.println("Historial de lectura (Mostrando hacia adelante):");
        historial.mostrarAdelante();

        System.out.println("Historial de lectura (Mostrando inverso desde la cola):");
        historial.mostrarInverso();

        // Probando eliminar la cabeza, un intermedio y la cola
        System.out.println("\nEliminando 'La metamorfosis' (cabeza)...");
        historial.eliminar("La metamorfosis");
        
        System.out.println("Eliminando 'Noches blancas' (intermedio)...");
        historial.eliminar("Noches blancas");
        
        System.out.println("Eliminando 'Crimen y castigo' (cola)...");
        historial.eliminar("Crimen y castigo");

        System.out.println("\nHistorial final despues de borrar:");
        historial.mostrarAdelante();
    }
}