package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }
    
    /**
     * 1 - Método para invertir la lista enlazada
     */
    public void invertirLista() {
        Nodo prev = null;
        Nodo current = primero;
        Nodo next;
        while (current != null) {
            next = current.enlace;
            current.enlace = prev;
            prev = current;
            current = next;
        }
        primero = prev;
    }

    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */
    public int obtenerDesdeFinal(int n) {
        Nodo principal = primero;
        Nodo referencia = primero;
        int count = 0;

        while (count < n) {
            if (referencia == null) return -1; 
            referencia = referencia.enlace;
            count++;
        }

        while (referencia != null) {
            principal = principal.enlace;
            referencia = referencia.enlace;
        }

        return principal.dato;
    }

    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */
    public void eliminarDuplicados() {
        Nodo actual = primero;

        while (actual != null && actual.enlace != null) {
            Nodo comparador = actual;

            while (comparador.enlace != null) {
                if (actual.dato == comparador.enlace.dato) {
                    comparador.enlace = comparador.enlace.enlace; 
                } else {
                    comparador = comparador.enlace;
                }
            }
            actual = actual.enlace;
        }
    }


    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    public int obtenerTamanio() {
        int count = 0;
        Nodo temp = primero;
        while (temp != null) {
            count++;
            temp = temp.enlace;
        }
        return count;
    }
    /**
     * Ejercicio 1: Ordenar la lista de forma ascendente (Método de burbuja)
     */
    public void ordenarAscendente() {
        if (primero == null || primero.enlace == null) {
            return;
        }
        boolean intercambiado;
        do {
            intercambiado = false;
            Nodo actual = primero;
            Nodo anterior = null;
            Nodo siguiente = primero.enlace;
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    intercambiado = true;
                    if (anterior != null) {
                        anterior.enlace = siguiente;
                    } else {
                        primero = siguiente;
                    }
                    actual.enlace = siguiente.enlace;
                    siguiente.enlace = actual;
                    anterior = siguiente;
                    siguiente = actual.enlace;
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.enlace;
                }
            }
        } while (intercambiado);
    }

    /**
     * Ejercicio 2: Unir dos listas enlazadas
     */
    public void unirListas(Lista otraLista) {
        if (otraLista == null || otraLista.primero == null) {
            return;
        }
        if (primero == null) {
            primero = otraLista.primero;
            return;
        }
        Nodo temp = primero;
        while (temp.enlace != null) {
            temp = temp.enlace;
        }
        temp.enlace = otraLista.primero;
    }

    /**
     * Ejercicio 3: Separar números pares e impares en dos listas enlazadas
     */
    public Lista[] separarParesImpares() {
        Lista pares = new Lista();
        Lista impares = new Lista();
        Nodo actual = primero;

        while (actual != null) {
            if (actual.dato % 2 == 0) {
                pares.insertarCabezaLista(actual.dato);
            } else {
                impares.insertarCabezaLista(actual.dato);
            }
            actual = actual.enlace;
        }

        return new Lista[]{pares, impares};
    }

}
