package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Instructor;
import co.edu.poli.contexto1.model.Persona;
import co.edu.poli.contexto1.model.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que implementa las interfaces {@link OperacionCRUD} y {@link OperacionArchivo}
 * para gestionar un arreglo de objetos de tipo Persona.
 * El arreglo inicia con tamaño 2 y crece dinámicamente cuando se llena.
 * La serialización guarda en disco y la deserialización recarga los datos,
 * permitiendo persistencia entre ejecuciones.
 *
 * @author Joan Florez
 * @version 1.0
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    /** Nombre del archivo donde se persisten los datos. */
    private static final String ARCHIVO = "personas.txt";

    /** Arreglo interno que almacena los objetos Persona. Tamaño inicial: 2. */
    private Persona[] arregloObjetos;

    /**
     * Constructor. Inicializa el arreglo vacío con capacidad de 2 posiciones.
     */
    public ImplementacionOperacionCRUD() {
        this.arregloObjetos = new Persona[2];
    }

    // CREAR
    /**
     * Inserta en el primer null de izquierda a derecha.
     * Si está lleno, amplía el arreglo en una posición.
     * Valida null e ID duplicado.
     *
     * @param persona objeto a insertar
     * @return mensaje con el resultado
     */
    @Override
    public String crear(Persona persona) {
        if (persona == null) {
            return "Error: no se puede insertar un objeto null.";
        }
        for (Persona p : arregloObjetos) {
            if (p != null && p.getId().equals(persona.getId())) {
                return "Error: ya existe un objeto con ID " + persona.getId() + ".";
            }
        }
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] == null) {
                arregloObjetos[i] = persona;
                return "Creado correctamente en posicion [" + i + "]: " + persona.obtenerInfo();
            }
        }
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
    /**
     * Retorna el objeto en la posición indicada, o null si está fuera de rango.
     *
     * @param indice posición a consultar
     * @return objeto Persona o null
     */
    @Override
    public Persona leer(int indice) {
        if (indice < 0 || indice >= arregloObjetos.length) {
            return null;
        }
        return arregloObjetos[indice];
    }

    // LEER TODOS
    /**
     * Retorna el arreglo completo incluyendo posiciones null.
     *
     * @return arreglo de Persona
     */
    @Override
    public Persona[] leerTodos() {
        return arregloObjetos;
    }

    // MODIFICAR POR ID
    /**
     * Busca por ID y reemplaza el objeto encontrado.
     *
     * @param id      ID del objeto a modificar
     * @param persona nuevo objeto
     * @return mensaje con el resultado
     */
    @Override
    public String modificar(String id, Persona persona) {
        if (persona == null) {
            return "Error: el nuevo objeto no puede ser null.";
        }
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] != null && arregloObjetos[i].getId().equals(id)) {
                String anterior = arregloObjetos[i].obtenerInfo();
                arregloObjetos[i] = persona;
                return "Modificado ID " + id + ".\n   Antes : " + anterior
                        + "\n   Ahora : " + persona.obtenerInfo();
            }
        }
        return "Error: no se encontró ningún objeto con ID " + id + ".";
    }

    // ELIMINAR POR ID
    /**
     * Busca por ID y pone null en esa posición.
     *
     * @param id ID del objeto a eliminar
     * @return mensaje con el resultado
     */
    @Override
    public String eliminar(String id) {
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] != null && arregloObjetos[i].getId().equals(id)) {
                String info = arregloObjetos[i].obtenerInfo();
                arregloObjetos[i] = null;
                return "Eliminado correctamente. Posicion [" + i + "] -> null\n   Era: " + info;
            }
        }
        return "Error: no se encontró ningún objeto con ID " + id + ".";
    }

    // SERIALIZAR: guarda el arreglo en archivo de texto
    /**
     * Guarda el arreglo en el archivo {@code personas.txt}.
     * Formato por línea:
     * <ul>
     *   <li>Usuario: {@code Usuario;id;nombre;peso;estatura;edad;grupoSanguineo}</li>
     *   <li>Instructor: {@code Instructor;id;nombre;peso;estatura;edad;grupoSanguineo;certificado;correo}</li>
     *   <li>Posición vacía: {@code null}</li>
     * </ul>
     *
     * @return mensaje indicando éxito o error
     */
    @Override
    public String serializar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Persona p : arregloObjetos) {
                if (p == null) {
                    bw.write("null");
                } else if (p instanceof Instructor) {
                    Instructor ins = (Instructor) p;
                    bw.write("Instructor;" + ins.getId() + ";" + ins.getNombre() + ";"
                            + ins.getPeso() + ";" + ins.getEstatura() + ";" + ins.getEdad() + ";"
                            + ins.getGrupoSanguineo() + ";" + ins.getCertificado() + ";" + ins.getCorreo());
                } else if (p instanceof Usuario) {
                    bw.write("Usuario;" + p.getId() + ";" + p.getNombre() + ";"
                            + p.getPeso() + ";" + p.getEstatura() + ";" + p.getEdad() + ";"
                            + p.getGrupoSanguineo());
                }
                bw.newLine();
            }
            return "Datos serializados correctamente en: " + ARCHIVO;
        } catch (IOException e) {
            return "Error al serializar: " + e.getMessage();
        }
    }

    // DESERIALIZAR: lee el archivo y reconstruye el arreglo
    /**
     * Lee el archivo {@code personas.txt} y reconstruye el arreglo de objetos.
     * Si el archivo no existe, retorna el arreglo vacío actual sin error.
     *
     * @return arreglo de Persona reconstruido desde el archivo
     */
    @Override
    public Persona[] deserializar() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            // Contar líneas para saber el tamaño del arreglo
            int lineas = 0;
            while (br.readLine() != null) lineas++;

            Persona[] resultado = new Persona[lineas];

            // Releer el archivo para construir los objetos
            try (BufferedReader br2 = new BufferedReader(new FileReader(ARCHIVO))) {
                String linea;
                int i = 0;
                while ((linea = br2.readLine()) != null) {
                    if (linea.equals("null")) {
                        resultado[i] = null;
                    } else {
                        String[] partes = linea.split(";");
                        if (partes[0].equals("Usuario")) {
                            resultado[i] = new Usuario(
                                    partes[2],                  // nombre
                                    partes[1],                  // id
                                    Double.parseDouble(partes[3]),  // peso
                                    Double.parseDouble(partes[4]),  // estatura
                                    Integer.parseInt(partes[5]),    // edad
                                    partes[6],                  // grupoSanguineo
                                    null
                            );
                        } else if (partes[0].equals("Instructor")) {
                            resultado[i] = new Instructor(
                                    partes[2],                  // nombre
                                    partes[1],                  // id
                                    Double.parseDouble(partes[3]),  // peso
                                    Double.parseDouble(partes[4]),  // estatura
                                    Integer.parseInt(partes[5]),    // edad
                                    partes[6],                  // grupoSanguineo
                                    partes[7],                  // certificado
                                    partes[8]                   // correo
                            );
                        }
                    }
                    i++;
                }
            }
            arregloObjetos = resultado;
            return arregloObjetos;
        } catch (IOException e) {
            // Si el archivo no existe aún, se retorna el arreglo vacío actual
            return arregloObjetos;
        }
    }
}