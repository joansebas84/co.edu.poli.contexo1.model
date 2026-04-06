package co.edu.poli.contexto1.model;

/**
 * Clase abstracta que representa una persona en el sistema de gestión.
 * Es la supersuperclase de la jerarquía: de ella heredan Usuario, Instructor y Turno.
 * Al ser abstracta no puede instanciarse directamente.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public abstract class Persona {

    /** Nombre completo de la persona. */
    private String nombre;

    /** Identificador único de la persona. */
    private String id;

    /** Peso de la persona en kilogramos. */
    private double peso;

    /** Estatura de la persona en metros. */
    private double estatura;

    /** Edad de la persona en años. */
    private int edad;

    // PUNTO 3 - ATRIBUTO FINAL: grupoSanguineo no puede cambiar una vez asignado
    /** Grupo sanguíneo de la persona. Atributo final, no puede modificarse tras la creación. */
    private final String grupoSanguineo;

    /**
     * Constructor de Persona.
     *
     * @param nombre         nombre completo de la persona
     * @param id             identificador único
     * @param peso           peso en kilogramos
     * @param estatura       estatura en metros
     * @param edad           edad en años
     * @param grupoSanguineo grupo sanguíneo (valor final, no cambia)
     */
    public Persona(String nombre, String id, double peso, double estatura, int edad, String grupoSanguineo) {
        this.nombre = nombre;
        this.id = id;
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.grupoSanguineo = grupoSanguineo;
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) de la persona.
     * Las subclases pueden sobreescribir este método para aplicar ajustes.
     *
     * @return valor del IMC calculado como peso / (estatura * estatura)
     */
    public double calcularImc() {
        return peso / (estatura * estatura);
    }

    /**
     * Actualiza el peso de la persona y retorna el nuevo IMC.
     * Sobrecarga 1: solo actualiza el peso.
     *
     * @param nuevoPeso nuevo peso en kilogramos
     * @return nuevo IMC tras el cambio de peso
     */
    public double actualizarPerfil(double nuevoPeso) {
        this.peso = nuevoPeso;
        return calcularImc();
    }

    /**
     * Actualiza el peso y la estatura de la persona y retorna el nuevo IMC.
     * Sobrecarga 2: actualiza peso y estatura.
     *
     * @param nuevoPeso   nuevo peso en kilogramos
     * @param nuevaAltura nueva estatura en metros
     * @return nuevo IMC tras los cambios
     */
    public double actualizarPerfil(double nuevoPeso, double nuevaAltura) {
        this.peso = nuevoPeso;
        this.estatura = nuevaAltura;
        return calcularImc();
    }

    /**
     * Método abstracto que retorna información relevante del objeto.
     * Cada subclase debe proporcionar su propia implementación.
     *
     * @return cadena con la información del objeto
     */
    public abstract String obtenerInfo();

    /**
     * Retorna el nombre de la persona.
     * @return nombre
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre de la persona.
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna el ID de la persona.
     * @return id
     */
    public String getId() { return id; }

    /**
     * Establece el ID de la persona.
     * @param id nuevo identificador
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el peso de la persona.
     * @return peso en kilogramos
     */
    public double getPeso() { return peso; }

    /**
     * Establece el peso de la persona.
     * @param peso nuevo peso en kilogramos
     */
    public void setPeso(double peso) { this.peso = peso; }

    /**
     * Retorna la estatura de la persona.
     * @return estatura en metros
     */
    public double getEstatura() { return estatura; }

    /**
     * Establece la estatura de la persona.
     * @param estatura nueva estatura en metros
     */
    public void setEstatura(double estatura) { this.estatura = estatura; }

    /**
     * Retorna la edad de la persona.
     * @return edad en años
     */
    public int getEdad() { return edad; }

    /**
     * Establece la edad de la persona.
     * @param edad nueva edad en años
     */
    public void setEdad(int edad) { this.edad = edad; }

    // grupoSanguineo es final, no tiene setter
    /**
     * Retorna el grupo sanguíneo de la persona.
     * Este atributo es final y no tiene setter.
     * @return grupo sanguíneo
     */
    public String getGrupoSanguineo() { return grupoSanguineo; }

    /**
     * Retorna una representación en texto del objeto Persona.
     * @return cadena con los datos principales de la persona
     */
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', id='" + id + "', peso=" + peso +
               ", estatura=" + estatura + ", edad=" + edad + ", grupoSanguineo='" + grupoSanguineo + "'}";
    }
}