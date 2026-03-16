package co.edu.poli.contexto1.servicios;

import co.edu.poli.contexto1.model.Enfermedad;
import co.edu.poli.contexto1.model.Usuario;

// PUNTO 3 - CLASE FINAL: UsuarioVip no puede ser heredada por ninguna otra clase
final class UsuarioVip extends Usuario {
    private double descuento;
    private String unicoDeSubscripcion;

    public UsuarioVip(String nombre, String id, double peso, double estatura, int edad,
                      String grupoSanguineo, Enfermedad[] enfermedad,
                      double descuento, String unicoDeSubscripcion) {
        super(nombre, id, peso, estatura, edad, grupoSanguineo, enfermedad);
        this.descuento = descuento;
        this.unicoDeSubscripcion = unicoDeSubscripcion;
    }

    public String fechaDeVencimientoSuscripcion(String dateInicio, String nroMeses) {
        return "Fecha de vencimiento calculada desde: " + dateInicio + " por " + nroMeses + " meses";
    }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

    public String getUnicoDeSubscripcion() { return unicoDeSubscripcion; }
    public void setUnicoDeSubscripcion(String unicoDeSubscripcion) { this.unicoDeSubscripcion = unicoDeSubscripcion; }

    @Override
    public String toString() {
        return "UsuarioVip{nombre='" + getNombre() + "', id='" + getId() + "', descuento=" + descuento +
               ", unicoDeSubscripcion='" + unicoDeSubscripcion + "'}";
    }
}