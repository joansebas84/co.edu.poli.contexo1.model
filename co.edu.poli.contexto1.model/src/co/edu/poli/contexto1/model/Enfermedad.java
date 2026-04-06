package co.edu.poli.contexto1.model;

/**
 * Clase que representa una enfermedad asociada a un usuario del sistema.
 * Lleva un conteo estático del total de enfermedades registradas.
 *
 * @author Joan Florez
 * @version 1.0
 * @since 2026
 */
public class Enfermedad {

    /** Tipo o nombre de la enfermedad. */
    private String tipo;

    /** Medicamento prescrito para la enfermedad. */
    private String medicamento;

    /** Observaciones adicionales sobre la enfermedad. */
    private String observaciones;

    /** Lugar donde se realizó el diagnóstico. */
    private String lugarDiagnostico;

    /** Fecha en que se realizó el diagnóstico. */
    private String fechaDiagnostico;

    /** Datos del médico que realizó el diagnóstico. */
    private String datosDeldoctor;

    // Atributo estático compartido por todos los objetos de Enfermedad
    /** Total de enfermedades registradas en el sistema. Atributo estático. */
    private static int totalEnfermedadesRegistradas = 0;

    /**
     * Constructor de Enfermedad. Incrementa automáticamente el contador estático.
     *
     * @param tipo             tipo o nombre de la enfermedad
     * @param medicamento      medicamento prescrito
     * @param observaciones    observaciones adicionales
     * @param lugarDiagnostico lugar del diagnóstico
     * @param fechaDiagnostico fecha del diagnóstico
     * @param datosDeldoctor   datos del médico tratante
     */
    public Enfermedad(String tipo, String medicamento, String observaciones,
                      String lugarDiagnostico, String fechaDiagnostico, String datosDeldoctor) {
        this.tipo = tipo;
        this.medicamento = medicamento;
        this.observaciones = observaciones;
        this.lugarDiagnostico = lugarDiagnostico;
        this.fechaDiagnostico = fechaDiagnostico;
        this.datosDeldoctor = datosDeldoctor;
        totalEnfermedadesRegistradas++;
    }

    /**
     * Indica si la enfermedad requiere medicamento activo.
     *
     * @return true si el medicamento no es null ni está vacío
     */
    public boolean necesitaMantenimiento() {
        return medicamento != null && !medicamento.isEmpty();
    }

    // Getter y Setter del atributo estático
    /**
     * Retorna el total de enfermedades registradas en el sistema.
     * @return total de enfermedades (atributo estático)
     */
    public static int getTotalEnfermedadesRegistradas() {
        return totalEnfermedadesRegistradas;
    }

    /**
     * Establece el total de enfermedades registradas.
     * @param total nuevo valor del contador estático
     */
    public static void setTotalEnfermedadesRegistradas(int total) {
        totalEnfermedadesRegistradas = total;
    }

    /** @return tipo de la enfermedad */
    public String getTipo() { return tipo; }
    /** @param tipo nuevo tipo */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /** @return medicamento prescrito */
    public String getMedicamento() { return medicamento; }
    /** @param medicamento nuevo medicamento */
    public void setMedicamento(String medicamento) { this.medicamento = medicamento; }

    /** @return observaciones de la enfermedad */
    public String getObservaciones() { return observaciones; }
    /** @param observaciones nuevas observaciones */
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    /** @return lugar del diagnóstico */
    public String getLugarDiagnostico() { return lugarDiagnostico; }
    /** @param lugarDiagnostico nuevo lugar */
    public void setLugarDiagnostico(String lugarDiagnostico) { this.lugarDiagnostico = lugarDiagnostico; }

    /** @return fecha del diagnóstico */
    public String getFechaDiagnostico() { return fechaDiagnostico; }
    /** @param fechaDiagnostico nueva fecha */
    public void setFechaDiagnostico(String fechaDiagnostico) { this.fechaDiagnostico = fechaDiagnostico; }

    /** @return datos del médico */
    public String getDatosDeldoctor() { return datosDeldoctor; }
    /** @param datosDeldoctor nuevos datos del médico */
    public void setDatosDeldoctor(String datosDeldoctor) { this.datosDeldoctor = datosDeldoctor; }

    /**
     * Retorna una representación en texto del objeto Enfermedad.
     * @return cadena con los datos de la enfermedad
     */
    @Override
    public String toString() {
        return "Enfermedad{tipo='" + tipo + "', medicamento='" + medicamento +
               "', observaciones='" + observaciones + "', lugarDiagnostico='" + lugarDiagnostico +
               "', fechaDiagnostico='" + fechaDiagnostico + "', datosDeldoctor='" + datosDeldoctor + "'}";
    }
}