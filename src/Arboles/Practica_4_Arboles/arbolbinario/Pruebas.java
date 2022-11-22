package Arboles.Practica_4_Arboles.arbolbinario;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS ARBOL BINARIO DE EXPRESION **********");
        String cadena1 = "52+83-*4/";
        String cadena2 = "92+3+4*";
        String cadena3 = "29*37-5*+8/";
        String cadena4 = "9";
        Arbol arbol1 = new Arbol(cadena1);
        Arbol arbol2 = new Arbol(cadena2);
        Arbol arbol3 = new Arbol(cadena3);
        Arbol arbol4 = new Arbol(cadena4);
        arbol1.ordenCentral();
        arbol1.mostrarExpresion();
        arbol1.calcularValor();
        System.out.println("------------------------------------------------------------");
        arbol2.ordenCentral();
        arbol2.mostrarExpresion();
        arbol2.calcularValor();
        System.out.println("------------------------------------------------------------");
        arbol3.ordenCentral();
        arbol3.mostrarExpresion();
        arbol3.calcularValor();
        System.out.println("------------------------------------------------------------");
        arbol4.ordenCentral();
        arbol4.mostrarExpresion();
        arbol4.calcularValor();
    }
}

