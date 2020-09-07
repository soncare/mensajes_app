/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor indica el id del mensaje");
        int vId_Mensaje = sc.nextInt();
        
        MensajesDAO.borrarMensajeDB(vId_Mensaje);
    }
    
    public static void editaMensaje(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Indique la actualizacion del mensaje");
        String vMensaje = sc.nextLine();
        
        System.out.println("Por favor indique el id del mensaje");
        int vId_Mensaje = sc.nextInt();
        
        Mensajes actualizar = new Mensajes();
        actualizar.setId_mensajes(vId_Mensaje);
        actualizar.setMensaje(vMensaje);
        MensajesDAO.actualizarMensajeDB(actualizar);
    }
}
