package Grafos.Ejemplo;

public class Ejercicios {

    public Ejercicios() {
    }
    //Ejer 1 junio 2017

    public GrafoMA complementario(GrafoMA g1) {
        int num = g1.getNumVertices();
        GrafoMA resul = new GrafoMA(num, g1.getDirigido());
        for (int i = 0; i < num; i++)
            for (int j = 0; j < num; j++)
                if ((!g1.existeArista(i, j)) && (i != j)) resul.insertarArista(i, j);

        return resul;
    }


    //Ejer 2 Junio 2016
    public void desconectaVertice(GrafoMA g1, int v) {
        int num = g1.getNumVertices();
        if (g1.verticeEnRango(v)) {
            for (int i = 0; i < num; i++)
                if (i != v) g1.eliminarArista(i, v);
        }
    }


    //Ejer 3 Julio 2015
    public int verticeReceptivo(GrafoMA g1) {
        int num = g1.getNumVertices();
        int i = 0, j = 0;
        boolean encont = false, seguir = true;
        while ((i < num) && (!encont)) {
            while (j < num && seguir) {
                seguir = g1.existeArista(i, j);
                j++;
            }
            if (seguir) encont = seguir;
            else {
                j = 0;
                i++;
            }

        }
        if (!encont) i=-1;
        return i;

    }

    private boolean todosCierto(GrafoMA g1, int v) {
        int num = g1.getNumVertices();
        int i = 0;
        boolean seguir = true;
        while (i < num && seguir) {
            seguir = g1.existeArista(v, i);
            i++;
        }
        return seguir;
    }

    //Ejer 4 Julio 2016
    int aristasGrafoCompleto(int n) {
        return (n * (n - 1) / 2);
    }



    private void recorridoEnProfundidadA (int v, boolean[] visitados,GrafoMA g1)
    {    visitados[v] = true;
        System.out.print(v + " ");
        // Para cada Vértice adyacentes desde v
        for (int i = 0; i < g1.getNumVertices(); i++) // Para cada Vértice adyacentes desde v
            if (g1.existeArista(v, i) && !visitados[i])
                this. recorridoEnProfundidadA (i, visitados,g1);
    }







    // Ejer 5    Método que nos devuelva el numero de bucles que tiene un grafo
    // No dirigido
    public int numBucles (GrafoMA g1){
        int resul=0;
        for (int i =0;i<g1.getNumVertices();i++)
            if (g1.existeArista(i,i)) resul++;

        return resul;
    }

    // 6 Método que nos devuelva el numero de componentes conexas que tiene un grafo
    // No dirigido

    public int numeroComponentesConexas(GrafoMA g1) {
        int resul = 0;
        boolean[] visitados = new boolean[g1.getNumVertices()];
        // se inicializa el vector de visitados que se utiliza para saber que vértice
        // he visitado ya y no volver a pasar por el(evitando bucles infinitos)
        for (int i = 0; i < g1.getNumVertices(); i++) {
            visitados[i] = false;
        } // Para cada Vértice para visitar todas las componentes conexas(GN)
        //o fuertemente conexas(GD)
        for (int i = 0; i < g1.getNumVertices(); i++) {
            if (!visitados[i]) //llama al método que recorre el grafo en profundidad
            {// a partir de un vértice
                g1.recorridoEnProfundidad(i, visitados);
                resul++;
            }
        }
        return resul;
    }



    // Ejerc 7

    public int verticeDesconectado(GrafoMA g1) {
        int num = g1.getNumVertices();
        int i = 0, j = 0;
        boolean encont = false, conecta = false;
        while ((i < num) && (!encont)) {
            while (j < num && !conecta) {
                conecta = g1.existeArista(i, j);
                j++;
            }
            if (!conecta) encont = true;
            else {
                j = 0;
                i++;
                conecta=false;
            }

        }
        if (!encont) i=-1;
        return i;

    }


//Ejerc 8
    public GrafoMA grafoTraspuesto(GrafoMA g1) {
        int num = g1.getNumVertices();
        GrafoMA resul = new GrafoMA(num, g1.getDirigido());
        for (int i = 0; i < num; i++)
            for (int j = 0; j < num; j++)
                if ((g1.existeArista(i, j)) && (i != j)) resul.insertarArista(j, i);

        return resul;
    }
//Ejerc 8bis con bucles
public GrafoMA grafoTraspuestob(GrafoMA g1) {
    int num = g1.getNumVertices();
    GrafoMA resul = new GrafoMA(num, g1.getDirigido());
    for (int i = 0; i < num; i++)
        for (int j = 0; j < num; j++)
            if (g1.existeArista(i, j)) resul.insertarArista(j, i);

    return resul;
}


