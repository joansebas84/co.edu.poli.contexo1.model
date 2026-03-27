package co.edu.poli.contexto1.model;

public class Instructor extends Persona {
    private String certificado;
    private String correo;

    public Instructor(String nombre, String id, double peso, double estatura, int edad,
                      String grupoSanguineo, String certificado, String correo) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo);
        this.certificado = certificado;
        this.correo = correo;
    }

    @Override
    public double calcularImc() {
        return (getPeso() / (getEstatura() * getEstatura())) * 0.95;
    }

    @Override
    public String obtenerInfo() {
        return "Instructor | ID: " + getId() + " | Nombre: " + getNombre()
                + " | Certificado: " + certificado + " | Correo: " + correo;
    }

    public String getCertificado() { return certificado; }
    public void setCertificado(String certificado) { this.certificado = certificado; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    // PUNTO 3 - MÉTODO FINAL: ninguna subclase puede sobreescribir toString de Instructor
    @Override
    public final String toString() {
        return "Instructor{nombre='" + getNombre() + "', id='" + getId() + "', certificado='" + certificado +
               "', correo='" + correo + "', peso=" + getPeso() + ", estatura=" + getEstatura() + "}";
    }
}