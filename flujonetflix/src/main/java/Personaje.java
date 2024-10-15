import java.io.File;
import java.io.Serializable;


public class Personaje implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String paisNaciiento;
    private String edad;
    private int codigoPelicula;

    File personajes = new File("resourcesNet/personajes.txt");

    public Personaje(String nombre, String paisNaciiento, String edad, int codigoPelicula) {
        this.nombre = nombre;
        this.paisNaciiento = paisNaciiento;
        this.edad = edad;
        this.codigoPelicula = codigoPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisNaciiento() {
        return paisNaciiento;
    }

    public void setPaisNaciiento(String paisNaciiento) {
        this.paisNaciiento = paisNaciiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getCodigoPelicula() {
        return codigoPelicula;
    }

    public void setCodigoPelicula(int codigoPelicula) {
        this.codigoPelicula = codigoPelicula;
    }
}