    // Ejerc 9 Método que indique si un vertice (pasado por parámetro) esta conectado con el resto
    // de vertices del grafo pasados por paramétro
    public boolean verticeAlcanzaResto(GrafoMA g1, int v) {
        boolean resul = true;
        int cont=0;
        boolean[] visitados = new boolean[g1.getNumVertices()];
        // se inicializa el vector de visitados que se utiliza para saber que vertice
        // he visitado ya y no volver a pasar por el(evitando bucles infinitos)
        for (int i = 0; i < g1.getNumVertices(); i++) {
            visitados[i] = false;
        }
        g1.recorridoEnProfundidad(v, visitados);
        while ((resul)&& (cont<g1.getNumVertices())) {
            resul = visitados[cont];
        }
        return resul;
    }


//ejercicio 10
    public boolean esRegular (GrafoMA g) {
        boolean  seguir=true;
        int gradoS, gradoE, gradoS0, gradoE0,i = 1, n;
        gradoS0=g.gradoSalida(0);
        gradoE0=g.gradoEntrada(0);
        while ((i<g.getNumVertices())&& (seguir)) {
            gradoS = g.gradoSalida(i);
            gradoE = g.gradoEntrada(i);
            seguir = (gradoE == gradoE0) && (gradoS == gradoS0);
            if (seguir) i++;
        }
        return seguir;
    }

    public boolean esRegularBis (GrafoMA g) {
        boolean  seguir=true;
        int gradoS, gradoE,i = 0;
        while ((i<g.getNumVertices())&& (seguir)) {
            seguir= g.gradoSalida(i)== g.gradoEntrada(i);
            if (seguir) i++;
        }
        return seguir;
    }

    // Segundo Parcial - 28 de mayo de 2019
    public boolean existeCaminoCorto(int u, int v,GrafoMA g) {
        boolean resultado = false;
        if (g.verticeEnRango(u) && g.verticeEnRango(v)){
            boolean[] visitados = new boolean[g.getNumVertices()];
            for (int i = 0; i < g.getNumVertices(); i++) {
                visitados[i] = false;
            }
           // Realizar recorrido desde el vértice u.
            this.profundidadAux(u, visitados, 1,g);
            resultado = visitados[v];
        }
        return resultado;
    }

    private void profundidadAux(int v, boolean[] visitados, int longitud,GrafoMA g) {
        visitados[v] = true;
        if (longitud <= 2) { // Vértices adyacentes a v
            for (int i = 0; i < g.getNumVertices(); i++)
                if (g.existeArista(v, i) && !visitados[i])
                    profundidadAux(i, visitados, longitud + 1, g);
        }

    }
//Examen Teoría Segundo Parcial - 3 de Junio de 2021
    public boolean verticesDistintaComponenteConexa(GrafoMA g, int v1, int v2) {
        boolean[] visitados = new boolean[g.getNumVertices()];
        for (int i = 0; i < g.getNumVertices(); i++) {
            visitados[i] = false; }
        g.recorridoEnProfundidad(v1, visitados);
        return !visitados[v2];
    }



    //Examen Teoría - 9 de Julio de 2021
    public int numeroVerticesComponenteConexa(GrafoMA g, int v) {
        int resultado = 0;
        boolean[] visitados = new boolean[g.getNumVertices()];
        for (int i = 0; i < g.getNumVertices(); i++) {
            visitados[i] = false; }
        g.recorridoEnProfundidad(v, visitados);
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (visitados[i]) { resultado++;
            } }
        return resultado; }

