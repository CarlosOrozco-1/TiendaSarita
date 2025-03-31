/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendasarita;

/**
 *
 * @author Carlos Orozco
 */


import java.util.Scanner;


public class TiendaSarita {

    public static void main(String[] args) {
        
        Scanner datos = new Scanner(System.in);
        
        //Declaración de variables
        float mDescuento = 1250; //monto descuento
        double descuento1 = 0.1;  //descuento1 del 10%
        double descuento2 = 0.05; //descuento2 del 5%
        double total; // almacena el resultado de los descuentos
        var moneda = " Q ";
        
        
        //Toma de datos
        
        System.out.print("Nombre del Cliente: ");
        var cliente = datos.nextLine();
        
        System.out.print("Tiene membresia Si / No: ");
        var mVip = datos.nextLine() . trim() . toLowerCase();
        
        boolean esMiembro = mVip.equals("sí") || mVip.equals("si");
        
        System.out.print("Ingrese el monto de la Compra: Q.");
        float montoCompra = datos.nextFloat();
        
        // Operaciones a realizar 
        
        if (montoCompra >= mDescuento && esMiembro == true) {
            
            //Aplicar desucuento del 10%
            var desc1 = montoCompra * descuento1; // genera el total de descuento descuento
            desc1 = Math.round(desc1*100.0) / 100.0; //redondear el total del descuento
            total = montoCompra - desc1; // Resta el total de decuento en la compra y almacena el resultado
            total = Math.round(total*100.0) / 100.0; // redondear el total para dos decimales
            
            mostraDatos(cliente, esMiembro, montoCompra); //carga el modulo con los datos del cliente
            
            System.out.println("\n----------------------------------------------------------------------------------------");
            
            System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t", "Monto Compra","%Descuento","Total Descuento", "Total");
            System.out.println("\n----------------------------------------------------------------------------------------");
            System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t", moneda+montoCompra," 10%",moneda+desc1,moneda+total);
            System.out.println("\n----------------------------------------------------------------------------------------");
        } 
        else if(montoCompra >= mDescuento | esMiembro == true){
            
            //Aplicar desucuento del 5%
            var desc1 = montoCompra * descuento2; // genera monto de descuento
            desc1 = Math.round(desc1*100.0) / 100.0; //redondear el total del descuento
            total = montoCompra - desc1; // suma el total de compra y realiza el descuento
            total = Math.round(total*100.0) / 100.0; // redondear el total para dos decimales
            
            mostraDatos(cliente, esMiembro, montoCompra);
            
            System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t", "Monto Compra","%Descuento","Total Descuento", "Total");
            System.out.println("\n----------------------------------------------------------------------------------------");
            System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t",moneda+montoCompra," 5%",moneda+desc1,moneda+total);
            System.out.println("\n----------------------------------------------------------------------------------------");
            
        }
        else {
            
            mostraDatos(cliente, esMiembro, montoCompra);
            
            System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t", "Monto Compra","%Descuento","Total Descuento", "Total");
            System.out.println("\n----------------------------------------------------------------------------------------");
            System.out.printf("%-15s \t %-15s \t %-15s \t %-15s \t",moneda+montoCompra," 0%",moneda," 0 ",moneda+montoCompra);
            System.out.println("\n----------------------------------------------------------------------------------------");
            System.out.println("No se realizo ningún tipo de descuento");
            System.out.println("Le invitamos a hacerse miembro para obtener beneficios");
            System.out.println("El monto minimo de compra para descuentos es de: Q. " + mDescuento);
        
        }
       
    }
    
    //Mostrar datos en consola
        public static void mostraDatos (String cliente, boolean esMiembro, float montoCompra){
            
        System.out.println("****Datos del cliente****");
        System.out.println("Nombre del Cliente: " + cliente);
        String respuesta = esMiembro ? "Si" : "No"; 
        System.out.println("Tiene membresia: " + respuesta);
        System.out.println("");
        System.out.println("***Detalle de Compra***");
        System.out.println("");    
           
        
     
        }   
    
}
