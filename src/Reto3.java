/*Autor: Jenny Alexandra Camacho Gómez
*22/10/26
*/
package src;
class NodoCircular {
    String estudiante;
    NodoCircular siguiente;
    
    NodoCircular(String estudiante) { 
        this.estudiante = estudiante; 
    }
}

class ListaCircular {
    private NodoCircular cabeza, cola;

    public void insertar(String estudiante) {
        NodoCircular nuevo = new NodoCircular(estudiante);
        if (cabeza == null) {
            // si es el unico apunta a si mismo para cerrar el ciclo circular
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            // cerrar el circulo y actualizar la cola
            nuevo.siguiente = cabeza;
            cola = nuevo;
        }
    }

    public void mostrarUnaVuelta() {
        if (cabeza == null) return;
        NodoCircular actual = cabeza;
        do {
            System.out.print(actual.estudiante + " -> ");
            // nos movemos al siguiente estudiante en el turno
            actual = actual.siguiente;
        } while (actual != cabeza); 
        System.out.println("(vuelve a " + cabeza.estudiante + ")");
    }

    public int contar() {
        if (cabeza == null) return 0;
        int contador = 0;
        NodoCircular actual = cabeza;
        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return contador;
    }

    // elimina al estudiante que sigue despues del indicado
    public void eliminarSiguienteDe(String estudiante) {
        if (cabeza == null) return;
        
        NodoCircular actual = cabeza;
        do {
            if (actual.estudiante.equals(estudiante)) {
                NodoCircular aEliminar = actual.siguiente;
                
                // caso si solo hay un nodo en toda la lista circular
                if (aEliminar == cabeza && cabeza == cola) {
                    cabeza = null;
                    cola = null;
                } else {
                    actual.siguiente = aEliminar.siguiente;
                    // si el que eliminamos era la cabeza actualizamos la cabeza
                    if (aEliminar == cabeza) {
                        cabeza = actual.siguiente;
                    }
                    // si el que eliminamos era la cola, actualizamos la cola
                    if (aEliminar == cola) {
                        cola = actual;
                    }
                }
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }
}

public class Reto3 {
    public static void main(String[] args) {
        ListaCircular turnos = new ListaCircular();
        
        // agregando estudiantes al turno de prestamo de libros
        turnos.insertar("Alex");
        turnos.insertar("Alejandro");
        turnos.insertar("Joel");
        turnos.insertar("Lucy");

        System.out.println("Turnos de prestamo:");
        turnos.mostrarUnaVuelta();
        
        System.out.println("total de estudiantes enlistados: " + turnos.contar());

        // Eliminando al estudiante que sigue después de 'Alex'
        System.out.println("\nEliminando al estudiante que está después de ");
        turnos.eliminarSiguienteDe("Rodión");

        System.out.println("Turnos de préstamo actualizados:");
        turnos.mostrarUnaVuelta();
        System.out.println("Total de estudiantes actual: " + turnos.contar());
    }
}

