package Grafos.Practica_5;

public class Seguir_AETSISI {
    //NOMBRE  Y GRUPO DEL ALUMNO
    private GrafoMA miREd;
    private Persona[] contactos;


    public Seguir_AETSISI(int n, Persona[] contactos) { //construye una matriz de nxn sin aristas
        miREd= new GrafoMA(n,true);
        this.contactos = contactos;
    }

    public int getNumPersonas() {
        return miREd.getNumVertices();
    }


    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------
// método que inserta una relación de seguir_a directa (una arista en el grafo)
    public void insertaRelacion(int o, int d) {
            miREd.insertarArista(o,d);
    }
    // método que elimina una relación de seguir_a directa (una arista en el grafo)
    public void eliminaRelacion(int o, int d) {
        miREd.eliminarArista(o,d);
    }
    // método que indica si existe una relación de seguir_a directa (una arista en el grafo)
    public boolean existeRelacion(int o, int d) {
        return miREd.existeArista(o,d);
    }

    //Metodo que compara dos cadenas que representan dos nombres ignorando mayusculas y minusculas
    private boolean nombresIguales(String cad1, String cad2){
        return (cad1.equalsIgnoreCase(cad2));
    }


    // encuentra la posición asociado a un nombre de persona en la tabla de contactos que
    // ademas se corresponde con el vertice que le representa en el grafo

    public int devuelvePosNombre(String nombre){
        int i=0;
        boolean encontrado=false;
        while (i<contactos.length && !encontrado){
            encontrado= nombresIguales(nombre,contactos[i].getNombre());
            if (!encontrado) i++;
        }
       // if (!miREd.verticeEnRango(i)) i=-1;//si ha salido por i= contactos.length no esta el nombre en la tabla
        if (!encontrado) i=-1;
        return i;
    }

    // Imprime la Matriz del relaciones( Matriz de adyacencia del grafo) por consola
    public void imprimirRelaciones() {
        System.out.println("Contenido de la matriz: ");
        System.out.print("  ");
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            if (i<10) System.out.print(" "+ i +" ");
             else System.out.print(i + " " );
        }
        System.out.println();
        for (int i = 0; i < miREd.getNumVertices(); i++) {
            if (i<10) System.out.print(" "+i );
            else System.out.print(i );
        for (int j = 0; j < miREd.getNumVertices(); j++) {
                if (miREd.existeArista(i,j)) System.out.print(" S ");
                else System.out.print(" N ");
            }
            System.out.println();
        }
    }

    //Imprime la información de la red y la matriz de Relaciones por consola
    public void mostrarRed() {
        System.out.println("Existen " + miREd.getNumVertices() + " contactos: \n");
        for (int i = 0; i < miREd.getNumVertices(); i++)
            System.out.println(i + ": " + contactos[i].getNombre());
        imprimirRelaciones();
        System.out.println();
    }

// ------------------------------------

    // MÉTODOS A COMPLETAR

    // ------------------------------------


