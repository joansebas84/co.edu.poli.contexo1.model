package co.edu.poli.contexto1.model;

/**
 * Clase que representa el registro de un usuario en el sistema.
 * No extiende de Persona; accede a los datos del usuario a través
 * de una relación de agregación (contiene un objeto Usuario).
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Registro {

    /** Usuario asociado a este registro. Relación de agregación. */
    private Usuario usuario;

    /** Correo electrónico del registro. */
    private String correo;

    /** Dirección de residencia del usuario registrado. */
    private String direccion;

    /** Número de contacto del usuario registrado. */
    private int numero;

    /** País de residencia del usuario registrado. */
    private String pais;

    /**
     * Constructor de Registro.
     *
     * @param usuario   objeto Usuario asociado al registro
     * @param correo    correo electrónico
     * @param direccion dirección de residencia
     * @param numero    número de contacto
     * @param pais      país de residencia
     */
    public Registro(Usuario usuario, String correo, String direccion, int numero, String pais) {
        this.usuario = usuario;
        this.correo = correo;
        this.direccion = direccion;
        this.numero = numero;
        this.pais = pais;
    }

    /**
     * Indica si el usuario del registro es mayor de edad.
     *
     * @param fechaActual fecha actual como referencia (no se usa en el cálculo actual)
     * @return true si la edad del usuario es mayor o igual a 18
     */
    public boolean esMayorDeEdad(String fechaActual) {
        return usuario.getEdad() >= 18;
    }

    /** @return usuario asociado al registro */
    public Usuario getUsuario() { return usuario; }
    /** @param usuario nuevo usuario */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    /** @return correo del registro */
    public String getCorreo() { return correo; }
    /** @param correo nuevo correo */
    public void setCorreo(String correo) { this.correo = correo; }

    /** @return dirección del registro */
    public String getDireccion() { return direccion; }
    /** @param direccion nueva dirección */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /** @return número de contacto */
    public int getNumero() { return numero; }
    /** @param numero nuevo número de contacto */
    public void setNumero(int numero) { this.numero = numero; }

    /** @return país del registro */
    public String getPais() { return pais; }
    /** @param pais nuevo país */
    public void setPais(String pais) { this.pais = pais; }

    /**
     * Retorna una representación en texto del objeto Registro.
     * @return cadena con los datos del registro
     */
    @Override
    public String toString() {
        return "Registro{usuario=" + usuario.getNombre() + ", correo='" + correo +
               "', direccion='" + direccion + "', numero=" + numero +
               ", pais='" + pais + "', edad=" + usuario.getEdad() + "}";
    }
}