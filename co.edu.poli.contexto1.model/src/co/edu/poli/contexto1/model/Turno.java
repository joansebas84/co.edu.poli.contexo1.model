package co.edu.poli.contexto1.model;

public class Turno extends Persona {
    private String dia;
    private String lugar;
    private String color;
    private String estado;
    private int codigo;
    private Registro[] registro;
    private Maquina maquina;
    private Instructor instructor;
    private String hora;
    private static int capacidadMaxima = 10;

    public Turno(String nombre, String id, double peso, double estatura, int edad,
                 String grupoSanguineo, String dia, String lugar, String color,
                 String estado, int codigo, Maquina maquina, Instructor instructor, String hora) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo);
        this.dia = dia;
        this.lugar = lugar;
        this.color = color;
        this.estado = estado;
        this.codigo = codigo;
        this.maquina = maquina;
        this.instructor = instructor;
        this.hora = hora;
    }

    @Override
    public String obtenerInfo() {
        return "Turno | ID: " + getId() + " | Dia: " + dia + " | Hora: " + hora
                + " | Lugar: " + lugar + " | Estado: " + estado;
    }

    public boolean quedanCupos() {
        int registrosActuales = (registro != null) ? registro.length : 0;
        return registrosActuales < capacidadMaxima;
    }

    public static int getCapacidadMaxima() { return capacidadMaxima; }
    public static void setCapacidadMaxima(int nuevaCapacidad) { capacidadMaxima = nuevaCapacidad; }

    public String getDia() { return dia; }
    public void setDia(String dia) { this.dia = dia; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public Registro[] getRegistro() { return registro; }
    public void setRegistro(Registro[] registro) { this.registro = registro; }

    public Maquina getMaquina() { return maquina; }
    public void setMaquina(Maquina maquina) { this.maquina = maquina; }

    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    @Override
    public String toString() {
        return "Turno{dia='" + dia + "', lugar='" + lugar + "', hora='" + hora +
               "', estado='" + estado + "', codigo=" + codigo +
               ", instructor=" + (instructor != null ? instructor.getNombre() : "N/A") +
               ", capacidadMaxima=" + capacidadMaxima + "}";
    }
}