package co.edu.poli.contexto1.model;

/**
 * Clase que representa un usuario del sistema de gestión.
 * Extiende de Persona heredando sus atributos y métodos.
 * Un usuario puede tener asociadas una o más enfermedades.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Usuario extends Persona {

    /** Arreglo de enfermedades asociadas al usuario. Multiplicidad 1 a muchos. */
    private Enfermedad[] enfermedad;

    /**
     * Constructor de Usuario.
     *
     * @param nombre         nombre completo del usuario
     * @param id             identificador único
     * @param peso           peso en kilogramos
     * @param estatura       estatura en metros
     * @param edad           edad en años
     * @param grupoSanguineo grupo sanguíneo
     * @param enfermedad     arreglo de enfermedades (puede ser null)
     */
    public Usuario(String nombre, String id, double peso, double estatura, int edad,
                   String grupoSanguineo, Enfermedad[] enfermedad) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo);
        this.enfermedad = enfermedad;
    }

    /**
     * Retorna información resumida del usuario.
     * Implementación del método abstracto de Persona.
     *
     * @return cadena con ID, nombre, edad y grupo sanguíneo del usuario
     */
    @Override
    public String obtenerInfo() {
        return "Usuario | ID: " + getId() + " | Nombre: " + getNombre()
                + " | Edad: " + getEdad() + " | Grupo: " + getGrupoSanguineo();
    }

    /**
     * Retorna el arreglo de enfermedades del usuario.
     * @return arreglo de enfermedades
     */
    public Enfermedad[] getEnfermedad() { return enfermedad; }

    /**
     * Establece el arreglo de enfermedades del usuario.
     * @param enfermedad nuevo arreglo de enfermedades
     */
    public void setEnfermedad(Enfermedad[] enfermedad) { this.enfermedad = enfermedad; }

    /**
     * Retorna una representación en texto del objeto Usuario.
     * @return cadena con los datos del usuario
     */
    @Override
    public String toString() {
        return "Usuario{nombre='" + getNombre() + "', id='" + getId() + "', peso=" + getPeso() +
               ", estatura=" + getEstatura() + ", edad=" + getEdad() + "}";
    }
}