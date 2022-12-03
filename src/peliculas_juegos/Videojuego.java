package peliculas_juegos;

public class Videojuego extends Produccion{

    private GeneroJuegos genero;
    private String compañía;
    private boolean entregado;

    public Videojuego(){}

    public Videojuego(String titulo, int duracion) {
        super(titulo, duracion);
    }

    public Videojuego(String titulo, int duracion, boolean estatus, GeneroJuegos genero, String compañía) {
        super(titulo, duracion, estatus);
        this.genero = genero;
        this.compañía = compañía;
    }

    public GeneroJuegos getGenero() {
        return genero;
    }

    public void setGenero(GeneroJuegos genero) {
        this.genero = genero;
    }

    public String getCompañía() {
        return compañía;
    }

    public void setCompañía(String compañía) {
        this.compañía = compañía;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                super.toString()+
                "genero=" + genero +
                ", compañía='" + compañía + '\'' +
                ", entregado=" + entregado +
                '}';
    }
}
