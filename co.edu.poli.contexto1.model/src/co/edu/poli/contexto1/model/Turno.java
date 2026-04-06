package co.edu.poli.contexto1.model;

/**
 * Clase que representa un turno dentro del sistema de gestión.
 * Extiende de Persona para heredar los datos básicos del responsable del turno.
 * Contiene un atributo estático {@code capacidadMaxima} compartido por todos los turnos.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Turno extends Persona {

    /** Día de la semana en que se realiza el turno. */
    private String dia;

    /** Lugar o sala donde se desarrolla el turno. */
    private String lugar;

    /** Color identificador del turno. */
    private String color;

    /** Estado actual del turno (ej: Activo, Inactivo). */
    private String estado;

    /** Código numérico identificador del turno. */
    private int codigo;

    /** Arreglo de registros asociados al turno. Multiplicidad 1 a muchos. */
    private Registro[] registro;

    /** Máquina asignada al turno. */
    private Maquina maquina;

    /** Instructor a cargo del turno. */
    private Instructor instructor;

    /** Hora de inicio del turno. */
    private String hora;

    /** Capacidad máxima de registros por turno. Atributo estático compartido por todos los turnos. */
    private static int capacidadMaxima = 10;

    /**
     * Constructor de Turno.
     *
     * @param nombre         nombre del turno
     * @param id             identificador único
     * @param peso           peso (heredado de Persona)
     * @param estatura       estatura (heredado de Persona)
     * @param edad           edad (heredado de Persona)
     * @param grupoSanguineo grupo sanguíneo (heredado de Persona)
     * @param dia            día de la semana del turno
     * @param lugar          lugar o sala del turno
     * @param color          color identificador
     * @param estado         estado del turno
     * @param codigo         código numérico del turno
     * @param maquina        máquina asignada
     * @param instructor     instructor a cargo
     * @param hora           hora de inicio
     */
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

    /**
     * Retorna información resumida del turno.
     * Implementación del método abstracto de Persona.
     *
     * @return cadena con ID, día, hora, lugar y estado del turno
     */
    @Override
    public String obtenerInfo() {
        return "Turno | ID: " + getId() + " | Dia: " + dia + " | Hora: " + hora
                + " | Lugar: " + lugar + " | Estado: " + estado;
    }

    /**
     * Indica si aún hay cupos disponibles en el turno.
     *
     * @return true si el número de registros actuales es menor a la capacidad máxima
     */
    public boolean quedanCupos() {
        int registrosActuales = (registro != null) ? registro.length : 0;
        return registrosActuales < capacidadMaxima;
    }

    /**
     * Retorna la capacidad máxima de registros por turno.
     * @return capacidad máxima (atributo estático)
     */
    public static int getCapacidadMaxima() { return capacidadMaxima; }

    /**
     * Establece la capacidad máxima de registros por turno.
     * Al ser estático, el cambio afecta a todos los objetos Turno.
     * @param nuevaCapacidad nueva capacidad máxima
     */
    public static void setCapacidadMaxima(int nuevaCapacidad) { capacidadMaxima = nuevaCapacidad; }

    /** @return día del turno */
    public String getDia() { return dia; }
    /** @param dia nuevo día */
    public void setDia(String dia) { this.dia = dia; }

    /** @return lugar del turno */
    public String getLugar() { return lugar; }
    /** @param lugar nuevo lugar */
    public void setLugar(String lugar) { this.lugar = lugar; }

    /** @return color identificador */
    public String getColor() { return color; }
    /** @param color nuevo color */
    public void setColor(String color) { this.color = color; }

    /** @return estado del turno */
    public String getEstado() { return estado; }
    /** @param estado nuevo estado */
    public void setEstado(String estado) { this.estado = estado; }

    /** @return código del turno */
    public int getCodigo() { return codigo; }
    /** @param codigo nuevo código */
    public void setCodigo(int codigo) { this.codigo = codigo; }

    /** @return arreglo de registros del turno */
    public Registro[] getRegistro() { return registro; }
    /** @param registro nuevo arreglo de registros */
    public void setRegistro(Registro[] registro) { this.registro = registro; }

    /** @return máquina asignada al turno */
    public Maquina getMaquina() { return maquina; }
    /** @param maquina nueva máquina */
    public void setMaquina(Maquina maquina) { this.maquina = maquina; }

    /** @return instructor a cargo del turno */
    public Instructor getInstructor() { return instructor; }
    /** @param instructor nuevo instructor */
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    /** @return hora de inicio del turno */
    public String getHora() { return hora; }
    /** @param hora nueva hora de inicio */
    public void setHora(String hora) { this.hora = hora; }

    /**
     * Retorna una representación en texto del objeto Turno.
     * @return cadena con los datos del turno
     */
    @Override
    public String toString() {
        return "Turno{dia='" + dia + "', lugar='" + lugar + "', hora='" + hora +
               "', estado='" + estado + "', codigo=" + codigo +
               ", instructor=" + (instructor != null ? instructor.getNombre() : "N/A") +
               ", capacidadMaxima=" + capacidadMaxima + "}";
    }
}