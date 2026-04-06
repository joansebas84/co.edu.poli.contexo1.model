package co.edu.poli.contexto1.model;

/**
 * Clase que representa una máquina del gimnasio o instalación.
 * Puede tener asociados uno o más trajes. Relación de agregación con Traje.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Maquina {

    /** Marca del fabricante de la máquina. */
    private String marca;

    /** Peso de la máquina. */
    private String peso;

    /** Color de la máquina. */
    private String color;

    /** Estado actual de la máquina (ej: Bueno, Dañada). */
    private String estado;

    /** Material principal de construcción. */
    private String material;

    /** Código identificador de la máquina. */
    private String codigo;

    /** Capacidad de carga de la máquina. */
    private String capacidad;

    /** Gravedad configurada en la máquina. */
    private double gravedad;

    /** Arreglo de trajes asociados a la máquina. Multiplicidad 1 a muchos. */
    private Traje[] traje;

    /**
     * Constructor de Maquina.
     *
     * @param marca     marca del fabricante
     * @param peso      peso de la máquina
     * @param color     color
     * @param estado    estado actual
     * @param material  material de construcción
     * @param codigo    código identificador
     * @param capacidad capacidad de carga
     * @param gravedad  gravedad configurada
     * @param traje     arreglo de trajes asociados
     */
    public Maquina(String marca, String peso, String color, String estado, String material,
                   String codigo, String capacidad, double gravedad, Traje[] traje) {
        this.marca = marca;
        this.peso = peso;
        this.color = color;
        this.estado = estado;
        this.material = material;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.gravedad = gravedad;
        this.traje = traje;
    }

    /**
     * Indica si la máquina necesita mantenimiento.
     *
     * @return true si el estado de la máquina es "dañada"
     */
    public boolean necesitaMantenimiento() {
        return estado != null && estado.equalsIgnoreCase("dañada");
    }

    /** @return marca de la máquina */
    public String getMarca() { return marca; }
    /** @param marca nueva marca */
    public void setMarca(String marca) { this.marca = marca; }

    /** @return peso de la máquina */
    public String getPeso() { return peso; }
    /** @param peso nuevo peso */
    public void setPeso(String peso) { this.peso = peso; }

    /** @return color de la máquina */
    public String getColor() { return color; }
    /** @param color nuevo color */
    public void setColor(String color) { this.color = color; }

    /** @return estado de la máquina */
    public String getEstado() { return estado; }
    /** @param estado nuevo estado */
    public void setEstado(String estado) { this.estado = estado; }

    /** @return material de la máquina */
    public String getMaterial() { return material; }
    /** @param material nuevo material */
    public void setMaterial(String material) { this.material = material; }

    /** @return código de la máquina */
    public String getCodigo() { return codigo; }
    /** @param codigo nuevo código */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /** @return capacidad de la máquina */
    public String getCapacidad() { return capacidad; }
    /** @param capacidad nueva capacidad */
    public void setCapacidad(String capacidad) { this.capacidad = capacidad; }

    /** @return gravedad configurada */
    public double getGravedad() { return gravedad; }
    /** @param gravedad nueva gravedad */
    public void setGravedad(double gravedad) { this.gravedad = gravedad; }

    /** @return arreglo de trajes asociados */
    public Traje[] getTraje() { return traje; }
    /** @param traje nuevo arreglo de trajes */
    public void setTraje(Traje[] traje) { this.traje = traje; }

    /**
     * Retorna una representación en texto del objeto Maquina.
     * @return cadena con los datos de la máquina
     */
    @Override
    public String toString() {
        return "Maquina{marca='" + marca + "', codigo='" + codigo + "', estado='" + estado +
               "', capacidad='" + capacidad + "', gravedad=" + gravedad + "}";
    }
}