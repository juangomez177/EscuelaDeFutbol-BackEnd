package co.udea.api.administrador.model;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
public class Admon {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_equipo")
    private String nombre_equipo;

    @Column(name = "categoria")
    private Integer categoria;

    @Column(name = "capitan")
    private String capitan;


    public Admon() {
    }

    public Admon(Integer id, String nombre_equipo, Integer categoria, String capitan) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.categoria = categoria;
        this.capitan = capitan;
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

    public void setNombre_equipo(String name) {
        this.nombre_equipo = nombre_equipo;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer id) {
        this.categoria = categoria;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }
}
