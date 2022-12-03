package peliculas_juegos;

public interface Activar {
    public boolean activar();
    public boolean desactivar();
    public boolean isActivo();
    public boolean compareTo(Produccion produccion);
}
