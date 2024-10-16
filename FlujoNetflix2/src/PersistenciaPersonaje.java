import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class PersistenciaPersonaje {

    public static ArrayList<String> LeerArchivo (String nombreArchivo) throws IOException{
        FileReader archivoEntrada;
        BufferedReader bufferEntrada;
        ArrayList<String> contenidoTexto;
        String linea;

        archivoEntrada = null;
        contenidoTexto = new ArrayList<>();

        archivoEntrada = new FileReader(nombreArchivo);
        bufferEntrada = new BufferedReader(archivoEntrada);

        while ((linea = bufferEntrada.readLine()) != null){
          contenidoTexto.add(linea);
        }

        bufferEntrada.close();
        archivoEntrada.close();

        return contenidoTexto;

    }


    public static void almacenarDatos(String nombre, String formato, Object...args) throws IOException{

        FileWriter archivoSalida;
        Formatter archivo;

        archivoSalida = new FileWriter(nombre, true);
        archivo = new Formatter(archivoSalida);
        archivo.format(formato, args);
        archivo.flush();
        archivo.close();

    }

    public static void serializarXML(String nombre, Object objeto) throws IOException {

        XMLEncoder codificador;

        codificador = new XMLEncoder( new FileOutputStream(nombre));
        codificador.writeObject(objeto);
        codificador.close();
    }

    public static Object deserializarXML(String nombre) throws IOException {

        XMLDecoder decodificador;
        Object objeto;

        decodificador = new XMLDecoder(new FileInputStream(nombre ));
        objeto = decodificador.readObject();
        decodificador.close();

        return objeto;
    }

    public static void serializarBinario(String nombre, Object objeto) throws IOException{

        ObjectOutputStream salida;

        salida = new ObjectOutputStream( new FileOutputStream(nombre));
        salida.writeObject(objeto);
        salida.close();
    }

    public static Object deserializarBinario(String nombre) throws IOException, ClassNotFoundException {

        Object objeto;
        ObjectInputStream entrada;

        entrada = new ObjectInputStream(new FileInputStream(nombre));
        objeto = entrada.readObject();
        entrada.close();

        return objeto;
    }

}