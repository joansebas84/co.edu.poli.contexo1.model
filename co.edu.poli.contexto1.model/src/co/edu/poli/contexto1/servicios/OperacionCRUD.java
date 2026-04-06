package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Persona;

/**
 * Interface que define las operaciones CRUD sobre objetos de tipo Persona.
 * Las clases que implementen esta interface deben proporcionar la lógica
 * para crear, leer, modificar y eliminar objetos en un arreglo.
 *
 * @author Joan Florez
 * @version 1.0
 */
public interface OperacionCRUD {

    /**
     * Crea e inserta un objeto Persona en el arreglo.
     * Inserta en el primer null encontrado de izquierda a derecha.
     * Si el arreglo está lleno, lo amplía dinámicamente.
     *
     * @param persona objeto a insertar
     * @return mensaje indicando el resultado de la operación
     */
    String crear(Persona persona);

    /**
     * Lee y retorna el objeto en la posición indicada del arreglo.
     *
     * @param indice posición del arreglo a consultar
     * @return objeto Persona en esa posición, o null si está vacía o fuera de rango
     */
    Persona leer(int indice);

    /**
     * Retorna el arreglo completo de objetos Persona.
     *
     * @return arreglo con todos los objetos (incluyendo nulls)
     */
    Persona[] leerTodos();

    /**
     * Modifica el objeto cuyo ID coincide con el parámetro {@code id}.
     *
     * @param id      ID del objeto a modificar
     * @param persona nuevo objeto con los datos actualizados
     * @return mensaje indicando el resultado de la operación
     */
    String modificar(String id, Persona persona);

    /**
     * Elimina el objeto cuyo ID coincide con el parámetro {@code id},
     * dejando esa posición del arreglo en null.
     *
     * @param id ID del objeto a eliminar
     * @return mensaje indicando el resultado de la operación
     */
    String eliminar(String id);
}