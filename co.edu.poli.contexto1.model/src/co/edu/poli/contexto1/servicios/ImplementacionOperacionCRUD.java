package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Persona;

public class ImplementacionOperacionCRUD implements OperacionCRUD {

    // Arreglo inicial de tamaño 2, crece dinámicamente cuando se llena
    private Persona[] arregloObjetos;

    public ImplementacionOperacionCRUD() {
        this.arregloObjetos = new Persona[2];
    }

    // CREAR: inserta en el primer null que encuentre de izquierda a derecha.
    // Si el arreglo está lleno, lo agranda y agrega al final (agregación infinita).
    @Override
    public String crear(Persona persona) {
        if (persona == null) {
            return "Error: no se puede insertar un objeto null.";
        }
        // Verificar ID duplicado
        for (Persona p : arregloObjetos) {
            if (p != null && p.getId().equals(persona.getId())) {
                return "Error: ya existe un objeto con ID " + persona.getId() + ".";
            }
        }
        // Buscar primer null
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] == null) {
                arregloObjetos[i] = persona;
                return "Creado correctamente en posicion [" + i + "]: " + persona.obtenerInfo();
            }
        }
        // Arreglo lleno: crecer dinámicamente
        Persona[] nuevo = new Persona[arregloObjetos.length + 1];
        for (int i = 0; i < arregloObjetos.length; i++) {
            nuevo[i] = arregloObjetos[i];
        }
        nuevo[arregloObjetos.length] = persona;
        arregloObjetos = nuevo;
        return "Arreglo lleno, se amplió. Creado en posicion [" + (arregloObjetos.length - 1) + "]: "
                + persona.obtenerInfo();
    }

    // LEER POR ÍNDICE
    @Override
    public Persona leer(int indice) {
        if (indice < 0 || indice >= arregloObjetos.length) {
            return null;
        }
        return arregloObjetos[indice];
    }

    // LEER TODOS
    @Override
    public Persona[] leerTodos() {
        return arregloObjetos;
    }

    // MODIFICAR POR ID: busca el objeto con ese ID y lo reemplaza
    @Override
    public String modificar(int indice, Persona persona) {
        if (persona == null) {
            return "Error: el nuevo objeto no puede ser null.";
        }
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] != null && arregloObjetos[i].getId().equals(String.valueOf(indice))) {
                String anterior = arregloObjetos[i].obtenerInfo();
                arregloObjetos[i] = persona;
                return "Modificado ID " + indice + ".\n   Antes : " + anterior
                        + "\n   Ahora : " + persona.obtenerInfo();
            }
        }
        return "Error: no se encontró ningún objeto con ID " + indice + ".";
    }

    // ELIMINAR POR ID: busca el objeto con ese ID y lo pone null
    @Override
    public String eliminar(int indice, int id) {
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] != null && arregloObjetos[i].getId().equals(String.valueOf(id))) {
                String info = arregloObjetos[i].obtenerInfo();
                arregloObjetos[i] = null;
                return "Eliminado correctamente. Posicion [" + i + "] -> null\n   Era: " + info;
            }
        }
        return "Error: no se encontró ningún objeto con ID " + id + ".";
    }
}