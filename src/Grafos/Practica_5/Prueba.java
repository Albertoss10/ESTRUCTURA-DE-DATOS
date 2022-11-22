package Grafos.Practica_5;

public class Prueba {
    public static void main (String [] args) {
        final int numeroContactos = 10;
        Persona[] contactos = new Persona[numeroContactos];
        Persona Juan = new Persona("Juan", "111111", "Nadie");
        Persona Jose = new Persona("José", "222222", "Cuervo");
        Persona Eva = new Persona("Eva", "333333", "Adan");
        Persona Alicia = new Persona("Alicia", "777777", "Maravillas");
        Persona Alan = new Persona("Alan", "999999", "Turing");
        Persona Guillermo = new Persona("Guillermo", "159267", "Tell");
        Persona Julio = new Persona("Julio", "123456", "Catedrales");
        Persona Lucas = new Persona("Lucas", "231456", "Pato");
        Persona Paula = new Persona("Paula", "654321", "Vázquez");
        Persona Clara = new Persona("Clara", "123654", "Oscuro");
        contactos[0] = Juan;
        contactos[1] = Jose;
        contactos[2] = Eva;
        contactos[3] = Alicia;
        contactos[4] = Alan;
        contactos[5] = Guillermo;
        contactos[6] = Julio;
        contactos[7] = Lucas;
        contactos[8] = Paula;
        contactos[9] = Clara;
        Seguir_AETSISI g = new Seguir_AETSISI(numeroContactos,contactos);
        g.insertaRelacion(0, 1);
        g.insertaRelacion(0, 5);
        g.insertaRelacion(0, 3);
        g.insertaRelacion(1, 5);
        g.insertaRelacion(1, 4);
        g.insertaRelacion(4, 5);
        g.insertaRelacion(5, 4);
        g.insertaRelacion(5, 0);
        g.insertaRelacion(3, 0);
        g.insertaRelacion(6, 8);
        g.insertaRelacion(8, 6);
        g.insertaRelacion(2, 7);
        g.insertaRelacion(2, 9);
        g.insertaRelacion(7, 9);
        g.insertaRelacion(9, 7);
        // Completar con todas las pruebas de los métodos del apartado 2.2.
        System.out.println("Apartado 2.2.1. Número de grupos:");
        g.contarGrupos();
        System.out.println("Apartado 2.2.2. Mostrar seguidos por Guillermo directamente");
        g.mostrarSeguidosPorADirectamente("Guillermo");
        System.out.println("Apartado 2.2.3. Mostrar seguidores directos de Juan");
        g.mostrarSeguidoresDirectoDe("Juan");
        System.out.println("Apartado 2.2.4. pertenecen al mismo grupo");
        g.sonDelMismoGrupo(Lucas, Clara);
        System.out.println("Apartado 2.2.5. Mostrar personas del mismo grupo de Clara 9");
        g.mostrarMiembrosGrupo(Clara);
        System.out.println("Apartado 2.2.6. Mostrar personas seguidas directa o indirectamente por Guillermo 5");
        g.mostrarSeguidosPor(Guillermo);
        System.out.println("Apartado 2.2.7. Juan 0 sigue a Alicia 3");
        g.mostrarEsSeguidaPor("Juan", "Alicia");
        System.out.println("Apartado 2.2.7. Seguidores de Alicia");
        g.mostrarSeguidoresDe("Alicia");

    }
}
