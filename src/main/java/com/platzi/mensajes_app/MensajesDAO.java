/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            try{
                String query = "insert into mensajes (mensaje,autor_mensaje) values (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
                conexion.close();
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            try{
                ResultSet rs = null;
                String query = "select * from mensajes";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println("");
                }
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo realizar la consulta a la Bd");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            try{
                int vLogrado = 0;
                String query = "delete from mensajes where id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                vLogrado = ps.executeUpdate();
                if (vLogrado > 0){
                    System.out.println("Registro eliminado con EXITO");
                }else{
                    System.out.println("No se pudo eliminar el registro");
                }
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo eliminar el registro");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_connection();){
            PreparedStatement ps = null;
            try{
                int vLogrado = 0;
                String query = "update mensajes set mensaje = ? where id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensajes());
                vLogrado = ps.executeUpdate();
                if (vLogrado > 0){
                    System.out.println("Actualizacion realizada con EXITO");
                }else{
                    System.out.println("No se pudo realizar la actualizacion del mensaje");
                }
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("No se pudo actualizar el registro");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
