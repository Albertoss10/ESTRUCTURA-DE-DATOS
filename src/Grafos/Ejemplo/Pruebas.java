package Grafos.Ejemplo;

public class Pruebas {
    public static void main(String[] args){
        Ejercicios miEjer= new Ejercicios();
        int MAX = 12;
        GrafoMA grafo = new GrafoMA(MAX, false);   // Grafo de 12 vértices no dirigido
        grafo.insertarArista(0,1);
        grafo.insertarArista(0,2);
        grafo.insertarArista(4,7);
        grafo.insertarArista(0,3);
        grafo.insertarArista(1,3);
        grafo.insertarArista(3,6);
        grafo.insertarArista(9,1);
        grafo.insertarArista(9,10);
        grafo.insertarArista(5,10);
        grafo.insertarArista(8,9);
        grafo.insertarArista(8,11);
        grafo.insertarArista(3,3);

        grafo.mostrar();
        System.out.println("numero de aristas del grafo: " + grafo.numAristas());
        System.out.println("Grado de entrada del vértice 1: " + grafo.gradoEntrada(1));
        System.out.println("Grado de salida del vértice 1: " + grafo.gradoSalida(1));
        System.out.println("----------------------- ");
        grafo.eliminarArista(3,3);
        grafo.mostrar();
        System.out.println("numero de aristas del grafo: " + grafo.numAristas());
        int MAX2 = 6;
        GrafoMA grafo2 = new GrafoMA(MAX2, true);   // Grafo de 5 vértices dirigido
        grafo2.insertarArista(0,1);
        grafo2.insertarArista(0,3);
        grafo2.insertarArista(1,2);
        grafo2.insertarArista(1,4);
        grafo2.insertarArista(2,0);
        grafo2.insertarArista(3,2);
        grafo2.insertarArista(4,3);
        grafo2.insertarArista(5,4);

        System.out.print("Recorrido desde 0:  ");
        grafo2.profundidadDesdeVertice(0);
        System.out.print("Recorrido desde 1:  ");
        grafo2.profundidadDesdeVertice(1);
        System.out.print("Recorrido desde 2:  ");
        grafo2.profundidadDesdeVertice(2);
        System.out.print("Recorrido desde 3:  ");
        grafo2.profundidadDesdeVertice(3);
        System.out.print("Recorrido desde 4:  ");
        grafo2.profundidadDesdeVertice(4);
        System.out.print("Recorrido desde 5:  ");
        grafo2.profundidadDesdeVertice(5);
        System.out.print("Recorrido profundidad completo  ");
        grafo2.profundidad();
        System.out.println();

        System.out.println("-------------------------");
        System.out.print("Amplitud desde 0:  ");
        grafo2.amplitudDesdeVertice(0);
        System.out.print("Amplitud desde 1:  ");
        grafo2.amplitudDesdeVertice(1);
        System.out.print("Amplitud desde 2:  ");
        grafo2.amplitudDesdeVertice(2);
        System.out.print("Amplitud desde 3:  ");
        grafo2.amplitudDesdeVertice(3);
        System.out.print("Amplitud desde 4:  ");
        grafo2.amplitudDesdeVertice(4);
        System.out.print("Amplitud desde 5:  ");
        grafo2.amplitudDesdeVertice(5);
        System.out.print("Recorrido amplitud completo:  ");
        grafo2.amplitud();

        // Ejercicio junio 2017 Crear un grafo complementario com MA
        MAX2 = 6;
        GrafoMA grafo3 = new GrafoMA(MAX2, false);   // Grafo de 5 vértices No dirigido
        grafo3.insertarArista(0,1);
        grafo3.insertarArista(0,3);
        grafo3.insertarArista(1,2);
        grafo3.insertarArista(1,4);
        grafo3.insertarArista(2,0);
        grafo3.insertarArista(3,2);
        grafo3.insertarArista(4,3);
        grafo3.insertarArista(5,4);
        grafo3.mostrar();
        GrafoMA grafo4 = new GrafoMA(MAX2, false);
        grafo4= miEjer.complementario(grafo3);
        grafo4.mostrar();
        miEjer.desconectaVertice(grafo4,4);
        grafo4.mostrar();

    }

}
