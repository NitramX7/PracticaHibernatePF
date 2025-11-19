package com.example.HibernatePF.dao;

import com.example.HibernatePF.model.Usuario;
import com.example.HibernatePF.model.Articulo;
import com.example.HibernatePF.model.Pago;
import com.example.HibernatePF.model.Valoracion;
import com.example.HibernatePF.model.Venta;

import org.hibernate.Session;
import java.util.*;
import org.hibernate.query.Query;

public class PuntoReventaDAO {

    // ===== CREATE =====
    public void guardarArticulo(Session session, Articulo articulo){
        session.persist(articulo);
    }

    public void guardarUsuario(Session session, Usuario usuario){
        session.persist(usuario);
    }

    public void guardarPago(Session session, Pago pago){
        session.persist(pago);
    }

    public void guardarValoracion(Session session, Valoracion valoracion){
        session.persist(valoracion);
    }

    public void guardarVenta(Session session, Venta venta){
        session.persist(venta);
    }

    // ===== LISTAR =====
    public List<Usuario> listarUsuario(Session session){
        // HQL -> nombre de la ENTIDAD, no de la tabla
        return session.createQuery("from Usuario", Usuario.class).list();
    }

    public List<Articulo> listarArticulo(Session session){
        return session.createQuery("from Articulo", Articulo.class).list();
    }

    public List<Pago> listarPago(Session session){
        return session.createQuery("from Pago", Pago.class).list();
    }

    public List<Valoracion> listarValoracion(Session session){
        return session.createQuery("from Valoracion", Valoracion.class).list();
    }

    public List<Venta> listarVenta(Session session){
        return session.createQuery("from Venta", Venta.class).list();
    }

    // ===== READ =====
    public Usuario buscarUsuarioPorId(Session session, int id) {
        return session.find(Usuario.class, id);
    }

    public Articulo buscarArticuloPorId(Session session, int id) {
        return session.find(Articulo.class, id);
    }

    public Pago buscarPagoPorId(Session session, int id) {
        return session.find(Pago.class, id);
    }

    public Valoracion buscarValoracionPorId(Session session, int id) {
        return session.find(Valoracion.class, id);
    }

    public Venta buscarVentaPorId(Session session, int id) {
        return session.find(Venta.class, id);
    }

    // busca usuarios por nombre
    public List<Usuario> buscarPorNombre(Session session, String nombre) {
       
        Query<Usuario> query = session.createQuery(
            "from Usuario u where u.nombre_usuario = :nombre", 
            Usuario.class
        );
        query.setParameter("nombre", nombre);
        return query.list();
    }

    // ===== UPDATE =====
    public void actualizarUsuario(Session session, Usuario usuario) {
        session.merge(usuario);
    }

    public void actualizarArticulo(Session session, Articulo articulo) {
        session.merge(articulo);
    }

    public void actualizarPago(Session session, Pago pago) {
        session.merge(pago);
    }

    public void actualizarValoracion(Session session, Valoracion valoracion) {
        session.merge(valoracion);
    }

    public void actualizarVenta(Session session, Venta venta) {
        session.merge(venta);
    }

    // ===== DELETE (por entidad) =====
    public void eliminarUsuario(Session session, Usuario usuario) {
        session.remove(usuario);
    }

    public void eliminarArticulo(Session session, Articulo articulo) {
        session.remove(articulo);
    }

    public void eliminarPago(Session session, Pago pago) {
        session.remove(pago);
    }

    public void eliminarValoracion(Session session, Valoracion valoracion) {
        session.remove(valoracion);
    }

    public void eliminarVenta(Session session, Venta venta) {
        session.remove(venta);
    }

    // ===== DELETE (por ID) =====
    public boolean eliminarUsuarioPorId(Session session, int id) {
        Usuario usuario = session.find(Usuario.class, id);
        if (usuario != null) {
            session.remove(usuario);
            return true;
        }
        return false;
    }

    public boolean eliminarArticuloPorId(Session session, int id) {
        Articulo articulo = session.find(Articulo.class, id);
        if (articulo != null) {
            session.remove(articulo);
            return true;
        }
        return false;
    }

    public boolean eliminarPagoPorId(Session session, int id) {
        Pago pago = session.find(Pago.class, id);
        if (pago != null) {
            session.remove(pago);
            return true;
        }
        return false;
    }

    public boolean eliminarValoracionPorId(Session session, int id) {
        Valoracion valoracion = session.find(Valoracion.class, id);
        if (valoracion != null) {
            session.remove(valoracion);
            return true;
        }
        return false;
    }

    public boolean eliminarVentaPorId(Session session, int id) {
        Venta venta = session.find(Venta.class, id);
        if (venta != null) {
            session.remove(venta);
            return true;
        }
        return false;
    }

    // ===== CONTAR =====
    public long contarUsuario(Session session) {
        Long total = session.createQuery(
                "select count(u.id) from Usuario u",
                Long.class
        ).uniqueResult();
        return (total != null) ? total : 0L;
    }

    public long contarArticulo(Session session) {
        Long total = session.createQuery(
                "select count(a.id) from Articulo a",
                Long.class
        ).uniqueResult();
        return (total != null) ? total : 0L;
    }

    public long contarPago(Session session) {
        Long total = session.createQuery(
                "select count(p.id) from Pago p",
                Long.class
        ).uniqueResult();
        return (total != null) ? total : 0L;
    }

    public long contarValoracion(Session session) {
        Long total = session.createQuery(
                "select count(v.id) from Valoracion v",
                Long.class
        ).uniqueResult();
        return (total != null) ? total : 0L;
    }

    public long contarVenta(Session session) {
        Long total = session.createQuery(
                "select count(v.id) from Venta v",
                Long.class
        ).uniqueResult();
        return (total != null) ? total : 0L;
    }
}
