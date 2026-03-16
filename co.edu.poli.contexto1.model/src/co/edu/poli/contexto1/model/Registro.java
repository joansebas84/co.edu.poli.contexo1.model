package co.edu.poli.contexto1.model;

public class Registro {
    private Usuario usuario;
    private String correo;
    private String direccion;
    private int numero;
    private String pais;

    public Registro(Usuario usuario, String correo, String direccion, int numero, String pais) {
        this.usuario = usuario;
        this.correo = correo;
        this.direccion = direccion;
        this.numero = numero;
        this.pais = pais;
    }

    public boolean esMayorDeEdad(String fechaActual) {
        return usuario.getEdad() >= 18;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    @Override
    public String toString() {
        return "Registro{usuario=" + usuario.getNombre() + ", correo='" + correo +
               "', direccion='" + direccion + "', numero=" + numero +
               ", pais='" + pais + "', edad=" + usuario.getEdad() + "}";
    }
}