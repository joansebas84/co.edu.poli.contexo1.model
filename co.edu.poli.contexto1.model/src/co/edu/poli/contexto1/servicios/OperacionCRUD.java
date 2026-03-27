package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Persona;

public interface OperacionCRUD {
    String crear(Persona persona);
    Persona leer(int indice);
    Persona[] leerTodos();
    String modificar(int indice, Persona persona);
    String eliminar(int indice, int id);
}