/* Ejercicio devolver la componente conexa con mayor numero de vertices
Ejercicio: Componente conexa con más vértices:
Recorrido de todas las componentes del grafo:
int [] visitados (inicialmente todos a -1).
en visitados se marcarán los vértices de cada componente con el número del primer vértice
visitado de esa componente.
Cada componente se recorre usando un recorrido en profundidad recursivo:
nuevo parámetro para la marca a incluir en visitados de esa componente
nuevo parámetro para devolver el número de vértices de la componente.
Si la componente actual tiene más vértices que la mejor, la actual pasa a ser la mejor.
Se debe guardar la marca de la mejor para finalmente recorriendo visitados imprimir solo los número
de los vértices de la componente con más vértices
 */
    // en un grafo no dirigido
    public void compoConexaMasVertices(GrafoMA g){// Grafos No Dirigidos
        int numVertices=g.getNumVertices();
        boolean[] visitados = new boolean[numVertices];
        int nVMayor=0;int oriCCMayor=0;int vCompConexa=0; int vCCantes=0;
        for (int v=0;v<numVertices;v++) visitados[v] = false;
        for(int i=0; i<numVertices;i++){
         if (!visitados[i]){
             vCCantes=numVisitados(visitados);
             g.recorridoEnProfundidad(i, visitados);
             vCompConexa= numVisitados(visitados)-vCCantes;
            }
         if (vCompConexa>nVMayor){
             nVMayor=vCompConexa;
             oriCCMayor=i;
         }
        }
        System.out.println("Origen de la Componente Conexa en el vertice  " + oriCCMayor );
        System.out.println(" con " + nVMayor + " vertices");
    }

    // en un grafo dirigido

    public void compoConexaMasVerticesGD(GrafoMA g){// Grafos Dirigidos
        int numVertices=g.getNumVertices();
        boolean[] visitados = new boolean[numVertices];
        int nVMayor=0;int oriCCMayor=0;int vCompConexa=0; int vCCantes=0;
        for (int v=0;v<numVertices;v++) visitados[v] = false;
        for(int i=0; i<numVertices;i++){
            if (!visitados[i]){
                vCCantes=numVisitados(visitados);
                recorridoEnProfundidadCadena(i, visitados,g);
                vCompConexa= numVisitados(visitados)-vCCantes;
            }
            if (vCompConexa>nVMayor){
                nVMayor=vCompConexa;
                oriCCMayor=i;
            }
        }
        System.out.println("Origen de la Componente Conexa en el vertice  " + oriCCMayor );
        System.out.println(" con " + nVMayor + " vertices");
    }

    private int numVisitados( boolean [] visitados)
    {int resul=0;
     for(int i=0;i< visitados.length;i++)
         if (visitados[i]) resul++;
      return resul;
    }

    public void recorridoEnProfundidadCadena (int v, boolean[] visitados, GrafoMA g)
    {    visitados[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < g.getNumVertices(); i++) // Para cada Vértice con cadena en v
            if ((g.existeArista(v, i)||(g.existeArista(i,v) ))&& (!visitados[i]))
                this. recorridoEnProfundidadCadena (i, visitados,g);
    }

    //Ejercicio 1

    public GrafoMA complementarioMio(GrafoMA g1){
        GrafoMA g2 = new GrafoMA(g1.getNumVertices(), g1.getDirigido());

        for(int x = 0; x < g1.getNumVertices(); x++){
            for(int i = 0; i < g1.getNumVertices(); i++){
                if(!g1.existeArista(x,i) && x != i){
                    g2.insertarArista(x, i);
                }
            }
        }

        return g2;
    }

    //Ejercicio 2
    public void desconectarVerticeMio(GrafoMA g1, int v){

        if(g1.verticeEnRango(v)){
            for(int x = 0; x < g1.getNumVertices(); x++){
                if(x != v){
                    g1.eliminarArista(v,x);
                }
            }
        }
    }

    //Ejercicio 3
    public int primerVerticeReceptivo(GrafoMA g1){
        boolean encontrado = false;
        boolean seguir;
        int x = 0,i = 0;

        while(x < g1.getNumVertices() && !encontrado){
            seguir = true;
            while(i < g1.getNumVertices() && seguir){
                seguir = g1.existeArista(i, x);
                i++;
            }
            if(seguir){
                encontrado = seguir;
            } else {
                i = 0;
                x++;
            }
        }
        if(!encontrado){
            x = -1;
        }
        return x;
    }

    //Ejercicio 4
    public int numAristas(int v){
        return (v*(v - 1)) / 2;
    }

    //Ejercicio 6
    public int numGrafos(GrafoMA g1){
        boolean [] visitados = new boolean [g1.getNumVertices()];
        int resul = 0;

        for(int x = 0; x < g1.getNumVertices(); x++){
            visitados[x] = false;
        }
        for(int i = 0; i < g1.getNumVertices(); i++){
            if(!visitados[i]){
                g1.recorridoEnProfundidadCadena(i,visitados);
                resul++;
            }
        }

        return resul;
    }

    //Ejercicio 9






}
