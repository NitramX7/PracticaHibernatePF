/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.HibernatePF.model;

/**
 *
 * @author nitra
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //
           
     int id;
    String nombre_usuario;
    String correo;
    Double valoracion;
    Date creado_en;
    Date actualizado_en;

    public Usuario(String nombre_usuario, String correo, Double valoracion, Date creado_en, Date actualizado_en) {
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.valoracion = valoracion;
        this.creado_en = creado_en;
        this.actualizado_en = actualizado_en;
    }
    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    public Date getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(Date creado_en) {
        this.creado_en = creado_en;
    }

    public Date getActualizado_en() {
        return actualizado_en;
    }

    public void setActualizado_en(Date actualizado_en) {
        this.actualizado_en = actualizado_en;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre_usuario=" + nombre_usuario + ", correo=" + correo + ", valoracion=" + valoracion + ", creado_en=" + creado_en + ", actualizado_en=" + actualizado_en + '}';
    }
    
    
}



