package co.edu.poli.contexto1.model;

public abstract class Persona {
    private String nombre;
    private String id;
    private double peso;
    private double estatura;
    private int edad;
    // PUNTO 3 - ATRIBUTO FINAL: grupoSanguineo no puede cambiar una vez asignado
    private final String grupoSanguineo;

    public Persona(String nombre, String id, double peso, double estatura, int edad, String grupoSanguineo) {
        this.nombre = nombre;
        this.id = id;
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.grupoSanguineo = grupoSanguineo;
    }

    public double calcularImc() {
        return peso / (estatura * estatura);
    }

    public double actualizarPerfil(double nuevoPeso) {
        this.peso = nuevoPeso;
        return calcularImc();
    }

    public double actualizarPerfil(double nuevoPeso, double nuevaAltura) {
        this.peso = nuevoPeso;
        this.estatura = nuevaAltura;
        return calcularImc();
    }

    // Método abstracto: cada subclase debe dar su propia implementación
    public abstract String obtenerInfo();

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    // grupoSanguineo es final, no tiene setter
    public String getGrupoSanguineo() { return grupoSanguineo; }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', id='" + id + "', peso=" + peso +
               ", estatura=" + estatura + ", edad=" + edad + ", grupoSanguineo='" + grupoSanguineo + "'}";
    }
}