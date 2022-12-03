package peliculas_juegos;

public class Produccion implements Activar {
    private String titulo;
    private int duracion;
    private boolean estatus;

    public Produccion(){
        this.duracion = 2;
        this.estatus = false;
    }
    public Produccion(String titulo) {
        this.titulo = titulo;
        this.estatus = false;
    }

    public Produccion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.estatus = false;
    }

    public Produccion(String titulo, int duracion, boolean estatus) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.estatus = estatus;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean activar() {
        if(this.estatus == true) return false;
        this.estatus = true;
        return true;
    }

    @Override
    public boolean desactivar() {
        if(this.estatus == false) return false;
        this.estatus = false;
        return true;
    }

    @Override
    public boolean isActivo() {
        return this.estatus;
    }

    @Override
    public boolean compareTo(Produccion produccion) {

        return this.duracion == produccion.getDuracion();
    }

    @Override
    public String toString() {
        return "{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", estatus=" + estatus +
                '}';
    }
}