public void mostrar(){
        miREd.mostrar();
}


    // Apartado 2.2.1 Primer método
    public int contarGrupos () {
        int resul = 0;
        boolean [] visitado = new boolean[getNumPersonas()];

        for(int x = 0; x < getNumPersonas(); x++) {
            visitado[x] = false;
        }

        for(int x = 0; x < getNumPersonas(); x++) {
            if (!visitado[x]) {
                miREd.recorridoEnProfundidad(x, visitado);
                resul++;
            }
        }

        System.out.println("\tHay " + resul + " grupos.");

        return resul;
    }

    // Apartado 2.2.2 Segundo método
    public void mostrarSeguidosPorADirectamente(String nombre) {
        int pos = devuelvePosNombre(nombre);
        if(pos == -1) {
            System.out.println("No existe la persona que buscas");
        } else {
            System.out.println("Seguidos por " + nombre + "(" + pos + "):");
            for (int x = 0; x < getNumPersonas(); x++) {
                if (miREd.existeArista(pos, x)) {
                    System.out.println(x + ": " + contactos[x].getNombre());
                }
            }
        }
    }

    // Apartado 2.2.3 Tercer método
    public void mostrarSeguidoresDirectoDe(String nombre) {
        int pos = devuelvePosNombre(nombre);
        if(pos == -1) {
            System.out.println("No existe la persona con nombre: " + nombre);
        } else {
            System.out.println("Seguidos de " + nombre + "(" + pos + "):");
            for(int x = 0; x < getNumPersonas(); x++) {
                if (miREd.existeArista(x, pos)) {
                    System.out.println(x + ": " + contactos[x].getNombre());
                }
            }
        }
    }
    // Apartado 2.2.4 Cuarto método
    public boolean sonDelMismoGrupo(Persona p, Persona p1){
        boolean mismo = false;
        boolean [] visitado = new boolean[getNumPersonas()];
        int pers = devuelvePosNombre(p.getNombre());
        int pers1 = devuelvePosNombre(p1.getNombre());
        if(pers != -1 && pers1 != -1){
            for(int x = 0; x < getNumPersonas(); x++) {
                visitado[x] = false;
            }
            miREd.recorridoEnProfundidadCadena(pers, visitado);
            if(visitado[pers1]) {
                mismo = true;
                System.out.println(p.getNombre() + " " + pers + " es del mismo grupo que " + p1.getNombre() + " " + pers1);
            } else {
                System.out.println(p.getNombre() + " " + pers + " no es del mismo grupo que " + p1.getNombre() + " " + pers1);
            }
        }

        return mismo;
    }
    // Apartado 2.2.5 Quinto método
    public void mostrarMiembrosGrupo(Persona p){
        boolean [] visitado = new boolean[getNumPersonas()];
        int pos = devuelvePosNombre(p.getNombre());
        if(pos == -1) {
            System.out.println("No existe la persona que buscas");
        } else {
            for(int x = 0; x < getNumPersonas(); x++){
                visitado[x] = false;
            }
            miREd.recorridoEnProfundidadCadena(pos, visitado);
            for(int x = 0; x < getNumPersonas(); x++){
                if(visitado[x] && x != pos){
                    System.out.println(x + ": " + contactos[x].getNombre());
                }
            }
        }
    }

    // Apartado 2.2.6 sexto método
    public void mostrarSeguidosPor(Persona p){
        boolean [] visitado = new boolean[getNumPersonas()];
        int pos = devuelvePosNombre(p.getNombre());
        if(pos == -1) {
            System.out.println("No existe la persona que buscas");
        } else {
            for(int x = 0; x < getNumPersonas(); x++) {
                visitado[x] = false;
            }
            miREd.recorridoEnProfundidad(pos, visitado);
            for(int x = 0; x < getNumPersonas(); x++){
                if(visitado[x] && x != pos){
                    System.out.println(x + ": " + contactos[x].getNombre());
                }
            }
        }
    }

    // Apartado 2.2.7 séptimo método

    public boolean mostrarEsSeguidaPor(String nombre1, String nombre2){
        boolean resul = false;
        boolean [] visitado = new boolean[getNumPersonas()];
        int pers = devuelvePosNombre(nombre1);
        int pers1 = devuelvePosNombre(nombre2);
        if(pers == -1 || pers1 == -1) {
            System.out.println("No existe al menos 1 de las personas");
        } else {
            for(int x = 0; x < getNumPersonas(); x++) {
                visitado[x] = false;
            }
            miREd.recorridoEnProfundidad(pers, visitado);
            if(visitado[pers1]){
                resul = true;
            }
            System.out.println(resul);
        }

        return resul;
    }


    // Apartado 2.2.8 octavo método (opcional)
   public void mostrarSeguidoresDe(String nombre1){
       boolean [] visitado = new boolean[getNumPersonas()];
       int pos = devuelvePosNombre(nombre1);
       if(pos == -1) {
           System.out.println("No existe la persona que buscas con el primer nombre");
       } else {
           System.out.println("Seguidores de " + nombre1 + "(" + pos + "):");

           for(int x = 0; x < getNumPersonas(); x++) {
               visitado[x] = false;
           }
           recorridoEnProfundidadInverso(pos, visitado);
           for(int x = 0; x < getNumPersonas(); x++){
               if(visitado[x] && x != pos){
                   System.out.println(x + ": " + contactos[x].getNombre());
               }
           }
       }
   }

    public void recorridoEnProfundidadInverso(int v, boolean[] visitados) {
        visitados[v] = true;
        // System.out.print(v + " ");
        // Para cada Vértice adyacentes desde v
        for (int i = 0; i < getNumPersonas(); i++) {
            if (miREd.existeArista(i, v) && !visitados[i]) {
                this.recorridoEnProfundidadInverso(i, visitados);
            }
        }
    }

}
	  




