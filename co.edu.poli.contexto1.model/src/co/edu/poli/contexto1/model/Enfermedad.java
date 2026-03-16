package co.edu.poli.contexto1.model;

public class Enfermedad {
    private String tipo;
    private String medicamento;
    private String observaciones;
    private String lugarDiagnostico;
    private String fechaDiagnostico;
    private String datosDeldoctor;
    // Atributo estático compartido por todos los objetos de Enfermedad
    private static int totalEnfermedadesRegistradas = 0;

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

    public boolean necesitaMantenimiento() {
        return medicamento != null && !medicamento.isEmpty();
    }

    // Getter y Setter del atributo estático
    public static int getTotalEnfermedadesRegistradas() {
        return totalEnfermedadesRegistradas;
    }

    public static void setTotalEnfermedadesRegistradas(int total) {
        totalEnfermedadesRegistradas = total;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMedicamento() { return medicamento; }
    public void setMedicamento(String medicamento) { this.medicamento = medicamento; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getLugarDiagnostico() { return lugarDiagnostico; }
    public void setLugarDiagnostico(String lugarDiagnostico) { this.lugarDiagnostico = lugarDiagnostico; }

    public String getFechaDiagnostico() { return fechaDiagnostico; }
    public void setFechaDiagnostico(String fechaDiagnostico) { this.fechaDiagnostico = fechaDiagnostico; }

    public String getDatosDeldoctor() { return datosDeldoctor; }
    public void setDatosDeldoctor(String datosDeldoctor) { this.datosDeldoctor = datosDeldoctor; }

    @Override
    public String toString() {
        return "Enfermedad{tipo='" + tipo + "', medicamento='" + medicamento +
               "', observaciones='" + observaciones + "', lugarDiagnostico='" + lugarDiagnostico +
               "', fechaDiagnostico='" + fechaDiagnostico + "', datosDeldoctor='" + datosDeldoctor + "'}";
    }
}