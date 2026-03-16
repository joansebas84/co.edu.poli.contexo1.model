package co.edu.poli.contexto1.model;

public class Empresa {
    private String nombre;
    private String ubicacion;
    private String correo;
    private String registroMercantil;
    private String disenio;
    private Instructor[] instructor;

    public Empresa(String nombre, String ubicacion, String correo,
                   String registroMercantil, String disenio, Instructor[] instructor) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.correo = correo;
        this.registroMercantil = registroMercantil;
        this.disenio = disenio;
        this.instructor = instructor;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getRegistroMercantil() { return registroMercantil; }
    public void setRegistroMercantil(String registroMercantil) { this.registroMercantil = registroMercantil; }

    public String getDisenio() { return disenio; }
    public void setDisenio(String disenio) { this.disenio = disenio; }

    public Instructor[] getInstructor() { return instructor; }
    public void setInstructor(Instructor[] instructor) { this.instructor = instructor; }

    @Override
    public String toString() {
        return "Empresa{nombre='" + nombre + "', ubicacion='" + ubicacion +
               "', correo='" + correo + "', registroMercantil='" + registroMercantil + "'}";
    }
}