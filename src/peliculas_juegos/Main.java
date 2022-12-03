package peliculas_juegos;

public class Main {
    public static void main(String[] args) {
        Pelicula peliculas[] = new Pelicula[5];
        peliculas[0] = new Pelicula("Tiulo 1",2,GeneroPeliculas.ACCION,"Director");
        peliculas[1] = new Pelicula("Tiulo 2",5,GeneroPeliculas.TERROR,"Director");
        peliculas[2]= new Pelicula("Tiulo 3",3,GeneroPeliculas.TERROR,"Director");
        peliculas[3] = new Pelicula("Tiulo 4",1,GeneroPeliculas.ACCION,"Director");
        peliculas[4] = new Pelicula("Tiulo 5",3,GeneroPeliculas.TERROR,"Director");

        Videojuego videojuegos[] = new Videojuego[5];
        videojuegos[0] = new Videojuego("Video 1",3, false, GeneroJuegos.ACCION, "Company");
        videojuegos[1] = new Videojuego("Video 2",2, false, GeneroJuegos.ACCION, "Company");
        videojuegos[2] = new Videojuego("Video 3",1, false, GeneroJuegos.ACCION, "Company");
        videojuegos[3] = new Videojuego("Video 4",4, false, GeneroJuegos.ACCION, "Company");
        videojuegos[4] = new Videojuego("Video 5",1, false, GeneroJuegos.ACCION, "Company");

        peliculas[4].activar();
        peliculas[3].activar();
        peliculas[2].activar();

        videojuegos[4].activar();
        videojuegos[3].activar();

        System.out.println("Peliculas desactivadas");
        int activados = 0;
        for (Pelicula peli:peliculas
             ) {
            if(peli.isActivo()) activados++;
            else System.out.println("Estado inactivo para: "+peli.toString());
        }
        System.out.println("Peliculas activas: "+activados);
        System.out.println("Juegos desactivados");
        activados = 0;
        for (Videojuego video:videojuegos
        ) {
            if(video.isActivo()) activados++;
            else System.out.println("Estado inactivo para: "+video.toString());
        }
        System.out.println("Videojuegos activos: "+activados);


        System.out.println("Juego con mayor duracion");
        mayorDuracion(videojuegos, null);
        System.out.println("Peli de TERROR con mayor duracion");
        mayorDuracion(null, peliculas);
    }

    public static void mayorDuracion(Produccion p[], Pelicula[] g){
        if(g == null){
            Produccion mayor = p[0];
            for (Produccion item : p
            ) {
                if(item.getDuracion() > mayor.getDuracion()) mayor = item;
            }
            System.out.println(mayor.toString());
        } else{
            Produccion mayor = new Produccion();
            mayor.setDuracion(0);
            for (Pelicula item : g
            ) {
                if(item.getGenero() == GeneroPeliculas.TERROR){
                    if(item.getDuracion() > mayor.getDuracion()) mayor = item;
                }
            }
            System.out.println(mayor.toString());
        }
    }
}
