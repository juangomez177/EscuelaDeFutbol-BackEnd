package co.udea.api.administrador.model;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_equipo")
    private String nombre_equipo;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "capitan")
    private String capitan;

    @Column(name = "entrenador")
    private String entrenador;


    public Equipo() {
    }

    public Equipo(Integer id, String nombre_equipo, String categoria, String capitan, String entrenador) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.categoria = categoria;
        this.capitan = capitan;
        this.entrenador = entrenador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCapitan() { return capitan; }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre_equipo='" + nombre_equipo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", capitan='" + capitan + '\'' +
                ", entrenador='" + entrenador + '\'' +
                '}';
    }
}
