package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Persona;

/**
 * Interface que define las operaciones de archivo sobre el arreglo de objetos Persona.
 * Las clases que implementen esta interface deben proporcionar la lógica
 * para serializar y deserializar los datos del arreglo en un archivo de texto.
 *
 * @author Joan Florez
 * @version 1.0
 */
public interface OperacionArchivo {

    /**
     * Serializa el contenido del arreglo en un archivo de texto en disco.
     * Cada objeto se guarda como una línea con sus datos separados por ";".
     *
     * @return mensaje indicando si la operación fue exitosa o hubo error
     */
    String serializar();

    /**
     * Deserializa el archivo de texto y reconstruye el arreglo de objetos Persona.
     * Si el archivo no existe retorna el arreglo vacío actual.
     *
     * @return arreglo de objetos Persona reconstruidos desde el archivo
     */
    Persona[] deserializar();
}