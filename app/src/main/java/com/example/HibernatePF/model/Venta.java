package com.example.HibernatePF.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_articulo;
    private int id_comprador;
    private Date fecha_venta;
    private double precio_final;
    private String estado;
   
    
    @Temporal(TemporalType.TIMESTAMP)
    Date creado_en;

    @Temporal(TemporalType.TIMESTAMP)
    Date actualizado_en;

    public Venta() {}

    public Venta(int id_articulo, int id_comprador, Date fecha_venta, double precio_final,
                 String estado, Date creado_en, Date actualizado_en) {
        this.id_articulo = id_articulo;
        this.id_comprador = id_comprador;
        this.fecha_venta = fecha_venta;
        this.precio_final = precio_final;
        this.estado = estado;
        this.creado_en = creado_en;
        this.actualizado_en = actualizado_en;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_articulo() { return id_articulo; }
    public void setId_articulo(int id_articulo) { this.id_articulo = id_articulo; }

    public int getId_comprador() { return id_comprador; }
    public void setId_comprador(int id_comprador) { this.id_comprador = id_comprador; }

    public Date getFecha_venta() { return fecha_venta; }
    public void setFecha_venta(Date fecha_venta) { this.fecha_venta = fecha_venta; }

    public double getPrecio_final() { return precio_final; }
    public void setPrecio_final(double precio_final) { this.precio_final = precio_final; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getCreado_en() { return creado_en; }
    public void setCreado_en(Date creado_en) { this.creado_en = creado_en; }

    public Date getActualizado_en() { return actualizado_en; }
    public void setActualizado_en(Date actualizado_en) { this.actualizado_en = actualizado_en; }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", precio_final=" + precio_final + ", estado=" + estado + '}';
    }
}
