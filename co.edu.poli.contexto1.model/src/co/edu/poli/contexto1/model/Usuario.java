package co.edu.poli.contexto1.model;

public class Usuario extends Persona {
    private Enfermedad[] enfermedad;

    public Usuario(String nombre, String id, double peso, double estatura, int edad,
                   String grupoSanguineo, Enfermedad[] enfermedad) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo);
        this.enfermedad = enfermedad;
    }

    @Override
    public String obtenerInfo() {
        return "Usuario | ID: " + getId() + " | Nombre: " + getNombre()
                + " | Edad: " + getEdad() + " | Grupo: " + getGrupoSanguineo();
    }

    public Enfermedad[] getEnfermedad() { return enfermedad; }
    public void setEnfermedad(Enfermedad[] enfermedad) { this.enfermedad = enfermedad; }

    @Override
    public String toString() {
        return "Usuario{nombre='" + getNombre() + "', id='" + getId() + "', peso=" + getPeso() +
               ", estatura=" + getEstatura() + ", edad=" + getEdad() + "}";
    }
}