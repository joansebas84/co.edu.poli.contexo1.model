package co.edu.poli.contexto1.model;

public class Traje {
    private String material;
    private String id;
    private String estadoDelTraje;
    private String tamanio;
    private String tipo;

    public Traje(String material, String id, String estadoDelTraje, String tamanio, String tipo) {
        this.material = material;
        this.id = id;
        this.estadoDelTraje = estadoDelTraje;
        this.tamanio = tamanio;
        this.tipo = tipo;
    }

    public boolean disponibleTraje() {
        return estadoDelTraje != null && estadoDelTraje.equalsIgnoreCase("disponible");
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEstadoDelTraje() { return estadoDelTraje; }
    public void setEstadoDelTraje(String estadoDelTraje) { this.estadoDelTraje = estadoDelTraje; }

    public String getTamanio() { return tamanio; }
    public void setTamanio(String tamanio) { this.tamanio = tamanio; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Traje{material='" + material + "', id='" + id + "', estadoDelTraje='" +
               estadoDelTraje + "', tamanio='" + tamanio + "', tipo='" + tipo + "'}";
    }
}