package co.edu.poli.contexto1.model;

/**
 * Clase que representa un traje utilizado en el sistema de gestión.
 * Los trajes pueden estar asociados a una máquina. Relación de agregación con Maquina.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Traje {

    /** Material del que está hecho el traje. */
    private String material;

    /** Identificador único del traje. */
    private String id;

    /** Estado actual del traje (ej: disponible, en uso). */
    private String estadoDelTraje;

    /** Talla o tamaño del traje. */
    private String tamanio;

    /** Tipo o categoría del traje. */
    private String tipo;

    /**
     * Constructor de Traje.
     *
     * @param material       material del traje
     * @param id             identificador único
     * @param estadoDelTraje estado actual del traje
     * @param tamanio        talla del traje
     * @param tipo           tipo o categoría
     */
    public Traje(String material, String id, String estadoDelTraje, String tamanio, String tipo) {
        this.material = material;
        this.id = id;
        this.estadoDelTraje = estadoDelTraje;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    /**
     * Indica si el traje está disponible para uso.
     *
     * @return true si el estado del traje es "disponible"
     */
    public boolean disponibleTraje() {
        return estadoDelTraje != null && estadoDelTraje.equalsIgnoreCase("disponible");
    }

    /** @return material del traje */
    public String getMaterial() { return material; }
    /** @param material nuevo material */
    public void setMaterial(String material) { this.material = material; }

    /** @return id del traje */
    public String getId() { return id; }
    /** @param id nuevo id */
    public void setId(String id) { this.id = id; }

    /** @return estado del traje */
    public String getEstadoDelTraje() { return estadoDelTraje; }
    /** @param estadoDelTraje nuevo estado */
    public void setEstadoDelTraje(String estadoDelTraje) { this.estadoDelTraje = estadoDelTraje; }

    /** @return talla del traje */
    public String getTamanio() { return tamanio; }
    /** @param tamanio nueva talla */
    public void setTamanio(String tamanio) { this.tamanio = tamanio; }

    /** @return tipo del traje */
    public String getTipo() { return tipo; }
    /** @param tipo nuevo tipo */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Retorna una representación en texto del objeto Traje.
     * @return cadena con los datos del traje
     */
    @Override
    public String toString() {
        return "Traje{material='" + material + "', id='" + id + "', estadoDelTraje='" +
               estadoDelTraje + "', tamanio='" + tamanio + "', tipo='" + tipo + "'}";
    }
}