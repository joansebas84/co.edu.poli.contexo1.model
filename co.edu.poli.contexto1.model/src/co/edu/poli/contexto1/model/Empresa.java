package co.edu.poli.contexto1.model;

/**
 * Clase que representa una empresa vinculada al sistema de gestión.
 * Puede tener asociados uno o más instructores. Relación de agregación con Instructor.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Empresa {

    /** Nombre de la empresa. */
    private String nombre;

    /** Ubicación o dirección de la empresa. */
    private String ubicacion;

    /** Correo electrónico de contacto de la empresa. */
    private String correo;

    /** Número de registro mercantil de la empresa. */
    private String registroMercantil;

    /** Diseño o descripción visual de la empresa. */
    private String disenio;

    /** Arreglo de instructores vinculados a la empresa. Multiplicidad 1 a muchos. */
    private Instructor[] instructor;

    /**
     * Constructor de Empresa.
     *
     * @param nombre            nombre de la empresa
     * @param ubicacion         ubicación o dirección
     * @param correo            correo electrónico de contacto
     * @param registroMercantil número de registro mercantil
     * @param disenio           diseño o descripción visual
     * @param instructor        arreglo de instructores vinculados
     */
    public Empresa(String nombre, String ubicacion, String correo,
                   String registroMercantil, String disenio, Instructor[] instructor) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.correo = correo;
        this.registroMercantil = registroMercantil;
        this.disenio = disenio;
        this.instructor = instructor;
    }

    /** @return nombre de la empresa */
    public String getNombre() { return nombre; }
    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return ubicación de la empresa */
    public String getUbicacion() { return ubicacion; }
    /** @param ubicacion nueva ubicación */
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    /** @return correo de la empresa */
    public String getCorreo() { return correo; }
    /** @param correo nuevo correo */
    public void setCorreo(String correo) { this.correo = correo; }

    /** @return registro mercantil */
    public String getRegistroMercantil() { return registroMercantil; }
    /** @param registroMercantil nuevo registro mercantil */
    public void setRegistroMercantil(String registroMercantil) { this.registroMercantil = registroMercantil; }

    /** @return diseño de la empresa */
    public String getDisenio() { return disenio; }
    /** @param disenio nuevo diseño */
    public void setDisenio(String disenio) { this.disenio = disenio; }

    /** @return arreglo de instructores */
    public Instructor[] getInstructor() { return instructor; }
    /** @param instructor nuevo arreglo de instructores */
    public void setInstructor(Instructor[] instructor) { this.instructor = instructor; }

    /**
     * Retorna una representación en texto del objeto Empresa.
     * @return cadena con los datos de la empresa
     */
    @Override
    public String toString() {
        return "Empresa{nombre='" + nombre + "', ubicacion='" + ubicacion +
               "', correo='" + correo + "', registroMercantil='" + registroMercantil + "'}";
    }
}