import javax.swing.*;
import java.beans.Transient;
import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;


public class Personaje implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nombre;
    private  transient String paisNacimiento;
    private transient int edad;
    private transient String codigoPelicula;

    public Personaje(String nombre, String paisNacimiento, int edad, String codigoPelicula) {
        this.nombre = nombre;
        this.edad = edad;
        this.codigoPelicula = codigoPelicula;
        this.paisNacimiento = paisNacimiento;
    }

    //constructor vacio

    public Personaje(){

    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Transient
    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    @Transient
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Transient
    public String getCodigoPelicula() {
        return codigoPelicula;
    }

    public void setCodigoPelicula(String codigoPelicula) {
        this.codigoPelicula = codigoPelicula;
    }

    @Override
    public String toString() {
        return nombre + ", " + paisNacimiento + ", " + edad + ", " + codigoPelicula ;
    }



}
