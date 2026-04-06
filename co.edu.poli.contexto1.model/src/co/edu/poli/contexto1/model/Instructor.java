package co.edu.poli.contexto1.model;

/**
 * Clase que representa un instructor del sistema de gestión.
 * Extiende de Persona y sobreescribe el método calcularImc()
 * aplicando un factor de ajuste de 0.95.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Instructor extends Persona {

    /** Código del certificado de habilitación del instructor. */
    private String certificado;

    /** Correo electrónico de contacto del instructor. */
    private String correo;

    /**
     * Constructor de Instructor.
     *
     * @param nombre         nombre completo del instructor
     * @param id             identificador único
     * @param peso           peso en kilogramos
     * @param estatura       estatura en metros
     * @param edad           edad en años
     * @param grupoSanguineo grupo sanguíneo
     * @param certificado    código del certificado de habilitación
     * @param correo         correo electrónico de contacto
     */
    public Instructor(String nombre, String id, double peso, double estatura, int edad,
                      String grupoSanguineo, String certificado, String correo) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo);
        this.certificado = certificado;
        this.correo = correo;
    }

    /**
     * Calcula el IMC del instructor aplicando un factor de ajuste de 0.95.
     * Sobreescritura del método calcularImc() de Persona.
     *
     * @return IMC ajustado: (peso / (estatura * estatura)) * 0.95
     */
    @Override
    public double calcularImc() {
        return (getPeso() / (getEstatura() * getEstatura())) * 0.95;
    }

    /**
     * Retorna información resumida del instructor.
     * Implementación del método abstracto de Persona.
     *
     * @return cadena con ID, nombre, certificado y correo del instructor
     */
    @Override
    public String obtenerInfo() {
        return "Instructor | ID: " + getId() + " | Nombre: " + getNombre()
                + " | Certificado: " + certificado + " | Correo: " + correo;
    }

    /**
     * Retorna el certificado del instructor.
     * @return código del certificado
     */
    public String getCertificado() { return certificado; }

    /**
     * Establece el certificado del instructor.
     * @param certificado nuevo código de certificado
     */
    public void setCertificado(String certificado) { this.certificado = certificado; }

    /**
     * Retorna el correo del instructor.
     * @return correo electrónico
     */
    public String getCorreo() { return correo; }

    /**
     * Establece el correo del instructor.
     * @param correo nuevo correo electrónico
     */
    public void setCorreo(String correo) { this.correo = correo; }

    // PUNTO 3 - MÉTODO FINAL: ninguna subclase puede sobreescribir toString de Instructor
    /**
     * Retorna una representación en texto del objeto Instructor.
     * Método final: ninguna subclase puede sobreescribirlo.
     *
     * @return cadena con los datos del instructor
     */
    @Override
    public final String toString() {
        return "Instructor{nombre='" + getNombre() + "', id='" + getId() + "', certificado='" + certificado +
               "', correo='" + correo + "', peso=" + getPeso() + ", estatura=" + getEstatura() + "}";
    }
}