package com.example.HibernatePF;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.HibernatePF.dao.PuntoReventaDAO;
// si usas las entidades aquí, también:
import com.example.HibernatePF.model.Usuario;
import com.example.HibernatePF.model.Articulo;
import com.example.HibernatePF.model.Pago;
import com.example.HibernatePF.model.Valoracion;
import com.example.HibernatePF.model.Venta;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        
        System.out.println(new App().getGreeting());
        

        Scanner sc = new Scanner(System.in);
        PuntoReventaDAO dao = new PuntoReventaDAO();

        boolean salir = false;

        while (!salir) {

            System.out.println("\n¿En qué apartado quieres operar?");
            System.out.println("1. Usuarios");
            System.out.println("2. Artículos");
            System.out.println("3. Pagos");
            System.out.println("4. Valoraciones");
            System.out.println("5. Ventas");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            int apartado = leerEntero(sc);
            

            if (apartado == 1) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                menuUsuarios(session, dao, sc);

            } else if (apartado == 2) {
                Session session = HibernateUtil.getSessionFactory().openSession();

                menuArticulos(session, dao, sc);

            } else if (apartado == 3) {
                Session session = HibernateUtil.getSessionFactory().openSession();

                menuPagos(session, dao, sc);

            } else if (apartado == 4) {
                Session session = HibernateUtil.getSessionFactory().openSession();

                menuValoraciones(session, dao, sc);

            } else if (apartado == 5) {
                Session session = HibernateUtil.getSessionFactory().openSession();

                menuVentas(session, dao, sc);

            } else if (apartado == 6) {
                salir = true;

            } else {
                System.out.println("Opción no válida.");
            }
        }

        sc.close();
    
    }
    
    private static void menuUsuarios(Session session, PuntoReventaDAO dao, Scanner sc) {

    boolean volver = false;

    while (!volver) {
        

        System.out.println("\n=== MENÚ USUARIOS ===");
        System.out.println("1. Crear usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Buscar usuario por ID");
        System.out.println("4. Buscar usuarios por nombre");
        System.out.println("5. Actualizar usuario");
        System.out.println("6. Eliminar usuario por ID");
        System.out.println("7. Contar usuarios");
        System.out.println("0. Volver");
        System.out.print("Opción: ");

        int opcion = leerEntero(sc);
        

        if (opcion == 1) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("Nombre de usuario: ");
            String nombre = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            Usuario u = new Usuario();
            
            u.setNombre_usuario(nombre);
            u.setCorreo(correo);
            
           System.out.print("Valoración: ");

            
          
            double valoracion = leerDouble(sc);
            
            if(valoracion >9.9|| valoracion < 0){
                System.out.println("Valoracion fuera de rango");
                return;
            }

            u.setValoracion(valoracion);
            
            Date ahora = new Date();
            u.setCreado_en(ahora);
            u.setActualizado_en(ahora);

            dao.guardarUsuario(session, u);
            System.out.println("Usuario guardado.");
            
            tx.commit();

        } else if (opcion == 2) {

            List<Usuario> lista = dao.listarUsuario(session);
            for (Usuario usr : lista) System.out.println(usr);

        } else if (opcion == 3) {

            System.out.print("ID: ");
            int id = leerEntero(sc);

            Usuario usr = dao.buscarUsuarioPorId(session, id);
            if (usr != null) System.out.println(usr);
            else System.out.println("No existe ese usuario.");

        } else if (opcion == 4) {

            System.out.print("Nombre a buscar: ");
            String nombreBuscar = sc.nextLine();

            List<Usuario> lista = dao.buscarPorNombre(session, nombreBuscar);
            if (lista.isEmpty()) System.out.println("No hay usuarios.");
            else lista.forEach(System.out::println);

        } else if (opcion == 5) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID a actualizar: ");
            int id = leerEntero(sc);

            Usuario usr = dao.buscarUsuarioPorId(session, id);

            if (usr == null) {
                System.out.println("No existe ese usuario.");
            } else {
                System.out.print("Nuevo nombre (vacío = igual): ");
                String nuevoNombre = sc.nextLine();
                if (!nuevoNombre.isBlank()) usr.setNombre_usuario(nuevoNombre);

                System.out.print("Nuevo correo (vacío = igual): ");
                String nuevoCorreo = sc.nextLine();
                if (!nuevoCorreo.isBlank()) usr.setCorreo(nuevoCorreo);
                
                System.out.print("Nueva valoracion (vacío = igual): ");
                
                double nuevaValoracion = leerDouble(sc);
                 if(nuevaValoracion >9.9|| nuevaValoracion < 0){
                    System.out.println("Valoracion fuera de rango");
                    return;
                }
                 usr.setValoracion(nuevaValoracion);
                 
                usr.setActualizado_en(new Date());

                dao.actualizarUsuario(session, usr);
                System.out.println("Usuario actualizado.");
            }
            
            tx.commit();

        } else if (opcion == 6) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID a eliminar: ");
            int id = leerEntero(sc);
            

            boolean eliminado = dao.eliminarUsuarioPorId(session, id);
            if (eliminado) System.out.println("Usuario eliminado.");
            else System.out.println("No existía ese usuario.");
            
            
            
            tx.commit();

        } else if (opcion == 7) {

            long total = dao.contarUsuario(session);
            System.out.println("Usuarios totales: " + total);

        } else if (opcion == 0) {

            volver = true;

        } else {

            System.out.println("Opción no válida.");
        }

    }
    
}
    private static void menuArticulos(Session session, PuntoReventaDAO dao, Scanner sc) {

    boolean volver = false;

    while (!volver) {
        

        System.out.println("\n=== MENÚ ARTÍCULOS ===");
        System.out.println("1. Crear artículo");
        System.out.println("2. Listar artículos");
        System.out.println("3. Buscar artículo por ID");
        System.out.println("4. Actualizar artículo");
        System.out.println("5. Eliminar artículo por ID");
        System.out.println("6. Contar artículos");
        System.out.println("0. Volver");
        System.out.print("Opción: ");

        int opcion = leerEntero(sc);
        

        if (opcion == 1) {
            
            Transaction tx = session.beginTransaction();


         
            try {
                Articulo a = new Articulo();

                System.out.print("Nombre del artículo: ");
                String nombre = sc.nextLine();
                a.setTitulo(nombre);

                System.out.print("Descripción: ");
                String desc = sc.nextLine();
                a.setDescripcion(desc);

                System.out.print("Precio: ");
                
                double precio = leerDouble(sc);
                a.setPrecio(precio);

                System.out.print("Ubicación: ");
                String ubicacion = sc.nextLine();
                a.setUbicacion(ubicacion);

                System.out.print("ID del vendedor: ");
                int idVendedor = leerEntero(sc);              
                a.setId_vendedor(idVendedor);

                a.setDisponible(true);                      

                // Fechas obligatorias
                Date ahora = new Date();
                a.setCreado_en(ahora);
                a.setActualizado_en(ahora);

                dao.guardarArticulo(session, a);

                
                System.out.println("Artículo guardado.");
            } catch (Exception e) {
                tx.rollback();
                System.out.println("Error al guardar artículo: " + e.getMessage());
        }
            
            tx.commit();

        } else if (opcion == 2) {

            List<Articulo> lista = dao.listarArticulo(session);
            for (Articulo art : lista) System.out.println(art);

        } else if (opcion == 3) {

            System.out.print("ID del artículo: ");
            int id = leerEntero(sc);

            Articulo art = dao.buscarArticuloPorId(session, id);
            if (art != null) System.out.println(art);
            else System.out.println("No existe ese artículo.");

        } else if (opcion == 4) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID del artículo a actualizar: ");
            int id = leerEntero(sc);
            

            Articulo art = dao.buscarArticuloPorId(session, id);

            if (art == null) {
                System.out.println("No existe ese artículo.");
            } else {
                
                System.out.print("Nuevo nombre (vacío = igual): ");
                String nuevoNombre = sc.nextLine();
                if (!nuevoNombre.isBlank()) {
                    art.setTitulo(nuevoNombre);
                }

                System.out.print("Nueva descripción (vacío = igual): ");
                String nuevaDesc = sc.nextLine();
                if (!nuevaDesc.isBlank()) {
                    art.setDescripcion(nuevaDesc);
                }

                dao.actualizarArticulo(session, art);
                System.out.println("Artículo actualizado.");
                
                tx.commit();
            }

        } else if (opcion == 5) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID del artículo a eliminar: ");
            int id = leerEntero(sc);

            boolean eliminado = dao.eliminarArticuloPorId(session, id);
            if (eliminado) System.out.println("Artículo eliminado.");
            else System.out.println("No existía ese artículo.");

            tx.commit();
            
        } else if (opcion == 6) {

            long total = dao.contarArticulo(session);
            System.out.println("Artículos totales: " + total);

        } else if (opcion == 0) {

            volver = true;

        } else {

            System.out.println("Opción no válida.");
        }
        
    }
    
   
}
    private static void menuPagos(Session session, PuntoReventaDAO dao, Scanner sc) {

    boolean volver = false;

    while (!volver) {

        System.out.println("\n=== MENÚ PAGOS ===");
        System.out.println("1. Crear pago");
        System.out.println("2. Listar pagos");
        System.out.println("3. Buscar pago por ID");
        System.out.println("4. Actualizar pago");
        System.out.println("5. Eliminar pago por ID");
        System.out.println("6. Contar pagos");
        System.out.println("0. Volver");
        System.out.print("Opción: ");

        int opcion = leerEntero(sc);

        if (opcion == 1) {
            
            Transaction tx = session.beginTransaction();


            Pago p = new Pago();

            System.out.print("Importe: ");
            double importe = leerDouble(sc);
            
            p.setImporte(importe);
            
            System.out.println("Método de pago (tarjeta, bizum, efectivo...):");
            String metodo = sc.nextLine();
            if(metodo.isBlank()) {
                metodo = "desconocido";
            }
            p.setMetodo(metodo);
            p.setEstado("pendiente");
            
            System.out.println("ID de la venta relacionada:");
            int idVenta = leerEntero(sc);
            p.setId_venta(idVenta);
            Date ahora = new Date();
            p.setCreado_en(ahora);

            dao.guardarPago(session, p);
            System.out.println("Pago guardado.");
            
            tx.commit();

        } else if (opcion == 2) {

            List<Pago> lista = dao.listarPago(session);
            for (Pago p : lista) System.out.println(p);

        } else if (opcion == 3) {

            System.out.print("ID del pago: ");
            int id = leerEntero(sc);

            Pago p = dao.buscarPagoPorId(session, id);
            if (p != null) System.out.println(p);
            else System.out.println("No existe ese pago.");

        } else if (opcion == 4) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID del pago a actualizar: ");
            int id = leerEntero(sc);

            Pago p = dao.buscarPagoPorId(session, id);

            if (p == null) {
                System.out.println("No existe ese pago.");
            } else {
                System.out.print("Nuevo importe (0 = igual): ");
                double nuevoImporte = leerDouble(sc);
                
                if (nuevoImporte > 0) {
                    p.setImporte(nuevoImporte);
                }

                dao.actualizarPago(session, p);
                System.out.println("Pago actualizado.");
            }
            
            tx.commit();

        } else if (opcion == 5) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID del pago a eliminar: ");
            int id = leerEntero(sc);

            boolean eliminado = dao.eliminarPagoPorId(session, id);
            if (eliminado) System.out.println("Pago eliminado.");
            else System.out.println("No existía ese pago.");
            
            tx.commit();

        } else if (opcion == 6) {

            long total = dao.contarPago(session);
            System.out.println("Pagos totales: " + total);

        } else if (opcion == 0) {

            volver = true;

        } else {

            System.out.println("Opción no válida.");
        }
    }
}
    private static void menuValoraciones(Session session, PuntoReventaDAO dao, Scanner sc) {

    boolean volver = false;

    while (!volver) {

        
        System.out.println("\n=== MENÚ VALORACIONES ===");
        System.out.println("1. Crear valoración");
        System.out.println("2. Listar valoraciones");
        System.out.println("3. Buscar valoración por ID");
        System.out.println("4. Actualizar valoración");
        System.out.println("5. Eliminar valoración por ID");
        System.out.println("6. Contar valoraciones");
        System.out.println("0. Volver");
        System.out.print("Opción: ");

        int opcion = leerEntero(sc);

        if (opcion == 1) {
            
            Transaction tx = session.beginTransaction();


            Valoracion v = new Valoracion();

            System.out.print("Puntuación (1-5): ");
            int puntos = leerEntero(sc);
             if(puntos >5|| puntos< 1){
                System.out.println("Puntos fuera de rango");
                return;
            }
            v.setPuntuacion(puntos);

            System.out.print("Comentario: ");
            String comentario = sc.nextLine();
            v.setComentario(comentario);
            
            System.out.print("ID del autor (usuario): ");
            int idAutor = leerEntero(sc);
            v.setId_autor(idAutor);
            
            System.out.print("ID de la venta valorada: ");
            int idVenta = leerEntero(sc);
            v.setId_venta(idVenta);
            
            Date ahora = new Date();
            v.setCreado_en(ahora);
            
            dao.guardarValoracion(session, v);
            System.out.println("Valoración guardada.");
            
            tx.commit();

        } else if (opcion == 2) {

            List<Valoracion> lista = dao.listarValoracion(session);
            for (Valoracion v : lista) System.out.println(v);

        } else if (opcion == 3) {

            System.out.print("ID de la valoración: ");
            int id = leerEntero(sc);

            Valoracion v = dao.buscarValoracionPorId(session, id);
            if (v != null) System.out.println(v);
            else System.out.println("No existe esa valoración.");

        } else if (opcion == 4) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID de la valoración a actualizar: ");
            int id = leerEntero(sc);

            Valoracion v = dao.buscarValoracionPorId(session, id);

            if (v == null) {
                System.out.println("No existe esa valoración.");
            } else {
                System.out.print("Nueva puntuación (0 = igual): ");
                int nuevaPunt = leerEntero(sc);
                
                 if (nuevaPunt != 0) {
                    if (nuevaPunt < 1 || nuevaPunt > 5) {
                         System.out.println("Puntuación fuera de rango");
                         tx.rollback();
                         return;
                }
                    v.setPuntuacion(nuevaPunt);
             }
                

                System.out.print("Nuevo comentario (vacío = igual): ");
                String nuevoCom = sc.nextLine();
                if (!nuevoCom.isBlank()) {
                    v.setComentario(nuevoCom);
                }
                v.setCreado_en(new Date());

                dao.actualizarValoracion(session, v);
                System.out.println("Valoración actualizada.");
            }
            tx.commit();

        } else if (opcion == 5) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID de la valoración a eliminar: ");
            int id = leerEntero(sc);

            boolean eliminado = dao.eliminarValoracionPorId(session, id);
            if (eliminado) System.out.println("Valoración eliminada.");
            else System.out.println("No existía esa valoración.");
            
            tx.commit();

        } else if (opcion == 6) {

            long total = dao.contarValoracion(session);
            System.out.println("Valoraciones totales: " + total);

        } else if (opcion == 0) {

            volver = true;

        } else {

            System.out.println("Opción no válida.");
        }
    }
}
    private static void menuVentas(Session session, PuntoReventaDAO dao, Scanner sc) {

    boolean volver = false;

    while (!volver) {
        


        System.out.println("\n=== MENÚ VENTAS ===");
        System.out.println("1. Crear venta");
        System.out.println("2. Listar ventas");
        System.out.println("3. Buscar venta por ID");
        System.out.println("4. Actualizar venta");
        System.out.println("5. Eliminar venta por ID");
        System.out.println("6. Contar ventas");
        System.out.println("0. Volver");
        System.out.print("Opción: ");

        int opcion = leerEntero(sc);

        if (opcion == 1) {
            
           Transaction tx = session.beginTransaction();


            Venta v = new Venta();

            // Ajusta a tus campos reales:
            System.out.print("Importe total: ");
            double totalVenta = leerDouble(sc);
           
            v.setPrecio_final(totalVenta);
            
            System.out.print("ID del artículo vendido: ");
            int idArticulo = leerEntero(sc);
            v.setId_articulo(idArticulo);
            
            System.out.print("ID del comprador: ");
            int idComprador = leerEntero(sc);
            v.setId_comprador(idComprador);
            
            v.setEstado("pendiente");
            
            Date ahora = new Date();
            v.setFecha_venta(ahora);
            v.setCreado_en(ahora);
            v.setActualizado_en(ahora);
            

            dao.guardarVenta(session, v);
            System.out.println("Venta guardada.");
            
            tx.commit();

        } else if (opcion == 2) {

            List<Venta> lista = dao.listarVenta(session);
            for (Venta v : lista) System.out.println(v);

        } else if (opcion == 3) {

            System.out.print("ID de la venta: ");
            int id = leerEntero(sc);

            Venta v = dao.buscarVentaPorId(session, id);
            if (v != null) System.out.println(v);
            else System.out.println("No existe esa venta.");

        } else if (opcion == 4) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID de la venta a actualizar: ");
            int id = leerEntero(sc);

            Venta v = dao.buscarVentaPorId(session, id);

            if (v == null) {
                System.out.println("No existe esa venta.");
            } else {
                System.out.print("Nuevo total (0 = igual): ");
                double nuevoTotal = leerDouble(sc);
                
                if (nuevoTotal > 0) {
                    v.setPrecio_final(nuevoTotal);
                }

                dao.actualizarVenta(session, v);
                System.out.println("Venta actualizada.");
                
                tx.commit();
            }

        } else if (opcion == 5) {
            
            Transaction tx = session.beginTransaction();


            System.out.print("ID de la venta a eliminar: ");
            int id = leerEntero(sc);

            boolean eliminado = dao.eliminarVentaPorId(session, id);
            if (eliminado) System.out.println("Venta eliminada.");
            else System.out.println("No existía esa venta.");
            
            tx.commit();

        } else if (opcion == 6) {

            long total = dao.contarVenta(session);
            System.out.println("Ventas totales: " + total);

        } else if (opcion == 0) {

            volver = true;

        } else {

            System.out.println("Opción no válida.");
        }
    }
}
    private static int leerEntero(Scanner sc) {
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();

                return num;
            } catch (Exception e) {
                System.out.println("❗ Entrada inválida. Introduce un número válido:");
                sc.nextLine();
            }
        }
    }


    private static double leerDouble(Scanner sc) {
        while (true) {
            try {
                String entrada = sc.nextLine().trim();
                entrada = entrada.replace(',', '.'); // Permite 2,5 o 2.5
                return Double.parseDouble(entrada);
            } catch (Exception e) {
                System.out.println("❗ Entrada inválida. Introduce un número decimal válido:");
            }
        }
    }
}
