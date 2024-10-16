import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Serie implements Serializable {

    private String codigo;
    private String titulo;
    private int añoInicio;
    private String sinopsis;
    private Genero genero;
    private ArrayList<Personaje> personajes;

    public Serie(String codigo, String titulo, int añoInicio, String sinopsis, Genero genero, ArrayList<Personaje> personajes) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.añoInicio = añoInicio;
        this.sinopsis = sinopsis;
        this.genero = genero;
        this.personajes = new ArrayList<>();

    }

    public Serie(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoInicio() {
        return añoInicio;
    }

    public void setAñoInicio(int añoInicio) {
        this.añoInicio = añoInicio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public void AñadirPersonaje(Personaje personaje){
        personajes.add(personaje);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", añoInicio=" + añoInicio +
                ", sinopsis='" + sinopsis + '\'' +
                ", genero=" + genero +
                ", personajes=" + personajes +
                '}';
    }


}
