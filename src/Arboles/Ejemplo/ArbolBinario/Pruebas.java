package Arboles.Ejemplo.ArbolBinario;

public class Pruebas {

    public static void main(String[] args) {
        Arbol arbol9 = new Arbol(9);
        Arbol arbol15 = new Arbol(15);
        Arbol arbol4 = new Arbol(4, arbol9, arbol15);
        Arbol arbol5 = new Arbol(5);
        Arbol arbol2 = new Arbol(2, arbol4, arbol5);
        Arbol arbol8 = new Arbol(8);
        Arbol arbol7 = new Arbol(7);
        Arbol arbol3 = new Arbol(3, arbol8, arbol7);
        Arbol arbol = new Arbol(1, arbol2, arbol3);

        arbol.preOrden();
        arbol.ordenCentral();
        arbol.postOrden();
        arbol.amplitud();
        arbol.amplitud2();
        System.out.println("Está el valor valor 5?: " + arbol.contiene(5));
        System.out.println("Está el valor valor 51?: " + arbol.contiene(51));
        System.out.println("Suma de los nodos: " + arbol.suma());

        arbol.preOrdenNivel();

    }

}


