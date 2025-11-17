package com.example.HibernatePF.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "valoraciones")
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_venta;
    private int id_autor;
    private int puntuacion;
    private String comentario;
    private Date creado_en;

    public Valoracion() {}

    public Valoracion(int id_venta, int id_autor, int puntuacion, String comentario, Date creado_en) {
        this.id_venta = id_venta;
        this.id_autor = id_autor;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.creado_en = creado_en;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_venta() { return id_venta; }
    public void setId_venta(int id_venta) { this.id_venta = id_venta; }

    public int getId_autor() { return id_autor; }
    public void setId_autor(int id_autor) { this.id_autor = id_autor; }

    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Date getCreado_en() { return creado_en; }
    public void setCreado_en(Date creado_en) { this.creado_en = creado_en; }

    @Override
    public String toString() {
        return "Valoracion{" + "id=" + id + ", puntuacion=" + puntuacion + ", comentario=" + comentario + '}';
    }
}
