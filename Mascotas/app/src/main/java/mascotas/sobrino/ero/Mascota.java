package mascotas.sobrino.ero;

import java.io.Serializable;

public class Mascota implements Serializable {
    private String nombre;
    private float peso;
    private int foto;
    private String raza;
    private float valoracion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Mascota(String nombre, float peso, int foto, String raza, float valoracion) {
        this.nombre = nombre;
        this.peso = peso;
        this.foto = foto;
        this.raza = raza;
        this.valoracion = valoracion;
    }
}
