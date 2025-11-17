package com.example.HibernatePF.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_vendedor;
    private String titulo;
    private String descripcion;
    private double precio;
    private String ubicacion;
    private boolean disponible;
    private Date creado_en;
    private Date actualizado_en;

    public Articulo() {}

    public Articulo(int id_vendedor, String titulo, String descripcion, double precio,
                    String ubicacion, boolean disponible, Date creado_en, Date actualizado_en) {
        this.id_vendedor = id_vendedor;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.ubicacion = ubicacion;
        this.disponible = disponible;
        this.creado_en = creado_en;
        this.actualizado_en = actualizado_en;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_vendedor() { return id_vendedor; }
    public void setId_vendedor(int id_vendedor) { this.id_vendedor = id_vendedor; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public Date getCreado_en() { return creado_en; }
    public void setCreado_en(Date creado_en) { this.creado_en = creado_en; }

    public Date getActualizado_en() { return actualizado_en; }
    public void setActualizado_en(Date actualizado_en) { this.actualizado_en = actualizado_en; }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", titulo=" + titulo + ", precio=" + precio + '}';
    }
}
