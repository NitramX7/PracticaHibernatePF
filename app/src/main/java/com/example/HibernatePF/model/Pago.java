package com.example.HibernatePF.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_venta;
    private double importe;
    private String metodo;
    private String estado;
    
    @Temporal(TemporalType.TIMESTAMP)
    Date creado_en;



    public Pago() {}

    public Pago(int id_venta, double importe, String metodo, String estado, Date creado_en) {
        this.id_venta = id_venta;
        this.importe = importe;
        this.metodo = metodo;
        this.estado = estado;
        this.creado_en = creado_en;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_venta() { return id_venta; }
    public void setId_venta(int id_venta) { this.id_venta = id_venta; }

    public double getImporte() { return importe; }
    public void setImporte(double importe) { this.importe = importe; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getCreado_en() { return creado_en; }
    public void setCreado_en(Date creado_en) { this.creado_en = creado_en; }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", importe=" + importe + ", metodo=" + metodo + '}';
    }
}
