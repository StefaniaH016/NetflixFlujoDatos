import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        ArrayList<Serie> series = new ArrayList<>();
        ArrayList<Personaje> nuevaLista;
        ArrayList<Serie> nuevaLista1;
        ArrayList<Personaje> personajes1 = new ArrayList<>();
        ArrayList<Personaje> personajes2 = new ArrayList<>();


        personajes1.add(new Personaje("Paulo Cesar", "Colombia", 30, "1234"));
        personajes1.add(new Personaje("Stefania Alvarez", "Colombia", 17, "1234"));
        personajes1.add(new Personaje("James", "Argentina", 29, "1234"));
        personajes1.add(new Personaje("Chayanne", "Puerto rico", 47, "1234"));

        series.add(new Serie("1234", "Las aventuras de floppa", 2019, "acompaña a floppa a sus perturbadoras aventuras por el monte del sexo", Genero.AVENTURA, personajes1));

        personajes2.add(new Personaje("Paulo Alberto", "Brasil", 43, "1235"));
        personajes2.add(new Personaje("Don Omar", "Chile", 33, "1235"));
        personajes2.add(new Personaje("James", "Japon", 20, "1235"));

        series.add(new Serie("1235", "La Gloria", 2022, "La protagonista que fue bulleada se asegurara de obtener su venganza", Genero.DRAMA, personajes2));

        String archivo, formato;
        String archivo2;
        String formato2;

        archivo2 = "/Users/Yesenia/ideaProjects/FlujoNetflix2/Personajes.txt";
        archivo = "/Users/Yesenia/ideaProjects/FlujoNetflix2/Series.txt";

        formato = "%s" + "\n";
        formato2 = "%s" + "\n";

        try {
            PersistenciaSeries.almacenarDatos(archivo, formato, series);
            JOptionPane.showMessageDialog(null, "se ha creado el archivo para series correctamente");

            PersistenciaPersonaje.almacenarDatos(archivo2, formato2, personajes1);
            PersistenciaPersonaje.almacenarDatos(archivo2, formato2, personajes2);
            JOptionPane.showMessageDialog(null, "se ha creado el archivo para personajes correctamente");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error en la manipulacion del archivo " + e.getMessage(), "Dialogo de Error", JOptionPane.ERROR_MESSAGE);

        }


        try {
            PersistenciaPersonaje.serializarXML("Personajes1.xml", personajes1);
            JOptionPane.showMessageDialog(null, personajes1);

            PersistenciaPersonaje.serializarXML("Personajes2.xml", personajes2);
            JOptionPane.showMessageDialog(null, personajes2);

            nuevaLista = (ArrayList<Personaje>) PersistenciaPersonaje.deserializarXML("Personajes1.xml");
            JOptionPane.showMessageDialog(null, nuevaLista);

            nuevaLista = (ArrayList<Personaje>) PersistenciaPersonaje.deserializarXML("Personajes2.xml");
            JOptionPane.showMessageDialog(null, nuevaLista);

            PersistenciaSeries.serializarXML("Series.xml", series);
            nuevaLista1 = (ArrayList<Serie>) PersistenciaSeries.deserializarXML("Series.xml");
            JOptionPane.showMessageDialog(null, nuevaLista1);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "Dialogo de Error", JOptionPane.ERROR_MESSAGE);

        }

        try {
            PersistenciaPersonaje.serializarBinario("Personajes1.dat", personajes1);
            JOptionPane.showMessageDialog(null, personajes1);

            nuevaLista = (ArrayList<Personaje>) PersistenciaPersonaje.deserializarBinario("Personajes1.dat");
            JOptionPane.showMessageDialog(null, nuevaLista);

            PersistenciaPersonaje.serializarBinario("Personajes2.dat", personajes2);
            JOptionPane.showMessageDialog(null, personajes2);

            nuevaLista = (ArrayList<Personaje>) PersistenciaPersonaje.deserializarBinario("Personajes2.dat");
            JOptionPane.showMessageDialog(null, nuevaLista);

            PersistenciaSeries.serializarBinario("Series.dat", series);
            JOptionPane.showMessageDialog(null, series);

            nuevaLista1 = (ArrayList<Serie>) PersistenciaSeries.deserializarBinario("Series.dat");
            JOptionPane.showMessageDialog(null, nuevaLista1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Dialogo de Error", JOptionPane.ERROR_MESSAGE);
        }

        String codigo = JOptionPane.showInputDialog("ingresa el codigo: ");
        //consultar personaje por su codigo de pelicula :)

        ArrayList<String> resultado = new ArrayList<>();
        resultado = PersistenciaPersonaje.LeerArchivo(archivo2);

        //lista de codigos

        for (String i : PersistenciaPersonaje.LeerArchivo(archivo2)) {

            if (i.contains(codigo)) {
                System.out.println("resultado de la busqueda: " + i);
            }
            else {
                JOptionPane.showMessageDialog(null, "El codigo que buscas no extiste", "Dialogo de Error",JOptionPane.ERROR_MESSAGE);
                break;
            }
        }


    }
}