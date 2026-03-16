package co.edu.poli.contexto1.model;

public class Maquina {
    private String marca;
    private String peso;
    private String color;
    private String estado;
    private String material;
    private String codigo;
    private String capacidad;
    private double gravedad;
    private Traje[] traje;

    public Maquina(String marca, String peso, String color, String estado, String material,
                   String codigo, String capacidad, double gravedad, Traje[] traje) {
        this.marca = marca;
        this.peso = peso;
        this.color = color;
        this.estado = estado;
        this.material = material;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.gravedad = gravedad;
        this.traje = traje;
    }

    public boolean necesitaMantenimiento() {
        return estado != null && estado.equalsIgnoreCase("dañada");
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getPeso() { return peso; }
    public void setPeso(String peso) { this.peso = peso; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getCapacidad() { return capacidad; }
    public void setCapacidad(String capacidad) { this.capacidad = capacidad; }

    public double getGravedad() { return gravedad; }
    public void setGravedad(double gravedad) { this.gravedad = gravedad; }

    public Traje[] getTraje() { return traje; }
    public void setTraje(Traje[] traje) { this.traje = traje; }

    @Override
    public String toString() {
        return "Maquina{marca='" + marca + "', codigo='" + codigo + "', estado='" + estado +
               "', capacidad='" + capacidad + "', gravedad=" + gravedad + "}";
    }
}