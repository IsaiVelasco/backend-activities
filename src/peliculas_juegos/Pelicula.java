package peliculas_juegos;

public class Pelicula extends Produccion {

    private GeneroPeliculas genero;
    private String director;

    public Pelicula(){}
    public Pelicula(String titulo, String director) {
        super(titulo);
        this.director = director;
    }

    public Pelicula(String titulo, int duracion, GeneroPeliculas genero, String director) {
        super(titulo, duracion);
        this.genero = genero;
        this.director = director;
    }

    public GeneroPeliculas getGenero() {
        return genero;
    }

    public void setGenero(GeneroPeliculas genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                super.toString()+
                "genero=" + genero +
                ", director='" + director + '\'' +
                '}';
    }
}
