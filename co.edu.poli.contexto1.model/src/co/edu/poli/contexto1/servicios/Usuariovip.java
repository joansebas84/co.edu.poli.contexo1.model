package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Enfermedad;
import co.edu.poli.contexto1.model.Usuario;

// PUNTO 3 - CLASE FINAL: UsuarioVip no puede ser heredada por ninguna otra clase
/**
 * Clase que representa un usuario VIP del sistema de gestión.
 * Extiende de Usuario heredando todos sus atributos y métodos.
 * Al ser clase final no puede ser heredada por ninguna otra clase.
 * Agrega descuento y código único de suscripción.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
final class UsuarioVip extends Usuario {

    /** Porcentaje de descuento aplicado al usuario VIP. */
    private double descuento;

    /** Código único de suscripción del usuario VIP. */
    private String unicoDeSubscripcion;

    /**
     * Constructor de UsuarioVip.
     *
     * @param nombre              nombre completo del usuario
     * @param id                  identificador único
     * @param peso                peso en kilogramos
     * @param estatura            estatura en metros
     * @param edad                edad en años
     * @param grupoSanguineo      grupo sanguíneo
     * @param enfermedad          arreglo de enfermedades (puede ser null)
     * @param descuento           porcentaje de descuento VIP
     * @param unicoDeSubscripcion código único de suscripción
     */
    public UsuarioVip(String nombre, String id, double peso, double estatura, int edad,
                      String grupoSanguineo, Enfermedad[] enfermedad,
                      double descuento, String unicoDeSubscripcion) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo, enfermedad);
        this.descuento = descuento;
        this.unicoDeSubscripcion = unicoDeSubscripcion;
    }

    /**
     * Calcula la fecha de vencimiento de la suscripción VIP.
     *
     * @param dateInicio fecha de inicio de la suscripción
     * @param nroMeses   número de meses de duración
     * @return cadena con la información de vencimiento calculada
     */
    public String fechaDeVencimientoSuscripcion(String dateInicio, String nroMeses) {
        return "Fecha de vencimiento calculada desde: " + dateInicio + " por " + nroMeses + " meses";
    }

    /**
     * Retorna el descuento del usuario VIP.
     * @return porcentaje de descuento
     */
    public double getDescuento() { return descuento; }

    /**
     * Establece el descuento del usuario VIP.
     * @param descuento nuevo porcentaje de descuento
     */
    public void setDescuento(double descuento) { this.descuento = descuento; }

    /**
     * Retorna el código único de suscripción.
     * @return código de suscripción
     */
    public String getUnicoDeSubscripcion() { return unicoDeSubscripcion; }

    /**
     * Establece el código único de suscripción.
     * @param unicoDeSubscripcion nuevo código de suscripción
     */
    public void setUnicoDeSubscripcion(String unicoDeSubscripcion) { this.unicoDeSubscripcion = unicoDeSubscripcion; }

    /**
     * Retorna una representación en texto del objeto UsuarioVip.
     * @return cadena con los datos del usuario VIP
     */
    @Override
    public String toString() {
        return "UsuarioVip{nombre='" + getNombre() + "', id='" + getId() + "', descuento=" + descuento +
               ", unicoDeSubscripcion='" + unicoDeSubscripcion + "'}";
    }
}